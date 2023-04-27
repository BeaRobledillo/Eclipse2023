package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aulaController
 */
@WebServlet("/aulas/*")
public class aulaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AulaDao auladao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public aulaController() {
		auladao = new AulaDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listaAulas(request, response);
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void listaAulas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Aula> aulas = auladao.get();
		request.setAttribute("aula", aulas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("aulas.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}