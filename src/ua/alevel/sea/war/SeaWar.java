package ua.alevel.sea.war;

import java.util.Scanner;

public class SeaWar {
    public static void main(String[] args) {
        Integer[][] field = {
                //a b  c  d  e  f  g  h  i  j
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 1
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0}, // 2
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, // 3
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0}, // 4
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, // 5
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 6
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 7
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, // 8
                {0, 0, 0, 0, 1, 0, 0, 1, 1, 0}, // 9
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}  // 10
        };
        Scanner in = new Scanner(System.in);
        char alpha;
        int col, num;
        boolean isFirstRow, isFirstCol, isLastRow, isLastCol;
        boolean noNeibourUp, noNeibourDown, noNeibourLeft, noNeibourRight;
        int is4sunk = 1; // 0 - если потоплен четырехпалубный
        int is3sunk = 2; // 0 - если потоплены оба трехпалубных

        boolean isWin = false;
        while (!isWin) {
            System.out.println("Now field is:");
            outPut(field);
            System.out.print("\nMake a shot (letter + number) : ");
            alpha = in.next().charAt(0);
            num = in.nextInt() - 1;

            switch (alpha) {
                case 'a':
                    col = 0;
                    break;
                case 'b':
                    col = 1;
                    break;
                case 'c':
                    col = 2;
                    break;
                case 'd':
                    col = 3;
                    break;
                case 'e':
                    col = 4;
                    break;
                case 'f':
                    col = 5;
                    break;
                case 'g':
                    col = 6;
                    break;
                case 'h':
                    col = 7;
                    break;
                case 'i':
                    col = 8;
                    break;
                case 'j':
                    col = 9;
                    break;
                default:
                    System.out.println("Letter should be from a to j.");
                    continue;
            }
            if (num > 9 || num < 0) {
                System.out.println("Number should be from 1 to 10.");
                continue;
            }

            isFirstRow = num < 1;
            isFirstCol = col < 1;
            isLastRow = num > 8;
            isLastCol = col > 8;
            noNeibourUp = false;
            noNeibourDown = false;
            noNeibourLeft = false;
            noNeibourRight = false;


            if (field[num][col] == 1) {
                System.out.println("Cool shot!");
                if (!isFirstRow) {
                    if (field[num - 1][col] == 1) { //////////////// если не в первой строке
                        System.out.println("The ship is shot.");
                        field[num][col] = 2;
                    } else if (field[num - 1][col] == 2) {
                        System.out.println("The last hit. The ship is sunk."); // только для двупалубных
                        field[num][col] = 3;
                        field[num - 1][col] = 3;
                    } else noNeibourUp = true; /// если нет корабля
                } else noNeibourUp = true; //// если нет поля
                if (!isFirstCol) {
                    if (field[num][col - 1] == 1) { //////////////// если не в первом столбце
                        System.out.println("The ship is shot.");
                        field[num][col] = 2;
                    } else if (field[num][col - 1] == 2) {
                        System.out.println("The last hit. The ship is sunk.");
                        field[num][col] = 3;
                        field[num][col - 1] = 3;
                    } else noNeibourLeft = true;
                } else noNeibourLeft = true;
                if (!isLastRow) {
                    if (field[num + 1][col] == 1) {  //////////////// если не в последней строке
                        System.out.println("The ship is shot.");
                        field[num][col] = 2;
                    } else if (field[num + 1][col] == 2) {
                        System.out.println("The last hit. The ship is sunk.");
                        field[num][col] = 3;
                        field[num + 1][col] = 3;
                    } else noNeibourDown = true;
                } else noNeibourDown = true;
                if (!isLastCol) {
                    if (field[num][col + 1] == 1) {  //////////////// если не в последнем столбце
                        System.out.println("The ship is shot.");
                        field[num][col] = 2;
                    } else if (field[num][col + 1] == 2) {
                        System.out.println("The last hit. The ship is sunk.");
                        field[num][col] = 3;
                        field[num][col + 1] = 3;
                    } else noNeibourRight = true;
                } else noNeibourRight = true;

                if (noNeibourUp && noNeibourDown && noNeibourLeft && noNeibourRight) { //////////// если над-под-слева-справа нет кораблей
                    System.out.println("The ship is sunk.");
                    field[num][col] = 3; // однопалубный
                }
            } else if (field[num][col] == 2 || field[num][col] == 3 || field[num][col] == 4) {
                System.out.println("Was already hit or miss. Try one more time.");
            } else {
                System.out.println("Miss. Try one more time.");
                field[num][col] = 4;
            }
            isWin = true;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == 1) {
                        isWin = false; // условие продолжения цикла, т.е остались непотопленные корабли
                        break;
                    }
                }
            }
        }
        System.out.println("\n\nCongratulations! You win.");
        outPut(field);
        in.close();
    }

    public static void outPut(Integer[][] field) {
        //                               КРАСИВЫЙ ВЫВОД
        System.out.println("\n   | a | b | c | d | e | f | g | h | i | j |");
        for (int i = 0; i < field.length; i++) {
            if (i < 9) System.out.print(" " + (i + 1));
            else System.out.print((i + 1));
            for (int j = 0; j < field.length; j++) {
                System.out.print(" | ");

                switch (field[i][j]) {
                    case 1: // целый
                        System.out.print("o");
                        break;
                    case 2: // раненный
                        System.out.print("e");
                        break;
                    case 3:// потопленный
                        System.out.print("x");
                        break;
                    case 4: // мимо
                        System.out.print(".");
                        break;
                    default: // если клетка еще не была тронута
                        System.out.print(" ");
                        break;
                }


                if (j == 9) System.out.print(" | ");
            }
            System.out.println("");
        }
    }


}

