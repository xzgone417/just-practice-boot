package com.exp.ucmp.auth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

import com.egrid.shiro.session.mgt.ShiroSessionThreadLocal;

@Component
@WebFilter(urlPatterns = "/**", filterName = "CleanFilter") 
public class CleanFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	try {
    		chain.doFilter(request, response);
    	} finally {
    		/*清理与Shiro相关的线程本地变量*/
    		ShiroSessionThreadLocal.getInstance().cleanLocalValue();
    	}
    }
 
    @Override
    public void destroy() {
    }
}
