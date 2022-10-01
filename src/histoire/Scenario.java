package histoire;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		personnages.Gaulois asterix = new personnages.Gaulois("Asterix", 8);
		personnages.Romain minus = new personnages.Romain("Minus", 6);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		System.out.println(minus.getNom());
		System.out.println(minus);
		System.out.println(minus.prendreParole());
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		minus.parler("Aïe");
		asterix.frapper(minus);
		minus.parler("Aïe");
		asterix.frapper(minus);
		minus.parler("J'abandonne...");
		
	
}
