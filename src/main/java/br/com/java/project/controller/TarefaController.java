package br.com.java.project.controller;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.java.project.dto.TarefaDTO;
import br.com.java.project.dto.UsuarioDTO;
import br.com.java.project.entity.Tarefa;
import br.com.java.project.entity.Usuario;
import br.com.java.project.error.ResourceBadRequestException;
import br.com.java.project.error.ResourceCreatedException;
import br.com.java.project.service.TarefaService;
import io.jsonwebtoken.Jwts;

@Controller
@RequestMapping("/admin")
public class TarefaController<TarefaRepository> {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping(value = "/tarefa")
	@ResponseBody
	public void adicionaTarefa(@RequestBody TarefaDTO tarefaDTO) {
		System.out.println("------------------------------------");
		System.out.println(tarefaDTO.getStatus());
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao(tarefaDTO.getDescricao());
		tarefa.setStatus(tarefaDTO.getStatus());

		if (tarefa.getStatus().equals("Aberto") || tarefa.getStatus().equals("ABERTO")) {
			if (tarefa.getDescricao() == "") {
				throw new ResourceBadRequestException("Inválido!!! A Descrição está vazia!");
			} else {
				tarefaService.salvar(tarefa);
			}
		} else {
			throw new ResourceBadRequestException("Inválido!!! O Status deve estar Aberto.");
		}
		throw new ResourceCreatedException("Válido!!! Tarefa Inserida");
	}

	@DeleteMapping(value = "/tarefa/{id}")
	@ResponseBody
	public String deletar(@PathVariable long id) {
		tarefaService.verificacaoIdTarefaExiste(id);
		tarefaService.deletar(id);
		return "Tarefa Deletada";
	}

	@PutMapping(value = "/tarefa/{id}")
	@ResponseBody
	public String modificaTarefa(@PathVariable long id, @RequestBody TarefaDTO tarefaDTO) {
		// System.out.println(tarefaDTO.getStatus());S
		// System.out.println(id);
		tarefaService.verificacaoIdTarefaExiste(id);

		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		tarefa.setStatus(tarefaDTO.getStatus());
		tarefa.setDescricao(tarefaDTO.getDescricao());

		tarefaService.verificacaoStatusTarefaExiste(tarefa);

		tarefaService.salvar(tarefa);
		return "Tarefa Modificada  com Sucesso!!!";
	}

	@GetMapping(value = "/tarefas")
	@ResponseBody
	public List<Tarefa> listar() {
		return tarefaService.listar();
	}

}
