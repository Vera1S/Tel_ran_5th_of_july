package Homework.From_07_08_23;

import Homework.From_24_07_23.Calculator;

import java.util.Random;
import java.util.Scanner;

public class MathQuizArray {
//     Задание:
//1) Взять весь код из предыдущего домашнего задания, переместить в новый проект.
//2) Добавить поддержку нескольких игроков.
//3) Каждому игроку будет задаваться отдельный набор вопросов(3).
//4) Для каждого игрока будет вестись свой счёт.
//5) Структура MathQuiz должна остаться той же: в методе "main" только вызов MathQuiz.start().

    //Для хранения информации о счёте каждого из игроков должен использоваться массив.

    public static void start() {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();


        int numPlayers = 5;     // Количество игроков
        int numQuestions = 3;   // Количество вопросов для каждого игрока
        int correctAnswer;
        int result = 0;
//        int score = 0;


        System.out.println("Добро пожаловать в опросник!");
        int[] scores = new int[numPlayers]; // Массив для хранения счетов игроков

        for (int i = 0; i < numPlayers; i++) { // <-- игроки


            for (int j = 0; j < numQuestions; j++) { // <-- вопросы
                int num1 = rand.nextInt(1, 100) + 1;
                int num2 = rand.nextInt(1, 100) + 1;


                System.out.println("Игрок " + (i + 1) + ", начинаете игру!");

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
//                scores[i] = score; // Сохраняем счет игрока

            }

        }
        for (int k = 0; k < numPlayers; k++) {


            System.out.println("Игрок " + (k + 1) + ", Ваш финальный счет: " + scores[k]);


        }
    }
}