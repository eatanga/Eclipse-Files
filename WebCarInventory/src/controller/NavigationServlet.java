package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarList;


/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarListHelper dao = new CarListHelper();
		String todo = request.getParameter("doThisToCar");

		// Redirect user to view all cars after changes
		String path = "/viewAllCarsServlet";

		if (todo.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CarList carToDelete = dao.searchForCarById(tempId);
				dao.deleteCar(carToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Oops!You forgot to select a car.");
			}

		} else if (todo.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CarList carToEdit = dao.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/ci_edit_car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Oops!You forgot to select a car");
			}

		} else if (todo.equals("add")) {
			path = "/ci_index.html";

		}

		getServletContext().getRequestDispatcher(path).forward(request, response);

	
	}

}
