package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import metier.Contact;
import service.IService;
import service.Service;

/**
 * Servlet implementation class ServletListerContact
 */
@WebServlet("/ServletListerContact")
public class ServletListerContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListerContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
				//1- Récupérer les éléments de la bdd
				//2- Traitements avec couche service
				
				IService cs = new Service();
				List<Contact> lesContacts = new ArrayList<Contact>();
				lesContacts = (List<Contact>) cs.findAllContacts();
				
						
				//3- Préparation envoi
				request.setAttribute("lesContacts", lesContacts); //le premier "lenom" va être utilisé dans la JSP. nom représente la valeur récupérée plus haut

				
				//4- Envoi
				request.getRequestDispatcher("/listerContact.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
