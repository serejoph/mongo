package projetomongo.model;

public class Localizacao {

	private String endereco;
	private Double lat;
	private Double lng;
	private String type = "point";
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double latitude) {
		this.lat = latitude;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double longitude) {
		this.lng = longitude;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
}
