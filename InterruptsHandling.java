import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
In the below program, if we do not make use of condition
if (Thread.currentThread().isInterrupted()) ;
it won't be able to stop the thread until it gets completed.
Hence we should make use of this condition if we expect the running thread to 
react to the interruption

interrupted() :: returns the Interrupt status of the thread and sets it to False.So if called once, it would return true, 
if the thread was interrupted, and then it would clear the flag.
So if it gets called again it would keep returning true unless it's interrupted again in the interim.

interrupt() :: very clear about its job, it would set the interrupt status to True 

isinterrupted() :: just returns a boolean value and doesn't sets/resets the flag

*/
public class InterruptsHandling {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			for (int i = 0; i < 100000000; i++) {
				if (Thread.currentThread().isInterrupted()) {
					break;
				}
				System.out.print("AnyTextYouLike");
			}
		});
		try {
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException ie) {
			System.out.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("Cancel non completed tasks");
			}
			executor.shutdownNow();
		}

	}
}
