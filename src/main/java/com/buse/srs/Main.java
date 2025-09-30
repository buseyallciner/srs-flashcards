package com.buse.srs;
import java.util.Scanner;

import com.buse.srs.model.Card;
import com.buse.srs.repo.CardRepository;

public class Main {
    public static void main(String[]args) {
        CardRepository repo=new CardRepository();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("--- Flashcards ---");
            System.out.println("1) Add Card");
            System.out.println("2) List Cards");
            System.out.println("3) Review");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice=input.nextInt();
            input.nextLine(); 

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }
            switch (choice){
                case 1:
                    System.out.println("Add Card selected");
                    System.out.print("Enter word: ");
                    String front=input.nextLine();
                    System.out.print("Enter meaning: ");
                    String back=input.nextLine();
                    repo.addCard(front,back);
                    System.out.println("Card added successfully");
                    break;
                case 2:
                    System.out.println("List Cards selected");
                    for(Card c: repo.listCards()){
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.println("Review selected");
                    if(repo.listCards().isEmpty()){
                        System.out.println("No cards available. Please add cards first.");
                    } else{
                        for(Card c:repo.listCards()){
                            System.out.println("Word: "+c.getFront());
                            System.out.print("Your answer: ");
                            String answer=input.nextLine();
                            if(answer.trim().equalsIgnoreCase(c.getBack().trim())){
                                System.out.println("Correct!!");
                            }else {
                                System.out.println("Wrong!! | Correct answer: "+c.getBack());
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice,try again.");
            }
        }
        input.close();
    }
}
