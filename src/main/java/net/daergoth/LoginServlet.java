package net.daergoth;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daergoth.data.UserDao;
import net.daergoth.data.UserDaoMock;
import net.daergoth.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao dao;
	
    public LoginServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		dao = new UserDaoMock();
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("** INFO ** LoginServlet POST");
		System.out.println("** INFO ** LoginServlet - ContextPath: " + request.getServletPath());

		if (request.getServletPath().equals("/login")) {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			System.out.println("** INFO ** /login - email: " + email + ", password: " + password);
			
			User u = dao.getUserByEmail(email);
			
			if (email != null && password != null && u != null) {
				if (password.equals(u.getPassword())) {
					request.getSession().setAttribute("logged-in-as", email);
					
					response.sendRedirect("/profile");
				} else {
					// Email/Password not correct
					// Send login page back
					request.getRequestDispatcher("/WEB-INF/login.jsp?error=0").forward(request, response);
				}
			} else {
				// Missing email or password
				// Send login page back
				request.getRequestDispatcher("/WEB-INF/login.jsp?error=1").forward(request, response);
			}
			
		} else if (request.getServletPath().equals("/logout")) {
			request.getSession().removeAttribute("logged-in-as");
			
			response.sendRedirect("/");
		}
		
	}

}
