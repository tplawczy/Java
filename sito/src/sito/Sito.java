package sito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sito {

	public static void main(String[] args) {
		int N = 20;

		int[] liczba = new int[N];
		for (int i = 2; i < N; i++) {
			liczba[i] = -1;
		}
		liczba[0] = 1;
		liczba[1] = 2;

		for (int n = 3; n <= liczba.length; n++) {

			int C[] = new int[10000];
			int D[] = new int[10000];
			Sitko x = new Sitko(C, D, liczba);

			ArrayList<Integer> t = new ArrayList<Integer>();
			for (int i : x.liczba) {
				t.add(i);
			}
			int rozmiar = Collections.frequency(t, 0);
			int[] A = new int[N - rozmiar];
			for (int i = 0; i < liczba.length; i++) {

				int f = i;
				if (x.liczba[i] != 0) {
					A[f] = x.liczba[i];
				} else {

					f = f - 1;
				}
			}

			boolean[] B = new boolean[A.length];
			Podzbiory i = new Podzbiory();
			i.podzbiory(A, 2, 0, 0, B, x);

			int c = x.sprawdzaniesum(C, D, liczba, n);
			if (c != 0) {
				x.liczba[n - 1] = c;
			}
		}
	}

}

class Sitko {
	int C[];
	int D[];
	int h = 0;
	int j = 0;
	int[] liczba;

	public Sitko(int[] C, int[] D, int[] liczba) {
		this.C = C;
		this.D = D;
		this.liczba = liczba;
	}

	int sprawdzaniesum(int[] C, int[] D, int[] liczba, int n) {
		int Z[] = new int[C.length];
		for (int i = 0; i < C.length; i++) {

			Z[i] = C[i] + D[i];
			// List<Integer> list = Arrays.asList(Z[i]);
			// System.out.print(" " + Z[i]);
		}

		ArrayList<Integer> w = new ArrayList<Integer>();
		for (int i : Z) {
			w.add(i);
		}
		int wystapienia = Collections.frequency(w, n);
		if (wystapienia == 1) {

			System.out.print(n + " ");
			return n;
		}
		return 0;
	}
}

class Podzbiory {

	public void podzbiory(int[] A, int k, int start, int ilosc_el, boolean[] uzyte, Sitko x) {
		int g = -1;

		if (ilosc_el == k) {
			for (int i = 0; i < A.length; i++) {

				if (uzyte[i] == true) {

					if (g == -1) {

						x.C[x.h] = A[i];
						x.h++;
						g = g * (-1);
					} else {

						x.D[x.j] = A[i];
						x.j++;
						g = g * (-1);
					}
					// System.out.print(" " + A[i]);

				}

			}

			// System.out.println();
			return;
		}

		if (start == A.length) {
			return;

		}

		uzyte[start] = true;
		podzbiory(A, k, start + 1, ilosc_el + 1, uzyte, x);

		uzyte[start] = false;
		podzbiory(A, k, start + 1, ilosc_el, uzyte, x);
	}
}
