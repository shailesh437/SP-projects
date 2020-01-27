import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExampleRunAsync {
	public static void main(String[] args) throws InterruptedException {

		CompletableFuture<Void> futureVoid = CompletableFuture.runAsync(() -> {
			try {
				FileWriter fw = new FileWriter("JavaWrittenFile.txt");
				for (int i = 0; i < 10000000; i++)
					fw.write("\n This File is written using java program::" + i);
				fw.write("\n Above lined added by the thread::" + Thread.currentThread().getName());
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});
		Thread.currentThread().sleep(2000);
		System.out.println("I'm main Thread::" + Thread.currentThread().getName());
		try {
			futureVoid.get();
		} catch (ExecutionException e3) {
			e3.printStackTrace();
		}
	}
}
