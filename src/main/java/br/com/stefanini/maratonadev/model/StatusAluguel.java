package br.com.stefanini.maratonadev.model;

/**
 * 
 * @author Renato NObrega
 * @versio 0.1.0
 * @created 01/11/2020 on 14:24
 *
 */


public enum StatusAluguel {

	ALUGADO("Alugado"), DISPONIVEL("Disponivel"), CANCELADO("Cancelado");

	private String descricao;

	private StatusAluguel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static boolean isAlugado(String alugado) {
		for (StatusAluguel status : StatusAluguel.values()) {
			if (status.name().equals(alugado)) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

	public static boolean isDisponivel(String disponivel) {
		for (StatusAluguel status : StatusAluguel.values()) {
			if (status.name().equals(disponivel)) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

	public static boolean isCancelado(String cancelado) {
		for (StatusAluguel status : StatusAluguel.values()) {
			if (status.name().equals(cancelado)) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}
}