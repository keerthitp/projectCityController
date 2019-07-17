package com.company.citycontroller;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class StringCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int toContinue = 1;
        String input;

        while (toContinue == 1){

            System.out.println("ENter a word to check if the first letter is in uppercase");
            input = scanner.nextLine();

            if(!(input.charAt(0) >= 'A') && !(input.charAt(0) <= 'Z'))
                System.out.println("IT is in lowercase");
            else
                System.out.println("IT is not in lowercase");

            System.out.println("Press 1 to continue");
            toContinue = scanner.nextInt();
            scanner.nextLine();

        }



    }
}
