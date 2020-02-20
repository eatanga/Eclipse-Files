package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarList;


/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String company = request.getParameter("company");
		String car = request.getParameter("car");
		if (company.isEmpty() || car.isEmpty() || company == null || car == null) {
			getServletContext().getRequestDispatcher("/ci_index.html").forward(request, response);
		} else {
			CarList cl = new CarList(company, car);
			CarListHelper dao = new CarListHelper();
			dao.addCar(cl);

			getServletContext().getRequestDispatcher("/ci_index.html").forward(request, response);
		}
	}

}
