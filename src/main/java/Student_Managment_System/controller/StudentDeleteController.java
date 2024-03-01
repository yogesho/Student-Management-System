package Student_Managment_System.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student_Managment_System.dao.StudentDao;
import Student_Managment_System.dto.Student;

@WebServlet("/delete")
public class StudentDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentDao studentDao=new StudentDao();
		boolean b=studentDao.deleteStudent(id);
		
		if(b) {
			List<Student> list=studentDao.getAllStudent();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
