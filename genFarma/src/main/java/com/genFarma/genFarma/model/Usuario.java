package com.genFarma.genFarma.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Team Sinergia
 * @version 1.0
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@NotBlank
	private String nome;

	@ApiModelProperty(example = "email@email.com.br")
	@NotNull(message = "O atributo email é Obrigatório!")
	@Email(message = "O atributo email deve ser válido!")
	private String email;

	@NotBlank
	@Size(min = 8, max = 100)
	private String senha;

	/**
	 * @author Priscila
	 * @version 1.0
	 */
	@OneToMany(mappedBy = "usuarioRelacionado", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "usuarioRelacionado" })
	private List<Produto> produtos = new ArrayList<>();

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
