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

	public Usuario login(Usuario usuario);

	public void verificacaoIdUsuarioExiste(String login);

	public void deletarUsuario(String login);

	public void validarCamposUsuario(Usuario usuario);

	//public List<Tarefa> listarTermiandas();

}