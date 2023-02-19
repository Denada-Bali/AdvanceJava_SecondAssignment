package com.dbali.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dbali.entities.Account;

public class Session_Utils {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute("username").toString();
	}

	
	  public static void setAccountInSession(Account account) { 
		  HttpSession session  = getSession(); session.setAttribute("account", account); }
	  
	 
	/*
	 * public static void setAccountInSession(Account account) {
	 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
	 * "account", account); }
	 */

	public static Account getAccountFromSession() {
		HttpSession session = getSession();
		return (Account) session.getAttribute("account");
	}

	public static void invalidateSession() {
		HttpSession session = getSession();
		session.invalidate();
	}
}
