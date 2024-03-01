package Student_Managment_System.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student_Managment_System.dto.Student;

@WebServlet("/signup")
public class StudentSignupController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Student student=new Student();
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		
		StudentDao studentDao=new StudentDao();
		Student dbstudent=studentDao.saveStudent(student);
		
		if(dbstudent!=null) {
			req.setAttribute("message", "signup succesfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
