package ie.gmit.sw;

import java.io.IOException;

public class DictionaryServer {

	public static void main(String[] args) throws IOException {
		DictionaryServiceImpl dictionary = new DictionaryServiceImpl();
		dictionary.loadDictionary();
		System.out.println(dictionary.lookup("Nefarious"));
	}//Main
}//DictionaryServer