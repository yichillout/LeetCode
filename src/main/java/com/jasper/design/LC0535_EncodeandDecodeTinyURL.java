package com.jasper.design;

import java.util.*;

public class LC0535_EncodeandDecodeTinyURL {

	public static void main(String[] str) {
		TinyUrl2 tu1 = new TinyUrl2();

		String url1 = "https://leetcode.com/problems/design-tinyurl";
		String url2 = "https://leetcode.com/problems/island-perimeter/";

		String url1short = tu1.encode(url1);
		String url2short = tu1.encode(url2);

		System.out.println(url1 + " -> " + url1short);
		System.out.println(url2 + " -> " + url2short);

		System.out.println(tu1.decode(url1short));
		System.out.println(tu1.decode(url2short));

	}
}

class TinyUrl1 {

	private Map<String, String> long2Short;
	private Map<String, String> short2Long;

	public TinyUrl1() {
		long2Short = new HashMap<>();
		short2Long = new HashMap<>();
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (long2Short.containsKey(longUrl)) {
			return long2Short.get(longUrl);
		}

		while (true) {
			String shortURL = generateShortURL();
			if (!short2Long.containsKey(shortURL)) {
				short2Long.put(shortURL, longUrl);
				long2Short.put(longUrl, shortURL);
				return shortURL;
			}
		}
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return short2Long.get(shortUrl);
	}

	private String generateShortURL() {
		String allowedChars = "0123456789" + "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Random rand = new Random();
		String shortURL = "http://tiny.url/";
		for (int i = 0; i < 6; i++) {
			int index = rand.nextInt(62);
			shortURL = shortURL + allowedChars.charAt(index);
		}
		return shortURL;
	}
}

class TinyUrl2 {

	public static int GLOBAL_ID = 0;

	private Map<Integer, String> id2url = new HashMap<>();
	private Map<String, Integer> url2id = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (url2id.containsKey(longUrl)) {
			return "http://tiny.url/" + idToShortKey(url2id.get(longUrl));
		}
		GLOBAL_ID++;
		url2id.put(longUrl, GLOBAL_ID);
		id2url.put(GLOBAL_ID, longUrl);
		return "http://tiny.url/" + idToShortKey(GLOBAL_ID);
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		String short_key = getShortKey(shortUrl);
		int id = shortKeytoID(short_key);
		return id2url.get(id);
	}

	private String idToShortKey(int id) {
		String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String short_url = "";

		while (id > 0) {
			short_url = chars.charAt(id % 62) + short_url;
			id = id / 62;
		}

		while (short_url.length() < 6) {
			short_url = "0" + short_url;
		}

		return short_url;
	}

	private int shortKeytoID(String short_key) {
		int id = 0;
		for (int i = 0; i < short_key.length(); i++) {
			id = id * 62 + toBase62(short_key.charAt(i));
		}
		return id;
	}

	private int toBase62(char c) {
		if (c >= '0' && c <= '9') {
			return c - '0';
		}
		if (c >= 'a' && c <= 'z') {
			return c - 'a' + 10;
		}
		return c - 'A' + 36;
	}

	private String getShortKey(String shortUrl) {
		return shortUrl.substring("http://tiny.url/".length());
	}

}
