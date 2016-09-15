package com.crud.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crud.model.Pessoa;
import com.crud.service.PessoaService;

@RestController
public class PessoaWS extends AbstractWS {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> listarTodos() {
		List<Pessoa> pessoas = pessoaService.listarTodos();
		if (pessoas.isEmpty()) {
			return new ResponseEntity<List<Pessoa>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> buscarArtistaPorId(@PathVariable("id") long id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
        if (pessoa == null) {
            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<Pessoa> criarArtista(@RequestBody Pessoa pessoa, UriComponentsBuilder ucBuilder) {
  
        if (pessoaService.isPessoaExistente(pessoa)) {
            return new ResponseEntity<Pessoa>(HttpStatus.CONFLICT);
        }
  
        pessoaService.salvar(pessoa);
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pessoa> excluirArtista(@PathVariable("id") long id) {
  
        Pessoa pessoa = pessoaService.buscarPorId(id);
        if (pessoa == null) {
            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }
  
        pessoaService.excluirPorId(id);
        return new ResponseEntity<Pessoa>(HttpStatus.NO_CONTENT);
    }
}
