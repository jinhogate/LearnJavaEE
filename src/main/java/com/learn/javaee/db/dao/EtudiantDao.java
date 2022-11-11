package com.learn.javaee.db.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learn.javaee.db.interfacesdao.IEtudiantDao;
import com.learn.javaee.db.utils.DaoFactory;
import com.learn.javaee.exception.DaoException;
import com.learnjavaee.models.beans.EtudiantBean;

public class EtudiantDao implements IEtudiantDao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DaoFactory daoFactory;
	
	public EtudiantDao(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	/**
	 * Recupérer la liste des étudiants en base
	 */
	public List<EtudiantBean> getAllEtudiants() throws DaoException{
		List<EtudiantBean> etudiants = new ArrayList<>();
		String query = "SELECT id, nom, prenom, sexe "
				+ " FROM ETUDIANT";
		try (Connection connection = this.daoFactory.getConnect();
				Statement statement =  connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)){
			while(resultSet.next()) {
				EtudiantBean etudiant = new EtudiantBean();
				etudiant.setId(resultSet.getInt("id"));
				etudiant.setNom(resultSet.getString("nom"));
				etudiant.setPrenom(resultSet.getString("prenom"));
				etudiant.setSexe(resultSet.getString("sexe"));
				etudiants.add(etudiant);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				throw new DaoException("Erreur de connection à la base car class  non trouvée");
			} else {
				Logger.getLogger(EtudiantDao.class.getName()).log(Level.SEVERE, "Erreur d'exécution de la requete :   {0}.'", query);
				throw new DaoException("Erreur d'exécution de la requête");
			}
		}
		return etudiants;
	}

	@Override
	/**
	 * Insérer un étudiant dans la base de données
	 */
	public List<EtudiantBean> ajouter(EtudiantBean etudiant) throws DaoException {
		String query = "INSERT INTO ETUDIANT(nom,prenom,sexe) VALUES (?,?,?)";
		try (Connection connection = this.daoFactory.getConnect();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, etudiant.getNom());
			preparedStatement.setString(2, etudiant.getPrenom());
			preparedStatement.setString(3, etudiant.getSexe());
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			Logger.getLogger(EtudiantDao.class.getName()).log(Level.SEVERE, "Erreur de connection à la base car class  non trouvée :" +  query);
			throw new DaoException("Erreur de connection à la base car class  non trouvée");
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(EtudiantDao.class.getName()).log(Level.SEVERE, "Erreur d'exécution de la requete :" +  query);
			throw new DaoException("Erreur d'exécution de la requête");
		}
		return this.getAllEtudiants();
	}
	
}
