package com.learnjavaee.controlers;

import java.util.ArrayList;
import java.util.List;

import com.learnjavaee.models.beans.CompteBean;
import com.learnjavaee.models.beans.UserBean;

import jakarta.servlet.http.HttpServletRequest;

public class ConnectionControler {
	List<CompteBean> comptes = new ArrayList<>();
	private void init() {
		// Initialisation des users
		UserBean user1 = new UserBean();
		user1.setIdUser(1);
		user1.setNomUser("GBEGNON");
		user1.setPrenomUser("Kossi Jorjinho");
		user1.setSexeUser("M");
		UserBean user2 = new UserBean();
		user2.setIdUser(2);
		user2.setNomUser("MEWENEMESSE");
		user2.setPrenomUser("Herve");
		user2.setSexeUser("F");
		// Initialisations de leurs comptes
		CompteBean cb1 = new CompteBean();
		cb1.setIdCompte(1);
		cb1.setLogin(user1.getNomUser());
		cb1.setPass(cb1.getLogin().concat("@"));
		cb1.setUserBean(user1);
		CompteBean cb2 = new CompteBean();
		cb2.setIdCompte(1);
		cb2.setLogin(user2.getNomUser());
		cb2.setPass(cb2.getLogin().concat("@"));
		cb2.setUserBean(user2);
		// Liste des comptes utilisateurs
		comptes.add(cb1);
		comptes.add(cb2);
	}
	
	/**
	 *  Cette méthode va nous servir à vérifier les identifiants de l'utilisateurs qui se connectent 
	 * @param request
	 * @return
	 */
	public CompteBean verifierConnextion(HttpServletRequest request) {
		this.init();
		CompteBean cb = new CompteBean();
		cb.setLogin(request.getParameter("login"));
		cb.setPass(request.getParameter("pass"));
		
		for(CompteBean compte : comptes) {
			if(cb.getLogin().equals(compte.getLogin()) && cb.getPass().equals(compte.getPass())) {
				return compte;
			}
		}
		return null;
	}
	
}
