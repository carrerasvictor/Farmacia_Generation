package com.genFarma.genFarma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.genFarma.genFarma.model.Produto;

/**
 * @author Amanda
 * @version 1.0
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	/**
	 * Metodo utilizado para realizar pesquisa pela coluna 'nome' da tabela
	 * 'produto'.
	 * 
	 * @author Amanda
	 * @param nome
	 * @return Lista com nome de produtos.
	 * @since 1.0
	 */
	public List<Produto> findByNomeContainingIgnoreCase(String nome);

	/**
	 * Metodo utilizado para realizar pesquisa pelo menor 'preco' da tabela
	 * 'produto'.
	 * 
	 * @author Leonardo
	 * @param nome
	 * @return Lista com nome de produtos.
	 * @since 1.0
	 */
	public List<Produto> findByPrecoLessThan(Double preco);

	/**
	 * Metodo utilizado para realizar pesquisa pelo maior 'preco' da tabela
	 * 'produto'.
	 * 
	 * @author Leonardo
	 * @param nome
	 * @return Lista com nome de produtos.
	 * @since 1.0
	 */
	public List<Produto> findByPrecoGreaterThan(Double preco);

	/**
	 * Metodo utilizado para realizar pesquisa pela coluna 'subcategoria' da tabela
	 * 'produto'.
	 * 
	 * @author Leonardo
	 * @param nome
	 * @return Lista com nome de produtos.
	 * @since 1.0
	 */
	public List<Produto> findBySubcategoriaContainingIgnoreCase(String subcategoria);

}
