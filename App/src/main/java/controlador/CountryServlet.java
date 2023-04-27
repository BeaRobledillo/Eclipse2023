package controlador;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bea.dao.CountryDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Country;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/country/*")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CountryServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parametro = request.getPathInfo();
			CountryDAO paises = new CountryDAO();
			if (parametro == null) {

				List<Country> todos = paises.paises();
				/*
				 * for(Country paises:todos) { response.getWriter().append(pais.getCountry()); }
				 */
				JSONArray resultado = new JSONArray(todos);
				response.getWriter().append(resultado.toString());
			} else {
				int id = Integer.parseInt(parametro.substring(1));
				Country pais = paises.paisPorId(id);
				JSONObject resultado = new JSONObject(pais);
				// response.getWriter().append(parametro);
				response.getWriter().append(resultado.toString());
			}
		} catch (Exception ex) {
			JSONObject error = new JSONObject();
			error.put("Error", "GET");
			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());
			// System.out.println();
			// System.out.println(request.getPathInfo());

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Leer los datos que nos mandan
		String data = request.getReader().lines().collect(Collectors.joining());
		// System.out.println(data);
		JSONObject pais = new JSONObject(data);
		Country newpais = new Country(0, pais.get("country").toString());
		System.out.println(newpais);

		CountryDAO daoPais = new CountryDAO();

		daoPais.crearPais(0, pais.get("country").toString());
		try {
		} catch (Exception ex) {
			JSONObject error = new JSONObject();
			error.put("Error", "POST");
			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Modificar el elemento
		try {
			// Obtener el JSON que me pasan
			String data = request.getReader().lines().collect(Collectors.joining());
			JSONObject pais = new JSONObject(data);
			// Obtengo el id que tengo que cambiar
			String parametro = request.getPathInfo();
			int id = Integer.parseInt(parametro.substring(1));

			// Utilizo el DAO para hacer el cambio
			CountryDAO daoPais = new CountryDAO();
			daoPais.cambiarPais(id, pais.getString("country"));

		} catch (Exception ex) {
			JSONObject error = new JSONObject();
			error.put("Error", "POST");
			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());

		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String parametro = request.getPathInfo();
			int id = Integer.parseInt(parametro.substring(1));

			CountryDAO daoPais = new CountryDAO();
			daoPais.borrarPais(id);

		} catch (Exception ex) {
			JSONObject error = new JSONObject();
			error.put("Error", "POST");
			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());

		}
	}

}