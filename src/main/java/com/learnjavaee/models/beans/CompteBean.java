package com.learnjavaee.models.beans;

public class CompteBean {
	private Integer idCompte;
	private String login;
	private String pass;
	
	private UserBean userBean;
	
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public Integer getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
