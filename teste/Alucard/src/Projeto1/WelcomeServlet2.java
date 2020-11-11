package Projeto1;

// WelcomeServlet2.java
// Processando solicitações get de HTTP contendo dados.
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class WelcomeServlet2 extends HttpServlet 
{

// processa a solicitação "get" do cliente
protected void doGet( HttpServletRequest request, 
HttpServletResponse response )
throws ServletException, IOException 
{
String firstName = request.getParameter( "firstname" );
response.setContentType( "text/html" );
PrintWriter out = response.getWriter(); 

// envia o documento XHTML ao cliente
// inicia o documento XHTML 
out.println( "<?xml version = \"1.0\"?>" );
out.printf( "%s%s%s", "<!DOCTYPE html PUBLIC", 
" \"-//W3C//DTD XHTML 1.0 Strict//EN\"",
" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" );
out.println( "<html xmlns = \"http://www.w3.org/1999/xhtml\">" );

// seção da cabeça do documento
out.println( "<head>" );
out.println( 
"<title>Processing get requests with data</title>" );
out.println( "</head>" );

// seção do corpo do documento
out.println( "<body>" );
out.println( "<h1>Hello " + firstName + ",<br />" );
out.println( "Welcome to Servlets!</h1>" );
out.println( "</body>" );

// fim do documento XHTML
out.println( "</html>" );
out.close(); // fecha o fluxo para completar a página
} // fim do método doGet
} // fim da classe WelcomeServlet2
