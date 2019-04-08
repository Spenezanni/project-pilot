package br.com.java.project.controller;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.java.project.entity.Usuario;
import br.com.java.project.repository.UsuarioRepository;
  
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
       
      private UsuarioRepository usuarioRepository;
  
      @Autowired
      public UsuarioController( UsuarioRepository usuarioRepository) {
            this.usuarioRepository = usuarioRepository;
      }
  
      @RequestMapping(value = "/{usuario}", method = RequestMethod.GET)
      public String listaLivros(@PathVariable("usuario") String usuario, Model model) {
            List<Usuario> listaUsuario = UsuarioRepository.findByUsuario(usuario);
            if (listaUsuario != null) {
                  model.addAttribute("livros", listaUsuario);
            }
            return "listaUsuario";
      }
  
      
}