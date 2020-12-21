package hangman;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class hangMan extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font theFont = new Font("ZapfDingbats", Font.BOLD, 12);
	Font f = new Font("ZapfDingbats", Font.BOLD, 16);
	int y=100, x=100;
	static int misses=0;
	int lenght;
	String word, theWord, displayWord="", letter, theGuess;
	ArrayList<String> words= new ArrayList<String>();
	String[] characters;
	ArrayList<Character> pickedChar= new ArrayList<Character>();
	static boolean winning=false;
	JPanel splitPanel=new JPanel();
	JLabel guessesTitle = new JLabel("Letters that have been picked: ");
	JTextArea guesses=new JTextArea();
	JLabel blanksTitle = new JLabel("The Word: ");
	JTextArea blanks = new JTextArea();
	JTextField letterChoice=new JTextField(1);
	JFrame popup = new JFrame();
	picturePanel picPanel = new picturePanel();
	
	public hangMan(){
		TextFieldListener tfListener = new TextFieldListener();
	    letterChoice.addActionListener(tfListener);//add action listener to text field
		
	    //5 role panel 
		splitPanel.setLayout(new GridLayout(5,1,5,5));//make panel with 5 rows
		setLayout(new GridLayout(1, 2, 5, 5));//set frame to 2 columns
		//add labels and text fields to the frame
		
		getWord();
		displayBlanks();
		displayGuesses();
		word=theWord;
		add(picPanel);
		add(splitPanel);
		blanks.setEditable(false);
		guesses.setEditable(false);
		guesses.setFont(theFont);
		blanks.setFont(f);
		splitPanel.add(guessesTitle, BorderLayout.NORTH);
		splitPanel.add(guesses, BorderLayout.SOUTH);
		splitPanel.add(blanksTitle, BorderLayout.NORTH);
		splitPanel.add(blanks, BorderLayout.SOUTH);
		letterChoice.setEnabled(true);
		splitPanel.add(letterChoice);
	}
	public static int getMisses() {
		return misses;
	}
	
	public static boolean getWin() {
		return winning;
	}
	
	private class TextFieldListener implements ActionListener{ 
		public void actionPerformed(ActionEvent evt){  
			letter = letterChoice.getText();//gets text from text field
			letter=letter.toLowerCase(); //makes lower case
			pickLetters();
		    letterChoice.setText("");//clears text field for next entry
    }
 }
	
	public void pickLetters() {
		char check=letter.charAt(0);
		String myWord = displayWord;
		char[] myWordChars = myWord.toCharArray();
		String editWord = theWord;
		char[] myEditWordChars = editWord.toCharArray();
		
		if(!(pickedChar.contains(check))) {//if not already checked
			pickedChar.add(check);//adds to check list
			theGuess=String.valueOf(pickedChar);
			guesses.setText(theGuess);//edits displayed guess letters
			repaint();
			
			if(theWord.contains(letter)) {// if word contains letter
				while(theWord.contains(letter)) {//takes out all instances of letter
					int index=theWord.indexOf(letter);
					char theLetter=letter.charAt(0);
					myWordChars[index]= theLetter;//changes displayWord to have proper letters
					myEditWordChars[index]=('!');//changes theWord to remove letters to allow for loop to end
					theWord= String.valueOf(myEditWordChars);//changes char lists back to string
					displayWord = String.valueOf(myWordChars);//same as above
					blanks.setText(displayWord);//changes displayed words
					repaint();
					}
				}
			else {
				misses++;//adds to misses if not in word
				repaint();
			}
			if(misses==11) {
				letterChoice.setEnabled(false);//turn off input
				repaint();
			}
			else if(displayWord.equalsIgnoreCase(word)){//checks if displayed word == word 
				guesses.setText("You Won");
				winning=true;
				letterChoice.setEnabled(false);
			}
		} //if letter not already picked
		else {
			popup.setSize(200,100);
			popup.setTitle("All ready picked");
			popup.add(new JTextArea("Pick a differant letter!!"));
			popup.setVisible(true);
			popup.setLocationRelativeTo(null);
		}
		
	}
	
	public void displayBlanks() {
		for(int i=0; i<theWord.length(); i++) {//makes a string counting all indexes and sets blanks to display it
				displayWord=displayWord+Integer.toString(i);
		}
		blanks.setText(displayWord);
	}
	
	public void displayGuesses() { //Pre fills the guess boxes text
		guesses.setText("No guesses yet");
	}
	
	public void getWord() {// goes into file, takes single lines as words
		File myFile= new File("hangman.txt");// opens file
		try {
			Scanner sc = new Scanner(myFile);
			while (sc.hasNextLine()) {
		    	String line=sc.nextLine();
		    	line.trim();//removes white space
		    	line=line.toLowerCase();// makes lower case
		    	words.add(line);//adds to array list
				    }
				
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lenght=words.size();
		theWord=words.get(((int)(Math.random()*lenght)+0));//random number from size of array list and picks word with it		
	} 
	
	public static void main(String[] args) {
		hangMan frame = new hangMan();
		frame.setTitle("HangMan");
		frame.setSize(400, 300); //size of frame 
		frame.setLocationRelativeTo(null); //center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

