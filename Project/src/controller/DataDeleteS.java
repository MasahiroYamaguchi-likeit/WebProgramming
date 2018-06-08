package controller;

import java.io.IOException;

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
 * Servlet implementation class DataDelete
 */
@WebServlet("/DataDeleteS")
public class DataDeleteS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataDeleteS() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/DataDelete.jsp");
		dispatcher.forward(request, response);
	}
}
