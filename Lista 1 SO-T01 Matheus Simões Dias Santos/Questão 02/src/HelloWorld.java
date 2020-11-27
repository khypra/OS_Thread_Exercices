import java.util.*;


//Matheus Simoões Dias Santos, SO-T01
// Segunda questão do exercício

public class HelloWorld {
	
	private ArrayList<Date> list_data = new ArrayList<Date>() ;
	
	public HelloWorld() throws InterruptedException {
		
		
		
			MinhaThreadRunnable threadA = new MinhaThreadRunnable("Thread 0", this);
			Thread a = new Thread(threadA);
			a.start();
		
			MinhaThreadRunnable threadB = new MinhaThreadRunnable("Thread 1", this);
			Thread b = new Thread(threadB);
			b.start();
			
			MinhaThreadRunnable threadC = new MinhaThreadRunnable("Thread 2", this);
			Thread c = new Thread(threadC);
			c.start();
			
			MinhaThreadRunnable threadD = new MinhaThreadRunnable("Thread 3", this);
			Thread d = new Thread(threadD);
			d.start();
			
			MinhaThreadRunnable threadE = new MinhaThreadRunnable("Thread 4", this);
			Thread e = new Thread(threadE);
			e.start();
			
			
//			for(int i=0; i<5; i++) {
//				synchronized (this) {
//					this.wait();
//				}
//				System.out.println("acabou uma");
//			}
			
			e.join();
			
			this.list_data.add(threadA.getDate());
			this.list_data.add(threadB.getDate());
			this.list_data.add(threadC.getDate());
			this.list_data.add(threadD.getDate());
			this.list_data.add(threadE.getDate());
			
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		HelloWorld instance = new HelloWorld();
		
		Date comparar = new Date();
		int contador = 0;
		
		for(int i = 0 ; i< instance.list_data.size(); i++ ) {
			System.out.println("A thread " + i + " foi completa as : ");
			System.out.println(instance.list_data.get(i));
			if(i==0) {
				comparar = instance.list_data.get(i);
				contador = i;
			} else if(comparar.after(instance.list_data.get(i))) {
				comparar = instance.list_data.get(i);
				contador = i;
			}
		}
		
		Collections.sort(instance.list_data);
		
		System.out.println("a thread mais rapida foi a : " + contador + " e terminou as " + instance.list_data.get(contador));
		
		
		
	}
}
