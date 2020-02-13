package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DollarConverter;

/**
 * Servlet implementation class convertDollarServlet
 */
@WebServlet("/convertDollarServlet")
public class convertDollarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public convertDollarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dollarAmount = request.getParameter("dollarAmount");
		
		
		DollarConverter dAmt = new DollarConverter(Integer.parseInt(dollarAmount));
		
		request.setAttribute("d", dAmt);
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
		//PrintWriter writer = response.getWriter();
		//writer.println(dAmt.toString());
		//writer.close();
	}

}
