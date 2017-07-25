package br.com.drogaria.domain;

public class Fabricante {
	private Long idFabricante;
	private String descricao;

	public Long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String saida = idFabricante + "-" + descricao;
		return saida;
	}
}
