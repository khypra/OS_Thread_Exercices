import java.util.ArrayList;
import java.util.*;

public class MinhaThreadRunnable implements Runnable {
	private String nome;
	private HelloWorld principal;
	private ArrayList<Integer> list;

	public MinhaThreadRunnable(String nome, HelloWorld principal, ArrayList<Integer> list ) {
		this.nome = nome;
		this.principal = principal;
		this.list = list;
	}

	@Override
	public void run() {

		System.out.println("Olá, sou a " + this.nome);
		System.out.println("Vetor Antes da ordenação: ");
		System.out.println(this.list);
		
		Collections.sort(this.list);
		

		System.out.println("Vetor ordenado: ");
		System.out.println(this.list);
		
		try {
			synchronized (this.principal) {
				this.principal.notify();
			}
			
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		System.out.printf("FIM %s%n", this.nome);
	}
}
