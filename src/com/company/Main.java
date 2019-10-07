package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("quiz.txt");
            Scanner fileScanner = new Scanner(fileReader);
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);

            System.out.println("////// QUIZ //////");

            List<String> question = new ArrayList<>();
            List<String> answerA = new ArrayList<>();
            List<String> answerB = new ArrayList<>();
            List<String> answerC = new ArrayList<>();
            List<String> answerD = new ArrayList<>();
            List<String> correctAnswer = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                question.add(fileScanner.nextLine());
                answerA.add(fileScanner.nextLine());
                answerB.add(fileScanner.nextLine());
                answerC.add(fileScanner.nextLine());
                answerD.add(fileScanner.nextLine());
                correctAnswer.add(fileScanner.nextLine());
            }

            List<Question> questionsBase = new ArrayList<>();

            for (int i = 0; i < question.size(); i++) {
                questionsBase.add(new Question(question.get(i), answerA.get(i), answerB.get(i), answerC.get(i), answerD.get(i), correctAnswer.get(i)));
            }

            Character userAnswer;
            int points = 0;
            for (int i = 0; i < questionsBase.size(); i++) {
                System.out.println("---");
                System.out.print("Question:" + (i + 1));
                System.out.print(questionsBase.get(i).toString());

                do {
                    System.out.print("Answer: ");
                    userAnswer = Character.toUpperCase(scanner.next().charAt(0));
                } while (!isRightAnswerFormat(userAnswer));


                if (isRightAnswerFormat(questionsBase.get(i).correctAnswer)) {
                    if (userAnswer.toString().equals(questionsBase.get(i).correctAnswer))
                        points++;
                } else throw new Exception("\nThere's a problem with quiz.txt file. Wrong format of correctAnswer");

            }

            System.out.println("\n points: " + points + "/" + question.size());
//            fileScanner.close();


        } catch (java.util.NoSuchElementException ex) {
            System.out.println(ex.getMessage() + "\nThere's a problem with quiz.txt file.");
        } catch (java.io.FileNotFoundException ex) {
            System.out.println(ex.getMessage() + "\nI can't find quiz.txt file.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    private static boolean isRightAnswerFormat(String answer) {
        return answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D");
    }

    private static boolean isRightAnswerFormat(Character answer) {
        return answer.equals('A') || answer.equals('B') || answer.equals('C') || answer.equals('D');
    }
}

