package br.com.java.project.dto;


public class TarefaDTO {

	private String status;

	private String descricao;
	
	private String status2;
	
	public TarefaDTO(){
		
		
	}

	public TarefaDTO(String status, String descricao, String status2) {
		this.status = status;
		this.descricao = descricao;
		this.status2 = status2;
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

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	
	
	

}
