package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import util.ConsumeCSV;
import model.User;

class ConsumeCSVTest {

	@Test
public void testSortingFunction() {
	ConsumeCSV consumeCSV = new ConsumeCSV();
	List<User> users = new ArrayList<User>();
	users.add(new User("1", "Nelson Mandela", 3, "Humana"));
	users.add(new User("2", "Mahatma Gandhi", 6, "Florida Blue"));
	users.add(new User("3", "Dwayne Johnson", 4, "Humana"));
	consumeCSV.sortListByLastName(users);
	assertTrue(users.get(0).getFullName() == "Mahatma Gandhi" && users.get(1).getFullName() == "Dwayne Johnson" && users.get(2).getFullName() == "Nelson Mandela");
}

	@Test
public void testCheckForSameInsurersAndIds() {
	ConsumeCSV consumeCSV = new ConsumeCSV();
	List<User> users = new ArrayList<User>();	
	users.add(new User("1", "Mark Zuckerburg", 2, "Humana"));
	users.add(new User("2", "Satya Nadella", 4, "Humana"));
	User user = new User("1", "Sundar Pichai", 3, "Humana");
	consumeCSV.checkForSameInsurersAndIds(users, user);
	assertTrue(users.get(0).getFullName() == "Satya Nadella" && users.get(1).getFullName() == "Sundar Pichai");
}

}
