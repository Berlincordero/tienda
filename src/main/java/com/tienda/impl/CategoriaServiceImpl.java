
package com.tienda.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import com.tienda.service.CategoriaService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.spec.NamedParameterSpec;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    
    @Autowired
    CategoriaDao categoriaDao;
            
            
    @Override
    @Transactional(readOnly = true) 
    public List<Categoria> getCategorias(boolean activos) {
    
      List<Categoria> categorias = categoriaDao.findAll();
      
      if (activos) {
        categorias.removeIf(x -> !x.isActivo());
      }
      
      return categorias;
    }
    
     @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    @Override
    public List<Categoria> getPorDescripcion(String descripcion){
        return categoriaDao.findByDescripcion(descripcion);
  }
    @Override
@Transactional(readOnly=true)
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
  return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
}

}
