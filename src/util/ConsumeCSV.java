package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import java.util.*;
import java.nio.charset.StandardCharsets;

import model.User;

public class ConsumeCSV {
	
	private static List<User> users = new ArrayList<User>();

	public List<User> readFromCSV(String fileName) throws ParseException, IOException {
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			 String line = br.readLine();
			 line = br.readLine();
			 
			 while (line != null) {
				 String[] row = line.split(",");
				 
				 User user = new User(row[0], row[1], Integer.parseInt(row[2]), row[3]);
				 
				 if(users.size() > 0) {
					 checkForSameInsurersAndIds(users, user);
				 } else {
					 users.add(user);
				 }
				 
				 sortListByLastName(users);
				 
				 line = br.readLine();
			 }
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return users;
	}
	
	public static void sortListByLastName(List<User> users) {
		if (users.size() > 0) {
			  Collections.sort(users, new Comparator<User>() {
			      @Override
			      public int compare(final User object1, final User object2) {
			          return object1.getLastName().compareTo(object2.getLastName());
			      }
			  });
		}
	}
	
	public static void checkForSameInsurersAndIds(List<User> users, User user) {
		Boolean addUser = true;
		
		 for(int i = 0; i <= users.size()-1; i++) {
			 if(users.get(i).getInsurer().equals(user.getInsurer()) && users.get(i).getId().equals(user.getId())) {
				 if(user.getVersion() > users.get(i).getVersion()) {
					 users.remove(i);
					 break;
				 } else {
					 addUser = false;
					 break;
				 }
			 } 
		 }
		 if(addUser) {
			 users.add(user);		 
		 }
	}
}
