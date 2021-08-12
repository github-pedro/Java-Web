package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.ViagemBO;
import br.com.model.ViagemModel;

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
			ViagemBO viagemBO = new ViagemBO();
		ArrayList<ViagemModel> filtrar = new ArrayList<ViagemModel>();
			String filtro = request.getParameter("consulta");
			filtrar = viagemBO.filtrarViagem(filtro);
			request.setAttribute("ViagemModel", filtrar);
			request.getRequestDispatcher("minhasviagens.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
