package br.com.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.project.entity.Tarefa;
import br.com.java.project.error.ResourceBadRequestException;
import br.com.java.project.error.ResourceNotFoundException;
import br.com.java.project.repository.TarefaRepository;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Override
	public void salvar(Tarefa tarefa) {
		System.out.println(">>>>>>>>>>>>>>>>>>" + tarefa.toString());
		tarefaRepository.save(tarefa);
	}

	@Override
	public void deletar(Long id) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		tarefaRepository.delete(id);
	}

	@Override
	public List<Tarefa> listar() {

		/*
		 * List<Tarefa> tarefas = new ArrayList<Tarefa>(); Tarefa tarefa = new
		 * Tarefa(); tarefa.setId(123tatus("Aberto");
		 * tarefa.setDescricao("Comprar"); tarefas.add(tarefa);
		 * tarefas.add(tarefa); tarefas.add(tarefa);L); tarefa.setS
		 * tarefas.add(tarefa); tarefas.add(tarefa);
		 */

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
		} else if (tarefa.getStatus().equals("Fechado") || tarefa.getStatus() != "Aberto") {
			throw new ResourceBadRequestException("Status não permitido");
		}
		if (tarefa.getDescricao() == "") {
			throw new ResourceBadRequestException("Descrição não pode ser vazia!");
		}
	}
}