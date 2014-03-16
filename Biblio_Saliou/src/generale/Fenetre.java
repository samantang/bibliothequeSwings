/**
 * 
 */
package generale;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import utilitaires.MyTabbedPane;
import nature.Livre;
import nature.Personne;
import ajouts.AjoutLivre;
import ajouts.AjoutPersonne;
import bibliotheque.Bibliotheque;


/**
 * @author salioubah
 *
 *classe heritant de JFrame et qui contient tous les composants de l'application
 */
public class Fenetre extends JFrame {
	protected static final int INDEX_PERSONNE = 0;
    protected static final int INDEX_LIVRE = 1;
    private Dimension size;
    private Livre livre;
    
    File folder=new File ("images/Medias/"); 
    File donnees=new File ("donnees");

	
    private Bibliotheque bibliotheque = new Bibliotheque();
	private JMenuBar menuBar = new JMenuBar();
	
	// les principaux menus
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuEdition = new JMenu("Edition");
	private JMenu menuAide = new JMenu("Aide");
	
	// les sous-menus du fichier
	private JMenu menuLivre = new JMenu("Livre");
	private JMenu menuPersonne = new JMenu("Personne");
	
	// les sous-menus du livre
	private JMenuItem menuAjoutLivre = new JMenuItem("Ajouter Livre");
	private JMenuItem menuConsulteLivre = new JMenuItem("Consulter Livre");
	
	// les sous-menus de la personne
	private JMenuItem menuAjoutPersonne = new JMenuItem("Ajouter Personne");
	private JMenuItem menuConsultePersonne = new JMenuItem("Consulter Personne");
	
	// les sous menus de Edition
	private JMenu EditonLivre = new JMenu("Livre");
	private JMenu EditonPersonne = new JMenu("Personne");
	
	// les sous menus de la personne 
	private JMenuItem modifierPersonne = new JMenuItem("Modifier");
	private JMenuItem supprimerPersonne = new JMenuItem("Supprimer");
	private JMenuItem descriptionPersonne = new JMenuItem("Description");
	
	// les sous menus du livre
		private JMenuItem modifierLivre = new JMenuItem("Modifier");
		private JMenuItem supprimerLivre = new JMenuItem("Supprimer");
		private JMenuItem descriptionLivre = new JMenuItem("Description");
		private JMenuItem emprunterLivre = new JMenuItem("emprunter");
		
		// le sous menu Aide
		private JMenuItem aide = new JMenuItem("?");
		
		
		//menu contextuel
        private JPopupMenu menuContextuelL=new JPopupMenu();
        private JMenuItem mModifierL=new JMenuItem("modifier");
        private JMenuItem mSupprimerL=new JMenuItem("supprimer");
        private JMenuItem mDescriptionL=new JMenuItem("description");
        private JMenuItem mEmprunterL=new JMenuItem("Emprunter");

        private JPopupMenu menuContextuelP=new JPopupMenu();
        private JMenuItem mModifierP=new JMenuItem("modifier");
        private JMenuItem mSupprimerP=new JMenuItem("supprimer");
        private JMenuItem mDescriptionP=new JMenuItem("description");
		
		
		
        // contentPane pour les tableaux
        private MyTabbedPane  container;
        
        private FormeInscrit fInscrit;
        private FormeLivre fLivre;
        private String  titreInscrit [] = {"Numero", "Nom", "Prenom", "Sexe","Adresse","Tel","Age","Livre Emprunter"};
        private String titreLivre [] = {"ISBN", "Titre", "Auteur", "Categorie","Theme","Nombre de page","Disponible"};
        private JTable tableauInscrits;
        private JTable tableauLivres;
        
	
	public Fenetre() {
		this.setSize(900, 700);
	    this.setTitle("la bibliotheque de saliou");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	    
	    // Ajout des menus et sous-menus
	    this.menuLivre.add(menuAjoutLivre);
	    this.menuLivre.add(menuConsulteLivre);
	    
	    this.menuPersonne.add(menuAjoutPersonne);
	    this.menuPersonne.add(menuConsultePersonne);
	    
	    this.menuFichier.add(menuLivre);
	    this.menuFichier.add(menuPersonne);
	    
	    this.EditonLivre.add(modifierLivre);
	    this.EditonLivre.add(supprimerLivre);
	    this.EditonLivre.add(descriptionLivre);
	    this.EditonLivre.add(emprunterLivre);
	    
	    this.EditonPersonne.add(modifierPersonne);
	    this.EditonPersonne.add(supprimerPersonne);
	    this.EditonPersonne.add(descriptionPersonne);
	    
	    this.menuEdition.add(EditonLivre);
	    this.menuEdition.add(EditonPersonne);
	    
	    this.menuAide.add(aide);
	    
	    this.menuBar.add(menuFichier);
	    this.menuBar.add(menuEdition);
	    this.menuBar.add(menuAide);
	    
	    this.setJMenuBar(menuBar);
	    
	  //creation du tabbedPane
        container=new MyTabbedPane(Color.CYAN, Color.WHITE);
        
        
      //on cree le dossier pour les images si il n'existe pas
        if(!folder.exists()) folder.mkdirs();
        if(!donnees.exists()) donnees.mkdirs();
	    
	    
		// creation de la forme d un inscrit avec les titres et les champs
	    fInscrit = new FormeInscrit(bibliotheque.getPersonne(), titreInscrit);
	    tableauInscrits = new JTable(fInscrit);
	 
	    
	    // creation de la forme d un livre avec les titres
	    fLivre = new FormeLivre(bibliotheque.getLivre(), titreLivre);
	    tableauLivres = new JTable(fLivre);
	    tableauLivres.setDefaultRenderer(JCheckBox.class, new tableCellRender());
        //une seule selection possible au niveau des lignes
        tableauLivres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    
	    container.insertTab("les inscrits", null, new JScrollPane(tableauInscrits), "la liste des inscrit", INDEX_PERSONNE);
	    container.insertTab("les livres", null, new JScrollPane(tableauLivres), "la liste des livres", INDEX_LIVRE);
	    
	    
	    // les ecouteur des menus
	    ecouteursMenus();
	    
	    // le menu contextuel
	    menuContextuel();
	    
		  //On ajoute le conteneur
	    this.setContentPane(container);
	    this.setVisible(true);
	}


	/**
	 * le menu contextuel de l'application
	 */
	private void menuContextuel() {
	//creation des menus contextuels et de leur listener
    //pour les livres
     menuContextuelL.add(mModifierL);
     menuContextuelL.add(mSupprimerL);
     menuContextuelL.add(mDescriptionL);
     menuContextuelL.add(mEmprunterL);
    //pour les inscrits
     menuContextuelP.add(mModifierP);
     menuContextuelP.add(mSupprimerP);
     menuContextuelP.add(mDescriptionP);
     
     mModifierP.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent arg0) {
                         int key=tableauInscrits.getSelectedRow();
                         modifierPersonne(key);
                 }

				private void modifierPersonne(int cle) {
					AjoutPersonne ajp = new AjoutPersonne(null, "modification de la personne", bibliotheque.getPersonne().get(cle), true);
					Personne pers = ajp.creeDialog();
					fInscrit.modifierPersonne(cle, pers);
					
				}
           });
     mSupprimerP.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent arg0) {
                         int key=tableauInscrits.getSelectedRow();
                         if(key >=0)
                         fInscrit.supprimerPersonne(key);
                 }
           });
     mDescriptionP.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent arg0) {
                         int key=tableauInscrits.getSelectedRow();
                         decrirePersonne(key);
                 }

				private void decrirePersonne(int cle) {
					container.addTab("description personne", new DescriptionPersonne(size,bibliotheque.getPersonne().get(cle),bibliotheque.getLivre()).getPanel(),MyTabbedPane.WITH_CLOSE_CROSS);
					container.setSelectedIndex(container.getTabCount()-1);
					
				}
           });

     tableauInscrits.addMouseListener(new MouseListener(){
                 @Override
                 public void mouseClicked(MouseEvent arg0) {}
                 @Override
                 public void mouseEntered(MouseEvent arg0) {}
                 @Override
                 public void mouseExited(MouseEvent arg0) {}
                 @Override
                 public void mousePressed(MouseEvent arg0) {}
                 @Override
                 public void mouseReleased(MouseEvent arg0) {
                           if ( arg0.getClickCount() == 2 ) {
                                  if(tableauInscrits.getSelectedRow()>=0){
                                          int key=tableauInscrits.getSelectedRow();
                                          decrirePersonne(key);
                                  }
               }
                         if(arg0.getButton()==MouseEvent.BUTTON3){
                   if(tableauInscrits.getSelectedRow()>=0){
                             menuContextuelP.show(tableauInscrits,arg0.getX() ,arg0.getY());
                   }
                 }
                 }
				private void decrirePersonne(int cle) {
					container.addTab("description personne", new DescriptionPersonne(size,bibliotheque.getPersonne().get(cle),bibliotheque.getLivre()).getPanel(),MyTabbedPane.WITH_CLOSE_CROSS);
					container.setSelectedIndex(container.getTabCount()-1);
					
				} 
      });

     container.addChangeListener(new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	}


	/**
	 * methode qui sert a ecouter les menus
	 */
	private void ecouteursMenus() {
		aide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Développeur: Saliou BAH  \n "
						+ "contact: elhadjpemafy@yahoo.fr");
			}
		});
		
		menuAjoutPersonne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AjoutPersonne ajP = new AjoutPersonne(null, "personne", true);
				Personne info = ajP.creeDialog();
				fInscrit.ajouterInscritAuTableau(info, false);
			}
		});
		supprimerPersonne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// on prend l'indice de la ligne et on le supprime
				int cle = tableauInscrits.getSelectedRow();
				if(cle>=0)
					fInscrit.supprimerPersonne(cle);
				else JOptionPane.showMessageDialog(null,"Vous devez selectionner une personne dans la liste","Suppression Inscrit",JOptionPane.NO_OPTION);
				
			}
		});
		modifierPersonne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// on recupère le clef de la ligne
				// on rouvre une nouvelle fenetre qui contient toutes les infos de la ligne à modifier
				int cle = tableauInscrits.getSelectedRow();
				modifierPersonne(cle);
				
			}

			private void modifierPersonne(int cle) {
				AjoutPersonne ajp = new AjoutPersonne(null, "modification de la personne", bibliotheque.getPersonne().get(cle), true);
				Personne pers = ajp.creeDialog();
				fInscrit.modifierPersonne(cle, pers);
				
			}
		});
		descriptionPersonne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cle = tableauInscrits.getSelectedRow();
				decrirePersonne(cle);
				
			}

			private void decrirePersonne(int cle) {
				container.addTab("description personne", new DescriptionPersonne(size,bibliotheque.getPersonne().get(cle),bibliotheque.getLivre()).getPanel(),MyTabbedPane.WITH_CLOSE_CROSS);
				container.setSelectedIndex(container.getTabCount()-1);
			}
		});
		menuAjoutLivre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// on cree une nouvelle fenetre avec les composants necessaires
				AjoutLivre al = new AjoutLivre(null, "livre", true);
				Livre jinfo = al.showJDialog();
				 fLivre.AjoutLivreAuTableau(jinfo, true);
			}

			
		});
		emprunterLivre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// on recupère la clee de la ligne sélectionnee
				
				int cle = tableauLivres.getSelectedRow();
				EmprunterLivre(cle);
			}

			private void EmprunterLivre(int cle) {
				// si le livre est disponible
				 if(bibliotheque.getLivre().get(cle).getDisponible()){
					// le traitement à faire
					fLivre.EmprunterLivre(cle, bibliotheque.getPersonne());
				}
				else { JOptionPane.showMessageDialog(null, "vous devez selectionner un livre ou regarder si le livre est disponible","emprunt du livre" ,JOptionPane.WARNING_MESSAGE  );
					
				}
			
				
				
			}
		});
		supprimerLivre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int cle = tableauLivres.getSelectedRow();
				supprimerLivre(cle);
			}

			private void supprimerLivre(int cle) {
				// TODO Auto-generated method stub
				if(cle >=0){
                    if(bibliotheque.getLivre().get(cle).getDisponible())
                            fLivre.supprimerLivre(cle);
                    else JOptionPane.showMessageDialog(null, "Ce livre est actuellement indisponible. " +
                                    "\nAucune suppression possible" +
                                    "\n        La Bibliotheque", "Suppression du Livre", JOptionPane.WARNING_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null,"Vous devez selectionner un livre dans la liste","Suppression Livre",JOptionPane.NO_OPTION);
			}
		});
	}


}
