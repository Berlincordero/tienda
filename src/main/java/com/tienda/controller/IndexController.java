
package com.tienda.controller;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    
    @Autowired
    UsuarioDao usuarioDao;
    
    
    @RequestMapping("/")
    public String page(Model model) {
        //model.addAttribute("attribute", "value");
        
        Object principal = SecurityContextHolder.getContext().getPrincipal();
        UserDetails user = null;
        
        if (principal instanceof UserDetails){
            user = (UserDetails) principal;
        }
        if (user != null){
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            
            httpSession.setAttribute("Email", usuario.getCorreo());
        }
        return "index";
    }
    
}
