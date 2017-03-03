package br.com.unitri.topicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unitri.topicos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
