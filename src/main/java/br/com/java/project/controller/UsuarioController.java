package br.com.java.project.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.java.project.dto.UsuarioDTO;
import br.com.java.project.entity.Usuario;
import br.com.java.project.service.TarefaService;
import io.jsonwebtoken.Jwts;

@Controller
public class UsuarioController {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping(value = "/usuario")
	@ResponseBody
	public void salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		System.out.println("------------------------------------");
		// System.out.println(UsuarioDTO.getUsuario());0
		Usuario usuario = new Usuario();
		usuario.setUsuario(usuarioDTO.getUsuario());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setEmail(usuarioDTO.getEmail()); 
		usuario.setSenha(usuarioDTO.getSenha());

		tarefaService.validarCamposUsuario(usuario);
		tarefaService.salvarUsuario(usuario);
		
	}

	@PostMapping(value = "/autenticar")
	@ResponseBody
	public LoginResponse login(@RequestBody UsuarioDTO usuarioDTO) throws ServletException {
		System.out.println(usuarioDTO.getLogin() + " " + usuarioDTO.getSenha() + " " + usuarioDTO.getEmail());
		// System.out.println(UsuarioDTO.getUsuario());
		Usuario usuario = new Usuario();

		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setEmail(usuarioDTO.getEmail());

		if (usuario.getLogin() == null || usuario.getSenha() == null) {
			throw new ServletException("Login e senha Obrigatórios");
		}

		Usuario usuarioAutenticado = tarefaService.login(usuario);

		if (usuarioAutenticado == null) {

			throw new ServletException("Usuário não encontrado");

		}
		if (!usuarioAutenticado.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Usuário ou senha Inválidos");
		}

		// return new ResponseEntity<Usuario>(usuarioAutenticado,
		// HttpStatus.OK);

		String token = Jwts.builder().setSubject(usuarioAutenticado.getLogin()).setSubject("Codigo Secreto").compact();

		return new LoginResponse(token);
	}
	
	@DeleteMapping(value = "/usuario/{login}")
	@ResponseBody
	public String deletar(@PathVariable String login) {
		tarefaService.verificacaoIdUsuarioExiste(login);
		tarefaService.deletarUsuario(login);
		return "Usuario Deletado";
	}
	
	

}
