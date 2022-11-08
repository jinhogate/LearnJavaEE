package com.learnjavaee.metier.facade;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learn.javaee.db.interfacesdao.IEtudiantDao;
import com.learn.javaee.db.utils.DaoFactory;
import com.learnjavaee.models.beans.EtudiantBean;

public class EtudiantFacade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DB_PATH = "D:/Learn/Java/JAVAEE/BDD/javaeebd/javaeebd.sqlite3";
	private IEtudiantDao dao;

	public EtudiantFacade() {
		DaoFactory daoFactory = DaoFactory.getInstance(DB_PATH);
		dao = daoFactory.getUtilisateurDao();
	}

	/**
	 * Fait appel au Dao et recupère la liste des étudiants
	 * @return
	 */
	public List<EtudiantBean> getAllEtudiants(){
		return dao.getAllEtudiants();
	}
	
	/**
	 * Insérer un étudiant en base
	 * @param etudiant
	 */
	public List<EtudiantBean> ajouterEtudiant(EtudiantBean etudiant) {
		try {
			return dao.ajouter(etudiant);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Logger.getLogger(EtudiantFacade.class.getName()).log(Level.SEVERE, "Erreur d'insertion dans la base de donnée de l'étudiant : {0}",etudiant.getId());
		}
		return new ArrayList<>();
	}
}
