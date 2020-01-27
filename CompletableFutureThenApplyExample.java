import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
 * thenApply() method is used when you want to process the output of
 * CompletableFuture when it arrives.
 * It takes a Function<T,R> as anargument ;i.e a Functional Interface
 * */
public class CompletableFutureThenApplyExample {
	public static void main(String[] args) {
		CompletableFuture<String> completableFutureRESULT_ONE = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException ie) {
			}
			return "RESULT_ONE";
		});
		CompletableFuture<String> completableFutureRESULT_TWO = completableFutureRESULT_ONE.thenApply(result_one -> {
			return "RESULT_TWO COMPUTED  USING " + result_one;
		});
		try {
			System.out.println(completableFutureRESULT_TWO.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
