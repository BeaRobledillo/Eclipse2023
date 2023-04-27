package text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controler.Aula;
import controler.AulaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AulaControler
 */

@WebServlet(urlPatterns = { "/aula", "/nueva", "/insertar", "/borrar", "/editar", "/actualizar" })
public class AulaControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AulaDAO auladao;

	/**
	 * Default constructor.
	 */
	public AulaControler() {
		auladao = new AulaDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);

		try {
			switch (action) {
			case "/Nueva":
				System.out.println("Nueva");
				NuevaAula(request, response);
				break;
			case "/Insertar":
				System.out.println("Insertar");
				insertarAula(request, response);
				break;
			case "/borrar":
				System.out.println("Borrar");
				borrarAula(request, response);

				break;
			case "/editar":
				System.out.println("Editar");
				EditarAula(request, response);
				break;
			case "/actualizar":
				System.out.println("Actualizar");
				actualizarAula(request, response);

				break;

			default:
				System.out.println("Index");

				listaAulas(request, response);
				break;
			}

		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listaAulas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Aula> aulas = auladao.get();
		request.setAttribute("aula", aulas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("aulas.jsp");
		dispatcher.forward(request, response);
	}

	private void NuevaAula(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("NuevaAula.jsp");
		dispatcher.forward(request, response);
	}

	private void insertarAula(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String nombre = request.getParameter("nombre");
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		Aula aula = new Aula(0, nombre, capacidad);
		auladao.addAula(aula);
		response.sendRedirect("aula");
	}

	private void EditarAula(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Aula aula = new Aula(0, null, id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditarAula.jsp");
		request.setAttribute("aula", aula);
		dispatcher.forward(request, response);

	}

	private void actualizarAula(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		Aula aula = new Aula(0, nombre, capacidad);
		auladao.addAula(aula);
		response.sendRedirect("./aula");
	}

	private void borrarAula(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		auladao.deleteAula(id);
		response.sendRedirect("aula");

	}

}
