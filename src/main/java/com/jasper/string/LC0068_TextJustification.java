package com.jasper.string;

import java.util.ArrayList;
import java.util.List;

public class LC0068_TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		int len = 0;
		ArrayList<String> list = new ArrayList<String>();
		StringBuffer str = new StringBuffer();
		int preindex = 0;
		for (int i = 0; i < words.length; i++) {
			if (len + words[i].length() + i - preindex > L) {
				int spacenum = 0;
				int extraspace = 0;
				if (i - preindex != 1) {
					spacenum = (L - len) / (i - preindex - 1);
					extraspace = (L - len) % (i - preindex - 1);
				}
				str = new StringBuffer();
				for (int j = preindex; j < i; j++) {
					str.append(words[j]);
					if (j < i - 1) {
						for (int k = 0; k < spacenum; k++)
							str.append(" ");
						if (extraspace > 0)
							str.append(" ");
						extraspace--;
					}
				}
				for (int j = str.length(); j < L; j++)
					str.append(" ");

				list.add(str.toString());
				preindex = i;
				len = 0;
			}
			len += words[i].length();
		}
		str = new StringBuffer();
		for (int i = preindex; i < words.length; i++) {
			str.append(words[i]);
			if (str.length() < L)
				str.append(" ");
		}
		for (int i = str.length(); i < L; i++) {
			str.append(" ");
		}
		list.add(str.toString());
		return list;
	}

}
