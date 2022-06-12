package projetomongo.dto;

import projetomongo.model.Aluno;

public class LocalizacaoDto {
	
	private String nome;
	private Double lat;
	private Double lng;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	public LocalizacaoDto (Aluno aluno) {
		this.nome = aluno.getNome();
		this.lat = aluno.getLocalizacao().getCoordinates()[0];
		this.lng = aluno.getLocalizacao().getCoordinates()[1];
	}

	public LocalizacaoDto() {
		
	}
}
