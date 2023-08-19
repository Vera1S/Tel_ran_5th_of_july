package Homework.From_09_08_23;

import Homework.From_24_07_23.Calculator;

import java.util.Random;
import java.util.Scanner;

public class MathQuizSort {
//Задание 1
//Разобраться как работает двоичный поиск(binary search), реализовать его на java.

//Задание 2
//Взять предыдущее домашнее задание(MathQuiz с несколькими игроками), и сделать так, что имена игроков в
// конце выводятся по количеству набранных баллов: игрок с наибольшим результатом - на первом месте,
// игрок с наименьшим - на последнем.
//Пример вывода результатов:
//Ivan 550 очков
//Elena 270 очков
//Igor 90 очков
//Alf 85 очков

//Для реализации использовать сортировку пузырьком.

    public static void start() {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();


        int numPlayers;     // Количество игроков
        int numQuestions = 3;   // Количество вопросов для каждого игрока
        int correctAnswer;
        int result = 0;


        System.out.println("Добро пожаловать в опросник!");

        String[] playerNames = {"Ivan", "Elena", "Igor", "Alf"}; // массив с именами играков
        numPlayers = playerNames.length; // Считывание количество игроков
        int[] scores = new int[playerNames.length]; // Массив для хранения счетов игроков с их именами


        for (int i = 0; i < numPlayers; i++) { // <-- игроки
            for (int j = 0; j < numQuestions; j++) { // <-- вопросы
                int num1 = rand.nextInt(1, 100) + 1;
                int num2 = rand.nextInt(1, 100) + 1;


                System.out.println("Игрок " + (playerNames[i] + 1) + ", начинаете игру!");

                switch (rand.nextInt(4)) {
                    case 0:
                        System.out.print("Вопрос " + (j + 1) + ": " + num1 + " + " + num2 + " = ");
                        result = Calculator.add(num1, num2);
                        break;
                    case 1:
                        System.out.print("Вопрос " + (j + 1) + ": " + num1 + " - " + num2 + " = ");
                        result = Calculator.subtract(num1, num2);
                        break;
                    case 2:
                        System.out.print("Вопрос " + j + ": " + num1 + " * " + num2 + " = ");
                        result = Calculator.multiply(num1, num2);
                        break;
                    default:
                        System.out.print("Вопрос " + j + ": " + num1 + " / " + num2 + " = ");
                        // Avoid division by zero;
                        // Избегайте деления на ноль
                        if (num1 == 0) {
                            num2 = 1;
                        }
                        result = Calculator.divide(num1, num2);
                }


                correctAnswer = scan.nextInt();

                // Вывод финального счета для каждого игрока
                if (result == correctAnswer) {
                    scores[i] += 5;
                    System.out.println("Правильно! Текущее количество баллов: " + scores[i]);
                } else {
                    scores[i] -= 5;
                    System.out.println("Неправильно! Правильный ответ: " + result + ". Текущее количество баллов: " + scores[i]);

                }
            }

        }

        // Сортировка пузырьком для массива счетов и соответствующих игроков
        for (int i = 0; i < numPlayers - 1; i++) {
            for (int j = 0; j < numPlayers - i - 1; j++) {
                if (scores[j] < scores[j + 1]) {
                    // Меняем местами счета игроков
                    int tempScore = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = tempScore;

                    // Меняем местами имена игроков
                    String tempPlayer = playerNames[j];
                    playerNames[j] = playerNames[j + 1];
                    playerNames[j + 1] = tempPlayer;
                }
            }
        }

        for (int k = 0; k < numPlayers; k++) {

            System.out.println("Игрок " + (playerNames[k] + 1) + ", Ваш финальный счет: " + scores[k]);


        }
    }
}

