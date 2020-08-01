package com.helpers;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBManagerSetup implements ServletContextListener{
	private DBManager dbm = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext sc = sce.getServletContext();
		String uid = sc.getInitParameter("DBUSER");
		String pwd = sc.getInitParameter("DBPASS");
		String url= sc.getInitParameter("DBURL");
		dbm = new DBManager(url,uid,pwd);

		sc.setAttribute("TodoDBManager", dbm);

	}
}
