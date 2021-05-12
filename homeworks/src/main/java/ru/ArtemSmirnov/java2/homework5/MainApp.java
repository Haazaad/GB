package ru.ArtemSmirnov.java2.homework5;

public class MainApp {
    static final int SIZE = 10_000_000;

    static long workTime;

    public static void main(String[] args) {
        float[] arr1 = prepareArray();
        modifyArray(arr1, 0);
        System.out.printf("Время модификации массива без использования потоков %d мс\n", System.currentTimeMillis() - workTime);
        float[] arr2 = prepareArray();
        try {
            modifyArray_v2(arr2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static float[] prepareArray() {
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }
        workTime = System.currentTimeMillis();
        return array;
    }

    public static void modifyArray(float[] array, int initialValue) {
        for (int i = 0, j = initialValue; i < array.length; i++, j++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (float) j / 5) * Math.cos(0.2f + (float) j / 5) * Math.cos(0.4f + (float) j / 2));
        }
    }

    public static void modifyArray_v2(float[] array) throws InterruptedException {
        long time;
        float[] a1 = new float[SIZE / 2];
        float[] a2 = new float[SIZE / 2];
        System.arraycopy(array, 0, a1, 0, SIZE / 2);
        System.arraycopy(array, SIZE / 2, a2, 0, SIZE / 2);
        time = System.currentTimeMillis();
        System.out.printf("Время разбития исходного массива на 2 %d мс\n", time - workTime);
        Thread tr1 = new Thread(() -> modifyArray(a1, 0));
        Thread tr2 = new Thread(() -> modifyArray(a2, SIZE / 2));
        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();
        System.out.printf("Время модификации 2х массивов в 2х потоках %d мс\n", System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.arraycopy(a1, 0, array, 0, SIZE/2);
        System.arraycopy(a2, 0, array, SIZE / 2, SIZE / 2);
        System.out.printf("Время склейки 2х массивов в один %d мс\n", System.currentTimeMillis() - time);
        System.out.printf("Общее время работы метода %d мс\n", System.currentTimeMillis() - workTime);
    }
}
