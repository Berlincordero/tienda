
package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;


public interface ProductoService {
    // metodo para consultar todas las productos //el parametro define si se muestra solo las activas o todas 
    public List<Producto> getProductos(boolean activos);
    
    // se obtiene una producto por su id
    public Producto getProducto(Producto producto);
    
    //Inserta: se inserta cuando el idproducto esta vacio(valor 0 o null)
    //modifica: se modifica cuando el idproducto no esta vacio 
    public void save(Producto producto); 
    
    // se elimina un resgiatro por su idproducto
    public void delete(Producto producto);
}
