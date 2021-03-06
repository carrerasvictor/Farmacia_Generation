package com.genFarma.genFarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Victor
 * @version 1.0
 */
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@NotBlank
	@Size(min = 1, max = 100)
	private String nome;

	@NotBlank
	@Size(min = 1, max = 300)
	private String descricao;

	@NotBlank
	@Column(length = 10, precision = 2)
	private Double preco;

	@NotBlank
	@Size(min = 1, max = 50)
	private String subcategoria;

	/**
	 * @author Joao
	 * @version 1.0
	 */
	@ManyToOne
	@JoinColumn(name = "fk_categoria")
	@JsonIgnoreProperties({ "produtos" })
	private Categoria categoriaRelacionada;
	
	/**
	 * @author Priscila
	 * @version 1.0
	 */
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	@JsonIgnoreProperties({ "produtos" })
	private Usuario usuarioRelacionado;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public Categoria getCategoriaRelacionada() {
		return categoriaRelacionada;
	}

	public void setCategoriaRelacionada(Categoria categoriaRelacionada) {
		this.categoriaRelacionada = categoriaRelacionada;
	}

	public Usuario getUsuarioRelacionado() {
		return usuarioRelacionado;
	}

	public void setUsuarioRelacionado(Usuario usuarioRelacionado) {
		this.usuarioRelacionado = usuarioRelacionado;
	}
}
