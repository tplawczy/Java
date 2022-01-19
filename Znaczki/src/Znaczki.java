import java.util.Arrays;
import java.lang.Math;

public class Znaczki {
	void znaczki() {

		int n = 2;
		int m = 7;
		int[] rodzajZnaczka = new int[n];
		rodzajZnaczka[0] = 2;
		rodzajZnaczka[1] = 3;
		//rodzajZnaczka[2] = 5;
		
        int licznik;
		int oplata1 = rodzajZnaczka[n - 1] * m;

		for (int i = (oplata1); i > 0; i--) {
			//System.out.println(i);
			int oplata;
			oplata = i;
			licznik=i;
			int iloscZnaczkow = 0;

			while (oplata > 0) {
				int z = 0;

				for (int j = 0; j < n; ++j) {
					if ((rodzajZnaczka[j] <= oplata) && (rodzajZnaczka[j] > z)) {
						z = rodzajZnaczka[j];
					
					}
					else{z=rodzajZnaczka[0];}
				}
				oplata -= z;
				++iloscZnaczkow;
				if (oplata == 0 && iloscZnaczkow <= m) {

					// System.out.println(iloscZnaczkow);
					System.out.println(licznik);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Znaczki().znaczki();
	}
}
