package com.gh.server.startup;

import com.gh.server.connector.http.HttpConnector;

public class Bootstrap {

	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		connector.start();
	}

}
