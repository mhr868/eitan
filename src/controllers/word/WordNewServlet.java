package controllers.word;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Word;

/**
 * Servlet implementation class WordNewServlet
 */
@WebServlet("/word/new")
public class WordNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Word w = new Word();

		request.setAttribute("_token", request.getSession().getId());
		request.setAttribute("word", w);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word/new.jsp");
		rd.forward(request, response);
	}

}
