// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Wordle newGame = new Wordle();
        String word = newGame.generateWord();
        boolean solved = false;

        for(int i=1; i < 7; i++){
            String playerInput = newGame.getInput();
            if (newGame.checkGuess(playerInput, word)){
                System.out.println("Guess successful");
                System.out.println("The word was " + word);
                System.out.println("Achieved in " + i + " guesses");
                solved = true;
                break;
            } else{
                char guessToken;
                int index;
                for(int j=0; j<5; j++){
                    guessToken = playerInput.charAt(j);
                    index = word.indexOf(guessToken);
                    if (index == -1){
                        System.out.println("Character " + guessToken + " not in word");
                    }
                    else if (index == j){
                        System.out.println(guessToken + " in the correct position, index " + j);
                    }else{
                        ;System.out.println("Character " + guessToken + " in word but not in correct position");
                }
            }

            }
        }
        if (!solved){
            System.out.println("Game over");
            System.out.println("The word was" + word);
        }
    }
}