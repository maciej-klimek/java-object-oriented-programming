public class LoopArray {

	public static void main(String[] args) {

		// Array of Strings
		String months[] = { "Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Desember" };

		System.out.println("The array consists of " + months.length + " elements.\n");

		for (int i = 0; i < months.length; i++)
			System.out.print(months[i] + ", ");
		System.out.println();

		for (String tmp : months)
			System.out.print(tmp + ", ");
		System.out.println();
		
	}
}