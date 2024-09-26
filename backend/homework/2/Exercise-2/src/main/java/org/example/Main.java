package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//Sample example where the sentence is taken as review
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definitely will be a frequent flyer! Francisco was very attentive";

        // Feature dataset which contain feature which are in the review

        String[][] featureSet = {
                {"ambiance", "ambience", "atmosphere", "decor"},
                {"dessert", "ice cream", "desert"},
                {"food"},
                {"soup"},
                {"service", "management", "waiter", "waitress", "bartender", "staff", "server"}
        };

        String[] posOpinionWords = {"good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious"};

        String[] negOpinionWords = {"slow", "bad", "horrible", "awful", "unprofessional", "poor"};


        SentimentAnalyzer senti = new SentimentAnalyzer();
        int[] featureOpinions = senti.detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Final Review " + Arrays.toString(featureOpinions));

    }
}