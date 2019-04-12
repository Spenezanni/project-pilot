package br.com.java.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.java.project.dto.TarefaDTO;
import br.com.java.project.entity.Tarefa;
import br.com.java.project.service.TarefaService;

@Controller
public class TarefaController<TarefaRepository> {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping(value = "/tarefa")
	@ResponseBody
	public String adicionaTarefa(@RequestBody TarefaDTO tarefaDTO) {
		System.out.println(tarefaDTO.getStatus());
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao(tarefaDTO.getDescricao());
		tarefa.setStatus(tarefaDTO.getStatus());
		tarefaService.salvar(tarefa);
		return "works";
	}

	@DeleteMapping(value = "/tarefa/delete/{id}")
	@ResponseBody
	public String deletar(@PathVariable long id) {
		tarefaService.deletar(id);
		return "Tarefa Deletada";
	}

	@PutMapping(value = "/tarefa/modifica/{id}")
	@ResponseBody
	public String modificaTarefa(@PathVariable long id, @RequestBody TarefaDTO tarefaDTO) {
		System.out.println(tarefaDTO.getStatus());
		System.out.println(id);
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao(tarefaDTO.getDescricao());
		tarefa.setStatus(tarefaDTO.getStatus());
		tarefa.setId(id);
		 tarefaService.salvar(tarefa);
		return "Tarefa Modificada";
	}
	
	

}