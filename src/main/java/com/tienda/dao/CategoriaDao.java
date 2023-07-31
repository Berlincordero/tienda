
package com.tienda.dao;

import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    
    
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
   
    
}
