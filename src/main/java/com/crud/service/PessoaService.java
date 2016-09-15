package com.crud.service;

import java.util.List;

import com.crud.model.Pessoa;

public interface PessoaService {

	List<Pessoa> listarTodos();
	
	Pessoa buscarPorId(long id);
	
	void salvar(Pessoa pessoa);
	
	void atualizar(Pessoa pessoa);
	
	void excluirPorId(long id);
	
	boolean isPessoaExistente(Pessoa pessoa);
}
