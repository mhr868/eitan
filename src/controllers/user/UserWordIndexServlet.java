package controllers.user;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.Word;
import utils.DBUtil;

/**
 * Servlet implementation class UserWordIndexServlet
 */
@WebServlet("/user/word/index")
public class UserWordIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserWordIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.createEntityManager();

		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch(Exception e) {
			page = 1;
		}

		User login_user = (User)request.getSession().getAttribute("login_user");

		List<Word> words = em.createNamedQuery("getUserWords", Word.class)
				.setParameter("posting_user", login_user)
				.setFirstResult(15 * (page - 1))
				.setMaxResults(15)
				.getResultList();

		long words_count = (long)em.createNamedQuery("getUserWordsCount", Long.class)
				.setParameter("posting_user", login_user)
				.getSingleResult();

		em.close();

		if(request.getSession().getAttribute("flush") != null) {
			request.setAttribute("flush", request.getSession().getAttribute("flush"));
			request.getSession().removeAttribute("flush");
		}

		request.setAttribute("page", page);
		request.setAttribute("words", words);
		request.setAttribute("words_count", words_count);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/word_index.jsp");
		rd.forward(request, response);

	}

}
