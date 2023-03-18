package br.com.hotel;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.com.hotel.util.JPAFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testeservlet")
public class TesteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet conectado....");
		
		EntityManager em = JPAFactory.getEntityManager();
		
		System.out.println("EM" + em);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("hotel-devaneio.jsp");
		requestDispatcher.forward(req, resp);
	
	}
}
