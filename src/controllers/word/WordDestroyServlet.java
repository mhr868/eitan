package controllers.word;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Word;
import utils.DBUtil;

/**
 * Servlet implementation class WordDestroyServlet
 */
@WebServlet("/word/destroy")
public class WordDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String _token = request.getParameter("_token");
		if(_token != null && _token.equals(request.getSession().getId())) {
			EntityManager em = DBUtil.createEntityManager();

			Word w = em.find(Word.class, (Integer)request.getSession().getAttribute("word_primary_id"));

			em.getTransaction().begin();
			em.remove(w);
			em.getTransaction().commit();
			em.close();

			request.getSession().removeAttribute("word_primary_id");
			request.getSession().setAttribute("flush", "登録情報を削除しました。");

			response.sendRedirect(request.getContextPath() + "/user/word/index");
		}
	}

}
