package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	private final String DICTIONARY_FILE = "Resources/Dictionary.txt";
	
	private String word;
	private Map<String, String> Dictionary = new HashMap<String, String>();
	
	public DictionaryServiceImpl() throws RemoteException {
		super();
	}

	//Search for a word in the Dictionary Hashmap
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
	
	/*
	public Map<String, String> loadDictionary(Map<String,String> DictionaryP) throws RemoteException, IOException {
	    String line;
	    BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_FILE));
	    while ((line = reader.readLine()) != null)
	    {
	        String[] parts = line.split(",", 2);
	        if (parts.length >= 2)
	        {
	            String key = parts[0];
	            String value = parts[1];
	            DictionaryP.put(key, value);
	        } else {
	            System.out.println("ignoring line: " + line);
	        }
	    }//while
	    
	    reader.close();
		return DictionaryP;
	}//loadDictionary
	*/
	
	//Load data from DICTIONARY_FILE into Dictionary Hashmap & split
	//the word from the definition on the first coma of every line
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
}//DictionaryService