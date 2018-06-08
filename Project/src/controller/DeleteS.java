package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class DeleteS
 */
@WebServlet("/DeleteS")
public class DeleteS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String Id = request.getParameter("Id");
		UserDAO userDao = new UserDAO();

		try {
			userDao.DataDelete(Id);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListS");
	}
}
