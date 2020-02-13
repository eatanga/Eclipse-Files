package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DollarConverter;

/**
 * Servlet implementation class interestServlet
 */
@WebServlet("/interestServlet")
public class interestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public interestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dollarAmount = request.getParameter("dollarAmount");
		
		
		DollarConverter iAmt = new DollarConverter(Integer.parseInt(dollarAmount));
		
		request.setAttribute("i", iAmt);
		getServletContext().getRequestDispatcher("/iresults.jsp").forward(request, response);
	}

}
