package fallingRocks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HighScore {
	
	public HighScore(int score, String path){
		if(new File("D:/Java/Frocvk/trunk/FallingRocks/bin/fallingRocks/data/score.txt").isFile()){
			try(PrintWriter out = new PrintWriter(new BufferedWriter
					(new FileWriter("D:/Java/Frocvk/trunk/FallingRocks/bin/fallingRocks/data/score.txt", true)))) {
			    out.println(score);
			}catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		}
	}
}
