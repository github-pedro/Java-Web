package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.BO.ViagemBO;
import br.com.model.ViagemModel;

/**
 * Servlet implementation class ViagemController
 */
@WebServlet("/ViagemController")
public class ViagemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViagemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ViagemBO viagemBO = new ViagemBO();
		String acao = request.getParameter("acao");
		if (acao != null && acao.equals("lis")) {

			ArrayList<ViagemModel> viagem = new ArrayList<ViagemModel>();
			viagem = viagemBO.mostrarViagem();
			request.setAttribute("ViagemModel", viagem);
			request.getRequestDispatcher("minhasviagens.jsp").forward(request, response);

		} else if (acao != null && acao.equals("ex")) {

			int id = Integer.parseInt(request.getParameter("id"));
			viagemBO.Deletar(id);
			response.sendRedirect("ViagemController?acao=lis");

		} else if (acao != null && acao.equals("alterar")) {

			String id = request.getParameter("id");
			ViagemModel viagem = viagemBO.buscarporRG(Integer.parseInt(id));
			request.setAttribute("viagemAlt", viagem);
			request.getRequestDispatcher("AlterarViagem.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ViagemBO viagemBO = new ViagemBO();
		String acao = request.getParameter("acao");

		Date dataVolta = Date.valueOf(request.getParameter("dataVolta"));
		Date dataSaida = Date.valueOf(request.getParameter("dataSaida"));
		
		if (acao != null && acao.equals("add")) {
			
			viagemBO.addViagem(new ViagemModel(
					request.getParameter("planejamento"), request.getParameter("pais"),request.getParameter("estado"),request.getParameter("cidade"), dataSaida, dataVolta,
					Double.parseDouble(request.getParameter("gasto")), request.getParameter("descricao")));
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Viagem Cadastrada com Sucesso!');");
			pw.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("viagem.jsp");
			rd.include(request, response);
			
		} else if (acao != null && acao.equals("alt")) {
			
			response.setContentType("text/html");
			ViagemModel viagem = new ViagemModel(Integer.parseInt(request.getParameter("id")),request.getParameter("planejamento"), request.getParameter("pais"),request.getParameter("estado"),request.getParameter("cidade"), dataSaida, dataVolta,
					Double.parseDouble(request.getParameter("gasto")), request.getParameter("descricao"));
			viagemBO.Alterar(viagem);
			response.sendRedirect("ViagemController?acao=lis");
			
		}

	}

}
