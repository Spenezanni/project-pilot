package br.com.java.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.project.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	static List<Usuario> findByUsuario(String id) {

		return null;
	}

}