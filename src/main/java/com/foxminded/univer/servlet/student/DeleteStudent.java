package com.foxminded.univer.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.univer.service.StudentService;
import com.foxminded.univer.models.Student;

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet {

	private StudentService studentService = new StudentService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("studentId"));
		try {
			Student studentToDelete = studentService.findById(id);
			studentService.delete(studentToDelete);
			req.setAttribute("deletedStudent", studentToDelete);
		} catch (ClassNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
		req.getRequestDispatcher("/student/showDeleted.jsp").forward(req, resp);
	}
}