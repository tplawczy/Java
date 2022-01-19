package podzial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Podzial {
	List<Operacja> kolejka = new ArrayList<Operacja>();

	void podzial(int n, int k) {
		Operacja pierwsza = new Operacja(n, k, new int[0]);
		kolejka.add(pierwsza);
		while (!kolejka.isEmpty()) {
			Operacja x = kolejka.remove(0);
			//System.out.println(
				//	"Przrtwarzamy operacje n=" + x.n + ",k=" + x.k + ", elementy = " + Arrays.toString(x.elementy));
			if (x.n == x.k) {
				wyswietlWynik(x.n,x.elementy);
				continue;
			}
				
			if (x.k == 0) {
				wyswietlWynik(x.elementy);
				continue;
			}
			Operacja lewy = new Operacja(x.n - 1, x.k, x.elementy);
			Operacja prawy = new Operacja(x.n - 1, x.k - 1, dopiszDoTablicy(x.elementy, x.n));
			kolejka.add(lewy);
			kolejka.add(prawy);
		}
	}

	private void wyswietlWynik(int n, int[] elementy) {
		// TODO Auto-generated method stub
		int[] nowszaTablica=new int[n+elementy.length];  
		for(int i=0;i<n;i++) {
			nowszaTablica[i]=i+1;
		}
		for(int i=n;i<nowszaTablica.length;i++) {
			nowszaTablica[i]=elementy[i-n];
		}
		wyswietlWynik(nowszaTablica);
	}

	private void wyswietlWynik(int[] elementy) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(elementy));
	}

	private int[] dopiszDoTablicy(int[] elementy, int n) {
		// TODO Auto-generated method stub
		int[] nowaTablica = new int[elementy.length + 1];
		for (int i = 0; i < elementy.length; i++) {
			nowaTablica[i+1] = elementy[i];
		}
		nowaTablica[0] = n;

		return nowaTablica;
	}

	public static void main(String[] args) {
		new Podzial().podzial(5,4);
	}
}

class Operacja {
	int n;
	int k;
	int[] elementy;

	public Operacja(int n, int k, int[] elementy) {
		this.n = n;
		this.k = k;
		this.elementy = elementy;
	}
}