package seminarOOP;

import java.util.ArrayList;
import java.util.Collections;

public class TestMagazin {

	public static boolean NrPrim(int nr) // metoda nrprim
	{
		if (nr < 2)
			return false;

		for (int d = 2; d * d <= nr; d++) {
			if (nr % d == 0)
				return false;
		}
		return true;

	}

	public static void customSort(ArrayList<Tricou> arr) {

		// complexitate patratica ( sunt doua for implicate)
		// complexitate liniara( un singur for)

		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(i).getNrBucati() > arr.get(j).getNrBucati()) {
					Tricou aux;
					aux = arr.get(i);
					// arr.get(i) = arr.get(j);
					arr.set(i, arr.get(j));
					// arr.get(i) = aux;
					arr.set(j, aux);
				}
			}
		}

	}

	public static void main(String[] args) {

		// Tricou obj=new Tricou"123","tricouCeva", "mov", "XL",23;

		ArrayList<Tricou> shop = new ArrayList<Tricou>(); // variatii de constructii
		shop.add(new Tricou("123", "tricouCeva", "mov", "XL", 22));
		shop.add(new Tricou("13", "tricouC", "verde", "L", 24));
		shop.add(new Tricou("143", "tricouCeva", "rosu", "XL", 23));
		shop.add(new Tricou("132", "tricouCeva", "blue", "L", 232));
		shop.add(new Tricou("17", "tricouCeva", "red", "S", 2903));

		Magazin ceva = new Magazin("ShopAdalia", shop);

		//Tricou deAdaugat = new Tricou("123", "tricouCeva", "mov", "XL", 10);

		//ceva.addTricou(deAdaugat);
		
		Tricou deSters = new Tricou("123", "tricouCeva", "mov", "XL", 7);
		ceva.removeTricou(deSters);

		System.out.println(ceva);

		for (int i = 0; i < shop.size(); i++)
			System.out.println(shop.get(i));

		System.out.println(" ");

		// customSort(shop);

		Collections.sort(shop, new ComparatorTricouNrBucati());

		System.out.println("Sortarea dupa nr de bucati este: ");
		for (int i = 0; i < shop.size(); i++)
			System.out.println(shop.get(i));

	}

}