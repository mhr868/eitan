package controllers.word;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Word;
import models.validators.WordValidator;
import utils.DBUtil;

/**
 * Servlet implementation class WordUpdateServlet
 */
@WebServlet("/word/update")
public class WordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordUpdateServlet() {
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
			w.setWord(request.getParameter("word"));
			w.setMean(request.getParameter("mean"));
			w.setSituation(request.getParameter("situation"));
			w.setNote(request.getParameter("note"));



			List<String> errors = WordValidator.validate(w);
			if(errors.size() > 0) {
				em.close();

				request.setAttribute("errors", errors);
				request.setAttribute("word", w);
				request.setAttribute("_token", request.getSession().getId());

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word/edit.jsp");
				rd.forward(request, response);
			} else {
				em.getTransaction().begin();
				em.getTransaction().commit();
				em.close();

				request.getSession().removeAttribute("word_primary_id");
                request.getSession().setAttribute("flush", "登録情報を更新しました。");
				response.sendRedirect(request.getContextPath() + "/user/word/index");
			}
		}
	}
}
