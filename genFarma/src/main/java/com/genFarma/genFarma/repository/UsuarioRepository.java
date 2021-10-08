package com.genFarma.genFarma.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.genFarma.genFarma.model.Usuario;

/**
 * @author Priscila
 * @version 1.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
