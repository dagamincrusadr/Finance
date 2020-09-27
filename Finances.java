import java.util.ArrayList;
import java.util.Scanner;

class Finances {
    public static Scanner scan = new Scanner(System.in);
    public static boolean running = true;
    public static ArrayList<String> A = new ArrayList<>();
    public static ArrayList<Double> B = new ArrayList<>();
    public static ArrayList<String> C = new ArrayList<>();
    public static String star;
    public static int i = 0;
    public static boolean exit = false;
    public static Double money;
    public static void main(String[] args) {
        Input();
        System.out.println("Expenses: " + A);
        if (C.size() > 0) {
            System.out.println("Added money: " + C);
        }
        System.out.println("Monthly money remaining: " + money);
    }
    static void Input() {
        System.out.println("Enter a star * when you would like to end the program");
        System.out.println("Please enter how much money you would like to allocate for this month");
        money = scan.nextDouble();
        while (running == true) {
            System.out.println("Please enter the name of what you bought, or a * to end the program");
            star = scan.next();
            if (star.equals("*") ) {
                while (i < B.size()) {
                    money -= B.get(i);
                    i++;
                }
                i = 0;
                while (i < B.size()) {
                    A.set(i, A.get(i) + " " + String.valueOf(B.get(i)));
                    i++;
                }
                System.out.println("Would you like to add an input of money?");
                while (exit == false) {
                    switch (scan.nextLine().toLowerCase()) {
                        case "no":
                        return;
                        case "yes":
                        while (exit == false) {
                            System.out.println("Enter the amount of money you would like to input, or a * to end the program");
                            star = scan.nextLine();
                            if (star.equals("*")) {
                                exit = true;
                                return;
                            }
                            money += Double.valueOf(star);
                            C.add(star);
                        }
                        break;
                        default:
                        System.out.println("Please input yes or no");
                        break;
                    }
                }
            }
            A.add(star);
            System.out.println("Please enter the cost of what you bought");
            B.add(scan.nextDouble());
            System.out.println(B);
        }
    }
}