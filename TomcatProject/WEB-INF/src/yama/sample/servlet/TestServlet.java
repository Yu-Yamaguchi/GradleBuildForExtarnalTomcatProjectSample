package yama.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 外部のGradleプロジェクトから正常にビルドが確認できるように、<br>
 * {@link HttpServlet}を継承したサーブレットを空実装します。
 */
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO 自動生成されたメソッド・スタブ
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO 自動生成されたメソッド・スタブ
		super.doPost(req, resp);
	}
}
