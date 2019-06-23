package com.foxminded.univer.servlet.auditorium;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.univer.dao.impl.AuditoriumDao;
import com.foxminded.univer.models.Auditorium;

@WebServlet("/deleteAuditorium")
public class DeleteAuditorium extends HttpServlet {

	private AuditoriumDao auditoriumDao = new AuditoriumDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("auditoriumId"));
		try {
			Auditorium aduditoriumToDelete = auditoriumDao.findById(id).get();
			auditoriumDao.delete(aduditoriumToDelete);
			req.setAttribute("deletedAuditorium", aduditoriumToDelete);
		} catch (ClassNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
		req.getRequestDispatcher("/auditorium/showDeleted.jsp").forward(req, resp);
	}
}
