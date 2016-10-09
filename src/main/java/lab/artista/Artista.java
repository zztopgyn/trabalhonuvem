package lab.artista;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artista {
	
	@Id
	private Integer codigo;
	private String nome;
	
	public Artista() {
	}

	
	
	public Artista(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
