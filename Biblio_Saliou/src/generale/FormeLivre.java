/**
 * 
 */
package generale;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import nature.Livre;
import nature.Personne;

/**
 * @author salioubah
 *
 */
public class FormeLivre extends AbstractTableModel {
	
	 List<Livre> livre;
	 String [] titre;
	 Personne pers;

	/**
	 * @param object
	 * @param titreLivre
	 */
	public FormeLivre(List<Livre> livre, String[] titreLivre) {
		this.livre = livre;
		this.titre = titreLivre;
	}
	
	// le titre des colonnes
	public String  getColumnName (int colonne){
		return titre[colonne];
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titre.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return livre.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
        case 0 : return rowIndex+1;
        case 1 : return livre.get(rowIndex).getTitre();
        case 2 : return livre.get(rowIndex).getAuteur();
        case 3 : return new JCheckBox(""+livre.get(rowIndex).getCategorie(),true);
        case 4 : return new JCheckBox(""+livre.get(rowIndex).themeToString(),true);
        case 5 : return livre.get(rowIndex).getNbrePage();
        case 6 : return new Boolean(livre.get(rowIndex).getDisponible());
        default: return livre.get(rowIndex);
        }
}

	/**
	 * @param l
	 * @param b
	 */
	public void AjoutLivreAuTableau(Livre l, boolean b) {
		if(l!=null){
			System.out.println(" le nom du livre "+l.getTitre());
            livre.add(l);
            if(b)
                    JOptionPane.showMessageDialog(null, "L'ajout du livre a la bibliotheque a ete effectuee avec succes\n" +
                                    "Les informations sont les suivantes :\n" +
                                    l.toString()+"\n", "Informations Ajout Livre", JOptionPane.INFORMATION_MESSAGE);
        fireTableDataChanged();
    }else{
            JOptionPane.showMessageDialog(null, "L'ajout du livre a la bibliotheque est annule\n        Merci", "Information Ajout Livre", JOptionPane.WARNING_MESSAGE);
    } 
		
	}


	/**
	 * @param cle
	 * @param person
	 */
	public void EmprunterLivre(int cle, List<Personne> person) {
		/*
         * on cree un tableau contenant le nom, le prenom et le code de l'inscrit
         * on l'affiche dans un JOptionPane
         * Apres avoir choisi la personne qui emprunte le livre, on retrouve son identifiant
         * on met la disponibilte du livre a false pour ne pas qu'une autre personne puisse l'emprunter
         * puis on ajoute l'identifiant du livre et son titre dans la liste des emprunts de la personne
         */
        String[] nomInscrit = new String[person.size()];
        String nom=null;
        for(int i=0;i<person.size();i++){
                nomInscrit[i]=person.get(i).getNom()+" "+person.get(i).getPrenom()+" id="+i;
        }
        if(nomInscrit.length>0){
                nom= (String) JOptionPane.showInputDialog(null,"veuiller selectionner votre nom","Selection de la personne",
                                JOptionPane.QUESTION_MESSAGE,null,nomInscrit,nomInscrit[0]);
        }
        
        if(nom!=null){
                int id=-1;
                //recherche de l'identifiant de la personne
                for(int i=0;i<nomInscrit.length;i++){
                        if(nomInscrit[i].equals(nom)){
                                id=i;
                                break;
                        }
                }
                //on rend le livre indisponible et on a l'ajoute a liste des emprunts de la personne        
                if(id>=0){
                        livre.get(cle).setDisponible(false);
                        person.get(id).emprunter(cle,livre.get(cle).getTitre());        
                        fireTableDataChanged();
                }
                
        }        
		
	}

	/**
	 * @param cle
	 */
	public void supprimerLivre(int cle) {
		// TODO Auto-generated method stub
		if(livre.size()>cle){
            livre.remove(cle);
            JOptionPane.showMessageDialog(null, "Ce livre a ete supprime de la liste des Livres\n" +
                            "\n", "Information Suppression Livre", JOptionPane.INFORMATION_MESSAGE);
            fireTableDataChanged();
    }
    else
    JOptionPane.showMessageDialog(null, "Erreur de suppression du livre\n", "Information Suppression Livre", JOptionPane.ERROR_MESSAGE);
		
		
	}

}
