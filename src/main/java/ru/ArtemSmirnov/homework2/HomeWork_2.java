package ru.ArtemSmirnov.homework2;

import java.util.Arrays;

public class HomeWork_2 {
    public static void main(String[] args) {
        setArray(10);
        setFixingArray();
        setFixingArrayWithMultiplication();
        fillDiagonal(4);
        findMaxAndMinElement(10);
        checkSumArray(setRandomArray(7,3));
        shiftArray(setRandomArray(10,11), 3);
    }

    public static void setArray(int number) {
        int[] array = setRandomArray(number, 2);
        System.out.println("Task № 1");
        System.out.println("Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(array) + "\n");
    }

    public static void setFixingArray() {
        System.out.println("Task № 2");
        int[] array = new int[8];
        for (int i = 0, j = 0; i < array.length; i++, j += 3) {
            array[i] = j;
        }
        System.out.println("Заданный массив: " + Arrays.toString(array) + "\n");
    }

    public static void setFixingArrayWithMultiplication() {
        System.out.println("Task № 3");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(array) + "\n");
    }

    public static void fillDiagonal(int num) {
        System.out.println("Task № 4");
        int[][] table = new int[num][num];
        System.out.println("Заданный массив:");

        // Заполнение диагонали слева направо
        for (int i = 0; i < num; i++) {
            table[i][i] = 1;
        }

        // Заполнение диагонали справа налево
        for (int i = 0, j = num - 1; i < num; i++, j--) {
            table[i][j] = 1;
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void findMaxAndMinElement(int element) {
        System.out.println("Task № 5");
        int[] array = setRandomArray(element, 101);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int min = array[0];
        int max = array[0];
        for (int elem : array) {
            if (elem > max) {
                max = elem;
            }
            if (min > elem) {
                min = elem;
            }
        }
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max + "\n");
    }

    public static void checkSumArray(int[] array) {
        System.out.println("Task № 6");
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int sum = 0;
        for (int elem : array) {
            sum += elem;
        }
        // проверяем что сумма всех элементов массива делится на 2 без остатка
        if (sum % 2 == 0) {
            int firstHalf = 0;
            int secondHalf = 0;
            // вычисляем половины суммы
            for (int elem : array) {
                if (firstHalf != sum / 2) {
                    firstHalf += elem;
                } else {
                    secondHalf += elem;
                }
            }
            boolean truly = firstHalf == secondHalf;
            System.out.println("В массиве есть место, где сумма левой и правой части массива равны? " + truly + "\n");
        } else {
            System.out.println("В массиве есть место, где сумма левой и правой части массива равны? " + false + "\n");
        }
    }

    // Задание массива с рандомным заполнением элементами
    public static int[] setRandomArray(int element, int random) {
        int[] array = new int[element];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * random);
        }
        return array;
    }

    public static void shiftArray(int[] array, int delta) {
        System.out.println("Task № 7");
        int shift, buffer;
        System.out.println("Исходный массив: " + Arrays.toString(array));

        // вычисляем на сколько позиций необходимо осуществить сдвиг
        if (Math.abs(delta) > array.length) {
            shift = Math.abs(delta) % array.length;
        } else {
            shift = Math.abs(delta);
        }

        // двигаем элементы массива
        if (shift != 0) {
            for (int i = 0; i < shift; i++) {
                // сдвиг вправо
                if (delta > 0) {
                    buffer = array[0];
                    array[0] = array[array.length - 1];
                    for (int j = 1; j < array.length - 1; j++) {
                        array[array.length - j] = array[array.length - j - 1];
                    }
                    array[1] = buffer;
                    // сдвиг влево
                } else if (delta < 0) {
                    buffer = array[array.length - 1];
                    array[array.length - 1] = array[0];
                    for (int j = 1; j < array.length - 1; j++) {
                        array[j - 1] = array[j];
                    }
                    array[array.length - 2] = buffer;
                }
            }
        }

        System.out.println("Измененный массив: " + Arrays.toString(array));

    }
}
