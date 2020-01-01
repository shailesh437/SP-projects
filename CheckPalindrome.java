package com.sp.Programming;

import java.util.Scanner;

public class CheckPalindrome {
	public static void main(String[] args) {
		String input = "";
		Scanner inpTaker = new Scanner(System.in);
		input = inpTaker.nextLine();
		inpTaker.close();
		input = input.replaceAll(" ", "");
		input = input.toLowerCase();
		char[] inputInChars = input.toCharArray();
		for (int i = 0, j = input.length()-1; i <= j; i++, j--) {
			if (inputInChars[i] != inputInChars[j]) {
				System.out.println("NOT A PLAINDROME");
				return;
			}
		}
		System.out.println("YES A PLAINDROME");
	}
}
