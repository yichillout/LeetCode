package com.jasper.hashtable;

//http://blog.csdn.net/mebiuw/article/details/52724207
public class LC0409_LongestPalindrome {
	// ASCII table a:97 A:65
	// n is the length of string     n - oddCount :  means that all the odd number should become the even number 
	// n - oddCount + 1 : means that it will keep the longest odd number
	public int longestPalindrome(String s) {

		int n = s.length();
		int oddCount = 0;
		char[] charList = s.toCharArray();
		int[] upperCount = new int[26];
		int[] lowerCount = new int[26];

		for (int i = 0; i < n; i++) {
			if (charList[i] < 'a') {
				lowerCount[charList[i] - 'A']++;
			} else {
				upperCount[charList[i] - 'a']++;
			}
		}

		for (int j = 0; j < 26; j++) {
			if (lowerCount[j] % 2 != 0)
				oddCount++;
			if (upperCount[j] % 2 != 0)
				oddCount++;
		}
      if(oddCount ==0) return n;
		return n - oddCount + 1;
	}
}
