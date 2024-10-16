package csc210;

public class Methods {
    // entry point function - this is where the program starts
    public static void main(String[] args) {
        Methods.printHelloWorld();
        int len = Methods.printMessage("Goodbye, World!");
        System.out.println(len);
        
    }
        public static void printHelloWorld() {
            System.out.println("Hello, World!");

        }
        public static int printMessage(String msg) {
            System.out.println(msg);
            return msg.length();

        }
}
