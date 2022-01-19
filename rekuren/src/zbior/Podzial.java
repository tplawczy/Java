
package zbior;

import java.util.Arrays;

public class Podzial {



	void C(Operacja z) {

		if (z.k == 0) {

			System.out.println(Arrays.toString(z.elementy));
		} else if (z.k == z.n) {
			// z = 1;

			for (int i = 0; i < z.k; i++) {
				z.elementy = dopiszDoTablicy(z.elementy, i + 1);
			};

			System.out.println(Arrays.toString(z.elementy));

		} else if (z.k > 0 && z.k < z.n) {

			C(new Operacja(z.n-1,z.k,z.elementy));
			z.elementy = dopiszDoTablicy(z.elementy, z.n);
			C(new Operacja(z.n - 1, z.k - 1, z.elementy));

		}

	}

	private int[] dopiszDoTablicy(int[] elementy, int n) {
		// TODO Auto-generated method stub
		int[] nowaTablica = new int[elementy.length + 1];
		for (int i = 0; i < elementy.length; i++) {
			nowaTablica[i + 1] = elementy[i];
		}
		nowaTablica[0] = n;

		return nowaTablica;
	}

	public static void main(String[] args) {
		int x = 147;
		int y = 58;
		int[] elementy = new int[0];

		(new Podzial()).C(new Operacja(x, y, elementy));
	
	}
}
