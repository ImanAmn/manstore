import java.util.*;
// TODO: package to import other classes with out make theme like line 5

public class Costumer {
	Main main = new Main();
	// Main mm = new Main();
	// TODO: there is no diff to use mm or main
	// DataBase dataBase = new DataBase();

	public List<Item> cart = new LinkedList<>();

	static int previousId = 0;
	public int id;

	public String username;
	public String pass; // TODO: private pass...
	public final String birthdate;
	public String phoneNumber;
	public int balance = 0;

	public Costumer(String username, String pass, String birthdate, String phoneNumber) {
		this.username = username;
		this.pass = pass;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		id = ++previousId;
		id *= 10;
		id += 2; // All customers id has 2 at the end of number
	}

	public void costumerPanel() {
		System.out.println("list of available commands:");
		System.out.println("1. account info");
		System.out.println("2. add balance");
		System.out.println("3. list of items");
		System.out.println("4. search by tag");
		System.out.println("5. log out\n");

		int operation = Integer.parseInt(main.sc.nextLine());

		switch (operation) {
			case 1:
				costumerInfo();
				break;

			case 2:
				addBalance();
				break;

			case 3:
				listOfItems();
				break;

			case 4:
				searchByTag();
				break;

			case 5:
				logOut();

		}
	}

	public void costumerInfo() {
		System.out.println("=== INFO ===");
		System.out.println("* Username: " + username + "\n" + "* Pass: " + pass + "\n" + "* Birth Date: " + birthdate + "\n" + "* Phone number: " + phoneNumber);
		System.out.println("* $" + balance + "\n");
		costumerPanel();
	}

	public void addBalance() {
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 2) {
			costumerPanel();
			return;
		}
		int add = Integer.parseInt(lst[1]);
		balance += add;
		System.out.println("=== You have $" + balance + " now, buy something! ===\n");
		// main.log.addBalance(this); TODO
		costumerPanel();
	}

	public void listOfItems() {
		main.dataBase.showItems("null");
		buyItem();
		costumerPanel();
	}

	public void buyItem() {
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 2)
			return;
		int itemId = Integer.parseInt(lst[1]);
		Item item = main.dataBase.findItem(itemId);
		if (item == null || item.numbers == 0) 
			System.out.println("!!! NOT FOUND !!!\n");

		else if (balance >= item.price) {
			balance -= item.price;
			item.numbers--;
			System.out.println("+++ Payment was successful +++\n");
			// main.log.buyItem(this, item); TODO
			cart.add(item);
		}

		else {
			System.out.println("--- Sorry, you dont have enough money to buy this item :( --- \n");
		}

	}

	public void searchByTag() {
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 4) {
			costumerPanel();
			return;
		}
		String tagName = lst[3];
		main.dataBase.showItems(tagName);
		buyItem();
		costumerPanel();
	}

	public void logOut() {
		System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		System.out.println(" +-+-+-+-+-+- Exited succesfully +-+-+-+-+-+-+-+-+-");
		System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
	}

}
