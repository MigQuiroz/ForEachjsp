package com.miguel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.miguel.Book;
//@WebServlet lo puedo omitir si lo pongo en el web.xml
public class servletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Book> bookList = new ArrayList<Book>();
    
	public servletPrincipal() {
		super();
		//Agregar libros al array
		bookList.add(new Book("To kill a mockingbird","Harper Lee",  5.50f));
		bookList.add(new Book("1984", "George Orwell", 4.50f));
		bookList.add(new Book("Frankenstein","Mary Shelly", 4.00f));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if (action.equals("/new")) {
			addBook(request,response);
		}
		else {
			listBooks(request, response);
		}
		
	}
	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("book_list", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jpsPrincipal.jsp");
		dispatcher.forward(request,response);
	}
	private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookForm.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if (action.equals("/insert")) {
			insertBook(request,response);
		}
	}
	
	private  void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title =request.getParameter("booktitle");
		String author = request.getParameter("bookauthor");
		String priceString = request.getParameter("bookprice");
		
		Book newBook = new Book(title,author, Float.parseFloat(priceString));
		bookList.add(newBook);
		
		response.sendRedirect("list");
		
	}

}
