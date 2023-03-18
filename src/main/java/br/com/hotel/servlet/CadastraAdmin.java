package br.com.hotel.servlet;

import java.io.IOException;

import br.com.hotel.modelo.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class CadastraAdmin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("***********************teste");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Integer hotel = Integer.parseInt(req.getParameter("hotel"));
		
		Admin admin = new Admin(nome, email, senha,hotel);
		
		System.out.println(admin);
		
		
	}

}
