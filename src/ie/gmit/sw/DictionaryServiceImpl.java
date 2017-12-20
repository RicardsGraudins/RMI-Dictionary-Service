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

	@Override
	public String lookup(String s) throws RemoteException {
		word = Dictionary.get(s);
		return word;
	}
	
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
	
	public void loadDictionary() throws RemoteException, IOException {
	    String line;
	    BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_FILE));
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
	}//loadDictionary
}//DictionaryService