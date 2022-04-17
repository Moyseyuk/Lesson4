package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1. Поиск элемента в массиве");
        System.out.println("2. Удаление элемента из массива");
        System.out.println("3. Поиск минимального, максимального и среднего значения массива");
        System.out.println("4. Сравнение средних значений массивов");
        System.out.println("5. Создание массива из четных позиций первого");
        System.out.println("6. Замена жлемента массива на ноль");
        System.out.println("7. Сортировка имён");
        System.out.println("8. Сортировка пузырьком");
        System.out.print("Выберите какой пункт домашнего задания хотите проверить:");

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int scr1 = sc.nextInt();
            switch (scr1){
                case (1):
                    find();
                    break;
                case (2):
                    replacement();
                    break;
                case (3):
                    maxMinMiddle();
                    break;
                case (4):
                    massCompare();
                    break;
                case (5):
                    parityMass();
                    break;
                case (6):
                    changing();
                    break;
                case (7):
                    names();
                    break;
                case (8):
                    bubbleSort();
                    break;
                default:
                    System.out.println("Выберите один из 8-ми пунктов");
                    break;
            }
        } else {
            System.out.println("Извините, но вы ввели явно не число. Перезапустите программу и попробуйте снова!");
        }
    }

    public static void find() {
        int[] mass = new int[10];
        inicialization(mass);
        int a = input();
        compare(mass, a);
    }

    public static void replacement() {
        int[] mass = new int[15];
        inicialization(mass);
        int a = input();
        int i = mass.length;

        int compareCount = 0;
        for (int count = 0; count < mass.length; count++) {
            if (mass[count] == a) {
                compareCount++;
            }
        }
        for (int cicleCount = 0; cicleCount <= compareCount; cicleCount++) {
            for (int j = 0; j < i; j++) {
                if (mass[j] == a) {
                    for (int count = 0; count < i; count++) {
                        if (mass[count] == a) {
                            for (; count < (i - 1); count++) {
                                mass[count] = mass[count + 1];
                            }
                            i--;
                        }
                    }
                }
            }
        }

        if (i < 15) {
            for (int count = 0; count < i; count++) {
                System.out.print(mass[count] + "; ");
            }
        } else {
            System.out.println("Заданное вами число не входит в массив");
        }
    }

    public static void maxMinMiddle() {
        int massSize = massSize();
        int[] mass = new int[massSize];
        inicialization(mass);
        int max = -1;
        int min = 11;
        int sum = 0;
        for (int count = 0; count < mass.length; count++) {
            if (mass[count] > max) {
                max = mass[count];
            }
            if (mass[count] < min) {
                min = mass[count];
            }
            sum += mass[count];
        }
        System.out.println("Максимальное значение в массиве: " + max + ";");
        System.out.println("Минимальное значение в массиве: " + min + ";");
        System.out.println("Среднее значение массива: " + sum / mass.length + ";");
    }

    public static void massCompare() {
        int[] mass1 = new int[5];
        int[] mass2 = new int[5];
        System.out.print("Массив 1: ");
        inicialization(mass1);
        System.out.print("Массив 2: ");
        inicialization(mass2);

        double sum1 = 0;
        for (int count = 0; count < mass1.length; count++) {
            sum1 += mass1[count];
        }
        double middle1 = sum1 / mass1.length;

        double sum2 = 0;
        for (int count = 0; count < mass2.length; count++) {
            sum2 += mass2[count];
        }
        double middle2 = sum2 / mass2.length;

        System.out.println("Среднее арифметическое первого массива: " + middle1 + ";");
        System.out.println("Среднее арифметическое второго массива: " + middle2 + ";");

        if (middle1 != middle2) {
            if (middle1 > middle2) {
                System.out.println("Среднее арифметическое первого массива больше.");
            } else {
                System.out.println("Среднее арифметическое второго массива больше.");
            }
        } else {
            System.out.println("Средние арифметические двух массивов равны.");
        }
    }

    public static void parityMass() {
        System.out.println("Массив должен быть размером от 6 до 10 символов");
        int massSize = massSize();
        while ( !(massSize > 5 && massSize <= 10)) {
            System.out.println("Массив должен быть размером от 6 до 10 символов");
            massSize = massSize();
        }
        int[] mass = new int[massSize];
        inicialization(mass);
        int parityMassSize = 0;
        for (int count = 0; count < mass.length; count++){
            if ((mass[count] % 2) == 0){
                parityMassSize++;
            }
        }
        int[] parityMass = new int[parityMassSize];
        int i = 0;
        for (int count = 0; count < mass.length; count++){
            if ((mass[count] % 2) == 0){
                parityMass[i] = mass[count];
                i++;
            }
        }
        for (int count = 0; count < parityMass.length; count++) {
            System.out.print(parityMass[count] + "; ");
        }
        System.out.println("\n");
    }

    public static void changing(){
        int massSize = massSize();
        int[] mass = new int[massSize];
        inicialization(mass);
        for (int count = 0; count < mass.length; count++){
            if (count % 2 != 0){
                mass[count] = 0;
            }
        }
        for (int count = 0; count < mass.length; count++) {
            System.out.print(mass[count] + "; ");
        }
        System.out.println("\n");
    }

    public static void names() {
        String[] mass = new String[5];
        for (int count = 0; count < mass.length; count++){
            System.out.print("Введите " + (count + 1) + "имя: ");
            Scanner sc = new Scanner(System.in);
            sc = new Scanner(System.in);
            mass[count]= sc.nextLine();
        }
        for (int count = 0; count < mass.length; count++) {
            System.out.print(mass[count] + "; ");
        }
        System.out.println("\n");
        Arrays.sort(mass);
        System.out.println(Arrays.toString(mass));
    }

    public static void inicialization(int[] mass) {
        for (int count = 0; count < mass.length; count++) {
            mass[count] = (int) (Math.random() * 10);
        }
        for (int count = 0; count < mass.length; count++) {
            System.out.print(mass[count] + "; ");
        }
        System.out.println("\n");
    }

    public static int input() {
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (!sc.hasNextInt()) {
            System.out.print("Введите число: ");
            sc = new Scanner(System.in);
        }
        number = sc.nextInt();
        return (number);
    }

    public static int massSize() {
        System.out.print("Введите размер массива: ");
        Scanner sc = new Scanner(System.in);
        int massSize = 0;
        while (!sc.hasNextInt()) {
            System.out.print("Введите число: ");
            sc = new Scanner(System.in);
        }
        massSize = sc.nextInt();
        return (massSize);
    }

    public static void compare(int[] mass, int a) {
        int i = 0;
        for (int count = 0; count < mass.length; count++) {
            if (mass[count] == a) {
                i++;
            }
        }
        if (i > 0) {
            System.out.println("Введённое вами число " + a + " входит в массив");
        } else {
            System.out.println("Введённое вами число " + a + " не входит в массив");
        }
    }

    public static void bubbleSort(){
        int massSize = massSize();
        int[] mass = new int[massSize];
        inicialization(mass);

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mass.length-1; i++) {
                if(mass[i] > mass[i+1]){
                    isSorted = false;

                    buf = mass[i];
                    mass[i] = mass[i+1];
                    mass[i+1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mass));
    }

}
