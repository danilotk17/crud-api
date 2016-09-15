package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.model.Pessoa;
import com.crud.repository.PessoaRepository;

@Service("pessoaService")
@Transactional
public class PessoaServiceImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa buscarPorId(long id) {
		return pessoaRepository.findOne(id);
	}

	@Override
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		salvar(pessoa);
	}

	@Override
	public void excluirPorId(long id) {
		pessoaRepository.delete(id);
	}

	@Override
	public boolean isPessoaExistente(Pessoa pessoa) {
		
		if(pessoa.getId() == null) {
			return false;
		}
		
		return pessoaRepository.exists(pessoa.getId());
	}

}
