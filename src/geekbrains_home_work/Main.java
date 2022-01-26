package geekbrains_home_work;

import java.util.Random;
import java.util.Scanner;

public class Main {

        public static char[][] map;
        public static final int SIZE = 3;
        public static final int DOTS_TO_WIN = 3;
        public static final char DOT_EMPTY = '.';
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static Scanner sc = new Scanner(System.in);
        public static Random rand = new Random();
        public static void main(String[] args) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("Поюедил искуственный интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Игра закончена");
        }

        public static boolean checkWin(char symb) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][0] == symb && map[i][1] == symb && map[i][2] == symb) return true;
                    if (map[i][1] == symb && map[i][2] == symb && map[i][3] == symb) return true;
                    if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
                    if (map[0][2] == symb && map[1][1] == symb && map[2][0] == symb) return true;
                }
            }
            return false;
        }

        public static boolean isMapFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) return false;
                }
            }
            return true;
        }

        public static void aiTurn() {
            int x, y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[x][y] = DOT_O;
        }

        public static void humanTurn() {
            int x, y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(x, y));
            map[x][y] = DOT_X;
        }

        public static boolean isCellValid(int x, int y) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
            if (map[x][y] == DOT_EMPTY) return true;
            return false;
        }

        public static void initMap() {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        public static void printMap() {
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
//
//
//    public static char[][] map;
//    public static final int SIZE = 5;
//    public static final int DOTS_TO_WIN = 4;
//    public static final char DOT_EMPTY = '.';
//    public static final char DOT_X = 'X';
//    public static final char DOT_O = 'O';
//    public static Scanner sc = new Scanner(System.in);
//    public static Random rand = new Random();
//
//    public static void main(String[] args) {
//        initMap();
//        printMap();
//        while (true) {
//            humanTurn();
//            printMap();
//            if (checkWin(DOT_X)) {
//                System.out.println("Победил человек");
//                break;
//            }
//            if (isMapFull()) {
//                System.out.println("Ничья");
//                break;
//            }
//            aiTurn();
//            printMap();
//            if (checkWin(DOT_O)) {
//                System.out.println("Поюедил искуственный интеллект");
//                break;
//            }
//            if (isMapFull()) {
//                System.out.println("Ничья");
//                break;
//            }
//        }
//        System.out.println("Игра закончена");
//    }
//
//    public static boolean checkWin(char symb) {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][0] == symb && map[i][1] == symb && map[i][2] == symb && map[i][3] == symb) return true;
//                if (map[i][1] == symb && map[i][2] == symb && map[i][3] == symb && map[i][4] == symb) return true;
//                if (map[0][j] == symb && map[1][j] == symb && map[2][j] == symb && map[3][j] == symb) return true;
//                if (map[1][j] == symb && map[2][j] == symb && map[3][j] == symb && map[4][j] == symb) return true;
//                if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb && map[3][3] == symb) return true;
//                if (map[1][1] == symb && map[2][2] == symb && map[3][3] == symb && map[4][4] == symb) return true;
//                if (map[0][1] == symb && map[1][2] == symb && map[2][3] == symb && map[3][4] == symb) return true;
//                if (map[1][0] == symb && map[2][1] == symb && map[3][2] == symb && map[4][3] == symb) return true;
//                if (map[4][0] == symb && map[3][1] == symb && map[2][2] == symb && map[1][3] == symb) return true;
//                if (map[3][1] == symb && map[2][2] == symb && map[1][3] == symb && map[0][4] == symb) return true;
//                if (map[3][0] == symb && map[2][1] == symb && map[1][1] == symb && map[0][2] == symb) return true;
//                if (map[4][1] == symb && map[3][2] == symb && map[3][3] == symb && map[1][4] == symb) return true;
//            }
//
//        } return false;
//    }
//
//    public static boolean isMapFull() {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == DOT_EMPTY) return false;
//            }
//        }
//        return true;
//    }
//
//    public static void aiTurn() {
//        int x, y;
//        do {
//            x = rand.nextInt(SIZE);
//            y = rand.nextInt(SIZE);
//        } while (!isCellValid(x, y));
//        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
//        map[x][y] = DOT_O;
//    }
//
//    public static void humanTurn() {
//        int x, y;
//        do {
//            System.out.println("Введите координаты в формате X Y");
//            x = sc.nextInt() - 1;
//            y = sc.nextInt() - 1;
//        } while (!isCellValid(x, y));
//        map[x][y] = DOT_X;
//    }
//
//    public static boolean isCellValid(int x, int y) {
//        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
//        if (map[x][y] == DOT_EMPTY) return true;
//        return false;
//    }
//
//    public static void initMap() {
//        map = new char[SIZE][SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                map[i][j] = DOT_EMPTY;
//            }
//        }
//    }
//
//    public static void printMap() {
//        for (int i = 0; i <= SIZE; i++) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < SIZE; i++) {
//            System.out.print((i + 1) + " ");
//            for (int j = 0; j < SIZE; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }


