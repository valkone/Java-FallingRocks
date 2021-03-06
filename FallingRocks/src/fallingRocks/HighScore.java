package fallingRocks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.plaf.FileChooserUI;

public class HighScore {
	public static void saveScore(){
			if(getScore()<Game.currentLevel){
				writeScore(Game.currentLevel);
			}
	}
	
	static void writeScore (int score){
		try {
			PrintWriter out = new PrintWriter("score.txt");
			out.print(score);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.print("Error writing to score.txt");
		}
	}
	
	public static int getScore(){
		try {
			
			FileReader file = new FileReader("score.txt");
			Scanner scan = new Scanner(file);
			int i=scan.nextInt();
			scan.close();
			file.close();
			return i;
		} catch (IOException e) {
			System.err.println("Error reading score.txt");
			e.printStackTrace();
			return -1;
		}
	}
	
}
