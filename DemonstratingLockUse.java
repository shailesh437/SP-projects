import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class DemonstratingLockUse {
	static int count;
	static ReentrantLock lock = new ReentrantLock();

	public static void incrementWithoutLock() {
		count = count + 1;
	}

	public static void incrementWithLock() {
		lock.lock();
		try {
			count = count + 1;
		} finally {
			lock.unlock();
		}
	}
	public static void stop(ExecutorService executor) {
	    try {
	        executor.shutdown();
	        executor.awaitTermination(60, TimeUnit.SECONDS);
	    }
	    catch (InterruptedException e) {
	        System.err.println("termination interrupted");
	    }
	    finally {
	        if (!executor.isTerminated()) {
	            System.err.println("killing non-finished tasks");
	        }
	        executor.shutdownNow();
	    }
	}

	public static void main(String[] args) {
		ExecutorService executorsWithoutUsingLock = Executors.newFixedThreadPool(3);
		ExecutorService executorsUsingLock = Executors.newFixedThreadPool(3);
		IntStream.range(0, 10000)
				.forEach(x -> executorsWithoutUsingLock.submit(InterruptsHandling::incrementWithoutLock));
		stop(executorsWithoutUsingLock);
		System.out.println("Before using Locks the value of count = " + count);
		count=0;
		IntStream.range(0, 10000).forEach(x -> executorsUsingLock.submit(InterruptsHandling::incrementWithLock));
		stop(executorsUsingLock);
		System.out.println("After using Locks the value of count = " + count);
	}
}
