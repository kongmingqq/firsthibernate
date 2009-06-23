import action.AddUsers;
import util.UserInterfaceUtil;


public class Main {
	public static void main(String[] args) {
		int option;
		System.out.println("Menu: 1. Add Users");
		option = UserInterfaceUtil.promptAndGetInt("Please select: ");
		if(option == 1) {
			AddUsers action = new AddUsers();
			action.perform();
		}
	}
}
