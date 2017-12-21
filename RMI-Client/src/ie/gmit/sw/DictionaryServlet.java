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

/**
 * Servlet implementation class DictionaryServlet
 */
@WebServlet("/DictionaryServlet")
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PriorityQueue<Request> inQueue = new PriorityQueue<Request>();
	private PriorityQueue<Request> outQueue = new PriorityQueue<Request>();
	private int IDGenerator;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DictionaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the user input
		String word = request.getParameter("wordInput");
		
		//Create new Request object with ID and user input - add to inQueue
		IDGenerator++;
		Request requestObj = new Request(IDGenerator, word);
		inQueue.offer(requestObj);
		
		try {
			//Lookup address
			DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			//Lookup the definition of the first inQueue object
			String definition = ds.lookup(inQueue.peek().getmessage());
			
			//Create new Request object, add same ID but this time the definition instead of the word
			Request requestObjDefinition = new Request(IDGenerator, definition);
			//Add the object to the outQueue
			outQueue.offer(requestObjDefinition);
			
			//Get the definition
			String result = outQueue.peek().getmessage();
			
			//Simulate Asynchronous Service
			System.out.println("Please wait...");
			System.out.println(inQueue.peek().toString());
			Thread.sleep(10000);
			
			//Send it to the user
			System.out.println(result);
		}//Try
		catch(Exception e){
			e.printStackTrace();
		}//Catch
		
		//Navigate to Reponse.jsp with word & definition
		request.setAttribute("word", inQueue.peek().getmessage());
		request.setAttribute("definition", outQueue.peek().getmessage());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Response.jsp");
		dispatcher.forward(request, response);
		
		//Delete the first Request object from both queues		
		inQueue.poll();
		outQueue.poll();
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}//DictionaryServlet