/**
 * 
 */
package bibliotheque;

import java.util.ArrayList;
import java.util.List;

import sauvegarde.SauvegarderLivre;
import sauvegarde.SauvegarderPersonne;
import nature.Livre;
import nature.Personne;

/**
 * @author salioubah
 * 
 * classe permettant de creer une bibliotheque
 *
 */
public class Bibliotheque {
	protected List<Personne> personne;
	protected List<Livre> livre;
	
	protected SauvegarderPersonne sauvePersonne;
	protected SauvegarderLivre sauveLivre;
	
	
	// constructeur par defaut
	public Bibliotheque (){
		sauvePersonne = new SauvegarderPersonne();
		personne = new ArrayList<Personne>();
		
		sauveLivre = new SauvegarderLivre();
		livre = new ArrayList<Livre>();
		
		creerBibliotheque();
		
	}
	

	/**
	 * 
	 */
	private void creerBibliotheque() {
		personne = sauvePersonne.getLesPersonnes();
		
	}


	/**
	 * @return the personne
	 */
	public List<Personne> getPersonne() {
		return personne;
	}

	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}


	/**
	 * @return the livre
	 */
	public List<Livre> getLivre() {
		return livre;
	}


	/**
	 * @param livre the livre to set
	 */
	public void setLivre(List<Livre> livre) {
		this.livre = livre;
	}
	
	
	

}
