package com.s3d.tech.utils;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  util for HttpResponse.
 *  Wind.Chen on 2014/11/27.
 */
public class ResponseUtils {

    /**
     *
     * @param agent                        request.getHeader("USER-AGENT")
     * @param response
     * @param fileAbsolutePath           absolute file path.
     * @throws java.io.IOException
     */
    public static void writeFileToResponse(String agent, HttpServletResponse response, String fileAbsolutePath) throws IOException {
        if (fileAbsolutePath == null || "".equals(fileAbsolutePath)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No related files are generated.");
        }else{
            writeFileToResponse(agent, response, new File(fileAbsolutePath));
        }
    }

    /**
     *
     * @param agent              request.getHeader("USER-AGENT")
     * @param response
     * @param file
     * @throws java.io.IOException
     */
    public static void writeFileToResponse(String agent, HttpServletResponse response, File file) throws IOException {
        if (file == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
            return;
        }

        String fileName = file.getName();
        if ((agent != null) && (agent.contains("Mozilla"))) {
            fileName = fileName.replaceAll(" ", "_");
        }

        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        int v;
        byte[] bytes = new byte[1024];
        while ((v = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, v);
        }
        outputStream.flush();
        IOUtils.closeQuietly(outputStream);
        IOUtils.closeQuietly(inputStream);
    }

}
