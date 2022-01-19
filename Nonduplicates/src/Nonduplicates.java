import java.util.HashSet;
import java.util.LinkedList;

public class Nonduplicates {

	static String s = "abacabad";
static int s1 =15;
	char firstNotRepeatingCharacter(String s) {

		boolean[] isduplicate = new boolean[s.length()];
		for (int i = 0; i < isduplicate.length; i++) {
			isduplicate[i] = false;
		}

		char end = '_';
		LinkedList<Character> nonduplicates = new LinkedList<Character>();
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {

			set.add(s.charAt(i));
			
		}
		//r (int i = 0; i < isduplicate.length; i++) {
		//f()
		//
		for (	int i = 0; i < isduplicate.length; i++) {
			if (isduplicate[i] == true)
				nonduplicates.add(s.charAt(i));
			
		}
		if (nonduplicates.isEmpty())
			return end;
		else
			return nonduplicates.getFirst();

	}

	public static void main(String[] args) {
		s1=s1/2;
		Nonduplicates non = new Nonduplicates();
		non.firstNotRepeatingCharacter(s);
		System.out.println(non.firstNotRepeatingCharacter(s));
		System.out.println(s1);
	}
}
