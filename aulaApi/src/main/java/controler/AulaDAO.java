package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {
	private Connection con;

	public AulaDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://mysql-trifulcas.alwaysdata.net:3306/trifulcas_code",
					"trifulcas_code", "TrifulcasForever");

			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
}
	public  List< Aula>get(){
		List<Aula> res = new ArrayList<>();
		try {
			String sql = "select * from aula ";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				res.add( new Aula(rs.getInt("id"), rs.getString("nombre"),rs.getInt("capacidad")));
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
		return  res;
		
	}
	 public Aula getById (int id) {
		 try {
				
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM aula WHERE id = ?");
				ps.setInt(1, id);
				

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					
					Aula aula = new Aula(rs.getInt("id"), rs.getString("nombre"),rs.getInt("capacidad"));
				
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
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aula.getNombre());
			stmt.setInt(2, aula.getCapacidad());
			int res = stmt.executeUpdate();
			return aula;
		} catch (Exception ex) {
			
			System.out.println(ex);
		}
		return null;
	
	}
	public Aula updateAula(int id, Aula aula) {
		try {
			String sql = "update aula set nombre=?,capacidad=? where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aula.getNombre());
			stmt.setInt(2, aula.getCapacidad());
			stmt.setInt(3,id);
			int res = stmt.executeUpdate();
			return aula;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	

	public boolean deleteAula(int id) {
		try {
			String sql = "delete  from aula where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			int res = stmt.executeUpdate();
			return res == 1;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;
	}


	
	
	}

