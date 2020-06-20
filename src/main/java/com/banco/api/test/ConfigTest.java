package com.banco.api.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.banco.api.domain.Conta;
import com.banco.api.repositories.ContaRepository;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {
	
	@Autowired
	private ContaRepository contaRepository;

	@Override
	public void run(String... args) throws Exception {
		Conta c1 = new Conta(null, "Maria Joaquina", "12345678901", 1010L, 1250.0);
		Conta c2 = new Conta(null, "Alex Santos", "00000000000", 2020L, 10300.0);
		Conta c3 = new Conta(null, "Joana Souza", "11111111111", 3030L, 250.0);
		Conta c4 = new Conta(null, "Murilo Santana", "22222222222", 4040L, 3800.0);
		
		contaRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
	}

}
