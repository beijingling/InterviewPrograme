package cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Resolver {

	final int N;
	final float[][] data;
	final CyclicBarrier barrier;
	List<Thread> ths = new ArrayList<Thread>();

	public Resolver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		Runnable run = new Runnable() {

			@Override
			public void run() {
				System.out.println("cyclicBarrier task ");
				// 这里主要是做一些总工作任务，比如合并每个循环中所有线程产生的零时数据
				// 此任务是在哪个线程中完成的呢？ -=== 最后一个到达屏障的线程
			}
		};
		barrier = new CyclicBarrier(N, run);
		for (int i = 0; i < N; i++) {
			Thread td = new Thread(new Worker(i, data));
			td.start();
			ths.add(td);
			// 不能在这里进行 td.join();因为此时join表示主线程需要等待新线程完成再进行，而新新城td此时正在await,
			// 导致主线程无法执行后面的代码
		}
		long time = System.currentTimeMillis();
		int index = 0;
		for (Thread t : ths) {
			System.out.println("sub thread index:" + index++);
			try {
				t.join(0);// 注意此时执行此代码的线程为主线程
				// 使当前线程进入等待队列
				// 等待的对象是 t 对象的 monitor
				// 使主线程在每个子线程中进行等待。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}// 如果不执行join 等待子线程，那么主线程可能先于子线程退出
		long during = System.currentTimeMillis() - time;
		System.out.println("mutile thread take time :" + during);
	}

	class Worker implements Runnable {
		final int myRow;
		final float[][] data;

		@Override
		public void run() {
			int i = data[myRow].length;
			int j = 0;

//			System.out.println("i:" + i);
			while (j < i) {
				data[myRow][j] = ThreadLocalRandom.current().nextFloat();
				j++;
//				System.out.println("j:" + j);
				// 如果是在这里进行同步等待 barrier.await();
				// 那么线程屏障非常多。
			}
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

		public Worker(int row, float[][] matrix) {
			myRow = row;
			data = matrix;
		}
	}
}
