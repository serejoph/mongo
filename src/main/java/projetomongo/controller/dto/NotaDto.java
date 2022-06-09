package projetomongo.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import projetomongo.model.Nota;

public class NotaDto {

	@Min(value = 0)
	@Max(value = 10)
	@NotNull
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Nota toNota() {
		Nota nota = new Nota();
		nota.setValor(this.valor);
		return nota;
	}
	
	
}
