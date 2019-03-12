package com.gh.server;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor2 {
	
	private static final String servletNamePre = "com.gh.server.";

	public void process(Request request, Response response) {
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		Class myClass = null;
		try {
			myClass = ServletProcessor2.class.getClassLoader().loadClass(servletNamePre+servletName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		try {
			RequestFacade requestFacade = new RequestFacade(request);
			ResponseFacade responseFacade = new ResponseFacade(response);
			servlet = (Servlet) myClass.newInstance();
			servlet.service((ServletRequest) requestFacade, (ServletResponse) responseFacade);
		} catch (Exception e) {
			System.out.println(e.toString());
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
	}

}
