
public class ShutDownHookExample {
public static void main(String[] args) {
	Runtime.getRuntime().addShutdownHook(new Thread(){
		public void run() {
			System.out.println("Shutdown  hook called !!");
		}
	});
	System.out.println("Main thread coming to end ..so application getting end");
}
}
