import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverterSwitchIf {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        try {
            System.out.println("Select the currency to convert to or from US dollars:");
            System.out.println("0: Mexican Pesos");
            System.out.println("1: Japanese Yen");
            System.out.println("2: Chinese Yuan");
            System.out.println("3: British Pounds");
            System.out.println("4: European Union Euros");
            int currency = kb.nextInt();

            System.out.println("Convert:");
            System.out.println("0: From US dollars");
            System.out.println("1: To US dollars");
            int direction = kb.nextInt();

            System.out.print("Enter the amount: ");
            float amount = kb.nextFloat();

            float conversionRate = 0;
            String currencyName = "";

            switch (currency) {
                case 0: // Mexican Pesos
                    currencyName = "Mexican Pesos";
                    conversionRate = 20.15f; // Example conversion rate
                    break;
                case 1: // Japanese Yen
                    currencyName = "Japanese Yen";
                    conversionRate = 110.60f; // Example conversion rate
                    break;
                case 2: // Chinese Yuan
                    currencyName = "Chinese Yuan";
                    conversionRate = 6.45f; // Example conversion rate
                    break;
                case 3: // British Pounds
                    currencyName = "British Pounds";
                    conversionRate = 0.75f; // Example conversion rate
                    break;
                case 4: // European Union Euros
                    currencyName = "European Union Euros";
                    conversionRate = 0.85f; // Example conversion rate
                    break;
                default:
                    System.out.println("Invalid currency selection.");
                    return;
            }

            float convertedAmount = 0;
            if (direction == 0) { // From US dollars
                convertedAmount = amount * conversionRate;
                System.out.printf("%.2f US dollars is %.2f %s%n", amount, convertedAmount, currencyName);
            } else if (direction == 1) { // To US dollars
                convertedAmount = amount / conversionRate;
                System.out.printf("%.2f %s is %.2f US dollars%n", amount, currencyName, convertedAmount);
            } else {
                System.out.println("Invalid conversion direction.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            kb.close();
        }
    }
}
