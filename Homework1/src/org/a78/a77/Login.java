package org.a78.a77;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String LOGIN = "admin";
	private static final String PASS = "qwerty123";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		showLoginPage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("login") == null || request.getParameter("pass") == null){
			showLoginPage(request, response);
		} else {
			showLoggedInPage(request, response);
		}
	}

	private void showLoginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().print(genLoginPage());
	}
	
	private void showLoggedInPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html; charset=UTF-8");
		if(req.getParameter("login").equals(LOGIN) && req.getParameter("pass").equals(PASS)){
			resp.getWriter().print(genLoginSuccesPage());
		} else {
			resp.getWriter().print(genLoginErrorPage());
		}		
	}
	
	private String genLoginPage(){
		StringBuilder page = new StringBuilder();
		
		page.append("<html><head><title>Log in</title></head>");
		page.append("<body>");
		page.append("<form method=POST>");
		page.append("Username:<input type=text name=login required><br/>");
		page.append("Password:<input type=password name=pass required><br/>");
		page.append("<input type=submit value='Log in'>");
		page.append("</form>");
		page.append("</body></html>");
		
		return page.toString();
	}
	
	private String genLoginSuccesPage() {
		StringBuilder page = new StringBuilder();
		
		page.append("<html><head><title>Admin page</title></head>");
		page.append("<body>");
		page.append("<h1>Login successfull!</h1>");
		page.append("<h2>Welcome, " + LOGIN + "</h2>");
		page.append("</body></html>");
		
		return page.toString();
	}
	
	private String genLoginErrorPage() {
		StringBuilder page = new StringBuilder();
		
		page.append("<html><head><title>Admin page</title></head>");
		page.append("<body>");
		page.append("<h1>Login Error!</h1>");
		page.append("<h2>Username or password incorrect. Please <a href=\"\">try again</a></h2>");
		page.append("</body></html>");
		
		return page.toString();
	}
	
}
