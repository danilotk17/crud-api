package com.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Pessoa;

@Repository("pessoaRepository")
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	List<Pessoa> findAll();
}
