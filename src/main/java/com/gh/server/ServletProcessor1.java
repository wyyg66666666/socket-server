package com.gh.server;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor1 {
	
	private static final String servletNamePre = "com.gh.server.";

	public void process(Request request, Response response) {
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
//		URLClassLoader loader = null;
//		try {
//			// create a URLClassLoader
//			URL[] urls = new URL[1];
//			URLStreamHandler streamHandler = null;
//			File classPath = new File(Constants.WEB_ROOT);
//			// the forming of repository is taken from the
//			// createClassLoader method in
//			// org.apache.catalina.startup.ClassLoaderFactory
//			String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
//			// the code for forming the URL is taken from
//			// the addRepository method in
//			urls[0] = new URL(null, repository, streamHandler);
//			loader = new URLClassLoader(urls);
//		} catch (IOException e) {
//			System.out.println(e.toString());
//		}
		Class myClass = null;
		try {
			myClass = ServletProcessor1.class.getClassLoader().loadClass(servletNamePre+servletName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		try {
			servlet = (Servlet) myClass.newInstance();
			servlet.service((ServletRequest) request, (ServletResponse) response);
		} catch (Exception e) {
			System.out.println(e.toString());
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
	}

}
