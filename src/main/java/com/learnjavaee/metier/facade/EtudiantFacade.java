package com.learnjavaee.metier.facade;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learn.javaee.db.interfacesdao.IEtudiantDao;
import com.learn.javaee.db.utils.DaoFactory;
import com.learn.javaee.exception.DaoException;
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
	 * @throws DaoException 
	 */
	public List<EtudiantBean> getAllEtudiants() throws DaoException{
		return dao.getAllEtudiants();
	}
	
	/**
	 * Insérer un étudiant en base
	 * @param etudiant
	 * @throws DaoException 
	 */
	public List<EtudiantBean> ajouterEtudiant(EtudiantBean etudiant) throws DaoException {
		if(etudiant.getNom().length()>10) {
			throw  new DaoException("Le nom de l'étudiant ne doit pas dépasser 10 caractères");
		}
		return dao.ajouter(etudiant);
	}
}
