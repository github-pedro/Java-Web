package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.BO.RoupaBO;
import br.com.DAO.RoupaDAO;
import br.com.model.RoupaModel;




/**
 * Servlet implementation class RoupaController
 */
@WebServlet("/RoupaController")
public class RoupaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoupaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoupaBO roupaBO = new RoupaBO();
		String acao = request.getParameter("acao");
		
		if(acao != null && acao.equals("lis")) {
			
			ArrayList<RoupaModel> roupa = new ArrayList<RoupaModel>();
			roupa = roupaBO.mostrarRoupas();
			request.setAttribute("RoupaModel", roupa);
			request.getRequestDispatcher("listaRoupas.jsp").forward(request, response);
			
		}else if(acao != null && acao.equals("ex")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			roupaBO.Deletar(id);
			response.sendRedirect("RoupaController?acao=lis");
			
		}else if(acao != null && acao.equals("alterar")){
			
			String id = request.getParameter("id");
			RoupaModel roupa = roupaBO.buscarporID(Integer.parseInt(id));
			request.setAttribute("roupaAlt", roupa);
			request.getRequestDispatcher("AlterarCadastro.jsp").forward(request,response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoupaBO roupaBO = new RoupaBO();
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equals("add")) {
			
			roupaBO.addRoupa(new RoupaModel(request.getParameter("tipo"), request.getParameter("marca"),
					Integer.parseInt(request.getParameter("estoque")), request.getParameter("medida"),
					Float.parseFloat(request.getParameter("vcompra")),
					Float.parseFloat(request.getParameter("vvenda"))));
			response.sendRedirect("index.jsp");
			
		}else if(acao != null && acao.equals("alt")) {
			
			RoupaDAO roupaDAO = new RoupaDAO();
			response.setContentType("text/html");
		
			
			int id = Integer.parseInt(request.getParameter("id"));
			String tipo = request.getParameter("tipo");
			String marca = request.getParameter("marca");
			int estoque = Integer.parseInt(request.getParameter("estoque"));
			String medida = request.getParameter("medida");
			float vcompra = Float.parseFloat(request.getParameter("vcompra"));
			float vvenda = Float.parseFloat(request.getParameter("vvenda"));
			
			RoupaModel roupa = new RoupaModel(tipo, marca, estoque, medida, vcompra, vvenda, id);
			roupaDAO.Alterar(roupa);
			response.sendRedirect("RoupaController?acao=lis");
		}

	}

}
