package br.com.unitri.topicos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unitri.topicos.model.Produto;
import br.com.unitri.topicos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository repository;

	@CrossOrigin("*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> list() {
		
		List<Produto> produtos = repository.findAll();
		
		return  ResponseEntity.ok(produtos);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Produto produto) {
		
		repository.save(produto);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	public ProdutoRepository getRepository() {
		return repository;
	}

	public void setRepository(ProdutoRepository repository) {
		this.repository = repository;
	}
	
}
