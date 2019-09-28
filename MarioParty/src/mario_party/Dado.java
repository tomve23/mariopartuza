package mario_party;

public class Dado {
	
	public static int tiroDeDado() {
		return (int) (Math.random() * 7 + 1);
	}
	
	public static void main(String[] args) {
		System.out.println(tiroDeDado());
	}
	
}
