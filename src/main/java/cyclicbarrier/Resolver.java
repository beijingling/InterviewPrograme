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
				// TODO Auto-generated method stub
				System.out.println("cyclicBarrier task ");
			}
		};
		barrier = new CyclicBarrier(N, run);
		for (int i = 0; i < N; i++) {
			Thread td = new Thread(new Worker(i, data));
			td.start();
			ths.add(td);
		}
		long time = System.currentTimeMillis();
		for (Thread t : ths) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long during = System.currentTimeMillis() - time;
		System.out.println("mutile thread take time :" + during);
	}

	class Worker implements Runnable {
		final int myRow;
		final float[][] data;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i = data[myRow].length;
			int j = 0;

//			System.out.println("i:" + i);
			while (j < i) {
				data[myRow][j] = ThreadLocalRandom.current().nextFloat();
				j++;
//				System.out.println("j:" + j);
			}
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Worker(int row, float[][] matrix) {
			myRow = row;
			data = matrix;
		}
	}
}
