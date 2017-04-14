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
 * Servlet implementation class ServletAjouterAdresse
 */
@WebServlet("/ServletAjouterAdresse")
public class ServletAjouterAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletAjouterAdresse() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		
		//1- Récupérer paramètres
		String nomRue = request.getParameter("nomRue");
		String ville = request.getParameter("ville");
		String codePostale = request.getParameter("codePostale");
		
		
		//2- Traitement avec la couche service
		IService is = new Service();
		Adresse a = new Adresse();
		a.setNomRue(nomRue);
		a.setVille(ville);
		a.setCodePostale(codePostale);
		
		is.ajouterAdresse(a);
		
		
		//3- Préparation de l'envoi
		request.setAttribute("lenomRue",nomRue);
		request.setAttribute("laville",ville);
		request.setAttribute("lecodePostale",codePostale);
		
		//4-Envoi
		request.getRequestDispatcher("/ajouterAdresse.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
