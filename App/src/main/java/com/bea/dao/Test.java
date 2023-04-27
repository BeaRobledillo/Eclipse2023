package com.bea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import models.Aula;

public class Test {

	public static void main(String[] args) {
//		CountryDAO pais = new CountryDAO();
//		System.out.println(pais.paises());

		AulaDAO aula = new AulaDAO();
		aula.addAula(new Aula(0, "Física", 50));
		aula.updateAula(14, new Aula(0, "Química", 50));
		aula.deleteAula(22);
		
		
		System.out.println(aula.get());
		System.out.println(aula.getById(1));

	}

}