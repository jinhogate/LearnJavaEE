package com.learn.javaee.db.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learn.javaee.db.dao.EtudiantDao;

public class DaoFactory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7833702767048926149L;
	private static DaoFactory singleton;
	private String dbpath;

	private DaoFactory (String dbpath) {
		this.dbpath = dbpath;
	}

	public static DaoFactory getInstance(String dbpath) {
		if(singleton==null) {
			singleton = new DaoFactory(dbpath);
		}
		return singleton;
	}

	/**
	 *  Définition de la méthode de connexion
	 * @param dbPath
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnect() throws ClassNotFoundException, SQLException {
			Class.forName("org.sqlite.JDBC");
			Logger.getLogger(DaoFactory.class.getName()).log(Level.INFO, "Connection à {0} avec succès!",this.dbpath );
			return DriverManager.getConnection("jdbc:sqlite:"+this.dbpath);
	}
	
	/**
	 * Recupération de l'implémentation du DAO
	 * @return
	 */
	public EtudiantDao getUtilisateurDao() {
		return new EtudiantDao(this);
	}
	
}
