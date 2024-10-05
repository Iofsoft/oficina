//Nome: Ian de Oliveira Fernandes
//RA: SC3037215
/*
Json usado para cadastrar um conserto:

	{
		"dataEntrada": "01/10/2024",
		"dataSaida": "04/10/2024",
		"mecanicoDados": {
			"nome": "Jovem da Silva",
			"experiencia": 2
		},
		"veiculoDados": {
			"marca": "Mercedes",
			"modelo": "G63",
			"ano" : "2025"
		}
	}
		
*/

package com.prw3.oficina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OficinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OficinaApplication.class, args);
	}

}
