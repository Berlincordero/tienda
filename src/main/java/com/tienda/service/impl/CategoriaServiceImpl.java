
package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.spec.NamedParameterSpec;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    
    @Autowired
    CategoriaDao categoriaDao;
            
            
    @Override
    @Transactional 
    public List<Categoria> getCategorias(boolean activos) {
    
      List<Categoria> categorias = categoriaDao.findAll();
      
      if (activos) {
        categorias.removeIf(x -> !x.isActivo());
      }
      
      return categorias;
    }
    
}
