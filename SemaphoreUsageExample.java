
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * This program demonstrates the scenario where we have multiple threads but the task division/completion needs to be 
 * synchronous i.e if tasks is divided into 10 parts; all threads should first finish part1 and then jump to part 2 and so on
 * So we will make use of CommonHaultPoint which will act as Barrier
 * */

public class SemaphoreUsageExample {

	public static void main(String[] args) {
		int numberOfThreads = 20; // NO_OF_THREADS
		Thread[] threadArray = new Thread[numberOfThreads];

		CommonHaultPoint commonHaultPoint = new CommonHaultPoint(numberOfThreads);
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(new CommunicatingWorkRunner(commonHaultPoint));
		}

		Arrays.asList(threadArray).stream().forEach(x -> x.start());
	}

	public static class CommonHaultPoint {
		private final int totalWT;
		private Semaphore semaphore = new Semaphore(0);
		private int counter = 0;
		private Lock lock = new ReentrantLock();
		public CommonHaultPoint(int totalWT) {
			this.totalWT = totalWT;
		}
		public void haultPoint() {
			lock.lock();
			boolean isLastWT = false;
			try {
				counter++;
				if (counter == totalWT - 1) {
					isLastWT = true;
				}
			} finally {
				lock.unlock();
			}

			if (isLastWT) {
				semaphore.release(totalWT-1);
			} else {
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public static class CommunicatingWorkRunner implements Runnable {
		private CommonHaultPoint commonHaultPoint;
		public CommunicatingWorkRunner(CommonHaultPoint commonHaultPoint) {
			this.commonHaultPoint = commonHaultPoint;
		}
		@Override
		public void run() {
			try {
				task();
			} catch (InterruptedException e) {
			}
		}
		private void task() throws InterruptedException {
			System.out.println(Thread.currentThread().getName() + " Initial part  of the task done");
			commonHaultPoint.haultPoint();
			System.out.println(Thread.currentThread().getName() + " Reamining part  of the Task started");
		}
	}
}
