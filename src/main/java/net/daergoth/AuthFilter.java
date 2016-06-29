package net.daergoth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daergoth.data.UserDao;
import net.daergoth.data.UserDaoMock;
import net.daergoth.model.User;

public class AuthFilter implements Filter {

	private UserDao dao;
	
    public AuthFilter() {
    	
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
		dao = new UserDaoMock();
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String email = (String)req.getSession().getAttribute("logged-in-as");
		
		User u = dao.getUserByEmail(email);
		
		if (u == null) {
			resp.setStatus(403);
			resp.getWriter().append("Please login first!");
			return;
		}
		
		
		chain.doFilter(request, response);
	}

}
