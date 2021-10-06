package com.genFarma.genFarma.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Victor
 * @version 1.0
 */
@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;

	@NotBlank
	@Size(min = 1, max = 50)
	private String nome;

	/**
	 * @author Joao
	 * @version 1.0
	 */
	@OneToMany(mappedBy = "categoriaRelacionada", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "categoriaRelacionada" })
	private List<Produto> produtos = new ArrayList<>();

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
