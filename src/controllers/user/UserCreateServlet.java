package controllers.user;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet("/user/create")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String _token = request.getParameter("_token");
		if(_token != null && _token.equals(request.getSession().getId())) {
			EntityManager em = DBUtil.createEntityManager();

			User u = new User();
			u.setUser_id(request.getParameter("user_id"));
			String password = EncryptUtil.getPasswordEncrypt(
					request.getParameter("password"),
					(String)this.getServletContext().getAttribute("salt")
					);
			u.setPassword(password);
			u.setName(request.getParameter("name"));
			u.setAdmin_flag(0);
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			u.setCreated_at(currentTime);
			u.setUpdated_at(currentTime);




			em.close();
		}
	}

}
