package com.jasper.twopointers;

/* You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word
 * in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9]. (order does not matter).
 */
import java.util.*;

public class LC0030_SubstringwithConcatenationofAllWords {
	public static List<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();
		int m = L.length, n = L[0].length();

		if (S.length() < m * n)
			return result;
		
		// m is the numbers of words we need to find
		// Because the words at array L can be duplicated, in the toFind map, key = word,val = count of the word.
		for (int i = 0; i < m; i++) {
			if (!toFind.containsKey(L[i])) {
				toFind.put(L[i], 1);
			} else {
				toFind.put(L[i], toFind.get(L[i]) + 1);
			}
		}
		for (int i = 0; i <= S.length() - n * m; i++) {
			System.out.println("-----------i=" + i + "-------" + S.charAt(i));
			found.clear();
			int j;
			for (j = 0; j < m; j++) {
				int k = i + j * n;
				String stub = S.substring(k, k + n);
				if (!toFind.containsKey(stub))
					break;
				if (!found.containsKey(stub)) {
					found.put(stub, 1);
					System.out.println(found);
				} else {
					found.put(stub, found.get(stub) + 1);
					System.out.println(found);
				}
				if (found.get(stub) > toFind.get(stub))
					break;
			}
			
			// is all words have been found?
			if (j == m)
				result.add(i);
		}
		return result;
	}
	
	

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		String s = "awordgoodgoodgoodbestworda";
		String s1 = "goodgoodbestworda";
		String[] L = { "word", "good", "best", "good" };
		a = (ArrayList) findSubstring(s, L);
		a = (ArrayList) findSubstring(s1, L);
		System.out.println("the length of s : " + s.length());
	}
}