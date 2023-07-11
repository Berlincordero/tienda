package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.domain.Producto;
import com.tienda.impl.FirebaseStorageServiceImpl;
import com.tienda.service.ProductoService;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

  
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Producto> productos = productoService.getProducto(false);
        List<Producto> producto= productoService.getProducto(true);
        model.addAttributes("productos", productos);
        model.addAttributes("categoria", productos);
        model.addAttributes("totalproductos", productos.size());
        
        return "/producto/listado";
       

    }
      @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }

    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoaEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        List<Producto> producto = productoService.getProducto(true);
        model.addAttribute("producto", producto);
        model.addAttribute("categoria", producto);
        return "/producto/modifica";
    }
}