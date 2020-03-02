package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Stu;
import service.StuService;

@WebServlet("/FindById")
public class FindByIdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求的数据有中文就必须要设置编码
		req.setCharacterEncoding("UTF-8");
		// 获得页面上的数据
		String id = req.getParameter("id");
		// 调用service中获得数据的方法
		StuService ss = new StuService();
		// 因为这个获得的数据是整行数据，一行在数据库表中保存的就是一个实体的完整信息
		// 所以这里使用一个实体来进行保存
		Stu stu = ss.findByid(id);
		if (stu != null) {
			// 将获得的数据，放入到作用域中
			req.setAttribute("stu",stu);
			// 页面跳转到修改页面,查询使用转发
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("Index");
		}
	}
}
