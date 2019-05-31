package br.com.java.project.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.java.project.entity.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);

	Usuario save(Usuario usuario);
	
	Usuario findBySenha(String senha);


	
    void delete(String login);

	Usuario findOne(String login);
	


}
