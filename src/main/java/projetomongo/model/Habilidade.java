package projetomongo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Habilidade {

	private String nome;
	@Field(name = "nível")
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

	@Override
	public String toString() {
		return "Habilidade [nome=" + nome + ", nivel=" + nivel + "]";
	}

	
	
}
