package com.example.MavenAgain;

import org.hibernate.Session;

import capaDao.Countrydao;
import model.Country;
import util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Countrydao miDAO = new Countrydao();

		Country pais = miDAO.get(9);
		pais.setCountry("Albacete, caga y vete");
		miDAO.save(pais);

		pais = new Country(0, "Titulcia");
		miDAO.save(pais);

		pais = miDAO.get(12811);
		miDAO.delete(12813);

		System.out.println(miDAO.get(1));
		System.out.println(miDAO.getAll());
	}
}
