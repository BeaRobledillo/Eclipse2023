package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class AulaDao {
	private String cadenaConexion = "jdbc:mysql://mysql-trifulcas.alwaysdata.net:3306/trifulcas_code";
	private String usuario = "trifulcas_code";
	private String password = "TrifulcasForever";
	private Connection con;
	public AulaDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(cadenaConexion, usuario, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Aula> get() {
		if (con == null) {
			System.out.println("Fallo de conexión a la BBDD");
			return null;
		}
		try {
			Statement stmt = con.createStatement();
			List<Aula> res = new ArrayList<Aula>();
			ResultSet rs = stmt.executeQuery("select * from aula");
			while (rs.next()) {
				res.add(new Aula(rs.getInt("id"), rs.getString("nombre"), rs.getInt("capacidad")));
			}
			return res;
		} catch (Exception ex) {
			System.out.println("Error al obtener la lista de aulas");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	public Aula getById(int id) {
		if (con == null) {
			System.out.println("Fallo de conexión a la BBDD");
			return null;
		}
		try {
			PreparedStatement ps = con.prepareStatement("select * from aula where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Aula(rs.getInt("id"), rs.getString("nombre"), rs.getInt("capacidad"));
			}
			System.out.println("No existe ninguna aula con el id " + id);
			return null;
		} catch (Exception ex) {
			System.out.println("Error al obtener el aula");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	public Aula addAula(Aula aula) {
		if (con == null) {
			System.out.println("Fallo de conexión a la BBDD");
			return null;
		}
		try {
			PreparedStatement ps = con.prepareStatement("insert into aula (nombre, capacidad) values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, aula.getNombre());
			ps.setInt(2, aula.getCapacidad());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			long last_id = 0;
			if (rs.next()) {
				last_id = rs.getLong(1);
			}
			int id = (int) last_id;
			return new Aula(id, aula.getNombre(), aula.getCapacidad());
		} catch (Exception ex) {
			System.out.println("Error al añadir el aula");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	public Aula updateAula(int id, Aula aula) {
		if (con == null) {
			System.out.println("Fallo de conexión a la BBDD");
			return null;
		}
		try {
			PreparedStatement ps = con.prepareStatement("update aula set nombre = ? , set capacidad = ? where id = ?");
			ps.setString(1, aula.getNombre());
			ps.setInt(2, aula.getCapacidad());
			ps.setInt(3, id);
			ps.executeUpdate();
			return aula;
		} catch (Exception ex) {
			System.out.println("Error al hacer update al aula");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	public boolean deleteAula(int id) {
		if (con == null) {
			System.out.println("Fallo de conexión a la BBDD");
			return false;
		}
		try {
			PreparedStatement ps = con.prepareStatement("delete from aula WHERE id = ?");
			ps.setInt(1, id);
			return ps.executeUpdate() == 1;
		} catch (Exception ex) {
			System.out.println("Error al borrar el aula");
			System.out.println(ex.getMessage());
			return false;
		}
	}
}