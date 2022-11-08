package com.learnjavaee.controler.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.learnjavaee.metier.facade.EtudiantFacade;
import com.learnjavaee.models.beans.EtudiantBean;

/**
 * Servlet implementation class EtudiantServlet
 */
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EtudiantFacade etudiantFacade = new EtudiantFacade();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("etudiants", etudiantFacade.getAllEtudiants());
    	request.getServletContext().getRequestDispatcher("/WEB-INF/pages/etudiants.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	EtudiantBean etudiant = new EtudiantBean();
    	etudiant.setNom(request.getParameter("nom"));
    	etudiant.setPrenom(request.getParameter("prenom"));
    	etudiant.setSexe(request.getParameter("sexe"));
    	request.setAttribute("etudiants", etudiantFacade.ajouterEtudiant(etudiant));
    	request.getServletContext().getRequestDispatcher("/WEB-INF/pages/etudiants.jsp").forward(request, response);
	}

}
