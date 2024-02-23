import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出不大于N 的最大质数
 */
class Question2 {
	public static int maxPrimeNum(int n) {
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		if (n == 1 || n == 2)
			return n;
		for (int i = 3; i < n; i++) {
			boolean isPrime = false;
			// 如果一个数是素数，小于根号 N的所有素数都不能被整除
			double maxOffset = Math.sqrt(i);
			for (int prime : primes) {
				if (prime > maxOffset)
					break;
				if (i % prime == 0) {
					isPrime = false;
					break;
				} else {
					isPrime = true;
				}

			}
			if (isPrime) {
				primes.add(i);
			}
		}

		return primes.get(primes.size() - 1);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 77, 7, 5, 90, 100, 500, 1000, 10000, 100000, 1000000, 16549543, };
		int maxPrime = maxPrimeNum(101);
		assertEquals(97, maxPrime);

		for (int num : nums) {
			long timeStart = System.currentTimeMillis();
			System.out.print(maxPrimeNum(num) + "\t\t");
			long timeEnd = System.currentTimeMillis();
			long timeGap = timeEnd - timeStart;
			System.out.println(timeGap);
		}

	}
}