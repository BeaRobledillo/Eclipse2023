package controlador;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bea.dao.AulaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Aula;

/**
 * Servlet implementation class AulaControlador
 */
@WebServlet("/aula/*")
public class AulaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AulaControlador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject result = new JSONObject();
		result.put("Error", false);
		result.put("Mensaje", "OK");

		try {
			String parametro = request.getPathInfo();
			AulaDAO aulas = new AulaDAO();
			if (parametro == null) {

				List<Aula> todos = aulas.get();
				JSONArray resultado = new JSONArray(todos);

				result.put("data", resultado.toString());
				response.getWriter().append(result.toString());

				// response.getWriter().append(resultado.toString());
			} else {
				int id = Integer.parseInt(parametro.substring(1));
				Aula aula = aulas.getById(id);
				JSONObject resultado = new JSONObject(aula);

				result.put("data", resultado.toString());
				response.getWriter().append(result.toString());

				// response.getWriter().append(resultado.toString());
			}
		} catch (Exception ex) {
			JSONObject error = new JSONObject();
			// error.put("Error", "GET");

			error.put("Error", true);
			error.put("data", "{}");

			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject result = new JSONObject();
		result.put("Error", false);
		result.put("Mensaje", "OK");

		try {

			String data = request.getReader().lines().collect(Collectors.joining());
			JSONObject aula = new JSONObject(data);
			AulaDAO daoAula = new AulaDAO();
			Aula newAula = new Aula(0, aula.getString("nombre"), aula.getInt("capacidad"));
			daoAula.addAula(newAula);

			result.put("data", aula);
			response.getWriter().append(result.toString());

		} catch (

		Exception ex) {

			JSONObject error = new JSONObject();
			error.put("Error", true);
			error.put("data", "{}");
			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());

		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject result = new JSONObject();
		result.put("Error", false);
		result.put("Mensaje", "OK");

		try {
			String data = request.getReader().lines().collect(Collectors.joining());
			JSONObject aula = new JSONObject(data);
			String parametro = request.getPathInfo();
			int id = Integer.parseInt(parametro.substring(1));
			AulaDAO daoAula = new AulaDAO();
			Aula newAula = new Aula(0, aula.getString("nombre"), aula.getInt("capacidad"));
			daoAula.updateAula(id, newAula);
			result.put("data", aula);
			response.getWriter().append(result.toString());

		} catch (Exception ex) {

			JSONObject error = new JSONObject();
			error.put("Error", true);
			error.put("data", "{}");
			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());

		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject result = new JSONObject();
		result.put("Error", false);
		result.put("Mensaje", "OK");

		try {
			String parametro = request.getPathInfo();
			int id = Integer.parseInt(parametro.substring(1));
			AulaDAO daoAula = new AulaDAO();
			daoAula.deleteAula(id);
			result.put("data", parametro);
			response.getWriter().append(result.toString());

		} catch (Exception ex) {
			JSONObject error = new JSONObject();
			error.put("Error", true);
			error.put("data", "{}");
			error.put("Mensaje", ex.getMessage());
			response.getWriter().append(error.toString());

		}

	}
}
