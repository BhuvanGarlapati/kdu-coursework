package org.example;

import java.lang.management.PlatformLoggingMXBean;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            List<player> books = readBooksFromCSV("/Users/bhuvang/IdeaProjects/assessment/src/main/java/org/example/IPL_2021-data.csv");
            for (player b : books) {
                System.out.println(b);

            }

        }
    static List<player> books = new ArrayList<>();
        private static List<player> readBooksFromCSV(String fileName) {

            Path pathToFile = Paths.get(fileName);
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
                String line = br.readLine();
                while (line != null) {
                    String[] attributes = line.split(",");
                    player book = createBook(attributes);
                    books.add(book);
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return books;
                }
        private static player createBook(String[] metadata) {
            String name = metadata[0];
            String team = metadata[1];
            String role = metadata[2];
            int matches = Integer.parseInt(metadata[3]);
            int run = Integer.parseInt(metadata[4]);
            double average = Double.parseDouble(metadata[5]);
            double sr = Double.parseDouble(metadata[6]);
            int wickets = Integer.parseInt(metadata[7]);

            return new player(name,team,role,matches,run , average,sr,wickets);

            }
            public static ArrayList<player> getbowlers(String team){
            ArrayList<player> bowler=new ArrayList<>();
            for(int i=0;i<books.size();i++){
                if(books.get(i).getRole()=="BOWLER" && books.get(i).getWickets()>=40 && books.get(i).getTeam()==team){
                    bowler.add(books.get(i));
                }
            }
            return bowler;
            }
            public static int highestWicket(String team){
            int highest=0;
                for(int i=0;i<books.size();i++){
                    if( books.get(i).getTeam()==team){
                        if(books.get(i).getWickets()>highest){
                            highest=books.get(i).getWickets();
                        }

                    }
                }
                return highest;

            }
    public static int highestRun(String team){
        int highest=0;
        for(int i=0;i<books.size();i++){
            if( books.get(i).getTeam()==team){
                if(books.get(i).getRuns()>highest){
                    highest=books.get(i).getRuns();
                }

            }
        }
        return highest;

    }

    public int[] top3run(){
            ArrayList<Integer> runs=new ArrayList<>();
            int[] arr=new int[3];
        for(int i=0;i<books.size();i++){
            runs.add(books.get(i).getRuns());
            }
        Collections.sort(runs, Collections.reverseOrder());
        arr[0]=runs.get(0);
        arr[1]=runs.get(1);
        arr[2]=runs.get(2);
        return arr;
    }

    public int[] top3rwicket(){
        ArrayList<Integer> runs=new ArrayList<>();
        int[] arr=new int[3];
        for(int i=0;i<books.size();i++){
            runs.add(books.get(i).getMatches());
        }
        Collections.sort(runs, Collections.reverseOrder());
        arr[0]=runs.get(0);
        arr[1]=runs.get(1);
        arr[2]=runs.get(2);
        return arr;
    }
        }
     class player {
        String Name;
        String Team;
        String Role;
        int Matches;
        int Runs;
        int Wickets;
        double Average;
        double SR;

        public player(String Name,String Team,String Role,int Matches,int Runs,double Average,double SR,int Wickets){

            this.Name=Name;
            this.Team=Team;
            this.Role=Role;
            this.Matches=Matches;
            this.Runs=Runs;
            this.Average=Average;
            this.SR=SR;
            this.Wickets=Wickets;
        }

        public String getName(){
            return Name;
        }
        public String getTeam(){
            return Team;
        }
        public String getRole(){
            return Role;
        }
        public int getMatches(){
            return Matches;
        }
        public int getRuns(){
            return Runs;
        }
        public int getWickets(){
            return Wickets;
        }
        public double getAverage(){
            return Average;
        }
        public double getSR(){
            return SR;
        }
        @Override
        public String toString() {
            return "Book [name=" + Name + ", Test=" + Team + ", role=" + Role + ",Matches=" + Matches + ",Runs=" + Runs +
                    ",Wickets=" + Wickets + ",Average=" + Average + "SR=" + SR+"]";


        }

    }
