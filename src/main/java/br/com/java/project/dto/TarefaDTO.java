package br.com.java.project.dto;


public class TarefaDTO {

	private String status;

	private String descricao;
	
	public TarefaDTO(){
		
	}

	public TarefaDTO(String status, String descricao) {
		this.status = status;
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
