package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserListS")
public class UserListS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる

		HttpSession session = request.getSession(false);
		Object login = session.getAttribute("userInfo");
		if (login == null) {
			response.sendRedirect("LoginS");
			return;
		}

		// ユーザ一覧情報を取得
		UserDAO userDao = new UserDAO();
		List<User> userList = userDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO  未実装：検索処理全般
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginID");
		String name = request.getParameter("Name");
		String birthDate = request.getParameter("Date");
		String birthDate2 = request.getParameter("Date2");
		UserDAO userDao = new UserDAO();
		List<User> userList = userDao.DataSearch(loginId, name, birthDate, birthDate2);

		if (userList == null) {
			response.sendRedirect("UserListS");
			return;
		}
		request.setAttribute("userList", userList);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);

	}

}
