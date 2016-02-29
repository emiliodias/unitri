package br.com.sm.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sm.domain.Erro;
import br.com.sm.domain.Pessoa;
import br.com.sm.repository.PessoaRepository;

@RestController
@RequestMapping(value = "pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Pessoa> listaPessoas(@RequestParam(required = false) String nome) {

		if(nome == null)	
			return repository.findAll();
		
		return repository.findByNomeContaining(nome);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPessoa(@PathVariable Integer id) throws InterruptedException {

		Pessoa pessoa = repository.findOne(id);

		if (pessoa == null) {

			Erro erro = new Erro("Pessoa não encontrada", 404, System.currentTimeMillis(),
					"http://www.unitri.edu.br/api/erros/404");

			return new ResponseEntity<Erro>(erro, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> salvarPessoa(@RequestBody Pessoa pessoa) {

		pessoa = repository.save(pessoa);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri());

		return new ResponseEntity(responseHeaders, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletarPessoa(@PathVariable int id) {

		repository.delete(id);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);

	}

}
