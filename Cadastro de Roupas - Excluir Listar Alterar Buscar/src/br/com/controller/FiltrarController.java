package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.BO.RoupaBO;
import br.com.model.RoupaModel;


/**
 * Servlet implementation class FiltrarController
 */
@WebServlet("/FiltrarController")
public class FiltrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltrarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<RoupaModel> filtrar = new ArrayList<RoupaModel>();
		RoupaBO roupaBO = new RoupaBO();
		String filtro = request.getParameter("consulta");
		filtrar = roupaBO.filtrarRoupa(filtro);
		request.setAttribute("RoupaModel", filtrar);
		request.getRequestDispatcher("listaRoupas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
