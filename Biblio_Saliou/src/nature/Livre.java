/**
 * 
 */
package nature;

import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;


/**
 * @author salioubah
 *classe presentant la stucture d un livre
 */
public class Livre implements Serializable {
	private static final long serialVersionUID = -4113434291601966473L;
    private String image;
	private String titre;
	private String auteur;
	private String resume;
	private Categorie categorie;
	private List<Theme> theme;
	private String nbrePage;
	private Boolean disponible=true;
	
	
	public Livre() {
        this.image = "";
        this.titre = "";
        this.auteur = "";
        this.resume = "";
        this.categorie = null;
        this.theme=null;
        this.nbrePage ="";
}
	
	/**
	 * @param image
	 * @param titre
	 * @param auteur
	 * @param resume
	 * @param categorie
	 * @param theme
	 * @param nbrePage
	 */
	public Livre(String image, String titre, String auteur, String resume,
			Categorie categorie, List<Theme> theme, String nbrePage) {
		super();
		this.image = image;
		this.titre = titre;
		this.auteur = auteur;
		this.resume = resume;
		this.categorie = categorie;
		this.theme = theme;
		this.nbrePage = nbrePage;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}
	/**
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	/**
	 * @return the theme
	 */
	public List<Theme> getTheme() {
		return theme;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(List<Theme> theme) {
		this.theme = theme;
	}
	/**
	 * @return the nbrePage
	 */
	public String getNbrePage() {
		return nbrePage;
	}
	/**
	 * @param nbrePage the nbrePage to set
	 */
	public void setNbrePage(String nbrePage) {
		this.nbrePage = nbrePage;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the disponible
	 */
	public Boolean getDisponible() {
		return disponible;
	}
	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public String themeToString(){
        String str="";
        ListIterator<Theme> i= theme.listIterator();
        while(i.hasNext())
                str+=i.next().toString()+", ";
        return str;
}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Livre [image=" + image + ", titre=" + titre + ", auteur="
				+ auteur + ", resume=" + resume + ", categorie=" + categorie
				+ ", theme=" + theme + ", nbrePage=" + nbrePage
				+ ", disponible=" + disponible + ", themeToString()="
				+ themeToString() + "]";
	}
	
	
	

}
