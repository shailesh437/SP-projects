package thread;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {
	List<Runnable> memberTasks;
	List<Thread> memberThreads;

    public MultiExecutor(List<Runnable> tasks) {
    	memberTasks= new ArrayList<>();
    	memberTasks.addAll(tasks);    	
    }

    public void executeAll() {
    	memberThreads=new ArrayList<Thread>();
    	for(Runnable r: memberTasks)
    		memberThreads.add(new Thread(r));
    	memberThreads.stream().forEach(Thread::start);
    }
    
    public static void main(String[] args) {
    	List<Runnable> tasksMain = new ArrayList<Runnable>();
    	tasksMain.add(()->{System.out.println("m thread 1"+Thread.currentThread().getName());});
    	tasksMain.add(()->{System.out.println("m thread 2"+Thread.currentThread().getName());});
    	tasksMain.add(()->{System.out.println("m thread 3"+Thread.currentThread().getName());});
    	MultiExecutor me = new MultiExecutor(tasksMain);
    	me.executeAll();
	}
}