import java.util.*;
import java.text.SimpleDateFormat;  
import java.io.*;

public class Main {
	
	// TODO packages, files
	// TODO cowsay:) TODO
	

	static DataBase dataBase = new DataBase();
	static boolean mark = true;
	static boolean acceptedUser = false;
	static Scanner sc = new Scanner(System.in);
	// file
	static Log log = new Log();


	public static void main(String[] args) {
			
		//java.util.Date date = new java.util.Date();    
		//System.out.println(date);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("YY/dd/MM  :::  HH:mm:ss");


		System.out.println("                                           ██                                   ");
		System.out.println(" ████▄██▄   ▄█████▄  ██▄████▄  ▄▄█████▄  ███████    ▄████▄    ██▄████   ▄████▄  ");
		System.out.println(" ██ ██ ██   ▀ ▄▄▄██  ██▀   ██  ██▄▄▄▄ ▀    ██      ██▀  ▀██   ██▀      ██▄▄▄▄██ ");
		System.out.println(" ██ ██ ██  ▄██▀▀▀██  ██    ██   ▀▀▀▀██▄    ██      ██    ██   ██       ██▀▀▀▀▀▀ ");
		System.out.println(" ██ ██ ██  ██▄▄▄███  ██    ██  █▄▄▄▄▄██    ██▄▄▄   ▀██▄▄██▀   ██       ▀██▄▄▄▄█ ");
		System.out.println(" ▀▀ ▀▀ ▀▀   ▀▀▀▀ ▀▀  ▀▀    ▀▀   ▀▀▀▀▀▀      ▀▀▀▀     ▀▀▀▀     ▀▀         ▀▀▀▀▀  ");
		System.out.println(formatter.format(date));
		System.out.println("\n\n");
		
		//
		Admin admin = new Admin("admin", "admin");
		dataBase.addAdmin(admin);
		dataBase.addItem(new Item("asb", 100, "animal", 5, 6451));
		//

		log.write("Iman Amani");
		log.write("Haji chetori?");


		while (mark) {
			System.out.println("here’s a list of available commands:");
			System.out.println("1. sign up");
			System.out.println("2. log in");
			System.out.println("3. close");

			int operation = Integer.parseInt(sc.nextLine());

			switch (operation) {
				case 1:
					signUp();
					break;

				case 2:
					logIn();
					break;

				case 3:
					exit();
			}

		}

	}

	public static void signUp() {
		String info = sc.nextLine();
		String[] lst = info.split(" ");
		if (lst.length < 5)
			return;
		if (info.equals("back")) {
			return;
		}
		else if (lst[2].equals("costumer")) {
			getDataCostumer(lst[3], lst[4]);
		}
		else if (lst[2].equals("seller")) {
			getDataSeller(lst[3], lst[4]);
		}

	}

	public static void getDataCostumer(String username, String pass) {
		System.out.println("Enter your birth date: ");
		String birthdate = sc.nextLine();
		System.out.println("Enter your phone number: ");
		String phoneNumber = sc.nextLine();
		// int balance = 0;
		// TODO: valid username checker TODO
		if (dataBase.isValidUsername(username)) {
			Costumer costumer = new Costumer(username, pass, birthdate, phoneNumber);
			dataBase.addCostumer(costumer);
			System.out.println(" === Costumer added! === \n");
			// log.addUser(costumer); TODO
		}
		else {
			System.out.println(" !!! Sorry, this username is already taken !!!\n"); 
		}
	}


	public static void getDataSeller(String username, String pass) {
		System.out.println("Enter your birth date: ");
		String birthdate = sc.nextLine();
		System.out.println("Enter your phone number: ");
		String phoneNumber = sc.nextLine();
		// int balance = 0;
		// TODO: valid username checker TODO
		if (dataBase.isValidUsername(username)) {
			Seller seller = new Seller(username, pass, birthdate, phoneNumber);
			dataBase.addSeller(seller);
			System.out.println(" === Seller added! === \n");
			// log.addUser(seller); TODO
		}
		else {
			System.out.println(" !!! Sorry, this username is already taken !!! \n");
		}
		
	}


	public static void logIn() {
		acceptedUser = false;
		String input = sc.nextLine();
		String[] lst = input.split(" ");
		if (lst.length < 4)
			return;
		String username = lst[2];
		String pass = lst[3];
		searchAdmin(username, pass); // TODO   TODO
		searchCostumer(username, pass);
		searchSeller(username, pass);
		// Here, the user was not accepted...
		if (!acceptedUser)
			System.out.println(" --- Oh, failed :( --- \n");
		acceptedUser = false;

	}

	public static void searchCostumer(String username, String pass) {
		Costumer costumer = dataBase.findCostumer(username, pass);
		if (costumer == null) {
			// TODO: write a meaasge...  TODO
			// I thinks it should be after 3 searchs.... Yes? 
			return;
		}
		acceptedUser = true;
		costumer.costumerPanel();
	}

	public static void searchSeller(String username, String pass) {
		Seller seller = dataBase.findSeller(username, pass);
		if (seller == null) {
			return;
		}
		acceptedUser = true;
		seller.sellerPanel();
	}  

	public static void searchAdmin(String username, String pass) {
		Admin admin = dataBase.findAdmin(username, pass);
		if (admin == null) {
			return;
		}
		acceptedUser = true;
		admin.adminPanel();
	}

	public static void exit() {
		mark = false;
		System.out.println(" __________");
		System.out.println("< GoodBye >");
		System.out.println(" ----------");
		System.out.println("        \\   ^__^");
		System.out.println("         \\  (oo)\\_______");
		System.out.println("            (__)\\       )\\/\\");
		System.out.println("                ||----w |");
		System.out.println("                ||     ||");
	}
					

}
