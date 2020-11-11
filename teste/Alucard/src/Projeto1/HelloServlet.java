package Projeto1;

import java.io.*;   
import javax.servlet.*;   
import javax.servlet.http.*;   
  
public class HelloServlet extends HttpServlet{  
	public void doGet(HttpServletRequest request, HttpServletResponse response)   
	throws IOException, ServletException {   
	       
	    // vamos definir o tipo de conteudo    
	    // que será devolvido pelo response   
	    response.setContentType("text/html");   
	  
	    // pegamos o PrintWriter do response, através    
	    // do qual escreveremos o conteudo da pagina   
	    PrintWriter out = response.getWriter();   
	  
	    // Agora vamos escrever o conteudo da pagina    
	    out.println("<H1>Hello World!</h1>");   
	  
	}  
}  
