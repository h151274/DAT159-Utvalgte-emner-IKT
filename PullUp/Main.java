package PullUp;

public class Main {

	public static void printResults(SuperDuper a, Super b) {
		System.out.println("Called from SuperDuper class: " + a.function() + "\n" + "Called from Super class: "
				+ b.function() + "\n" + "get from SuperDuper: " + b.test());
	}

	public static void main(String[] args) {
		SuperDuper A = new SuperDuper();
		Super B = new Super();
		printResults(A, B);
	}
}
