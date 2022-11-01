package com.learnjavaee.controler.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LearnJavaServlet
 */
public class LearnJavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnJavaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Cette méthode devrait recevoir la requéte HTTP en paramètre, effecturer une action puis renvoyer une réponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Echange de données du servlet au JSPs
		request.setAttribute("userName", "GBEGNON Kossi");
		request.setAttribute("userOld", 25);
		// On recupère dans un premiere temps la référence de notre servlet dans le context courant dans lequel il est exécuté
		// Ensuite on recupère l'object RequestDispatcher qui permet de lier une requête à une ressource
		// Enfin on applique la redirection
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/learn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
