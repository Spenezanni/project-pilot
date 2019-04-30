package br.com.java.project.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.java.project.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);

	Usuario save(Usuario usuario);
	
	Usuario findOne(String login);

}
