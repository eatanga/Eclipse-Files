package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Buyer;
import model.CarList;
import model.PurchaseDetails;

/**
 * Servlet implementation class createNewInventoryServlet
 */
@WebServlet("/createNewInventoryServlet")
public class createNewInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarListHelper clh = new CarListHelper();
		String purchName = request.getParameter("purchName");
		System.out.println("Inventory Name: " + purchName);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String buyerName = request.getParameter("buyerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		String[] selectedCars = request.getParameterValues("allCarsToAdd");
		List<CarList> selectedCarsInInventory = new ArrayList<CarList>();
		if (selectedCars != null && selectedCars.length > 0) {
			for (int i = 0; i < selectedCars.length; i++) {
				System.out.println(selectedCars[i]);
				CarList c = clh.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInInventory.add(c);

			}
		}

		Buyer buyer = new Buyer(buyerName);
		PurchaseDetails bld = new PurchaseDetails(purchName, ld, buyer);
		bld.setCarInventory(selectedCarsInInventory);
		PurchaseDetailsHelper plh = new PurchaseDetailsHelper();
		plh.insertNewPurchaseDetails(bld);

		System.out.println("Success!");
		System.out.println(bld.toString());

		getServletContext().getRequestDispatcher("/viewAllInventoryServlet").forward(request, response);

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
