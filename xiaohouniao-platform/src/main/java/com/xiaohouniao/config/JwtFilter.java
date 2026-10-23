package com.xiaohouniao.config;

import com.xiaohouniao.common.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter implements Filter {

    private final JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI();

        if (path.startsWith("/api/public/") || path.startsWith("/uploads/")
                || path.equals("/") || path.endsWith(".html") || path.endsWith(".js")
                || path.endsWith(".css") || path.endsWith(".png") || path.endsWith(".jpg")
                || path.endsWith(".svg") || path.endsWith(".ico") || path.endsWith(".woff2")) {
            chain.doFilter(request, response);
            return;
        }

        if (path.startsWith("/api/admin/auth/")) {
            chain.doFilter(request, response);
            return;
        }

        String authHeader = req.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            resp.setStatus(401);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write("{\"code\":401,\"msg\":\"未登录\"}");
            return;
        }

        try {
            String token = authHeader.substring(7);
            jwtUtil.parseToken(token);
            chain.doFilter(request, response);
        } catch (Exception e) {
            resp.setStatus(401);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write("{\"code\":401,\"msg\":\"Token无效或已过期\"}");
        }
    }
}
