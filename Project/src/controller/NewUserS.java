package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUserS")
public class NewUserS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewUserS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("LoginS");
			return;
		}
		Object login = session.getAttribute("userInfo");
		if (login == null) {
			response.sendRedirect("LoginS");
			return;
		}
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String Cpassword = request.getParameter("Cpassword");
		UserDAO userDao = new UserDAO();

		if (!(password.equals(Cpassword))) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "passwordが正しくありません");

			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (loginId == "" || name == "" || birthDate == "" || password == "") {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "未記入の項目があります");

			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		try {
			userDao.InsertData(loginId, name, birthDate, password);
		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListS");
	}
}
