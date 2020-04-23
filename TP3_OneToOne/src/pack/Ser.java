package pack;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ser
 */
@WebServlet("/Ser")
public class Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Facade f;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ser() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch(op) {
		case "ajoutpersonne":
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			f.ajoutPersonne(nom,prenom);
			request.getRequestDispatcher("index.html").forward(request, response);
			return;
			

		case "ajoutadresse":
			String rue = request.getParameter("rue");
			String ville = request.getParameter("ville");
			f.ajoutAdresse(rue,ville);
			request.getRequestDispatcher("index.html").forward(request, response);
			return;
			

		case "associer":
			Collection <Personne> lp = f.listePersonnes();
			Collection <Adresse> la = f.listeAdresses();
			request.setAttribute("lp", lp);
			request.setAttribute("la",la);
			request.getRequestDispatcher("associer.jsp").forward(request, response);
			return;
			
		case "Ok":
				int idp = Integer.parseInt(request.getParameter("idp"));
				int ida = Integer.parseInt(request.getParameter("ida"));
				f.associer(idp, ida);
				request.getRequestDispatcher("index.html").forward(request, response);
				return;
				
		case "lister":
			Collection <Personne> lpp = f.listePersonnes();
			request.setAttribute("lpp", lpp);
			request.getRequestDispatcher("lister.jsp").forward(request, response);
			return;
			
		case "Retour":
			request.getRequestDispatcher("index.html").forward(request, response);
			return;
			

		}

	}

}
