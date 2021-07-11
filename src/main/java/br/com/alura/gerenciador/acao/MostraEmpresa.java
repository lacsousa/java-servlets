package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa ( HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaPelaId(id);
        
        request.setAttribute("empresa", empresa);

        
		System.out.println("Ação mostrando dados da empresa");
		
		return "forward:/formAlteraEmpresa.jsp";
		
	}
	
}
