package br.com.java.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.project.entity.Tarefa;
import br.com.java.project.entity.Usuario;
import br.com.java.project.error.ResourceBadRequestException;
import br.com.java.project.error.ResourceNotFoundException;
import br.com.java.project.repository.TarefaRepository;
import br.com.java.project.repository.UsuarioRepository;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void salvar(Tarefa tarefa) {
		System.out.println(">>>>>>>>>>>>>>>>>>" + tarefa.toString());
		tarefaRepository.save(tarefa);
	}

	@Override
	public void salvarUsuario(Usuario usuario) {
		System.out.println(">>>>>>>>>>>>>>>>>>" + usuario.toString());
		usuarioRepository.save(usuario);
	}

	@Override
	public void deletar(Long id) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		tarefaRepository.delete(id);
	}

	@Override
	public List<Tarefa> listar() {
		return tarefaRepository.findAll();
	}

	@Override
	public void verificacaoIdTarefaExiste(long id) {
		Tarefa tarefa = tarefaRepository.findOne(id);
		if (tarefa == null) {
			throw new ResourceNotFoundException("Id de Tarefa não existe");
		}
	}

	@Override
	public void verificacaoStatusTarefaExiste(Tarefa tarefa) {

		if (tarefa.getStatus().equals("Aberto")) {
			System.out.println("Status Sucesso!!!");
		} else if (tarefa.getStatus().equals("Fechado")) {
			System.out.println("Status Sucesso!!!");
		} else if (tarefa.getStatus() != "Aberto") {
			throw new ResourceBadRequestException("Status não permitido");
		}
		if (tarefa.getDescricao() == "") {
			throw new ResourceBadRequestException("Descrição não pode ser vazia!");
		}
	}

	@Override
	public Usuario login(Usuario usuario) {

		Usuario user = usuarioRepository.findByLogin(usuario.getLogin());

		return user;
	}

	@Override
	public void verificacaoIdUsuarioExiste(String login) {
		Usuario usuario = usuarioRepository.findOne(login);
		if (usuario == null) {
			throw new ResourceNotFoundException("Id de Tarefa não existe");
		}
	}

	@Override
	public void deletarUsuario(String login) {

		System.out.println(">>>>>>>>>>>>>>>>>>");
		usuarioRepository.delete(login);
	}

	@Override
	public void validarCamposUsuario(Usuario usuario) {

		if (usuario.getUsuario() == "" || usuario.getEmail() == "" || usuario.getLogin() == ""
				|| usuario.getSenha() == "") {
			throw new ResourceBadRequestException("Não pode haver campos em branco!!!");

		}
	}
}