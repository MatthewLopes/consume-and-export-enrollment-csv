package controller;

import java.io.IOException;
import java.text.ParseException;

import util.ConsumeCSV;

public class Main {

	public static void main(String[] args)throws ParseException, IOException {
		
		String fileName = "src\\EnrollmentFile.csv";
		
		ConsumeCSV consumeCSV = new ConsumeCSV();
		consumeCSV.readFromCSV(fileName);
		
	}

}
