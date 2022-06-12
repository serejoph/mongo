package projetomongo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import projetomongo.model.Aluno;
import projetomongo.model.Curso;

public class UserDto {

	@NotBlank
	@Size(min = 5)
	private String nome;
	@NotBlank
	@Size(min = 5)
	private String curso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	@Size(min = 5)
	@NotBlank
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "UserDto [nome=" + nome + ", curso=" + curso + ", dataNascimento=" + dataNascimento + "]";
	}
	public Aluno toAluno() {
		Aluno aluno = new Aluno();
		aluno.setCurso(new Curso(this.curso));
		aluno.setNome(this.nome);
		aluno.setDataNascimento(this.dataNascimento);
		aluno.getLocalizacao().setEndereco(this.endereco);
		return aluno;
	}
	
	
	
}
