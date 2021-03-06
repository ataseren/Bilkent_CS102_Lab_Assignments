package hangmangame.extras;

import javax.swing.*;
import java.awt.*;
import cs102.hangman.*;


public class LabelsHangmanView extends JPanel implements IHangmanView
{
   //properties
   JLabel tries;
   JLabel usedWords;
   JLabel secretWord;
   JPanel holder;
   private static final Font font = new Font( null, Font.BOLD, 30);
   
   //constructors
   public LabelsHangmanView()
   {
      super();
      this.setPreferredSize(new Dimension(400,200));

      tries = new JLabel("");
      usedWords = new JLabel("");
      secretWord = new JLabel("");
      holder = new JPanel();
      
      tries.setFont( font);
      usedWords.setFont( font);
      secretWord.setFont( font);
      
      
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.add(secretWord);
      this.add(tries);
      this.add(usedWords);      
      this.setBackground(Color.cyan);
   }
   
   //methods
   /**
    * updates view
    * @param hangman obj
    */
   public void updateView(Hangman hangman)
   {
      if ( !hangman.isGameOver() ) 
      {
         secretWord.setText(hangman.getKnownSoFar()); 
         tries.setText("Tries: " + hangman.getNumOfIncorrectTries());
         usedWords.setText("Used letters: " + hangman.getUsedLetters());
      }
      else
      {
         if ( hangman.hasLost() )
         {
            secretWord.setText("Oops it was: "+ hangman.getKnownSoFar());
            tries.setText("You lost!");
            usedWords.setText("You used: " + hangman.getUsedLetters());
         }
         else
         {
            secretWord.setText("Congratulations. You won!!!");
            tries.setText("In " + hangman.getNumOfIncorrectTries() + " incorrect tries!!");
            usedWords.setText("You used: " + hangman.getUsedLetters());
         }
      }
   }  
}