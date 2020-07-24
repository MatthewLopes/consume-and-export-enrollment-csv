package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.User;


public class ExportToCSV {

	public static void exportToCSV(List<User> users) {
		String folder = "src\\results\\";
		
		try{
			File directory = new File(folder);
			File[] files = directory.listFiles();
			for(File file : files) {
				file.delete();
			}
			for(int i = 0; i < users.size(); i++) {
				File file = new File(folder + users.get(i).getInsurer() + ".csv");
				FileWriter fr = new FileWriter(file, true);
				if(file.length() == 0) {
					fr.write("ID,Name,Version,Insurer\r\n");
				}
				fr.write(users.get(i).getId() + "," + users.get(i).getFullName() + "," + users.get(i).getVersion() + "," + users.get(i).getInsurer() + "\r\n");
				fr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
