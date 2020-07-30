package controllers.word;

import java.io.IOException;

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
 * Servlet implementation class WordEditServlet
 */
@WebServlet("/word/edit")
public class WordEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.createEntityManager();
		Word w = em.find(Word.class, Integer.parseInt(request.getParameter("id")));
		em.close();

		User login_user = (User)request.getSession().getAttribute("login_user");
		if(w != null && login_user != null && w.getPosting_user().getPrimary_id() == login_user.getPrimary_id()) {
			request.setAttribute("word", w);
			request.setAttribute("_token", request.getSession().getId());
			request.getSession().setAttribute("word_primary_id", w.getPrimary_id());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word/edit.jsp");
		rd.forward(request, response);
	}

}
