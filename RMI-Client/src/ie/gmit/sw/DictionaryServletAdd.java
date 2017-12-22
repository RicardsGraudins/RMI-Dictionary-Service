package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* This servlet simply handles adding a new word to the DICTIONARY_FILE on the server.
 * Note: The server must be restarted in order for the new word to be queryable.
 */
@WebServlet("/DictionaryServletAdd")
public class DictionaryServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//@see HttpServlet#HttpServlet()
    public DictionaryServletAdd() {
        super();
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get user input for a new word & definition
		String word = request.getParameter("wordInput");
		String definition = request.getParameter("definitionInput");
		
		try {
			//Lookup remote object @ rmi://127.0.0.1:1099/dictionaryService
			DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			//Add the new word to the DICTIONARY_FILE on the server
			ds.addWord(word, definition);
			//3 second delay before changing to Index.jsp
			Thread.sleep(3000);
		}//Try
		
		catch(Exception e){
			e.printStackTrace();
		}//Catch
		
		//Navigate to Index.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
		dispatcher.forward(request, response);
	}//doGet

	
	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost
}//DictionaryServletAdd