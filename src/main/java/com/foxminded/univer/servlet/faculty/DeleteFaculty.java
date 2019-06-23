package com.foxminded.univer.servlet.faculty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.univer.dao.impl.FacultyDao;
import com.foxminded.univer.models.Faculty;

@WebServlet("/deleteFaculty")
public class DeleteFaculty extends HttpServlet {

	private FacultyDao facultyDao = new FacultyDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("facultyId"));
		try {
			Faculty facultyToDelete = facultyDao.findById(id).get();
			facultyDao.delete(facultyToDelete);
			req.setAttribute("deletedFaculty", facultyToDelete);
		} catch (ClassNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
		req.getRequestDispatcher("/faculty/showDeleted.jsp").forward(req, resp);
	}
}