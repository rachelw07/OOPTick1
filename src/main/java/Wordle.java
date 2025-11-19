import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Wordle {

    public ArrayList<String> getWordsFromFile(String resourcePath) {
        ArrayList<String> possibleWordsList = new ArrayList<>();
        // resourcePath example: "wordle/wordle-Ta.txt"
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                System.out.println("Resource not found: " + resourcePath);
                return possibleWordsList;
            }
            try (Scanner fileReader = new Scanner(is)) {
                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine().trim();
                    if (!data.isEmpty())
                        possibleWordsList.add(data);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred reading resource: " + e.getMessage());
        }
        return possibleWordsList;
    }

    public String generateWord() {
        ArrayList<String> possibleWordsList = getWordsFromFile("wordle/wordle-La.txt");
        int index = (int) (Math.random() * possibleWordsList.size());
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

    public boolean checkInput(String input) {
        ArrayList<String> possibleGuessWordsList = getWordsFromFile("wordle/wordle-Ta.txt");
        ArrayList<String> possibleWordsList = getWordsFromFile("wordle/wordle-La.txt");
        return possibleGuessWordsList.contains(input) || possibleWordsList.contains(input);
    }

    public Boolean checkGuess(String input, String goalWord) {
        return Objects.equals(input, goalWord);
    }

}
