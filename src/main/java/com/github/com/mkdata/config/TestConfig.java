package com.github.com.mkdata.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.com.mkdata.entities.Cliente;
import com.github.com.mkdata.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository beneficiarioRepository;
	
	
	@Override
	public void run(String... args) throws Exception {	
		/*
		
		Cliente c1 = new Cliente(null, "Michael Jackson da Costa", "Fisica", "13.143.256-54", "24671902", Instant.parse("2023-04-24T14:40:30Z"), "sim", "11988761324");
		
		
		beneficiarioRepository.saveAll(Arrays.asList(c1));
		
		
		*/
	}
			
	
	
}
