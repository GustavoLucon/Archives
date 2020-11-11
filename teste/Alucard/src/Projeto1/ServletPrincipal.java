package Projeto1;

public class ServerPrincipal extends HttpServlet
{ 
	protected void doGet(	HttpServletRequest request,							HttpServletResponse response)
			throws ServletException, IOException 
{	Process(request,response);		}
		
protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException 
{	Process(request,response);		}
	
	protected void Process(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException 
{
	    PrintWriter	out;
	    String		title = "Servlet simples";
	    response.setContentType("text/html");
    out = response.getWriter();
         out.println("<HTML><HEAD><TITLE>");
	    out.println(title);
	    out.println("</TITLE></HEAD><BODY>");
	    out.println("<H1>" + title + "</H1>");
	    out.println("<P>O meu Servlet funcionou perfeitamente.");
	    out.println("</BODY></HTML>");
	    out.close();
     }
}

