import java.util.*;

public class Admin {
	Main main = new Main();

	static int previousId = 0;
	public String username;
	public String pass;
	private int id;

	public Admin(String username, String pass) {
		this.username = username;
		this.pass = pass;
		id = ++previousId;
		id *= 10;
	}

	public void adminPanel() {
		System.out.println("list of available commands:");
		System.out.println("1. list of unverified users");
		System.out.println("2. list of all users");
		System.out.println("3. remove user");
		System.out.println("4. remove item");
		System.out.println("5. log out\n");

		int operation = Integer.parseInt(main.sc.nextLine());

		switch (operation) {
			case 1:
				listOfUnverifiedUsers();
				break;

			case 2:
				listOfAllUsers();
				break;

			case 3:
				removeUser();
				break;

			case 4:
				removeItem();
				break;

			case 5:
				logOut();

		}
	}

	public void listOfUnverifiedUsers() {
		main.dataBase.showUnverifiedUsers();
		approveUser();
		adminPanel();
	}

	public void approveUser() {
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 2)
			return;
		String username = lst[1];
		Seller seller = main.dataBase.sudoFindSeller(username);
		if (seller == null) {
			System.out.println("!!! User not found !!! \n");
			return;
		}
		seller.approve();
		// main.log.approveUser(seller); TODO 
		System.out.println("+++ Approved successfully +++\n");
	}


	public void listOfAllUsers() {
		main.dataBase.showAllUsers();
		adminPanel();
	}

	public void removeUser() {
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 3) {
			adminPanel();
			return;
		}
		String username = lst[2];
		Object user = main.dataBase.sudoFindUser(username);

		if (user instanceof Seller) {
			Seller seller = (Seller) user;
			main.dataBase.sellerList.remove(seller);
		//	main.log.removeUser(seller); TODO
			System.out.println("+++ user with username " + seller.username + " was removed successfully +++\n");
		}

		else if (user instanceof Costumer) {
			Costumer costumer = (Costumer) user;
			main.dataBase.costumerList.remove(costumer);
		//	main.log.removeUser(costumer); TODO
			System.out.println("+++ user with username " + costumer.username + " was removed successfully +++ \n");
		}

		else 
			System.out.println("!!! What do you want here?! :/ !!!");

		// TODO: learn about وراثت in java, seller x = (seller) user
		/*if (Object == Seller)
			System.out.println("SSSSSSSS\n");
		else if (Object == Costumer)
			System.out.println("CCCCCCCC\n");
		else
			System.out.println(" !!!! \n");*/
		adminPanel();
	}

	public void removeItem() {
		String[] lst = main.sc.nextLine().split(" ");
		if (lst.length < 3) {
			adminPanel();
			return;
		}
		int itemId = Integer.parseInt(lst[2]);
		Item item = main.dataBase.findItem(itemId);
		if (item == null) 
			adminPanel();
		else {
			item.numbers = 0;
		//	main.log.removeItem(item); TODO
			System.out.println("+++ item with id " + item.id + " was removed successfully +++\n");
		}
		// TODO: lst < check to dont return, Panel... TODO
	}

	public void logOut() {
		System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		System.out.println(" +-+-+-+-+-+- Exited succesfully +-+-+-+-+-+-+-+-+-");
		System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");

	}

}
