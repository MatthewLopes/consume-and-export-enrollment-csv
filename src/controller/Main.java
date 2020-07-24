package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import util.ConsumeCSV;
import util.ExportToCSV;
import model.User;

public class Main {

	public static void main(String[] args)throws ParseException, IOException {
		
		String fileName = "src\\EnrollmentFile.csv";
		
		ConsumeCSV consumeCSV = new ConsumeCSV();
		
		final List<User> users = consumeCSV.readFromCSV(fileName);
		
		ExportToCSV.exportToCSV(users);
		
	}

}
