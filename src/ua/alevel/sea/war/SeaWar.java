package ua.alevel.sea.war;

import java.util.Scanner;

public class SeaWar {
    public static void main(String[] args) {
        Integer[][] field = init();
        Scanner in = new Scanner(System.in);
        char alpha;
        int col, num;


        boolean isWin = false;
        while (!isWin) {
            System.out.println("Now field is:");
            outPut(field);
            System.out.print("\nMake a shot (letter + number) : ");
            alpha = in.next().charAt(0);
            if (in.hasNextInt()) {
                num = in.nextInt() - 1;
            } else {
                System.out.println("Number should be from 1 to 10.");
                in.next();
                continue;
            }

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

//            noNeibourUp = false;
//            noNeibourDown = false;
//            noNeibourLeft = false;
//            noNeibourRight = false;

            int currentShot = field[num][col];


//            int currentShotUp = 9;
//            int currentShotDown = 9;
//            int currentShotLeft = 9;
//            int currentShotRight = 9;

            int[] ups = new int[3];
            int[] downs = new int[3];
            int[] lefts = new int[3];
            int[] rights = new int[3];

            int upsQuantity = 0, downsQuantity = 0, leftsQuantity = 0, rightsQuantity = 0;

//            try {
//                currentShotUp = field[num - 1][col];
//            } catch (ArrayIndexOutOfBoundsException e) {
//                noNeibourUp = true;
//            }
//            try {
//                currentShotDown = field[num + 1][col];
//            } catch (ArrayIndexOutOfBoundsException e) {
//                noNeibourDown = true;
//            }
//            try {
//                currentShotLeft = field[num][col - 1];
//            } catch (ArrayIndexOutOfBoundsException e) {
//                noNeibourLeft = true;
//            }
//            try {
//                currentShotRight = field[num][col + 1];
//            } catch (ArrayIndexOutOfBoundsException e) {
//                noNeibourRight = true;
//            }


            try {
                for (int i = 0; i < 3; i++) {
                    ups[i] = field[num - i - 1][col];
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

            try {
                for (int i = 0; i < 3; i++) {
                    downs[i] = field[num + i + 1][col];
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

            try {
                for (int i = 0; i < 3; i++) {
                    lefts[i] = field[num][col - i - 1];
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

            try {
                for (int i = 0; i < 3; i++) {
                    rights[i] = field[num][col + i + 1];
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }


            for (int i = 0; i < 3; i++) {
                if (ups[i] == 1 || ups[i] == 2) upsQuantity++;
                else break;
            }
            for (int i = 0; i < 3; i++) {
                if (downs[i] == 1 || downs[i] == 2) downsQuantity++;
                else break;
            }
            for (int i = 0; i < 3; i++) {
                if (lefts[i] == 1 || lefts[i] == 2) leftsQuantity++;
                else break;
            }
            for (int i = 0; i < 3; i++) {
                if (rights[i] == 1 || rights[i] == 2) rightsQuantity++;
                else break;
            }

//            System.out.println(upsQuantity + " " + downsQuantity + " " + leftsQuantity + " " + rightsQuantity);
//            if (currentShot == 1 || currentShot == 2)
//                System.out.println("ship size is " + (upsQuantity + leftsQuantity + rightsQuantity + downsQuantity + 1));

            switch (currentShot) {
                case 0:
                    System.out.println("Miss. Try one more time.");
                    field[num][col] = 4;
                    continue;
                case 1:
                    System.out.println("Cool shot!");

//                    switch (currentShotUp) {
//                        case 1:
//                            System.out.println("The ship is shot.");
//                            field[num][col] = 2;
//                            break;
//                        case 2:
//                            System.out.println("The last hit. The ship is sunk.");
//                            field[num][col] = 3;
//                            field[num - 1][col] = 3;
//                            break;
//                        default:
//                            noNeibourUp = true;
//                    }
//
//                    switch (currentShotLeft) {
//                        case 1:
//                            System.out.println("The ship is shot.");
//                            field[num][col] = 2;
//                            break;
//                        case 2:
//                            System.out.println("The last hit. The ship is sunk.");
//                            field[num][col] = 3;
//                            field[num][col - 1] = 3;
//                            break;
//                        default:
//                            noNeibourLeft = true;
//                    }
//
//
//                    switch (currentShotDown) {
//                        case 1:
//                            System.out.println("The ship is shot.");
//                            field[num][col] = 2;
//                            break;
//                        case 2:
//                            System.out.println("The last hit. The ship is sunk.");
//                            field[num][col] = 3;
//                            field[num + 1][col] = 3;
//                            break;
//                        default:
//                            noNeibourDown = true;
//                    }
//
//                    switch (currentShotRight) {
//                        case 1:
//                            System.out.println("The ship is shot.");
//                            field[num][col] = 2;
//                            break;
//                        case 2:
//                            System.out.println("The last hit. The ship is sunk.");
//                            field[num][col] = 3;
//                            field[num][col + 1] = 3;
//                            break;
//                        default:
//                            noNeibourRight = true;
//                    }

//                    if (noNeibourUp && noNeibourDown && noNeibourLeft && noNeibourRight) { //////////// если над-под-слева-справа нет кораблей
//                        System.out.println("The ship is sunk.");
//                        field[num][col] = 3; // однопалубный
//                    }

                    // проверка, не последний ли это выстрел в корабль
                    boolean isLastShot;
                    boolean isLastUpShot = true;
                    boolean isLastDownShot = true;
                    boolean isLastLeftShot = true;
                    boolean isLastRightShot = true;

                    for (int i = 0; i < upsQuantity; i++) {
                        if (field[num - i - 1][col] != 2) {
                            isLastUpShot = false;
                            break;
                        }
                    }
                    for (int i = 0; i < downsQuantity; i++) {
                        if (field[num + i + 1][col] != 2) {
                            isLastDownShot = false;
                            break;
                        }
                    }
                    for (int i = 0; i < leftsQuantity; i++) {
                        if (field[num][col - i - 1] != 2) {
                            isLastLeftShot = false;
                            break;
                        }
                    }
                    for (int i = 0; i < rightsQuantity; i++) {
                        if (field[num][col + i + 1] != 2) {
                            isLastRightShot = false;
                            break;
                        }
                    }

                    isLastShot = isLastUpShot && isLastDownShot && isLastLeftShot && isLastRightShot;

                    if (isLastShot) {
                        field[num][col] = 3;
                        for (int i = 0; i < upsQuantity; i++) {
                            field[num - i - 1][col] = 3;
                        }
                        for (int i = 0; i < downsQuantity; i++) {
                            field[num + i + 1][col] = 3;
                        }
                        for (int i = 0; i < leftsQuantity; i++) {
                            field[num][col - i - 1] = 3;
                        }
                        for (int i = 0; i < rightsQuantity; i++) {
                            field[num][col + i + 1] = 3;
                        }
                        System.out.println("The ship is sunk.");
                    } else {
                        field[num][col] = 2;
                    }


                    break;
                case 2:
                    System.out.println("Was already hit. Try one more time.");
                    break;
                case 3:
                    System.out.println("Was already sunk. Try one more time.");
                    break;
                case 4:
                    System.out.println("Was already miss. Try one more time.");
                    break;

            }

            isWin = true;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == 1) {
                        isWin = false; // условие продолжения цикла, т.е остались непотопленные корабли
                        break; // достаточно одного непотопленного корабля чтобы продолжать игру
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
//                        System.out.print(" ");
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

    public static Integer[][] init() {

        Integer[][] field = new Integer[10][10];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }

//        Integer[][] field = {
//                //a b  c  d  e  f  g  h  i  j
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 1
//                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0}, // 2
//                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, // 3
//                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0}, // 4
//                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, // 5
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 6
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 7
//                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, // 8
//                {0, 0, 0, 0, 1, 0, 0, 1, 1, 0}, // 9
//                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}  // 10
//        };
        addShips(4, field);
        addShips(3, field);
        addShips(3, field);
        addShips(2, field);
        addShips(2, field);
        addShips(2, field);
        addShips(1, field);
        addShips(1, field);
        addShips(1, field);
        addShips(1, field);


        return field;
    }

    public static boolean isHorizontalShip() {
        return ((int) (Math.random() * 2) % 2 == 0);
    }

    public static void addShips(int size, Integer[][] field) {
        boolean isHorizontal = isHorizontalShip();

        int row = (int) (Math.random() * (field.length - size + 1));
        int col = (int) (Math.random() * (field.length - size + 1));
        if (isShipAllowedHere(row, col, field, isHorizontal, size)) {
            for (int i = 0; i < size; i++) {
                if (isHorizontal) {
                    field[row + i][col] = 1;
                } else {
                    field[row][col + i] = 1;
                }
            }
        } else {
            addShips(size, field);
        }
    }

    public static boolean isShipAllowedHere(int row, int col, Integer[][] field, boolean isHorizontal, int size) {
        boolean temp = false;
        if (field[row][col] == 1) return false;
        for (int i = -1; i < size + 1; i++) {
            for (int j = -1; j < 2; j++) {
                if (isHorizontal) {
                    try {
                        temp = field[row + i][col + j] == 1;
                        if (temp) return false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                } else {
                    try {
                        temp = field[row + j][col + i] == 1;
                        if (temp) return false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                }
            }
        }
        


        return true;
    }


}

