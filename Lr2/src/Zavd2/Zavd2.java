package Zavd2;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zavd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.print("Введіть кількість чисел в масиві - ");
        int km;

        //Перевірка на правильність написання (не рядок, а число)
        try {
            km = sc.nextInt();
            sc.nextLine();            //очищення буфера після введення числа

            if (km <= 0) {        //Перевірка на негативний розмір масиву
                System.out.print("Неправильно введені дані! Спробуйте ще раз - ");
                km = sc.nextInt();
                sc.nextLine();            //очищення буфера після введення числа
            }
        } catch (InputMismatchException e) {
            sc.next();
            System.out.print("Неправильно введені дані! Спробуйте ще раз - ");
            km = sc.nextInt();
            sc.nextLine();            //очищення буфера після введення числа

            if (km <= 0) {        //Перевірка на негативний розмір масиву
                System.out.print("Неправильно введені дані! Спробуйте ще раз - ");
                km = sc.nextInt();
                sc.nextLine();            //очищення буфера після введення числа
            }
        }

        System.out.println();

        float[] array = new float[km];      //створення масиву
        Random rnd = new Random();          //створення рандомізації
        DecimalFormat df = new DecimalFormat("###.###");    //формат чисел масиву

        //Визначити мінімальний елемент масиву та його індекс
        float min = array[0];
        int min_id = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextFloat(-50, 0);
            if (min > array[i]) {
                min = array[i];
                min_id = i;
            }
            System.out.println(i + ": " + df.format(array[i]) + "; ");
        }
        System.out.println("\nMінімальний елемент: " + df.format(min) + ", індекс: " + min_id);
    }
}
