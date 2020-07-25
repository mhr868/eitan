package controllers.word;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.Word;
import utils.DBUtil;

/**
 * Servlet implementation class WordCreateServlet
 */
@WebServlet("/word/create")
public class WordCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordCreateServlet() {
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
			Word w = new Word();

			w.setWord(request.getParameter("word"));
			w.setMean(request.getParameter("mean"));
			w.setSituation(request.getParameter("situation"));
			w.setNote(request.getParameter("note"));

			User u = (User)request.getSession().getAttribute("login_user");
			w.setPosting_user(u);

			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			w.setCreated_at(currentTime);
			w.setUpdated_at(currentTime);


		}
	}
}
