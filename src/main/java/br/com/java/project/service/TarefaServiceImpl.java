package br.com.java.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.project.entity.Tarefa;
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
		/*List<Tarefa> tarefas = new ArrayList<Tarefa>();
		Tarefa tarefa = new Tarefa();
		tarefa.setId(123L);
		tarefa.setStatus("Aberto");
		tarefa.setDescricao("Comprar");

		tarefas.add(tarefa);
		tarefas.add(tarefa);
		tarefas.add(tarefa);
		tarefas.add(tarefa);
		tarefas.add(tarefa);*/
		
		return tarefaRepository.findAll();
	}

}
