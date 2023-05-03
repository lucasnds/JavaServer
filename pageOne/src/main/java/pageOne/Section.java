package pageOne;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Section")
public class Section extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		try{			
			HttpSession sessao = request.getSession(true);			
			Integer acessos = (Integer) sessao.getAttribute("Numero_acessos");
			if (acessos == null) { acessos = 1;
			}else { acessos = acessos + 1; }
			sessao.setAttribute("Numero_acessos", acessos);	
			PrintWriter writer = response.getWriter();			
			writer.append( " <h1> Exemplo de sessão </h1>" );			
			writer.append( "O documento foi acessado " +  acessos + " vezes.");
		} catch (IOException e){
			e.printStackTrace();
		}
	}	
	
	public class SalvarInformacoesServlet extends HttpServlet {

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	        
	        HttpSession session = request.getSession(true);
			writer.append( " <h1> Exemplo de sessão </h1>" );			

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        session.setAttribute("username", username);
	        session.setAttribute("password", password);
	        
	        String nome = request.getParameter("nome");
	        String sobrenome = request.getParameter("sobrenome");
	        String email = request.getParameter("email");
	        session.setAttribute("nome", nome);
	        session.setAttribute("sobrenome", sobrenome);
	        session.setAttribute("email", email);
	        
	        String instituicao = request.getParameter("instituicao");
	        String curso = request.getParameter("curso");
	        int periodo = Integer.parseInt(request.getParameter("periodo"));
	        session.setAttribute("instituicao", instituicao);
	        session.setAttribute("curso", curso);
	        session.setAttribute("periodo", periodo);
	        
	        String empresa = request.getParameter("empresa");
	        String cargo = request.getParameter("cargo");
	        int experiencia = Integer.parseInt(request.getParameter("experiencia"));
	        session.setAttribute("empresa", empresa);
	        session.setAttribute("cargo", cargo);
	        session.setAttribute("experiencia", experiencia);
	        
	        response.sendRedirect("Confirmation.jsp");
	    }
	}	


}
