package corejava.music;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SongMain {
public static void main(String[] args) throws ParseException {
	Scanner scan = new Scanner(System.in);
	List<Song> songList= new ArrayList<Song>();
	System.out.println("enter no. of objects");
	Integer noOfObjects = Integer.parseInt(scan.nextLine());
	
	for(int i=0; i<noOfObjects; i++)
	{
	System.out.println("Enter song detail:");
	String song1 = scan.nextLine();
	Song songOf1=Song.CreateSong(song1);
	songList.add(songOf1);
	}
	
	System.out.println(songList);
	Collections.sort(songList);
	System.out.println(songList);
	
	
}
}
