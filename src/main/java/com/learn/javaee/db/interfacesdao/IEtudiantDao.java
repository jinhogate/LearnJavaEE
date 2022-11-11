package com.learn.javaee.db.interfacesdao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.learn.javaee.exception.DaoException;
import com.learnjavaee.models.beans.EtudiantBean;

public interface IEtudiantDao extends Serializable {

	// Recupérer tous les étudiants dans la base
	List<EtudiantBean> getAllEtudiants () throws DaoException;
	// Insérer un étudiant en base
	List<EtudiantBean>  ajouter(EtudiantBean etudiant) throws DaoException;
	
}
