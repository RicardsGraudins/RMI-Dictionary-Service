package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
/* DictionaryServiceImpl is the Remote Object for this project. In order for it to be a
 * remote object it must implement the remote interface DictionaryService which forces
 * the remote object to implement all the remote methods of DictionaryService.
 * 
 * DictionaryServiceImpl also extends UnicastRemoteObject which makes it a subclass.
 * UnicastRemoteObject provides DictionaryServiceImpl with all the functionality it requires
 * in order to communicate with the server-side skeleton which is responsible for
 * unmarshalling client requests on the server and marshalling responses.
 * 
 * Before any remote client can invoke any of our remote object methods, DictionaryServiceImpl
 * must first be instantiated and bound to a naming registry with a human-readable name. This is
 * done inside the class DictionaryServer.
 */

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	private final String DICTIONARY_FILE = "Resources/Dictionary.txt";
	
	private String word;
	private Map<String, String> Dictionary = new HashMap<String, String>();
	
	public DictionaryServiceImpl() throws RemoteException {
		super();
	}

	//Check if a word exists in the Dictionary HashMap and return a string.
	@Override
	public String lookup(String s) throws RemoteException {
		if (Dictionary.containsKey(s)) {
			word = Dictionary.get(s);
			return word;
		}
		else {
			return s + " is not in the dictionary.";
		}
	}//lookup
	
	//Load data from DICTIONARY_FILE into the Dictionary HashMap & split
	//the word from the definition on the first comma of every line
	public void loadDictionary() throws RemoteException {
	    String line;
	    BufferedReader reader;
	    
		try {
			reader = new BufferedReader(new FileReader(DICTIONARY_FILE));
			
		    while ((line = reader.readLine()) != null)
		    {
		        String[] parts = line.split(",", 2);
		        if (parts.length >= 2)
		        {
		            String key = parts[0];
		            String value = parts[1];
		            Dictionary.put(key, value);
		        } else {
		            System.out.println("Ignoring line: " + line);
		        }
		    }//while
		    
		    reader.close();
		}//Try 
		catch(IOException e) {
			e.printStackTrace();
		}//Catch
	}//loadDictionary
	
	//Append a new word to the DICTIONARY_FILE 
	public void addWord(String word, String definition) throws RemoteException{
		File file = new File(DICTIONARY_FILE);
		
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write("\n" + word + ", " + definition);
			writer.flush();
			writer.close();
		}//Try
		catch(IOException e) {
			e.printStackTrace();
		}//Catch
	}//addWord
	
	//Delete an existing word & its definition from DICTIONARY_FILE
	//Adapted from https://stackoverflow.com/questions/1377279/find-a-line-in-a-file-and-remove-it
	public void deleteWord(String word, String definition) throws RemoteException{
		File inputFile = new File(DICTIONARY_FILE);
		File tempFile = new File("Resources/tempFile.txt");
		
		try {
			//Create temporary file
			tempFile.createNewFile();
			
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String lineToRemove = word + ", " + definition;
			String currentLine;
			
			while((currentLine = reader.readLine()) != null) {
			    //Trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(lineToRemove)) continue;
			    writer.write(currentLine + System.getProperty("line.separator"));
			}//While
			writer.close();
			reader.close();
			//Rename tempFile.txt to Dictionary.txt
			tempFile.renameTo(inputFile);
		}//Try
		catch(IOException e){
			e.printStackTrace();
		}//Catch
	}//deleteWord
	
	//Modify a word's definition in DICTIONARY_FILE
	public void modifyWord(String word, String definition, String newDefinition) throws RemoteException{
		//Delete the word & its definition from DICTIONARY_FILE
		deleteWord(word, definition);
		//Add the word & its new definition to DICTIONARY_FILE
		addWord(word, newDefinition);
	}//modifyWord
}//DictionaryService