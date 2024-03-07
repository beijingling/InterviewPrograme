package cyclicbarrier;

import java.util.concurrent.ThreadLocalRandom;

public class CyclicBarryDemo {

	public static void main(String[] args) {
		float[][] matrix = new float[1000][100000];
		Resolver resolver = new Resolver(matrix);
//		for (int i = 0; i < 10; i++) {
//			System.out.println();
//			for (int j = 0; j < 10; j++) {
//				System.out.print(matrix[i][j] + "\t");
//			}
//		}

		long time = System.currentTimeMillis();
		int h = matrix.length;
		int w = matrix[0].length;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				matrix[i][j] = ThreadLocalRandom.current().nextFloat();
			}
		}
		long during = System.currentTimeMillis() - time;
		System.out.println("single thread during :" + during);
	}
}
