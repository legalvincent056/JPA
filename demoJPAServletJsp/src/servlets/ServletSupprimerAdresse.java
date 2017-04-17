package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Adresse;
import service.IService;
import service.Service;

/**
 * Servlet implementation class ServletSupprimerAdresse
 */
@WebServlet("/ServletSupprimerAdresse")
public class ServletSupprimerAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerAdresse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		//1- Récupérer paramètres
		int id = Integer.parseInt(request.getParameter("id"));
			
		
		//2- Traitement avec la couche service
		IService is = new Service();
		Adresse a = new Adresse();
		a.setId(id);
		
		is.deleteAdresse(a);
		
		
		//3- Préparation de l'envoi
		request.setAttribute("lid",id);
		
		
		//4-Envoi
		request.getRequestDispatcher("/supprimerAdresse.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
