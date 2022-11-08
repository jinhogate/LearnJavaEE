package com.learnjavaee.controler.servlets;

import java.io.IOException;

import com.learnjavaee.metier.facade.FichierFacade;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class EnvoieFichierServlet
 */
public class EnvoieFichierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CHEMIN_FICHIERS = "D:/Learn/Java/JAVAEE/File_server/"; // A changer
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvoieFichierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/fichier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FichierFacade  fichierFacade = new FichierFacade();
		// On récupère le champ description comme d'habitude
        String description = request.getParameter("description");
        request.setAttribute("description", description );

        // On récupère le champ du fichier
        Part part = request.getPart("fichier");
            
        // On vérifie qu'on a bien reçu un fichier
        String nomFichier = fichierFacade.getNomFichier(part);

        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            // On écrit définitivement le fichier sur le disque
             fichierFacade.ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            request.setAttribute(nomChamp, nomFichier);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/fichier.jsp").forward(request, response);
	}

}
