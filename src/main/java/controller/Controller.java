package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans produto = new JavaBeans();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			listaProdutos(request, response);
		} else if (action.equals("/insert")){
			novoProduto(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	// listar produtos
	protected void listaProdutos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//criando um novo objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		//encaminhar a alista de produtos
		request.setAttribute("produtos", lista);
		RequestDispatcher rd =request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
	}
	
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//setar as variaveis javabeans
		produto.setNomepro(request.getParameter("nome"));
		produto.setDescripro(request.getParameter("descrição"));
		produto.setMercapro(request.getParameter("mercadoalvo"));
		produto.setTecnopro(request.getParameter("tecnologias"));
		dao.inserirProduto(produto);
		//redirecionar para o documento lista.jsp
		response.sendRedirect("main");
	}

}
