package com.api.bompreparo.application.config.security.jwt.handler;

import com.api.bompreparo.application.config.security.jwt.ServletUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException exc) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            String json = ServletUtil.getJson("error", "Acesso negado.");
            ServletUtil.write(response, HttpStatus.FORBIDDEN, json);
        }
    }

}
