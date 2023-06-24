
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    // metodo para consultar todas las categorias //el parametro define si se muestra solo las activas o todas 
    public List<Categoria> getCategorias(boolean activos);
    
}
