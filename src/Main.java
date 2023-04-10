import java.util.Random;
import java.util.Scanner;

class Main {
    public static int[][] desk = new int[3][3];

    public static void main(String[] args) {
        System.out.println("Tic-tac-toe! So let's get started, here is our board");
        showDesk();

        int index = 0;
        while (true) {
            int player = (index % 2) + 1;
            if (checkConditions(player)) {
                sendWin(player);
                break;
            }
            if (player == 1)
                setPlayerPos();
            else if (player == 2)
                setBotPos();
           index++;
        }
    }

    public static boolean checkConditions(int player) {
        if (desk[0][0] == player && desk[0][1] == player && desk[0][2] == player) {
            return true;
        } else if (desk[1][0] == player && desk[1][1] == player && desk[1][2] == player) {
            return true;
        } else if (desk[2][0] == player && desk[2][1] == player && desk[2][2] == player) {
            return true;
        } else if (desk[0][0] == player && desk[1][0] == player && desk[2][0] == player) {
            return true;
        } else if (desk[0][1] == player && desk[1][1] == player && desk[2][1] == player) {
            return true;
        } else if (desk[0][2] == player && desk[1][2] == player && desk[2][2] == player) {
            return true;
        } else if (desk[0][0] == player && desk[1][1] == player && desk[2][2] == player) {
            return true;
        } else if (desk[2][2] == player && desk[1][1] == player && desk[2][0] == player) {
            return true;
        } else {
            return false;
        }
    }

    public static void sendWin(int player) {
        System.out.printf("Player%s is win!\n", player);
    }

    public static void setPlayerPos() {
        int[] positions = getPositions();
        desk[positions[0] - 1][positions[1] - 1] = 1;
        // showDesk();
    }

    public static void setBotPos() {
        int random_x = random_number(0, 2);
        int random_y = random_number(0, 2);

        if (desk[random_x][random_y] == 0) {
            desk[random_x][random_y] = 2;
            showDesk();
            System.out.printf("The bot has made its move to position %s, %s, it's your turn!\n", random_x, random_y);
        } else setBotPos();
    }

    public static int[] getPositions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Make your move: ");
        return convertToInts(scanner.nextLine());
    }

    public static int[] convertToInts(String positions) {
        String[] stringPartsOfMove = positions.split(" ");
        return new int[] {
                Integer.parseInt(stringPartsOfMove[1]),
                Integer.parseInt(stringPartsOfMove[0])
        };
    }

    public static void showDesk() {
        System.out.printf(
                "%s | %s | %s\n---------\n%s | %s | %s\n---------\n%s | %s | %s\n",
                desk[0][0], desk[0][1], desk[0][2],
                desk[1][0], desk[1][1], desk[1][2],
                desk[2][0], desk[2][1], desk[2][2]
        );
    }

    public static int random_number(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}