import java.util.Date;

public class Month1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Date date = new Date(); // New Object that represents the current time (date) is created.

		System.out.println("The number of the current month is: " + (date.getMonth() + 1)); // round brackets are
																							// essential

		// IF Statement
		if (date.getMonth() == 0)
			System.out.println("January\n");

		// Another use of the IF statement with the relational operators
		int m = date.getMonth() + 1; // int value not to call method more than once
		if (m == 7 || m == 8)
			System.out.println("Vacation\n");
		else
			System.out.println("Working time\n");
	}
}