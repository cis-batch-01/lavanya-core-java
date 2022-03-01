package com.technocis.corejava.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChapterMain {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("enter the no of chapter");
		int noOfChapter = Integer.parseInt(scan.nextLine());
		List<Chapter> chapterList = new ArrayList<Chapter>();
		System.out.println("Enter the chapter detail");
		for (int i = 0; i < noOfChapter; i++) {
			String chapterDetail = scan.nextLine();
			Chapter chapter = Chapter.createChapter(chapterDetail);
			chapterList.add(chapter);
		}

		System.out.println(chapterList);

	}
}
