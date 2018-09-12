package xbox;

import java.util.Scanner;

/**
 *
 * @author cliburnsolano
 */
public class Xbox {

    private static final Scanner scanner = new Scanner(System.in);
    private static final box myBox = new box(5, 5, " ");
    private static final screen myScreen = new screen();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean quit = false;

        // Load intro
        intro();

        // Load instructions
        instructions();

        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down Spider-man...");
                    quit = true;
                    break;

                case 1:
                    changeHeight();
                    break;

                case 2:
                    changeWidth();
                    break;

                case 3:
                    changeTopBottomBorders();
                    break;

                case 4:
                    changeSideBorders();
                    break;

                case 5:
                    myScreen.display(myBox.getBox());
                    break;

                case 6:
                    instructions();
                    break;
            }
        }
    }

    private static void changeHeight() {
        System.out.println("Enter box height: ");
        int height = scanner.nextInt();

        myBox.setRows(height);
        myScreen.display(myBox.getBox());
    }

    private static void changeWidth() {
        System.out.println("Enter box width: ");
        int width = scanner.nextInt();

        myBox.setColumns(width);
        myScreen.display(myBox.getBox());
    }

    private static void changeTopBottomBorders() {
        System.out.println("Enter top and bottom border character: ");
        String border = scanner.nextLine();

        myBox.setBorderTopBottom(border);
        myScreen.display(myBox.getBox());
    }

    private static void changeSideBorders() {
        System.out.println("Enter side border character: ");
        String border = scanner.nextLine();

        myBox.setBorderSides(border);
        myScreen.display(myBox.getBox());
    }

    private static void intro() {
        System.out.println("Loading Shadow of War...");
    }

    private static void instructions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - Quit \n"
                + "1  - Set box height \n"
                + "2  - Set box width \n"
                + "3  - Set box top and bottom borders \n"
                + "4  - Set box left and right borders \n"
                + "5  - Display box \n"
                + "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
}
