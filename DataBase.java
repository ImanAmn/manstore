import java.util.*;

public class DataBase {
	public List<Costumer> costumerList =  new LinkedList<>();
	public List<Seller> sellerList =  new LinkedList<>();
	public List<Item> itemList =  new LinkedList<>();
	public List<Admin> adminList =  new LinkedList<>();

	public void addCostumer(Costumer costumer) {
		costumerList.add(costumer);
	}

	public void addSeller(Seller seller) {
		sellerList.add(seller);
	}

	public void addItem(Item item) {
		itemList.add(item);
	} 

	public void addAdmin(Admin admin) {
		adminList.add(admin);
	}

	public Costumer findCostumer(String username, String pass) {
		for (Costumer costumer: costumerList)
			if (costumer.username.equals(username) && costumer.pass.equals(pass))
				return costumer;
		return null;
	}	

	public Seller findSeller(String username, String pass) {
		for (Seller seller: sellerList)
			if (seller.username.equals(username) && seller.pass.equals(pass))
				return seller;
		return null;
	}

	public Seller sudoFindSeller(String username) {
		for (Seller seller: sellerList)
			if (seller.username.equals(username))
				return seller;
		return null;
	}

	public Item findItem(int itemId) {
		for (Item item: itemList)
			if (item.id == itemId)
				return item;
		return null;
	}
	
	public Admin findAdmin(String username, String pass) {
		for (Admin admin: adminList)
			if (admin.username.equals(username) && admin.pass.equals(pass))
				return admin;
		return null;
	}

	public Object sudoFindUser(String username) {
		for (Seller seller: sellerList)
			if (seller.username.equals(username))
				return seller;
		for (Costumer costumer: costumerList)
			if (costumer.username.equals(username))
				return costumer;
		return null;
	}

	public boolean isValidUsername(String username) {
		for (Seller seller: sellerList)
			if (seller.username.equals(username))
				return false;
		for (Costumer costumer: costumerList)
			if (costumer.username.equals(username))
				return false;
		for (Admin admin: adminList)
			if (admin.username.equals(username))
				return false;
		return true;
	}

	public void showItems(String tag) {
		System.out.println("=== List of items ===");
		if (tag.equals("null")) {
			for (Item item: itemList)
				if (item.numbers > 0)
					System.out.println("* Name: " + item.name + "\n" + "* Price: " + item.price + "\n" + "* Availability: " + item.numbers + "\n" + "* Tag: " + item.tag + "\n" + "* Item ID: " + item.id + "\n\n");
		}

		else {
			for (Item item: itemList)
				if (item.tag.equals(tag) && item.numbers > 0)
					System.out.println("* Name: " + item.name + "\n" + "* Price: " + item.price + "\n" + "* Availability: " + item.numbers + "\n" + "* Tag: " + item.tag + "\n" + "* Item ID: " + item.id + "\n\n");
		}

	}

	public void showUnverifiedUsers() {
		System.out.println("=== list of unverified sellers ===");
		for (Seller seller: sellerList)
			if (!seller.is_valid)
				System.out.println("* Name: " + seller.username + "\n" + "* ID: " + seller.id + "\n");
	}

	public void showAllUsers() {
		System.out.println("=== list of all users ===");
		System.out.println("\\___ Costumer(s)");
		for (Costumer costumer: costumerList)
			System.out.println("* Name: " + costumer.username + "\n" + "* ID: " + costumer.id + "\n");
		System.out.println("\\___ Seller(s)");
		for (Seller seller: sellerList)
			System.out.println("* Name: " + seller.username + "\n" + "* ID: " + seller.id + "\n");
	}


}

