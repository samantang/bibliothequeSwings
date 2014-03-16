/**
 * 
 */
package generale;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import nature.Personne;
import nature.Sexe;

	/**
	 * @author salioubah
	 *
	 */
	public class FormeInscrit extends AbstractTableModel {
		
	
	 String[] titre;
	 List <Personne> donnees;
	

	/**
	 *  @param donnees
	 * @param titreInscrit
	 */
	public FormeInscrit(List<Personne> donnees,String[] titre) {
		this.donnees = donnees;
		this.titre = titre;
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
		return donnees.size();
	}


	 /**
     * @return the string titre de la colonne
     */
    public String getColumnName(int col){
            return titre[col];
    }

	

    /* (non-Javadoc)
	* @see javax.swing.table.TableModel#getValueAt(int, int)
 	*/
    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
    case 0 : return rowIndex+1;
    case 1 : return donnees.get(rowIndex).getNom();
    case 2 : return donnees.get(rowIndex).getPrenom();
    case 3 : return  donnees.get(rowIndex).getSex();
    case 4 : return donnees.get(rowIndex).adresseToString();
    case 5 : return donnees.get(rowIndex).getTel();
    case 6 : return donnees.get(rowIndex).getAge();
    case 7 : return donnees.get(rowIndex).getEmprunt().size();
    default: return donnees.get(rowIndex);
    }
	}
    
    /**
     * permet d'ajouter une personne au tableau
     * @param p
     * @param showFen
     */
	public void ajouterInscritAuTableau(Personne p,boolean showFen){
    if(p!=null){
    	System.out.println("le nom dans la formeInscrit "+p.getNom());
            donnees.add(p);
//            if(showFen)
//                    JOptionPane.showMessageDialog(null, "Votre inscription a la bibliotheque a ete effectuee avec succes\n" +
//                                    "Vos informations sont les suivantes :\n" +
//                                    p.toString()+"\n        A bientot", "Informations Ajout Personnage", JOptionPane.INFORMATION_MESSAGE);
        fireTableDataChanged();
    }else{
            JOptionPane.showMessageDialog(null, "Votre inscription a la bibliotheque est annule\n        Merci", "Information Ajout Personnage", JOptionPane.WARNING_MESSAGE);
    } 
	}

	/**
	 * @param cle
	 */
	public void supprimerPersonne(int cle) {
		if(donnees.size()>=cle){
			donnees.remove(cle);
			fireTableDataChanged();
		}
		
	}

	/**
	 * @param cle
	 * @param pers
	 */
	public void modifierPersonne(int cle, Personne pers) {
		donnees.get(cle).modifierInscrit(pers);
		fireTableDataChanged();
	}

	
	
//	/**
//	 * Retourne la classe de la donnee de la colonne
//	 * @param c numero de colonne
//	 */
//	public Class getColumnClass(int c) {
//        return getValueAt(0, c).getClass();
//        }

	}
