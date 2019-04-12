package br.com.java.project.service;

import br.com.java.project.entity.Tarefa;

public interface TarefaService {

	public void salvar(Tarefa tarefa);
	
	public void deletar(Long id);
	

}