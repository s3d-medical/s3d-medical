package com.s3d.tech.springmvc;

import com.s3d.tech.restapi.result.RltDto;
import com.s3d.tech.utils.JacksonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wind.chen
 * @since 2016/9/21.
 */
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomHandlerExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache");
        try {
            RltDto rltDto = new RltDto();
            rltDto.fail(ex.getMessage());
            response.getWriter().write(JacksonParser.convertToJSONString(rltDto));
        } catch (Exception e) {
            LOGGER.error("Collo"+ e.getMessage(), e);
        }
        return mv;
    }
}
