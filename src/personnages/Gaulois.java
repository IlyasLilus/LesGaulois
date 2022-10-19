package personnages;

import objets.Equipement;
import territoires.Musee;

public class Gaulois {
	
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement [] trophees;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.trophees = new Equipement[100];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
		
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de "
//				+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci druide, je sens que ma force est " + effetPotion + " fois decuplee");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++) {
		this.trophees[nbTrophees] = trophee[i];
		}
		return;
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees>0) {
			parler("Je donne au musée tous mes trophées:");
			for (int i=0; i < nbTrophees; i++) {
				System.out.println("-"+trophees[i]);
				musee.donnerTrophees(this, trophees[i]);
			}
		}else {
			System.out.println("Aucun trophée !");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("BEGIN");
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Je parle");
		Romain cesar = new Romain("Cesar", 12);
		Romain marius = new Romain("Marius", 5);
		asterix.frapper(cesar);
		asterix.frapper(marius);
		asterix.boirePotion(3);
		System.out.println("END");
	}
}

