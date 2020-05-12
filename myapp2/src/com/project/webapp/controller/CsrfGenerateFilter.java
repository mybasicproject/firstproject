package com.project.webapp.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
//import com.google.common.cache.LoadingCache;


@WebFilter(urlPatterns = "/CsrfGenerateFilter",servletNames={"HomeController"})
public class CsrfGenerateFilter implements Filter {


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Initialized...");
	}

	public void destroy() {
		System.out.println("Filter destroyed...");
	}

	
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//String csrfValue = RandomStringUtils.random(10, 0, 0, true, true, null, new SecureRandom());
//		String csrfValue = RandomStringUtils.randomAlphanumeric(20);
//		HttpServletRequest req = (HttpServletRequest)request;
//		HttpSession session = req.getSession();
//		session.setAttribute("csrfToken", csrfValue);
//		chain.doFilter(request, response);
//		req.getRequestDispatcher("index.jsp").forward(request, response);
		// Assume its HTTP
        HttpServletRequest httpReq = (HttpServletRequest) request;

        // Check the user session for the salt cache, if none is present we create one
        Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>)httpReq.getSession()
        		.getAttribute("csrfPreventionSaltCache");

        if (csrfPreventionSaltCache == null){
            csrfPreventionSaltCache = CacheBuilder.newBuilder()
                .maximumSize(5000)
                .expireAfterWrite(20, TimeUnit.MINUTES)
                .build(null);

            httpReq.getSession().setAttribute("csrfPreventionSaltCache", csrfPreventionSaltCache);
        }

        // Generate the salt and store it in the users cache
        String salt = RandomStringUtils.random(20, 0, 0, true, true, null, new SecureRandom());
        //csrfPreventionSaltCache.put(salt, Boolean.TRUE);
        csrfPreventionSaltCache.asMap().put(salt, Boolean.TRUE);

        // Add the salt to the current request so it can be used
        // by the page rendered in this request
        httpReq.setAttribute("csrfPreventionSalt", salt);

        chain.doFilter(request, response);
        httpReq.getRequestDispatcher("index.jsp").forward(httpReq, response);
	}

}
