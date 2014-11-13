package ar.edu.itba.it.paw.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.itba.it.paw.domain.users.UserRepo;

@Component
public class AuthenticationFilter implements Filter {

	private UserRepo users;

	@Autowired
	public AuthenticationFilter(UserRepo users) {
		this.users = users;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// Do nothing
	}

	public void destroy() {
		// Do nothing
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if (!req.getRequestURL().toString().contains("login") && req.getSession().getAttribute("userId") == null) {
			resp.sendRedirect(req.getContextPath() + "/bin/user/login");
			return ;
		} else if (!req.getRequestURL().toString().contains("login")) {
			req.setAttribute("user", users.get((Integer)req.getSession().getAttribute("userId")));
		}
		chain.doFilter(request, response);
	}
}