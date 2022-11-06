package com.learnjavaee.controler.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import com.learnjavaee.controlers.ConnectionControler;
import com.learnjavaee.models.beans.CompteBean;

/**
 * Servlet implementation class AccueilServlet
 */
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) Cette méthode permet de gérer les actions de la page d'accueil
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> pParams = request.getParameterMap();
		String pName = request.getParameter("name");
		request.setAttribute("name", pName);
		request.setAttribute("params", pParams);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConnectionControler connectionControler = new ConnectionControler();
		HttpSession session = request.getSession();
		CompteBean compte = connectionControler.verifierConnextion(request);
		if(compte!=null) {
			// Envoi information du compte user sur la page à forward
			request.setAttribute("compte", compte);
			// Envoi information du compte user dans sa session
			session.setAttribute("compteSession", compte);
			// Envoi information identifiant user dans des cookies
			Cookie cookieLogin = new Cookie("login", compte.getLogin());
			Cookie cookiePass= new Cookie("pass", compte.getPass());
			cookieLogin.setComment("Votre login");
			cookieLogin.setHttpOnly(true);
			cookieLogin.setMaxAge(60*60);
			cookieLogin.setSecure(true);
			response.addCookie(cookieLogin);
			response.addCookie(cookiePass);
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/accueil.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Vos identifiants sont erronnés, veuillez les resaisir!");
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connection.jsp").forward(request, response);
		}
		
	}

}
