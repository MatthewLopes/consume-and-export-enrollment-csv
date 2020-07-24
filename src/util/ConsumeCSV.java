package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.nio.charset.StandardCharsets;

import model.User;

public class ConsumeCSV {

	private static HashMap<String, List<User>> insurerToUsersMap = new HashMap<String, List<User>>();

	public void readFromCSV(String fileName) throws ParseException, IOException {
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			 String line = br.readLine();
			 line = br.readLine();
			 
			 while (line != null) {
				 String[] row = line.split(",");
				 
				 addIdToUserToInsurerToIdToUserMap(row);
				 
				 line = br.readLine();
			 }
		} catch(Exception e) {
			
		}
		Iterator iterator = insurerToUsersMap.keySet().iterator();
		
		while(iterator.hasNext()) {
		       String key = iterator.next().toString();
		       List<User> value = insurerToUsersMap.get(key);
		       for(int i = 0; i < value.size(); i++) {
		    	   System.out.println(key + value.get(i).getId() + value.get(i).getFullName() + value.get(i).getVersion());
		       }
		}
	}
	
	private static void addIdToUserToInsurerToIdToUserMap(String[] row) {
		User user = new User(row[0], row[1], Integer.parseInt(row[2]), row[3]);
		 
		 if(!insurerToUsersMap.containsKey(row[3])) {
			 insurerToUsersMap.put(row[3], new ArrayList<User>());
		 } 
			 
		 insurerToUsersMap.get(row[3]).add(user);
	}
}
