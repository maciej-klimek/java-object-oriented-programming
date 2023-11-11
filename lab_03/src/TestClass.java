public class TestClass {

    private static int id = 0;
    private long ms = 0;
    public TestClass() {
        id++;
        this.ms = System.currentTimeMillis();
    }
    @Override
    public String toString() {
        return id + ". [" + String.valueOf(ms) + "]";
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentow programu");
        }

        else {
            int count = Integer.parseInt(args[0]);
            for (int i = 0; i < count; i++) {
                TestClass testObject = new TestClass();
                System.out.println(testObject);
            }

            System.out.println("Liczba obiektow: " + count);
        }
    }
}

