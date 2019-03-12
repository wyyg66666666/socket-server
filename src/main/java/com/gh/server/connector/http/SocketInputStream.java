package com.gh.server.connector.http;

import java.io.IOException;
import java.io.InputStream;

public class SocketInputStream extends InputStream {
	
	InputStream input = null;

	public SocketInputStream(InputStream input, int bufferSize) {
		this.input = input;
	}

	@Override
	public int read() throws IOException {
		byte[] buffer = new byte[2048];
		int i = 0;
		try {
			// input is the InputStream from the socket.
			i = input.read(buffer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	
	public void readRequestLine(HttpRequestLine requestLine) {
		
	}

}
