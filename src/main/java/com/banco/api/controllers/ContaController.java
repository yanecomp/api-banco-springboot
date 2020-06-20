package com.banco.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.api.domain.Conta;
import com.banco.api.services.ContaService;

@RestController
@RequestMapping(value="/conta")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public @ResponseBody List<Conta> findAll(){
		return this.contaService.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}")
	public @ResponseBody Conta conta(@PathVariable Long id){
		return contaService.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/conta/{cod}")
    public Conta findByConta(@PathVariable String cod) {
        return contaService.findByConta(Long.valueOf(cod));

    }

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/depositar/{id}/{valor}")
	public @ResponseBody Conta deposito(@PathVariable("id") Long id, @PathVariable("valor") String valor) {
		Conta conta = contaService.findById(id);
		conta.depositar(Double.parseDouble(valor));		
		final Conta updatedConta = contaService.insert(conta);
		return updatedConta;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/sacar/{id}/{valor}")
	public @ResponseBody Conta saque(@PathVariable("id") Long id, @PathVariable("valor") String valor) {
		Conta conta = contaService.findById(id);
		conta.sacar(Double.parseDouble(valor));		
		final Conta updatedConta = contaService.insert(conta);
		return updatedConta;
	}
	
}
