/**
 * 
 */
package sauvegarde;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import nature.Personne;


/**
 * @author salioubah
 *
 */
public class SauvegarderPersonne {
	
	private List<Personne> lesPersonnes= new ArrayList<Personne>();
    
    /**
     * @return les personnes Inscrites
     */
    public List<Personne> getLesPersonnes() {
            return lesPersonnes;
    }
    
    /**
     * Constructeur (charge la liste des inscrits dans une ArrayList a partir d'un fichier
     * 
     */
    public SauvegarderPersonne(){
            try{
                    File file = new File("donnees/inscrit.scr");
                    //on verifie s'il existe des donnees
                    if(file.length()>0){
                            ObjectInputStream ois = new ObjectInputStream(
                                            new BufferedInputStream(
                                                    new FileInputStream(
                                                                    file)));
                            lesPersonnes=(List<Personne>) ois.readObject();
                            ois.close();
                    }
                    else{
                            lesPersonnes= new ArrayList<Personne>();
                    }
            } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Erreur de chargement depuis le fichier inscrit !\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erreur de chargement depuis le fichier inscrit !\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Erreur de chargement depuis le fichier inscrit !\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    /**
     * cette methode enregistre les donnees des inscrits dans un fichier
     */
    public void serialize(){
            try {
                    ObjectOutputStream oos = new ObjectOutputStream(
                                                                            new BufferedOutputStream(
                                                                                            new FileOutputStream(
                                                                                                            new File("donnees/inscrit.scr"))));
                    oos.writeObject(lesPersonnes);
                    oos.close();
                    
            } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Erreur d'enregistrement dans le fichier inscrit !", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erreur d'enregistrement dans le fichier inscrit !", "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
    }

}
