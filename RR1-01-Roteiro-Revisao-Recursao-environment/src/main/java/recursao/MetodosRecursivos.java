package recursao;

public class MetodosRecursivos {

	
	public int somatorio(int[] array, int i) {
		if(i == array.length-1) {
			return array[i];
		}else {
			return array[i] + somatorio(array, i+1);	
		}
		}
	
	public int calcularSomaArray(int[] array){
		return somatorio(array, 0);
	}
	
	
	public long calcularFatorial(int n) {
		long result = 1;
		
		if(n == 0) {
			return 1;
		}
		result = n * (calcularFatorial(n-1));
		System.out.println(n + "!: " + result );
		return result;
	}

	public int calcularFibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		else {
			return calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}
		
	}
	
	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNull(array, 0);
		return result;
	}

	private int countNotNull(Object[] array, int indexFrom) {
		int result = 0;
		
		if (array[indexFrom] != null) {
			result++;
		}
		
		if (indexFrom != array.length - 1) { 
			result = result + countNotNull(array, indexFrom+1);
		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		if(expoente == 0) {
			return 1;
		}
		else {
			return(2 * potenciaDe2(expoente-1));
		}
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {

		} else {
			result = progressaoAritmetica(termoInicial, razao, n - 1) + razao;
		}
		return result;
	}
	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {

		} else {
			result = progressaoAritmetica(termoInicial, razao, n - 1) * razao;
		}
		return result;
	}
	
}


