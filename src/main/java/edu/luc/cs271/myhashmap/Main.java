package edu.luc.cs271.myhashmap;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
  private static final FlashCard[] flashcards =
      new FlashCard[] {
        new FlashCard("Is it winter", "yes"),
        new FlashCard("What gender is Jamison", "male"),
        new FlashCard("Who is the president of the USA", "Donald Trump :("),
        new FlashCard("Is this a final project", "yes"),
        new FlashCard("Is the sky blue", "yes"),
        new FlashCard("December 25th is what day", "Christmas Day"),
        new FlashCard("Is the earth flat", "no"),
        new FlashCard("Who is the NBA team in Chicago", "bulls"),
        new FlashCard("Who is the NFL team in Chicago", "Bears"),
        new FlashCard("What gender is Daria", "female"),
        new FlashCard("Who is Michael Jordan", "famous basketball player")
      };

  public static void main(final String[] args) throws InterruptedException {
    // own implementation of stack
    LinkedStack<FlashCard> likedListFlashCards = new LinkedStack<>();
    // used with a standard library stack
    Stack<FlashCard> stackFlashCards = new Stack<>();
    // hashmap to contain questions/answer as well
    HashMap<String, String> hashMapFlashCards = new HashMap<>();
    // scoreboard data
    int correctAnswers = 0, totalAnswers = 0;
    int size = Array.getLength(Main.flashcards);
    // shuffle three arrays so each data type has a different order
    FlashCard[] arrForList = shuffleArray(flashcards);
    FlashCard[] arrForStack = shuffleArray(flashcards);
    FlashCard[] arrForHashMap = shuffleArray(flashcards);
    // populate each data structure
    for (int i = 0; i < size; i++) {
      likedListFlashCards.push(arrForList[i]);
      stackFlashCards.push(arrForStack[i]);
      hashMapFlashCards.put(arrForHashMap[i].getQuestion(), arrForHashMap[i].getAnswer());
    }
    // setup for user i/o
    Scanner keyboard = new Scanner(System.in);
    String answer = "";
    // read out flash cards
    // read linkedlist first
    while (!likedListFlashCards.isEmpty()) {
      FlashCard current = likedListFlashCards.pop();
      System.out.println(current.getQuestion());
      System.out.println("Enter your answer: ");
      answer = keyboard.nextLine();
      if (answer.equals(current.getAnswer())) {
        System.out.println("CORRECT");
        correctAnswers++;
      } else {
        System.out.println("WRONG, you need to study more");
      }
      totalAnswers++;
    }
    // stack
    while (!stackFlashCards.isEmpty()) {
      FlashCard current = stackFlashCards.pop();
      System.out.println(current.getQuestion());
      System.out.println("Enter your answer: ");
      answer = keyboard.nextLine();
      if (answer.equals(current.getAnswer())) {
        System.out.println("CORRECT");
        correctAnswers++;
      } else {
        System.out.println("WRONG, you need to study more");
      }
      totalAnswers++;
    }

    // hashmap
    for (String key : hashMapFlashCards.keySet()) {
      System.out.println(key);
      System.out.println("Enter your answer: ");
      answer = keyboard.nextLine();
      if (answer.equals(hashMapFlashCards.get(key))) {
        System.out.println("CORRECT");
        correctAnswers++;
      } else {
        System.out.println("WRONG, you need to study more");
      }
      totalAnswers++;
    }

    System.out.println(
        "GOOD WORK STUDYING you got " + correctAnswers + " out of " + totalAnswers + " correct");
    keyboard.close();
  }

  /**
   * made public for test case
   *
   * @param arr
   * @return
   */
  public static FlashCard[] shuffleArray(FlashCard[] arr) {
    FlashCard[] result = new FlashCard[flashcards.length];
    // copy a new array so that we don't modify the original
    System.arraycopy(flashcards, 0, result, 0, flashcards.length);
    int n = result.length;
    Random random = new Random();
    random.nextInt();
    for (int i = 0; i < n; i++) {
      // calculate a random index, then swap the values
      int change = i + random.nextInt(n - i);
      FlashCard temp = result[i];
      result[i] = result[change];
      result[change] = temp;
    }
    return result;
  }
}
