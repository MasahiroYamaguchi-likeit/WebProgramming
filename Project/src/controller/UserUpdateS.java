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
import model.User;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdateS")
public class UserUpdateS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateS() {
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
		String id = request.getParameter("id");

		// 確認用：idをコンソールに出力
		System.out.println(id);

		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		UserDAO userDao = new UserDAO();
		User user = userDao.DetailData(id);

		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String ID = request.getParameter("id");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthdate");
		String password = request.getParameter("password");
		String Cpassword = request.getParameter("Cpassword");
		UserDAO userDao = new UserDAO();

		if (!(password.equals(Cpassword))) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "passwordが正しくありません");

			User user = userDao.DetailData(ID);

			// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

			request.setAttribute("user", user);
			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (name == "" || birthDate == "") {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "未記入の項目が正しくありません");

			User user = userDao.DetailData(ID);

			// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

			request.setAttribute("user", user);
			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if (password == "") {
			try {
				userDao.Update2(ID, name, birthDate);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				request.setAttribute("errMsg", "入力された内容は正しくありません");

				User user = userDao.DetailData(ID);

				// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

				request.setAttribute("user", user);
				// jspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
				dispatcher.forward(request, response);
				return;
			}
			response.sendRedirect("UserListS");
			return;
		}

		try {
			userDao.Update(ID, name, birthDate, password);
		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			User user = userDao.DetailData(ID);

			// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

			request.setAttribute("user", user);
			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListS");
	}
}
