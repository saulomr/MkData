package com.github.com.mkdata.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.github.com.mkdata.entities.Cliente;
import com.github.com.mkdata.repositories.ClienteRepository;
import com.github.com.mkdata.services.exceptions.DatabaseException;
import com.github.com.mkdata.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));		
		
	}
	
	public Cliente findByNome(String Nome) {
		Optional<Cliente> obj = repository.findByNome(nome);
		return obj.orElseThrow(() -> new ResourceNotFoundException(nome));		
		
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
				throw new ResourceNotFoundException(id);	
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Cliente update(Long id, Cliente obj) {
		try {
		Cliente entity = repository.getReferenceById(id);
		updateData (entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e){
			throw new ResourceNotFoundException(id);		
		}
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setTipo(obj.getTipo());
		entity.setCpfCnpj(obj.getCpfCnpj());
		entity.setRgIe(obj.getRgIe());
		entity.setDataCadastro(obj.getDataCadastro());
		entity.setAtivo(obj.getAtivo());
		entity.setTelefone(obj.getTelefone());
				
	}
	
}
