import java.util.*;

public class Seller {
	Main main = new Main();

	static int previousId = 0;
	public int id;

	public String username;
	public String pass;
	public final String birthdate;
	public String phoneNumber;
	public boolean is_valid = false; // TODO, get_is_valid and make it private

	public Seller(String username, String pass, String birthdate, String phoneNumber) {
		this.username = username;
		this.pass = pass;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		id = ++previousId;
		id *= 10;
		id += 1; // All sellers id has 1 at the end of number

	}

	public void sellerPanel() {
		System.out.println("list of available commands:");
		System.out.println("1. account info");
		System.out.println("2. add item");
		System.out.println("3. remove item");
		System.out.println("4. log out\n");

		int operation = Integer.parseInt(main.sc.nextLine());

		switch (operation) {
			case 1:
				sellerInfo();
				break;

			case 2:
				addItem();
				break;

			case 3:
				removeItem();
				break;

			case 4:
				logOut();

		}
	}

	public void sellerInfo() {
		System.out.println("=== INFO ===");
		System.out.println("* Username: " + username + "\n" + "* Pass: " + pass + "\n" + "* Birth Date: " + birthdate + "\n" + "* Phone number: " + phoneNumber);
		System.out.println("* Validate: " + is_valid + "\n"); // TODO: use RED and GREEN color to show is_valid
		sellerPanel();
	}

	public void addItem() { 
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 5) {
			sellerPanel();
			return;
		}
		String itemName = lst[2];
		int price = Integer.parseInt(lst[3]);
		String tag = lst[4];
		if (is_valid) {
			Item item = new Item(itemName, price, tag, 1, id);
			main.dataBase.addItem(item);
			// main.log.addItem(this, item); TODO
			System.out.println("+++ item with id " + item.id + " was added successfully +++\n");
		}
		else {
			System.out.println("!!! you dont have the permission to add an item !!!\n");
		}
		sellerPanel();

	}

	public void removeItem() {
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 3) {
			sellerPanel();
			return;
		}
		int itemId = Integer.parseInt(lst[2]);
		Item item = main.dataBase.findItem(itemId);
		if (item == null) {
			System.out.println(" --- Item was not found --- \n");
		}
		else if (item.sellerId == id) {
			item.numbers = 0; // TODO: check for to remove or not_available item...?
			// main.log.removeItem(this, item); TODO
			System.out.println(" +++ item was removed successfully +++ \n");
		}
		else 
			System.out.println(" !!! you cant remove this item !!! \n");
		sellerPanel();
	}

	public void approve() {
		is_valid = true;
	}

	public void logOut() {
		System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-"); // TODO: show time & date
		System.out.println(" +-+-+-+-+-+- Exited succesfully +-+-+-+-+-+-+-+-+-");
		System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
	}



}
