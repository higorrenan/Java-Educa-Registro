package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;
import java.util.ArrayList;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			registros(request, response);

		} else if (action.equals("/insert")) {
			novoContato(request, response);

		} else if (action.equals("/select")) {
			listarContato(request, response);

		} else if (action.equals("/update")) {
			editarContato(request, response);

		} else if (action.equals("/delete")) {
			removerContato(request, response);

		} else {
			response.sendRedirect("registro.jsp");
		}
	}

	// listar contatos, comando para diretorio ao documento jsp
	protected void registros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto para receber os dados JavaBens
		ArrayList<JavaBeans> lista = dao.listarcontatos();
		// Encaminahar a lista ao documento agenda.jsp
		request.setAttribute("registros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
		rd.forward(request, response);
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getId_contato());
		 * System.out.println(lista.get(i).getNome_contato());
		 * System.out.println(lista.get(i).getFone_contato());
		 * System.out.println(lista.get(i).getEmail_contato()); }
		 */

	}

	// métedo para setar as variáveis para a classe JavaBeans
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setNome_contato(request.getParameter("nome_contato"));
		contato.setFone_contato(request.getParameter("fone_contato"));
		contato.setEmail_contato(request.getParameter("email_contato"));
		// invocar o método inserirContato passando o obejeto contato
		dao.inserirContato(contato);
		// redirecionar para o documento registro.jsp
		response.sendRedirect("main");
	}

	// Editar contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento
		String idcon = request.getParameter("idcon");
		// Setar a varíavel JavaBeans
		contato.setId_contato(idcon);
		// Executar o método selecionarConatato (DAO)
		dao.selecionarContato(contato);
		// Setar os atributos do Formulário com o conteúdo JavaBeans
		request.setAttribute("id_contato", contato.getId_contato());
		request.setAttribute("nome_contato", contato.getNome_contato());
		request.setAttribute("fone_contato", contato.getFone_contato());
		request.setAttribute("email_contato", contato.getEmail_contato());
		// Ecaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	// método editar contato
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variáveis JavaBeans
		contato.setId_contato(request.getParameter("id_contato"));
		contato.setNome_contato(request.getParameter("nome_contato"));
		contato.setFone_contato(request.getParameter("fone_contato"));
		contato.setEmail_contato(request.getParameter("email_contato"));
		// Executar o método alterar contato
		dao.alteraContato(contato);
		// redirecionar para o documento registro.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}

	// Excluir contato
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("id_contato");
		// setar a variável id_contato JavaBeans
		contato.setId_contato(idcon);
		// executar o método deletar contato
		dao.deletarContato(contato);
		// redirecionar para o documento registro.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}
}
