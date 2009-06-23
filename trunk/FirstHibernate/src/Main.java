import action.*;
import util.UserInterfaceUtil;

public class Main {
	
	public static void main(String[] args) {
		while(true) {
			int option;
			System.out.println("* 1. Add Users");
			System.out.println("* 2. Add Products");
			System.out.println("* 3. Order Products for Users");
			System.out.println("* 4. List All Users");
			System.out.println("* 5. List All Products");
			System.out.println("* 6. Quit");
			option = UserInterfaceUtil.promptAndGetInt("Please select: ");
			if(option == 1) {
				Action action = new AddUsers();
				action.perform();
			} else if (option == 2) {
				Action action = new AddProducts();
				action.perform();
			} else if (option == 3) {
				Action action = new AddOrder();
				action.perform();
			} else if (option == 4) {
				Action action = new ListUsers();
				action.perform();
			} else if (option == 5) {
				Action action = new ListProducts();
				action.perform();
			} else if (option == 6) {
				System.exit(0);
			} else {
				System.out.println("Invalid Option. Please select again. \n");
			}
		}
	}
}
