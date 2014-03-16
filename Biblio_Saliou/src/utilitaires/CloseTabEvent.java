package utilitaires;

/**
 * @author salioubah
 * 
 * <b>Description:</b><i>Objet renvoye au listener lors de la fermeture d'un onglet</i>
 * <br/>
 */
public class CloseTabEvent {
    private MyTabbedPane tabbedPane;
    private int tabIndex;
    
    
    public CloseTabEvent (MyTabbedPane tabbedPane, int tabIndex) {
        this.tabbedPane = tabbedPane;
        this.tabIndex = tabIndex;
    }

    
    /**
     * 
     * @return l'index de l'onglet clique
     */
    public int getTabIndex () {
     
        return this.tabIndex;
    }
    
    /**
     * 
     * @return le tabbedPane qui a subit le clique
     */
    public MyTabbedPane getTabbedPane () {
        return this.tabbedPane;
    }
    
}