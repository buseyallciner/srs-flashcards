package com.buse.srs.repo;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

import com.buse.srs.model.Card;

public class CardRepository {

    private ArrayList<Card> cards=new ArrayList<>();
    private int nextId=1;

    public Card addCard(String front,String back){
        Card card=new Card(nextId++,front,back);
        cards.add(card);
        return card;
    }

    public ArrayList<Card> listCards(){
        return cards;
    }
    
}

