import java.util.*;


//Matheus Simoões Dias Santos, SO-T01

public class HelloWorld {
	public HelloWorld(ArrayList<Integer> list, int count) throws InterruptedException {
		MinhaThreadRunnable threadA = new MinhaThreadRunnable("Thread " + count + 1 , this, list);
		Thread a = new Thread(threadA);
		a.start();
		
		System.out.println("FIM Trhead");
	}
	public static void main(String[] args) throws InterruptedException {
		Boolean test = true;
		int count = 0;
		
		
		ArrayList<ArrayList<Integer>> matriz = new ArrayList<ArrayList<Integer>>();

		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.lineSeparator());
		/*1ª questão do exercício*/
		do {
			ArrayList<Integer> vetor = new ArrayList<Integer>();
			System.out.println("Digite alguns numeros para o vetor. Digite qualquer coisa alem de numeros para sair deste vetor");
			while (scanner.hasNext()) {
				if(scanner.hasNextInt()) {
					int i = scanner.nextInt();
			    	vetor.add(i);
				}
				else break;
		    }
			
			if(!vetor.isEmpty())
				matriz.add(vetor);
			
			new HelloWorld(vetor, count);
			count++;
			
			System.out.println("Se quiser sair digite 'sair', senão, digite qualquer outra coisa para começar a inserir outro vetor");
			
			scanner.next();
			
			String a = scanner.next();
			test = !(a.equals("sair"));
			System.out.println(a);
			
		} while(test);
		
		/*Fim primeira questao*/
		
		scanner.close();
		
		System.out.println(matriz);
		
		
		
	}
}
