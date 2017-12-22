package ie.gmit.sw;
/* Request is a simple object class that stores the ID of the request we're sending
 * to the server as well as a String message which can be either the word we're trying
 * to look up in the remote object or the definition of the word.
 */
public class Request {
	private int ID;
	private String message;
	
	public Request(int ID, String message){
		this.ID = ID;
		this.message = message;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Request Num: " + ID + "." + "\tWord: " + message + ".";
	}
}//Request