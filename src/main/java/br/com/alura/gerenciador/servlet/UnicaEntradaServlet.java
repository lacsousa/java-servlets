package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

//@WebServlet(name = "entrada", urlPatterns = { "/entrada" })
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//	    boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//	    boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//        
//	    if(ehUmaAcaoProtegida & usuarioNaoEstaLogado) {
//            response.sendRedirect("entrada?acao=LoginForm");
//            return;
//        }

		
		String nomeClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String endereco;
		
		try {
			Class classe = Class.forName(nomeClasse); // carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();;
			endereco = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}


//		if (paramAcao.equals("ListaEmpresas")) {
//
//			ListaEmpresas acao = new ListaEmpresas();
//			endereco = acao.executa(request, response);
//
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//
//			RemoveEmpresa acao = new RemoveEmpresa();
//			endereco = acao.executa(request, response);
//
//		} else if (paramAcao.equals("MostraEmpresa")) {
//
//			MostraEmpresa acao = new MostraEmpresa();
//			endereco = acao.executa(request, response);
//
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//
//			AlteraEmpresa acao = new AlteraEmpresa();
//			endereco = acao.executa(request, response);
//
//		} else if (paramAcao.equals("NovaEmpresa")) {
//
//			NovaEmpresa acao = new NovaEmpresa();
//			endereco = acao.executa(request, response);
//
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			endereco = acao.executa(request, response);
//		}

		String[] tipoEEndereco = endereco.split(":");
		if (tipoEEndereco != null && tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}

	}

}
