package projetomongo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import projetomongo.model.Habilidade;

public class HabilidadeDto {
	
	@NotBlank
	@Size(min = 3)
	private String nome;
	@NotBlank
	@Size(min = 3)
	private String nivel;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Habilidade toHabilidade() {
		Habilidade habilidade = new Habilidade();
		habilidade.setNivel(this.nivel);
		habilidade.setNome(this.nome);
		return habilidade;
	}

}
