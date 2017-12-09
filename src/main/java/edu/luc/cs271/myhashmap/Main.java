package edu.luc.cs271.myhashmap;


import javax.script.ScriptContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
  private static final FlashCard[] flashcards = new FlashCard[]{
          new FlashCard("Is it winter", "y"),
          new FlashCard("Is Jamison male", "y"),
          new FlashCard("Is it spring", "n"),
          new FlashCard("Is this a final project", "y"),
          new FlashCard("Is the sky blue", "y"),
          new FlashCard("Is there school on Christmas Day", "n"),
          new FlashCard("Is the earth flat", "n"),
          new FlashCard("Are the bulls good", "n"),
          new FlashCard("Are the bears good", "n"),
          new FlashCard("Is Daria male", "n")
  };

  public static void main(final String[] args) throws InterruptedException {
    LinkedList<FlashCard> likedListFlashCards = new LinkedList<>();
    Stack<FlashCard> stackFlashCards = new Stack<>();
    HashMap<String, String> hashMapFlashCards = new HashMap<>();

    //populate each data structure
    int size = Array.getLength(Main.flashcards);
    /*
    FlashCard currentFlashCard = Main.flashcards[i];
      likedListFlashCards.add(currentFlashCard);
      stackFlashCards.push(currentFlashCard);
      hashMapFlashCards.put(currentFlashCard.getQuestion(), currentFlashCard.getAnswer());
     */
    FlashCard[] arrForList = shuffleArray(flashcards);
    FlashCard[] arrForStack = shuffleArray(flashcards);
    FlashCard[] arrForHashMap = shuffleArray(flashcards);
    for (int i =0; i < size; i++) {
      likedListFlashCards.add(arrForList[i]);
      stackFlashCards.push(arrForStack[i]);
      hashMapFlashCards.put(arrForHashMap[i].getQuestion(), arrForHashMap[i].getAnswer());
    }
    //shuffle

    //read out flash cards
    //read linkedlist first
    for( int i =0; i < likedListFlashCards.size(); i++) {
      FlashCard current = likedListFlashCards.get(i);
      System.out.println(current.getQuestion());
      System.out.println(current.getAnswer());
    }
    //stack
    while(!stackFlashCards.isEmpty()) {
      FlashCard current = stackFlashCards.pop();
      System.out.println(current.getQuestion());
      System.out.println(current.getAnswer());
    }

    //hashmap
    for(String key: hashMapFlashCards.keySet()) {
      System.out.println(key);
      System.out.println(hashMapFlashCards.get(key));
    }
  }

  private static FlashCard[] shuffleArray(FlashCard[] arr) {
    FlashCard[] result = new FlashCard[flashcards.length];
    System.arraycopy(flashcards, 0, result, 0, flashcards.length);
    int n = result.length;
    Random random = new Random();
    random.nextInt();
    for (int i = 0; i < n; i++){
      int change = i + random.nextInt(n - i);
      FlashCard temp = result[i];
      result[i] = result[change];
      result[change] = temp;
    }
    return result;
  }
}

