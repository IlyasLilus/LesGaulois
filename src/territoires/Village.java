package territoires;

public class Village {
	private String nom;
	
	
	public Village(String nom) {
		this.nom = nom;
		
	}

	public String getNom() {
		return nom;
	}

	
	public static void main(String args[]) {
		Village manasia = new Village("Manasia");
		System.out.println(manasia.getNom());
	}
}