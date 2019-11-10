
public class Test {

	public static void main(String[] args) {
		String str = "algo";

		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			result = result ^ str.charAt(i);
		}
		System.out.println((char)result);

	}

}
