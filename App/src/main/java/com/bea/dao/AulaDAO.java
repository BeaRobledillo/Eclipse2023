package com.bea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Aula;

public class AulaDAO {
	private Connection connection;

	public AulaDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://mysql-trifulcas.alwaysdata.net:3306/trifulcas_code",
					"trifulcas_code", "TrifulcasForever");
		} catch (Exception ex) {
			System.err.println("Error al establecer la conexión a la base de datos: " + ex.getMessage());
			return;
		}

	}

	public List<Aula> get() {
		List<Aula> res = new ArrayList<>();
		try {
			String sql = "select * from aula";
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				res.add(new Aula(rs.getInt("id"), rs.getString("nombre"), rs.getInt("capacidad")));
			}
		} catch (Exception ex) {

			System.out.println(ex);
			return null;
		}
		return res;

	}

	public Aula getById(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM aula WHERE id = ?");
			ps.setInt(1, id);

			ResultSet result = ps.executeQuery();

			if (result.next()) {

				Aula aula = new Aula(result.getInt("id"), result.getString("nombre"), result.getInt("capacidad"));

				return aula;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			System.err.println("Error al buscar el aula por id: " + ex.getMessage());
			return null;
		}
	}

	public Aula addAula(Aula aula) {

		try {
			String sql = "insert into aula (nombre,capacidad) values (?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aula.getNombre());
			stmt.setInt(2, aula.getCapacidad());
			int res = stmt.executeUpdate();
			return aula;

		} catch (Exception ex) {
			System.out.println("Error al añadir el aula");
			System.out.println(ex.getMessage());

		}
		return null;
	}

	public Aula updateAula(int id, Aula aula) {
		try {
			String sql = "update aula set nombre=?,capacidad=? where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aula.getNombre());
			stmt.setInt(2, aula.getCapacidad());
			stmt.setInt(3, id);
			int res = stmt.executeUpdate();
			return aula;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;

	}

	public boolean deleteAula(int id) {
		try {
			String sql = "delete from aula where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			int res = stmt.executeUpdate();

			return res == 1;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

}
