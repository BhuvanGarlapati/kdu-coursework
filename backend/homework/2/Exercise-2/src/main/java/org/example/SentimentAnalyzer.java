package org.example;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int n=featureSet.length;
        int[] featureOpinions = new int[n];

        for (int i = 0; i < n; i++) {
            for (String set : featureSet[i]) {
                int opinion = getOpinionOnFeature(review, set, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    break;
                }
            }}
        return featureOpinions;
    }
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return opinion;
    }
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        // Add was and search in that review string
        String pattern = feature + " was ";
        String find=pattern.toLowerCase();

        int startIndex = review.toLowerCase().indexOf(find);
        if (startIndex != -1) {

            // Extract the substring after the pattern which is after was

            String opinionText = review.substring(startIndex + pattern.length());

            // Check for positive opinion from the extracted substring

            for (String positiveWord : posOpinionWords) {
                if (opinionText.toLowerCase().startsWith(positiveWord.toLowerCase())) {
                    opinion = 1;
                    break;
                }
            }
            // If no positive opinion, check for negative opinion
            if (opinion == 0) {
                for (String negativeWord : negOpinionWords) {
                    if (opinionText.toLowerCase().startsWith(negativeWord.toLowerCase())) {
                        opinion = -1;
                        break;
                    }
                }
            }
        }

        return opinion;
    }
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String[] sentences = review.split("\\.");

        for (String sentence : sentences) {
            // Check for positive opinion
            for (String positiveWord : posOpinionWords) {
                if (sentence.toLowerCase().contains(positiveWord.toLowerCase() + " " + feature.toLowerCase())) {
                    opinion = 1;
                    break;
                }
            }
            // If no positive opinion, check for negative opinion
            if (opinion == 0) {
                for (String negativeWord : negOpinionWords) {
                    if (sentence.toLowerCase().contains(negativeWord.toLowerCase() + " " + feature.toLowerCase())) {
                        opinion = -1;
                        break;
                    }
                }
            }
            // Break if an opinion is found in the sentence
            if (opinion != 0) {
                break;
            }
        }

        return opinion;
    }

}