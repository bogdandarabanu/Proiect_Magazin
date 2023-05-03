package seminarOOP;

import java.util.ArrayList;

//relatie de asociere intre clasa magazin si clasa tricou
public class Magazin {

	private String name;
	private ArrayList<Tricou> tricouri = new ArrayList<>();

	public Magazin(String name, ArrayList<Tricou> tricouri) {
		// super();
		this.name = name;
		this.tricouri = tricouri;
	}

	@Override
	public String toString() {
		return "Magazin [name=" + name + ", tricouri=" + tricouri + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Tricou> getTricouri() {
		return tricouri;
	}

	public void setTricouri(ArrayList<Tricou> tricouri) {
		this.tricouri = tricouri;
	}

	// metoda de adaugare
	// definesc ce tricou imi propun sa adaug
	// il caut in lista de tricouri din stoc
	// daca nu il gasesc atunci il adaug la final de lista, iar daca il gasesc
	// atunci ii updatez nr de buc corespunzator

	public void addTricou(Tricou adding) {
		boolean ok = false;
		int pozitie = 0;
		for (int i = 0; i < tricouri.size(); i++)
			if (tricouri.get(i).equalsTricou(adding) == true) {
				ok = true;
				pozitie = i;
				break;
			}
		if (ok == false) {
			System.out.println("Nu se gaseste in stoc.");
			tricouri.add(adding);
		}
		if (ok == true) {
			System.out.println("Se gaseste tricoul in stoc.");
			// tricouri.set(i, adding.getNrBucati()) new Tricou(....., valueUpdated)
			int valueUpdated = tricouri.get(pozitie).getNrBucati() + adding.getNrBucati();
			tricouri.get(pozitie).setNrBucati(valueUpdated);
		}
	}

	public void removeTricou(Tricou removing) {
		boolean ok = false;
		int pozitie = 0;
		for (int i = 0; i < tricouri.size(); i++)
			if (tricouri.get(i).equalsTricou(removing) == true) {
				ok = true;
				pozitie = i;
				break;
			}

		if (ok = false)
			System.out.println("Tricoul nu se gaseste in stock.");
		if (ok = true) {
			System.out.println("Tricoul exista in stock.");
			if (removing.getNrBucati() <= tricouri.get(pozitie).getNrBucati()) {
				int valueUpdate = tricouri.get(pozitie).getNrBucati() - removing.getNrBucati();
				tricouri.get(pozitie).setNrBucati(valueUpdate);
				System.out.println(
						"Stergere efectuata cu succes. Numarul de bucati este: " + tricouri.get(pozitie).getNrBucati());
				if (tricouri.get(pozitie).getNrBucati() == 0)
					System.out.println("Stockul a ajuns la 0.");
			} else
				System.out.println("Nu se poate efectua stergerea deoarece stockul este de "
						+ tricouri.get(pozitie).getNrBucati() + " bucati.");
		}
	}
}

//metoda de stergere --
//definesc ce tricou vreau sa sterg --
//il caut in lista -- 
//daca se afla in lista atunci nrBucati >= cate vreau sa sterg , atunci este
//posibila stergerea --
//daca nu se afla atunci afisez mesaj /valoare corespunzatoare -- 
//daca se afla, updatez nr de buc corespunz plus verific daca am ajuns la
//zero(caz particular)
