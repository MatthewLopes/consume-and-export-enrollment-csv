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
	
//	private static Map<String, User> idToUserMap = new HashMap<String, User>();
//	private static HashMap<String, Map<String, User>> insurerToUsersMap = new HashMap<String, Map<String, User>>();
	private static List<User> users = new ArrayList<User>();

	public void readFromCSV(String fileName) throws ParseException, IOException {
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			 String line = br.readLine();
			 line = br.readLine();
			 
			 while (line != null) {
				 String[] row = line.split(",");
				 
				 User user = new User(row[0], row[1], Integer.parseInt(row[2]), row[3]);
				 users.add(user);
				 
				 //addIdToUserToInsurerToIdToUserMap(row);
				 
				 line = br.readLine();
			 }
		} catch(Exception e) {
			
		}
		
		sortListByLastName(users);
		
		for(int i = 0; i < users.size(); i ++) {
			System.out.println(users.get(i).getId() + " " + users.get(i).getFullName() + " " + users.get(i).getVersion() + " " + users.get(i).getInsurer());
		}
		//printMap();
	}
	
	private void sortListByLastName(List<User >users) {
		if (users.size() > 0) {
			  Collections.sort(users, new Comparator<User>() {
			      @Override
			      public int compare(final User object1, final User object2) {
			          return object1.getLastName().compareTo(object2.getLastName());
			      }
			  });
		}
	}
	
//	private static void addIdToUserToInsurerToIdToUserMap(String[] row) {
//		User user = new User(row[0], row[1], Integer.parseInt(row[2]), row[3]);
//		String insuranceCo = row[3];
//		
//		if(!insurerToUsersMap.containsKey(insuranceCo)) {
//			insurerToUsersMap.put(insuranceCo, addUserToIdToUserMap(user));
//		}
//		
//		User nestedUser = insurerToUsersMap.get(insuranceCo).get(user.getId());
//		if(nestedUser != null) {
//			if(nestedUser.getVersion() < user.getVersion()) {
//				insurerToUsersMap.get(insuranceCo).put(user.getId(),  user);
//			}
//		} else {
//			insurerToUsersMap.get(insuranceCo).put(user.getId(), user);
//		}
//	}
//	
//	private static Map<String, User> addUserToIdToUserMap(User user) {
//		 
//		 idToUserMap.put(user.getId(), user);
//		 
//		 return idToUserMap;
//	}
//	
//	private static void printMap() {
//		Iterator iterator = insurerToUsersMap.keySet().iterator();
//		
//		while(iterator.hasNext()) {
//		       String key = iterator.next().toString();
//		       Map<String, User> idToUserMap = insurerToUsersMap.get(key);
//		       
//		       Iterator iterator2 = idToUserMap.keySet().iterator();
//		       
//		       while(iterator2.hasNext()) {
//			       String key2 = iterator2.next().toString();
//			       User value = idToUserMap.get(key2);
//		       
//			       System.out.println(key + value.getId() + value.getFullName() + value.getVersion());
//		       }
//		}
//	}
}
