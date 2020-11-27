import java.util.*;

public class MinhaThreadRunnable implements Runnable {
	private String nome;
	private HelloWorld principal;
	private Date date;

	public MinhaThreadRunnable(String nome, HelloWorld principal) {
		this.nome = nome;
		this.principal = principal;
		this.date = null;		
	}

	@Override
	public void run() {

		for(int i=0; i<10; i++) {
			if(i==9)
			System.out.println("Olá, sou a " + this.nome);
			
		}
		
		this.date = java.util.Calendar.getInstance().getTime();
		
		try {
			synchronized (this.principal) {
				this.principal.notify();
			}
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Date getDate() {
		return this.date;
	}
	
}
