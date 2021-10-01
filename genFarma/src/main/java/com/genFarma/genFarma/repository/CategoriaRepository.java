package com.genFarma.genFarma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genFarma.genFarma.model.Categoria;

/**
 * @author Amanda
 * @version 1.0
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	/**
	 * Metodo utilizado para realizar pesquisa pela coluna 'nome' da tabela
	 * 'categoria'.
	 * 
	 * @author Amanda
	 * @param nome
	 * @return Lista com nome de categorias.
	 * @since 1.0
	 */
	public List<Categoria> findByNomeContainingIgnoreCase(String nome);

}