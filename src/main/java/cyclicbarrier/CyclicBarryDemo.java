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
				// ThreadLocalRandom 生成真随机数的原理是获取当前对象的地址，传入random对象中作为种子seed
				// 这样每个线程调用时都是不同的对象地址，从而参数真随机数
			}
		}
		long during = System.currentTimeMillis() - time;
		System.out.println("single thread during :" + during);
		// 通过2种方式的对比，基本事实：多线程的速度比单线程的速度快。
		// 循环屏障的次数越多，完成整个任务的时间越长
	}
}
