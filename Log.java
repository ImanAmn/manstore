import java.util.*;
import java.io.*;

public class Log {

	public String path = "./log.txt";
	public File file = new File(path);
	public PrintStream printStream;
	public FileOutputStream fileOutputStream;

	public void write(String txt) {		
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

/*	public void addUser(Object user) {
		if (user instanceof Costumer) {
			Costumer costumer = (Costumer) user */


}
