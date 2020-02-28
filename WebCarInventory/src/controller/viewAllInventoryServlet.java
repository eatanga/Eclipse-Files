package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PurchaseDetails;

/**
 * Servlet implementation class viewAllInventoryServlet
 */
@WebServlet("/viewAllInventoryServlet")
public class viewAllInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PurchaseDetailsHelper pdh = new PurchaseDetailsHelper();
		List<PurchaseDetails> xyz = pdh.getInventory();
		request.setAttribute("allInventory", xyz);
		
		if(xyz.isEmpty()){
				request.setAttribute("allInventory", "");
		}

		getServletContext().getRequestDispatcher("/purchase-inventory-by-user.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
