package net.daergoth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daergoth.data.ProductDao;
import net.daergoth.data.ProductDaoMock;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductDao dao;
	    
	public ProfileServlet() {
        super();
    }

	@Override
    public void init() throws ServletException {
	    dao = new ProductDaoMock();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", dao.getAllProducts());
		
		request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
