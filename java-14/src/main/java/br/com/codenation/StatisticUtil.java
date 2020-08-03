package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) Arrays
						.stream(elements)
						.average()
						.getAsDouble();
	}

	public static int mode(int[] elements) {
		HashMap<Integer, Integer> elementsMatch = new HashMap<>();

		for (int element : elements) {
			int count = elementsMatch.getOrDefault(element, 0);

			elementsMatch.put(element, count +1);
		}

		return elementsMatch
				.entrySet()
				.stream().max(HashMap.Entry.comparingByValue())
					.get()
					.getKey();
	}

	public static int median(int[] elements) {
		return (int) Arrays
						.stream(elements)
						.sorted()
						.skip((elements.length -1) / 2)
						.limit(2 - elements.length % 2)
						.average()
						.getAsDouble();
	}
}