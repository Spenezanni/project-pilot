package br.com.java.project.service;

import java.util.List;

import br.com.java.project.entity.Tarefa;
import br.com.java.project.entity.Usuario;
import br.com.java.project.error.ResourceNotFoundException;

public interface TarefaService {

	public void salvar(Tarefa tarefa);
	
	public void deletar(Long id);
	
	public List<Tarefa> listar();

    public void verificacaoIdTarefaExiste(long id);
    
    public void verificacaoStatusTarefaExiste(Tarefa tarefa);

	public void salvarUsuario(Usuario usuario);
	
	public void autenticacao(Usuario usuario);
	

}