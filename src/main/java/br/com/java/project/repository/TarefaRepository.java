package br.com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.project.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	Tarefa save(Tarefa tarefa);
	
	void delete(Long id);
	

}