import java.util.*;

public class Item {

	static int previousId = 0;
	public int id;

	public String name;
	public int price;
	public String tag;
	public int numbers;
	public int sellerId;

	public Item(String name, int price, String tag, int numbers, int sellerId) {
		this.name = name;
		this.price = price;
		this.tag = tag;
		this.numbers = numbers;
		this.sellerId = sellerId;
		id = ++previousId;
		id *= 10;
		id += 3; // all items id has 3 at the end of number
	}
}
