/*
 * Save as ToDoServlet.java
 */
package r4r.servlet;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;



public class ToDoServlet extends HttpServlet {

 private ToDoClass toDoClass;
 private List<ToDoClass> toDoClasseList;
 private DateFormat dateFormat;
 private String newDate;

 @Override
 public void init() throws ServletException {
  toDoClass = new ToDoClass(null, null, null, null,null,null);
  toDoClasseList = new ArrayList<ToDoClass>();
  dateFormat = new SimpleDateFormat("dd/mm/yyyy");
  newDate = dateFormat.format(Calendar.getInstance().getTime());
 }

 protected void processRequest
	 (HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  try {
out.println("<html>");
out.println("<head>");
out.println("<title>" + getServletInfo() + "</title>");
out.println("</head>");
out.println("<body>");
out.println("<form action=\"ToDoServlet\" method=\"POST\">");
out.println("Nome do Funcionário:<input type=\"text\" name=\"nome\" value=\"\" size=\"30\" maxlength=\"20\"/><BR>");
out.println("De forma geral, como você avaliaria o produto? <select name=\"Pergunta1\">");
out.println("<option> CONCORDO TOTALMENTE </option>");
out.println("<option> CONCORDO </option>");
out.println("<option> NEUTRO </option>");
out.println("<option> DISCORDO </option>");
out.println("<option> DISCORDO TOTALMENTE</option></select><BR>");
out.println("De forma geral, como você avaliaria o vendedor? <select name=\"Pergunta2\">");
out.println("<option> CONCORDO TOTALMENTE </option>");
out.println("<option> CONCORDO </option>");
out.println("<option> NEUTRO </option>");
out.println("<option> DISCORDO </option>");
out.println("<option> DISCORDO TOTALMENTE</option></select><BR>");
out.println("Qual a chance de você indicar esse produto? <select name=\"Pergunta3\">");
out.println("<option> CONCORDO TOTALMENTE </option>");
out.println("<option> CONCORDO </option>");
out.println("<option> NEUTRO </option>");
out.println("<option> DISCORDO </option>");
out.println("<option> DISCORDO TOTALMENTE</option></select><BR>");
out.println("O produto é útil no seu dia-a-dia? <select name=\"Pergunta4\">");
out.println("<option> CONCORDO TOTALMENTE </option>");
out.println("<option> CONCORDO </option>");
out.println("<option> NEUTRO </option>");
out.println("<option> DISCORDO </option>");
out.println("<option> DISCORDO TOTALMENTE</option></select><BR>");
out.println("Descrição: <textarea name=\"description\" rows=\"4\" cols=\"25\"></textarea><BR>");
out.println("<input type=\"submit\" value=\"Submit\" />");
out.println("<input type=\"reset\" value=\"Reset\" />");
out.println("</form>");
out.println("</body>");
out.println("</html>");
  } finally {
out.close();
  }
 }

 @Override
 protected void doGet
	 (HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
  processRequest(request, response);
 }

 @Override
 protected void doPost
	 (HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();

  String nome = request.getParameter("nome");
  String description = request.getParameter("description");
  String Pergunta1 = request.getParameter("Pergunta1");
  String Pergunta2 = request.getParameter("Pergunta2");
  String Pergunta3 = request.getParameter("Pergunta3");
  String Pergunta4 = request.getParameter("Pergunta4");

  if (!nome.equals("")) {
toDoClass = new ToDoClass(nome, description, Pergunta1, Pergunta2, Pergunta3, Pergunta4);

toDoClasseList.add(toDoClass);

printHeader(out);
printDataList(out);
printFooter(out);

out.close();
  } else {
out.println("Nao deixa os campos em branco!");
out.println
("<BR><BLINK><a href=\"ToDoServlet\">Retornar para Pagina Principal:</a></BLINK>");
  }
 }

 @Override
 public String getServletInfo() {
  return "Pesquisa de NPS";
 }

 private void printHeader(PrintWriter out) {
  out.println("<html>");
  out.println("<head>");
  out.println("<title>Pesquisa de NPS</title>");
  out.println("</head>");
  out.println("<body>");
  out.println("<h1>Pesquisa de NPS</h1>");
 }

 private void printDataList(PrintWriter out) {
  Iterator iterator = toDoClasseList.iterator();
  while (iterator.hasNext()) {
ToDoClass object = (ToDoClass) iterator.next();
out.println(" <hr align=\"left\" width=\"35%\"/>");
out.println("<BR>Nome do Funcionário : " + " <b> "
            + object.getNome() + "</b>");
out.println("<BR> De forma geral, como você avaliaria o produto?" + " <b> "
           + object.getPergunta1() + "</b>");
out.println("<BR>De forma geral, como você avaliaria o vendedor? " + " <b> "
           + object.getPergunta2() + "</b>");
out.println("<BR>Qual a chance de você indicar esse produto? " + " <b> "
           + object.getPergunta3() + "</b>");
out.println("<BR>O produto é útil no seu dia-a-dia? " + " <b> "
           + object.getPergunta4() + "</b>");
out.println("<BR>Observação  : " + " <b> "
            + object.getDescription() + "</b>");

  }
  try {

Thread.sleep(1000);
  } catch (InterruptedException ex) {
Logger.getLogger(ToDoServlet.class.getName()).
	log(Level.SEVERE,
  "InterruptedException generated while processing request", ex);
  }
 }


 private void printFooter(PrintWriter out) {
  out.println("</body>");
  out.println("</html>");
  out.println("<BR><BR><BLINK><a href=\"ToDoServlet\">Adicionar mais Lista</a></BLINK>");
 }
}


class ToDoClass {


    private String nome;
    private String description;
    private String Pergunta1;
    private String Pergunta2;
    private String Pergunta3;
    private String Pergunta4;
    
    public ToDoClass
(String nome, String description, String Pergunta1, String Pergunta2, String Pergunta3, String Pergunta4) 
		{
        this.nome = nome;
        this.description = description;
        this.Pergunta1 = Pergunta1;
        this.Pergunta2 = Pergunta2;
        this.Pergunta3 = Pergunta3;
        this.Pergunta4 = Pergunta4;
    }

    public String getPergunta2() {
        return Pergunta2;
    }

    public void setPergunta2(String Pergunta2) {
        this.Pergunta2 = Pergunta2;
    }
    
    public String getPergunta3() {
        return Pergunta3;
    }

    public void setPergunta3(String Pergunta3) {
        this.Pergunta3 = Pergunta3;
    }
    
    public String getPergunta4() {
        return Pergunta4;
    }

    public void setPergunta4(String Pergunta4) {
        this.Pergunta4 = Pergunta4;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPergunta1() {
        return Pergunta1;
    }

    public void setPergunta1(String Pergunta1) {
        this.Pergunta1 = Pergunta1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}