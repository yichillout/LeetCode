package com.jasper.brainteaser;

public class LC0292_NimGame {

	public boolean canWinNim(int n) {
		int val = n % 4;
		if (val >= 1 && val <= 3)
			return true;
		return false;
	}

}
