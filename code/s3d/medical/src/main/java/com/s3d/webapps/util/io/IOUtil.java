package com.s3d.webapps.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
	public static final int defaultBufSize = 1024;

	public static void write(InputStream in, OutputStream out)
			throws IOException {
		write(in, out, 0);
	}

	public static void write(InputStream in, OutputStream out, int bufSize)
			throws IOException {
		int _bufSize = bufSize != 0 ? bufSize : defaultBufSize;
		byte[] buffer = new byte[_bufSize];
		int len;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		out.flush();
		out.close();
		in.close();
	}
}
