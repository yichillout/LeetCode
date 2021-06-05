package com.jasper.design;

import java.util.*;

class Logger {

	Map<String, Integer> map;

	public Logger() {
		map = new HashMap<String, Integer>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		if (map.containsKey(message)) {
			if (map.get(message) > timestamp) {
				return false;
			}
			map.put(message, timestamp + 10);
		} else {
			map.put(message, timestamp + 10);
		}
		return true;
	}
}

public class LC0359_LoggerRateLimiter {

}
