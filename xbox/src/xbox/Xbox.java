package xbox;

import java.util.Scanner;

/**
 *
 * @author cliburnsolano
 */
public class Xbox {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final box MY_BOX = new box(5, 5, " ");
    private static final screen MY_SCREEN = new screen();
    private static final cursor MY_CURSOR = new cursor(0, 0);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean quit = false;

        // Load intro
        intro();

        // Load instructions
        instructions();

        // Display xbox
        displayCursor();

        while (!quit) {
            System.out.println("\nEnter action: (1 to show available actions)");
            int action = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down Spider-man...");
                    quit = true;
                    break;

                case 1:
                    instructions();
                    break;

                case 2:
                    changeHeight();
                    break;

                case 3:
                    changeWidth();
                    break;

                case 4:
                    changeTopBottomBorders();
                    break;

                case 5:
                    changeSideBorders();
                    break;

                case 6:
                    changeXPos(-1);
                    break;

                case 7:
                    changeXPos(1);
                    break;

                case 8:
                    changeYPos(-1);
                    break;

                case 9:
                    changeYPos(1);
                    break;

                case 10:
                    MY_CURSOR.setBorderless(true);
                    System.out.println("Borderless: " + MY_CURSOR.isBorderless());
                    break;

                case 11:
                    MY_CURSOR.setBorderless(false);
                    System.out.println("Borderless: " + MY_CURSOR.isBorderless());
                    break;

                case 12:
                    MY_CURSOR.setBoxContents(MY_BOX.getBox());
                    MY_SCREEN.display(MY_CURSOR.getBoxContents());
                    break;
            }
        }
    }

    private static void changeXPos(int x) {
        MY_CURSOR.setxMax(MY_BOX.getColumns());
        MY_CURSOR.setxPos(x);
        displayCursor();
    }

    private static void changeYPos(int y) {
        MY_CURSOR.setyMax(MY_BOX.getRows());
        MY_CURSOR.setyPos(y);
        displayCursor();
    }

    private static void changeHeight() {
        System.out.println("Enter box height: ");
        int height = SCANNER.nextInt();

        MY_BOX.setRows(height);
        displayCursor();
    }

    private static void changeWidth() {
        System.out.println("Enter box width: ");
        int width = SCANNER.nextInt();

        MY_BOX.setColumns(width);
        displayCursor();
    }

    private static void changeTopBottomBorders() {
        System.out.println("Enter top and bottom border character: ");
        String border = SCANNER.nextLine();

        MY_BOX.setBorderTopBottom(border);
        displayCursor();
    }

    private static void changeSideBorders() {
        System.out.println("Enter side border character: ");
        String border = SCANNER.nextLine();

        MY_BOX.setBorderSides(border);
        displayCursor();
    }

    private static void resetCursor() {
        boolean originalBorderless = MY_CURSOR.isBorderless();

        MY_CURSOR.setBorderless(false);
        MY_CURSOR.setxMax(MY_BOX.getColumns());
        MY_CURSOR.setyMax(MY_BOX.getRows());
        MY_CURSOR.setxPos(0);
        MY_CURSOR.setyPos(0);
        MY_CURSOR.setBorderless(originalBorderless);
    }

    private static void displayCursor() {
        MY_CURSOR.setBoxContents(MY_BOX.getBox());
        MY_SCREEN.display(MY_CURSOR.getBoxContents());
    }

    private static void intro() {
        System.out.println("Loading Shadow of War...");
    }

    private static void instructions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - Quit \n"
                + "1  - Print a list of available actions \n"
                + "2  - Set box height (Minimum of 3) \n"
                + "3  - Set box width (Minimum of 3) \n"
                + "4  - Set box top and bottom borders \n"
                + "5  - Set box left and right borders \n"
                + "6  - Move cursor left \n"
                + "7  - Move cursor right \n"
                + "8  - Move cursor up \n"
                + "9  - Move cursor down \n"
                + "10  - Set borderless on \n"
                + "11  - Set borderless off \n"
                + "12  - Display box");
        System.out.println("Choose your action: ");
    }
}
