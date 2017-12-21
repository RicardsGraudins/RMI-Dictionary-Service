package ie.gmit.sw;

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