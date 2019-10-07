package com.company;

import java.util.Arrays;

public class Question {


    String question, answerA,answerB,answerC,answerD, correctAnswer;

    public Question(String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        String print = "\n" + question + "\n";
        print+= "A) " + answerA + "\n";
        print+= "B) " + answerB + "\n";
        print+= "C) " + answerC + "\n";
        print+= "D) " + answerD + "\n";
       // print += "Answer: " + correctAnswer + "\n";
        return print;
    }
}
