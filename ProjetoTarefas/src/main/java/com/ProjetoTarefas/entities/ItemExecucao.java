package com.ProjetoTarefas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "itemExecucao")
public class ItemExecucao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "percentual")
	private double percentual;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "dataExecuxao")
	private String dataExecuxao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPercentual() {
		return percentual;
	}
	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataExecuxao() {
		return dataExecuxao;
	}
	public void setDataExecuxao(String dataExecuxao) {
		this.dataExecuxao = dataExecuxao;
	}
}
