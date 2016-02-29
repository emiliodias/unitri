package br.com.sm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sm.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	public List<Pessoa> findByNomeContaining(String nome);

}
