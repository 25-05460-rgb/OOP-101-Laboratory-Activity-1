import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int totalQuantity = 0;
        double totalAmount = 0;
        double totalDeduction = 0;

        char orderAgain = 'Y';

        while (orderAgain == 'Y' || orderAgain == 'y') {

            System.out.println("\n===== CANTEEN MENU =====");
            System.out.println("1. Burger        - $100");
            System.out.println("2. Spaghetti     - $120");
            System.out.println("3. Fried Chicken - $150");
            System.out.println("4. Sandwich      - $80");
            System.out.println("5. French Fries  - $60");

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().charAt(0);

            if (itemNumber < 1 || itemNumber > 5) {
                System.out.println("Invalid item number. Please try again.");
                continue;
            }

            if (quantity < 1 || quantity > 10) {
                System.out.println("Invalid quantity. Please enter 1 to 10.");
                continue;
            }

            if (student != 'Y' && student != 'y'
                    && student != 'N' && student != 'n') {
                System.out.println("Invalid student status. Please enter Y or N.");
                continue;
            }

            double price = 0;

            switch (itemNumber) {
                case 1:
                    price = 100;
                    break;
                case 2:
                    price = 120;
                    break;
                case 3:
                    price = 150;
                    break;
                case 4:
                    price = 80;
                    break;
                case 5:
                    price = 60;
                    break;
            }

            double orderAmount = price * quantity;
            double deduction = 0;

            if ((student == 'Y' || student == 'y') && orderAmount >= 500) {
                deduction = orderAmount * 0.15;
            } else if (student == 'Y' || student == 'y') {
                deduction = orderAmount * 0.10;
            } else if (orderAmount >= 500) {
                deduction = orderAmount * 0.05;
            }

            totalQuantity += quantity;
            totalAmount += orderAmount;
            totalDeduction += deduction;

            System.out.println("\n===== ORDER SUMMARY =====");
            System.out.println("Order Amount: $" + orderAmount);
            System.out.println("Deduction: $" + deduction);
            System.out.println("Amount After Deduction: $"
                    + (orderAmount - deduction));

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().charAt(0);
        }

        double finalAmount = totalAmount - totalDeduction;

        System.out.println("\n===== FINAL SUMMARY =====");
        System.out.println("Total Quantity of Items Purchased: " + totalQuantity);
        System.out.println("Total Amount Before Deductions: $" + totalAmount);
        System.out.println("Total Deduction: $" + totalDeduction);
        System.out.println("Final Amount to Pay: $" + finalAmount);

        input.close();
    }
}