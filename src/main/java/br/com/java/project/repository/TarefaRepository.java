package br.com.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.project.entity.Tarefa;
import br.com.java.project.entity.Usuario;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	Tarefa save(Usuario usuario);
	
	void delete(Long id);


}

