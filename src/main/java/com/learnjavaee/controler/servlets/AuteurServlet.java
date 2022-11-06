package com.learnjavaee.controler.servlets;

import java.io.IOException;

import com.learnjavaee.models.beans.AuteurBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuteurServlet
 */
public class AuteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuteurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuteurBean auteur = new AuteurBean();
		auteur.setName("GBEGNON");
		auteur.setFirstName("Kossi");
		auteur.setActif(true);
		
		String[] titres = {"Titanic","Aquaba","Emile","Sans papier","Pays pauvre"};
		
		request.setAttribute("auteur", auteur);
		request.setAttribute("titres", titres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/auteur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
