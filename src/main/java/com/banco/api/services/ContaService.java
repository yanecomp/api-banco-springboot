package com.banco.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.api.domain.Conta;
import com.banco.api.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public List<Conta> findAll(){
		return contaRepository.findAll();
	}
	
	public Conta findById(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		return obj.get();
	}
	
	public Conta findByConta(Long cod) {
        return contaRepository.findByConta(cod);
    }
	
	public Conta insert(Conta conta) {
		return contaRepository.save(conta);
	}

}
