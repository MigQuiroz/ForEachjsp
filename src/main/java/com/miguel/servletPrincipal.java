package com.miguel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.miguel.Book;

/**
 * Servlet implementation class servletPrincipal
 */
public class servletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Book> bookList = new ArrayList<Book>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public servletPrincipal() {
		super();
		//Agregar libros al array
		bookList.add(new Book("To kill a mockingbird","Harper Lee",  5.50f));
		bookList.add(new Book("1984", "George Orwell", 4.50f));
		bookList.add(new Book("Frankenstein","Mary Shelly", 4.00f));
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("book_list", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jpsPrincipal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
