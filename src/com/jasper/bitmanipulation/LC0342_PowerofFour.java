package com.jasper.bitmanipulation;

public class LC0342_PowerofFour {

	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}

}
