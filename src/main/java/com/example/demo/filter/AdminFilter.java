package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",initParams={@WebInitParam(name ="EXCLUDED_PAGES" , value = "login;addlogin")})
public class AdminFilter implements Filter {

    private String excludedPages;
    private String[] excludedPageArray;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPages = filterConfig.getInitParameter("EXCLUDED_PAGES");
        if (null!=excludedPages && excludedPages.length()!=0) {
            excludedPageArray = excludedPages.split(String.valueOf(';'));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        boolean isExcludedPage = false;
        for (String page : excludedPageArray) {
            if(request.getServletPath().substring(1).equals(page)){
                isExcludedPage = true;
                break;
            }
        }
        if (isExcludedPage) {
            filterChain.doFilter(request, response);
        }
        else {
            if(session!=null&&session.getAttribute("admin") != null){
                filterChain.doFilter(request, response);
            }
            else{
                response.sendRedirect("/grafana_admin/login");
            }
        }
    }

    @Override
    public void destroy() {
        this.excludedPages = null;
        this.excludedPageArray = null;
    }
}
