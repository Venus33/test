package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Stu;
import service.StuService;

@WebServlet("/Index")

public class IndexServlet extends HttpServlet {
	// 创建一个service包中获得数据库中数据的对象
		private StuService  ss = new StuService();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 因为这里需要将数据库表中的所有数据都展示出来，它是一个多行多列的表格，我们使用一个集合来装
			
			// 调用service中获得所有数据的方法，并保存在一个集合中,为了简化在获得数据时进行强转的操作，这里使用泛型
			List<Stu> list = ss.getAll();
			// 将整个集合保存到作用域中
			req.setAttribute("list", list);
			// 实现页面的跳转,因为这里的操作是查询，我们就使用转发
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
}
