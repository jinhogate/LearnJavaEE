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
	 * Cette m�thode devrait recevoir la requ�te HTTP en param�tre, effecturer une action puis renvoyer une r�ponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On recup�re dans un premiere temps la r�f�rence de notre servlet dans le context courant dans lequel il est ex�cut�
		// Ensuite on recup�re l'object RequestDispatcher qui permet de lier une requ�te � une ressource
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
