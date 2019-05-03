package br.com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.project.entity.Tarefa;
import br.com.java.project.entity.Usuario;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	Tarefa save(Usuario usuario);
	
	void delete(Long id);
}