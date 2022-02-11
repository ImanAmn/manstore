import java.util.*;
import java.io.*;

public class Log {

	public String path = "./log.txt";
	public File file = new File(path);
	public PrintStream printStream;
	public FileOutputStream fileOutputStream;

	public void write(Object txt) {		
	//	file.getParentFile().mkdirs();
		try {
			if(!file.exists())
				file.createNewFile();
			fileOutputStream = new FileOutputStream(file, true);
			printStream = new PrintStream(fileOutputStream);
			printStream.println(txt);
			printStream.flush();
			printStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addUser(User user) {
		write("** ADD USER ** " + " username: " + user.username + " || ID: " + user.id + " || phoneNumber: " + user.phoneNumber + " || birthdate: " + user.birthdate);
	}

	public void addItem(User user, Item item) {
		write("** ADD ITEM ** " + " username: " + user.username + " || item: " + item.name + " || tag: " + item.tag + " || price: " + item.price);
	}

	public void removeItem(User user, Item item) {
		write("** REMOVE ITEM ** " + " username: " + user.username + " || item: " + item.name + " || tag: " + item.tag + " || price: " + item.price);
	}

	public void addBalance(User user, int balance) {
		write("** ADD BALANCE ** " + "username: " + user.username + " || amount: " + balance);
	}
	
	public void buyItem(User user, Item item) {
		write("** BUY ITEM ** " + "username: " + user.username + " || item: " + item.name + " || price: " + item.price);
	}

	public void approveUser(User user) {
		write("** APROVE USER ** " + " username: " + user.username + " || ID: " + user.id);
	}

	public void removeUser(User user) {
		write("** REMOVE USER ** " + " username: " + user.username + " || ID: " + user.id);
	}

	public void catLog() {
		Process p;
		String s;
		try {
			p = Runtime.getRuntime().exec("cat log.txt");
			BufferedReader read = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = read.readLine()) != null)
				System.out.println(s);
			System.out.println("\n");
			p.waitFor();
			p.destroy();
		}	catch (Exception e) {}
			
	}
}
