package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert(force>0):"force négative";
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "ï¿½ " + texte + "ï¿½");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(force>0):"force négative";
		int force_avant=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aï¿½e");
		} 
		else {
			parler("J'abandonne...");
		}
		assert(force_avant>force):"force n'a pas diminué";
	}
	
	public static void main(String[] args) {
		Romain cesar = new Romain("Cesar", 20);
		System.out.println(cesar.getForce());
		System.out.println(cesar.prendreParole());
		cesar.parler("Bonjour");
		cesar.recevoirCoup(10);
		cesar.recevoirCoup(10);
		System.out.println(cesar.getForce());
	}

	
}

