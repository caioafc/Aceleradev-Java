package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> listNumbers = new ArrayList<>();

		int num = 0;

		listNumbers.add(0);
		listNumbers.add(1);

		while (num <= 350) {
			num = (listNumbers.get(listNumbers.size() - 1)) + (listNumbers.get(listNumbers.size() - 2));
			listNumbers.add(num);
		}

		return listNumbers;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}