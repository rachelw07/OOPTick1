package wordle;

import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Wordle {

    public ArrayList<String> getWordsFromFile(String pathName) {
        File possibleWords = new File(pathName);
        ArrayList<String> possibleWordsList = new ArrayList<String>();
        try (Scanner fileReader = new Scanner(possibleWords)) {
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                possibleWordsList.add(data);
            }
            return possibleWordsList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return possibleWordsList;
    }

    public String generateWord(){
        ArrayList<String> possibleWordsList = getWordsFromFile("/home/rachelw/Documents/OOPTick1/src/wordle/wordle-La.txt");
        int index = (int)(Math.random() * possibleWordsList.size());
        return possibleWordsList.get(index);
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String inputWord = "";
        while (!checkInput(inputWord)) {
            System.out.println("Enter a 5 letter word");
            inputWord = scanner.nextLine();
        }
        return inputWord;
    }

    public boolean checkInput(String input){
        ArrayList<String> possibleGuessWordsList = getWordsFromFile("/home/rachelw/Documents/OOPTick1/src/wordle/wordle-Ta.txt");
        ArrayList<String> possibleWordsList = getWordsFromFile("/home/rachelw/Documents/OOPTick1/src/wordle/wordle-La.txt");
        return possibleGuessWordsList.contains(input)||possibleWordsList.contains(input);
    }
    public Boolean checkGuess(String input, String goalWord){
        return Objects.equals(input, goalWord);
    }

}
