package com.zuehlke.testing.testdata;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

	public static List<Integer> factorsOf(int number) {
		int n = number;
		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		return factors;
	}

	public static boolean isPrime(int number) {
		List<Integer> factors = factorsOf(number);
		return factors.size() == 1;
	}
}
