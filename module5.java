/**
 * Implement the Fibonacci function in both a recursive and iterative fashion. What’s the runtime efficiency of each? 
 */


public class module5 {
	
	public static void main(String[] args) throws InterruptedException {
		// Setting classes
		fibonacciRecursion recursion = new fibonacciRecursion();
		fibonacciDynamic dynamic = new fibonacciDynamic();

		// Start Threads
		recursion.start();
		dynamic.start();
	}
}

class fibonacciRecursion extends Thread {
	// Set to desired position in sequence
	int n = 10;

	public void run() {
		// Get times and run sequence method
		while (n <= 40) {
			long time1 = System.nanoTime();
			int answer = fibonacci(n);
			long time2 = System.nanoTime();
			// Print answer + time thread took to find it
			System.out.println("Recursion Thread found the answer: " + answer + " in " + (time2 - time1) + "ns");
			n = n + 10;
		}
	}

	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}

class fibonacciDynamic extends Thread {
	// Set to desired position in sequence
	int n = 10;

	public void run() {
		while (n <= 40) {
			// Get time and set variables
			long time1 = System.nanoTime();
			int v1 = 0, v2 = 1, v3 = 0;

			System.out.print("Dynamic Thread found the answer: ");
			// Dynamic Fibonacci sequence
			for (int i = 2; i <= n; i++) {
				v3 = v1 + v2;
				v1 = v2;
				v2 = v3;
			}
			long time2 = System.nanoTime();
			// Print answer + time thread took to find it
			System.out.println(v3 + " in " + (time2 - time1) + "ns");
			n = n + 10;
		}
	}
}