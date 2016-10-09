package lab.album;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {
	@Id
	private Integer codigo;
	private String nome;
	private String tipo;
	private Integer quantidade;
	private Date data;
	
	public static final String VINYL = "vinyl";
	
	public Album() {
	}


	public Album(Integer codigo, String nome, String tipo, Integer quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
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


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
