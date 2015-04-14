package com.s3d.webapps.util;

import java.io.File;
import java.io.IOException;

import javax.activation.FileTypeMap;
import javax.activation.MimetypesFileTypeMap;

public class FileMimeTypeUtil {
	private static FileTypeMap defaultMap = null;

	public static String getContentType(File file) {
		String filename = file.getName();
		return getContentType(filename);
	}

	public static String getContentType(String filename) {
		if (defaultMap == null) {
			try {
				defaultMap = new MimetypesFileTypeMap(ConfigLocationsUtil
						.getWebContentPath()
						+ "/META-INF/mime.types");
			} catch (IOException e) {
			}
		}
		return defaultMap.getContentType(filename);

	}
}
