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

}
