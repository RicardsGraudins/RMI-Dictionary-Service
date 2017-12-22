package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import java.util.PriorityQueue;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* Java Servlets are programs that run on a Web or Application server and act as a middle layer between
 * requests coming from a Web browser or other HTTP client and databases or applications on the HTTP server.
 * Using Servlets, you can collect input from users through web page forms, present records from a database
 * or another source, and create web pages dynamically.
 * 
 * In this project we use DictionaryServlet to process the user input from Index.jsp. The user input gets
 * assigned to a Request object which gets added to a PriorityQueue called inQueue, each Request object consists of
 * a request ID and String message which represents the word the user wants to look up in the dictionary(remote object).
 * 
 * We use Naming.lookup along with the lookup method to see if the server contains the word in the
 * remote object and store the definition in a new Request object but this time instead of storing the word it 
 * stores the definition of the word and this object gets added to a PriorityQueue called outQueue.
 * 
 * Once the process is complete the client navigates to Response.jsp which displays the definition.
 */
@WebServlet("/DictionaryServlet")
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PriorityQueue<Request> inQueue = new PriorityQueue<Request>();
	private PriorityQueue<Request> outQueue = new PriorityQueue<Request>();
	private int IDGenerator;
       
    //@see HttpServlet#HttpServlet()
    public DictionaryServlet() {
        super();
    }

	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the user input from form @ Index.jsp
		String word = request.getParameter("wordInput");
		
		//Create new Request object with ID and user input - add to inQueue
		IDGenerator++;
		Request requestObj = new Request(IDGenerator, word);
		inQueue.offer(requestObj);
		
		try {
			//Lookup remote object @ rmi://127.0.0.1:1099/dictionaryService
			DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			//Lookup the definition of the first inQueue object
			String definition = ds.lookup(inQueue.peek().getmessage());
			
			//Create new Request object, add same ID but this time the definition instead of the word
			Request requestObjDefinition = new Request(IDGenerator, definition);
			//Add the object to the outQueue
			outQueue.offer(requestObjDefinition);
			
			//Store the definition in a String
			String result = outQueue.peek().getmessage();
			
			//Simulate Asynchronous Service by putting thread to sleep for 10 seconds
			System.out.println("Please wait...");
			System.out.println(inQueue.peek().toString());
			Thread.sleep(10000);
			
			//Output definition
			System.out.println(result);
		}//Try
		catch(Exception e){
			e.printStackTrace();
		}//Catch
		
		//Navigate to Response.jsp with word & definition
		request.setAttribute("word", inQueue.peek().getmessage());
		request.setAttribute("definition", outQueue.peek().getmessage());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Response.jsp");
		dispatcher.forward(request, response);
		
		//Delete the first Request object from both PriorityQueues	
		inQueue.poll();
		outQueue.poll();
	}//doGet

	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost
}//DictionaryServlet