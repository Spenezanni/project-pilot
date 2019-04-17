package br.com.java.project.service;

import java.util.List;

import br.com.java.project.entity.Tarefa;

public interface TarefaService {

	public void salvar(Tarefa tarefa);
	
	public void deletar(Long id);
	
	public List<Tarefa> listar();
	

}