/**
 * 
 */
package nature;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 * @author salioubah
 *
 */
public class Personne implements Serializable {
	
	private static final long serialVersionUID = -3415209097881553727L;
    private String image;
private String nom;
private String prenom;
private String[] adresse;
private String tel;
private Sexe sex;
private String age;
private List<Emprunt> emprunt=new ArrayList<Emprunt>();


    /**
     * 
     */
    public Personne() {
            this.image = "";
            this.nom = "";
            this.prenom = "";
            String[] c = {"a","b"};
			this.adresse = c;
            this.tel = "";
            this.sex = Sexe.MASCULIN;
            this.age="";
    }
    /**
     * @param image
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param sex
     */
    public Personne(String image, String nom, String prenom, String[] adresse,
                    String tel, Sexe sex,String age) {
            this.image = image;
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = adresse;
            this.tel = tel;
            this.sex = sex;
            this.age=age;
    }
    
    
    /**
	 * @param image
	 * @param text
	 * @param text2
	 * @param sexe
	 * @param text3
	 */
	public Personne(String image, String nom, String prenom, Sexe sexe,
			String age) {
		this.image = image;
		this.nom = nom;
		this.prenom = prenom;
		this.sex = sexe;
		this.age = age;
		
	}
	/**
	 * @param image
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param sexe
	 * @param age
	 */
	public Personne(String image, String nom, String prenom, String tel,
			Sexe sexe, String age) {
		this.image = image;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.sex = sexe;
		this.age = age;
	}
	/**
     * @return the emprunt
     */
    public List<Emprunt> getEmprunt() {
            return emprunt;
    }

    /**
     * @return the age
     */
    public String getAge() {
            return age;
    }




    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
            return "image=" + image + ", nom=" + nom + ", prenom="
                            + prenom + 
                            "\nadresse=" + adresseToString() + "\ntel="
                            + tel + ", sex=" + sex + ", age=" + age;
    }
    
    public String adresseToString(){
            String adr="";
            for(String str : adresse){
                    adr+=" "+str;
                    System.out.println(str);
                    
            }
            return adr;
    }

    /**
     * @return the image
     */
    public String getImage() {
            return image;
    }



    /**
     * @return the nom
     */
    public String getNom() {
            return nom;
    }



    /**
     * @return the prenom
     */
    public String getPrenom() {
            return prenom;
    }



    /**
     * @return the adresse
     */
    public String[] getAdresse() {
            return adresse;
    }
    


    /**
     * @return the tel
     */
    public String getTel() {
            return tel;
    }

    

    /**
     * @return the sex
     */
    public Sexe getSex() {
            return sex;
    }


    /**
     * 
     * @param i
     */
    public void modifierInscrit(Personne i) {
            image = i.getImage();
            nom = i.getNom();
            prenom = i.getPrenom();
            adresse = i.getAdresse();
            tel = i.getTel();
            sex = i.getSex();
            age=i.getAge();
    }
    /**
     * 
     * @param key
     * @param titre
     */
    public void emprunter(int key, String titre) {
            Emprunt emp=new Emprunt(key,titre);
            emprunt.add(emp);
    }
}
