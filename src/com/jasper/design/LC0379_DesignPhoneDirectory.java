package com.jasper.design;

class PhoneDirectory {

	boolean[] isUsed;

	public PhoneDirectory(int maxNumbers) {
		isUsed = new boolean[maxNumbers];
	}

	public int get() {
		int temp = -1;
		for (int i = 0; i < isUsed.length; i++) {
			if (!isUsed[i]) {
				temp = i;
				isUsed[i] = true;
				break;
			}
		}
		return temp;
	}

	public boolean check(int number) {
		return !isUsed[number];
	}

	public void release(int number) {
		isUsed[number] = false;
	}
}

public class LC0379_DesignPhoneDirectory {

	public static void main(String[] args) {
		// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
		PhoneDirectory directory = new PhoneDirectory(3);

		// Assume it returns 0.
		System.out.println(directory.get());

		// Assume it returns 1.
		System.out.println(directory.get());

		// The number 2 is available, so return true.
		System.out.println(directory.check(2));

		// It returns 2, the only number that is left.
		System.out.println(directory.get());

		// The number 2 is no longer available, so return false.
		System.out.println(directory.check(2));

		// Release number 2 back to the pool.
		directory.release(2);

		// Number 2 is available again, return true.
		System.out.println(directory.check(2));

	}

}
