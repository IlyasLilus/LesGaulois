package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement =0;
	private Equipement[] equipements;
	
	
	public Romain(String nom, int force) {
		assert(force>0):"force n�gative";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert(force>0):"force n�gative";
//		int force_avant=force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} 
//		else {
//			parler("J'abandonne...");
//		}
//		assert(force_avant>force):"force n'a pas diminu�";
//	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
				case 2: {
					System.out.println("Le soldat " + nom + " est deja bien protégé !");
					break;
				}
				case 1: {
					if (equipements[0] == equipement) {
						System.out.println("Le soldat " + nom + " possede déjà un " + 
								equipement + ".");
						break;
					} else {
						equipement(equipement);
						break;
					}
				}
				default : {
					equipement(equipement);
					break;
				}
			}
		}
		
	private void equipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'equipe d'un " + 
				equipement + ".");
		}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculresistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if(force == 0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force � diminuer
		assert force < oldForce;
		return equipementEjecte;
	}
	
	
	private int calculresistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + 
				", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup <= 0) {
			return 0;
		}
		return forceCoup;
		}
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'�quipement de " + nom + 
				"s'envole sous la force du coup.");
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] = equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				} 
			}
			return equipementEjecte;
		}

		
	
	public static void main(String[] args) {
		Romain cesar = new Romain("Cesar", 20);
		System.out.println(cesar.getForce());
		System.out.println(cesar.prendreParole());
		cesar.parler("Bonjour");
		cesar.recevoirCoup(10);
		cesar.recevoirCoup(10);
		System.out.println(cesar.getForce());
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.BOUCLIER);
		cesar.sEquiper(Equipement.CASQUE);
	}
	
}

