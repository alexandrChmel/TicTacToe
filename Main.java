package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char arr[][] = new char[3][3];
        System.out.printf(
                """
                ---------
                | %c %c %c |
                | %c %c %c |
                | %c %c %c |
                ---------
      
                        """, arr[0][0], arr[0][1], arr[0][2], arr[1][0], arr[1][1], arr[1][2], arr[2][0], arr[2][1], arr[2][2]
        );

        int first;
        int second;
        boolean row = false;
        boolean column = false;
        boolean leftDiagonal = false;
        boolean rightDiagonal = false;
        char win = 7;
        int count = 0;
        boolean stop = false;
        char[] a = new char[1];
        while(!stop){
            for (int i = 0; i < 3; i++){
                for (int j = 0; j<3; j++){
                    for (boolean stopped = false; !stopped;) {
                        count ++;
                        first = scanner.nextInt();
                        second = scanner.nextInt();
                        if (first > 3 || second > 3 || first < 1 || second < 1) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else if (arr[first - 1][second - 1] == 'X' || arr[first - 1][second - 1] == 'O') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            if (count % 2 == 1){
                                arr[first - 1][second - 1] = 'X';
                                stopped = true;
                            } else{
                                arr[first - 1][second - 1] = 'O';
                                stopped = true;
                            }

                        }
                        count = 0;

                    }
                    System.out.printf(
                            """
                            ---------
                            | %c %c %c |
                            | %c %c %c |
                            | %c %c %c |
                            ---------
                                   
                                    """, arr[0][0], arr[0][1], arr[0][2], arr[1][0], arr[1][1], arr[1][2], arr[2][0], arr[2][1], arr[2][2]
                    );

                    if ((arr[i][0] != ' ') && (arr[i][0] == arr[i][1]) && (arr[i][0] == arr[i][2])){
                        win = arr[i][0];
                        row = true;
                        stop = true;;
                    }
                    if ((arr[0][j] != ' ') && (arr[0][j] == arr[1][j]) && (arr[0][j] == arr[2][j])){
                        win = arr[0][j];
                        column = true;
                        stop = true;
                    }

                    if ((arr[0][0] != ' ') && (arr[0][0] == arr[1][1]) && (arr[0][0] == arr[2][2])) {
                        win = arr[0][0];
                        leftDiagonal = true;
                        stop = true;
                    }
                    if ((arr[0][2] != ' ') && (arr[0][2] == arr[1][1]) && (arr[0][2] == arr[2][0])) {
                        win = arr[0][2];
                        rightDiagonal = true;
                        stop = true;

                    }


                }
            }
            stop = true;
        }


        if(row || column || leftDiagonal || rightDiagonal){ // solve this ' ' maybe try replacing with X || Y
            System.out.println(win + " wins");
        } else {
            System.out.println("Draw");
        }

    }
}