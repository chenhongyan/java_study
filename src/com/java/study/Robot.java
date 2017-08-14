package com.java.study;

import com.sun.istack.internal.localization.NullLocalizable;
import sun.font.TrueTypeFont;

import java.util.Scanner;

public class Robot {
    static String[] questionlist = {"Hi", "Ping", "Bye"};
    static String[] judyanswer = {"Hi honey", "Pong", "See you"};
    static String[] Maxanswer = {"Hi What's up", "Pong", "B"};

    public static void main(String args[]){
        if(args.length != 1){
            System.err.println("Please input an robot name");
        }
        String[] answer = null;
        if (args[0].equalsIgnoreCase("Judy")){
            answer = judyanswer;
        }
        if (args[0].equalsIgnoreCase("Max")){
            answer = Maxanswer;
        }
        if (answer == null){
            System.err.println("No robot");
            return;
        }
        while(true){
            Scanner word = new Scanner(System.in);
            String question = word.next();
            int matchindex = -1;
            for(int i = 0; i < questionlist.length; i++){
                if(questionlist[i].equalsIgnoreCase(question)){
                    matchindex = i;
                }
            }
            if(matchindex == -1){
                System.out.println("There is no match answer");
            }
            else
                System.out.println(answer[matchindex]);
            if(question.equalsIgnoreCase("Bye")){
                System.out.println("The robot exists");
                word.close();
                break;
            }

        }
    }
}
