package utilitaires;

import java.util.EventListener;

/**
 * @author salioubah
 * 
 * <b>Description:</b><i>Listener pour catcher les evenements de fermeture d'onglet</i>
 * <br/>
 */
public interface CloseTabListener extends EventListener {
    /**
     * Methode appelee lorsque que la croix est clique dans un MyTabbedPanePlus
     * @param event
     */
    public void closeAction (CloseTabEvent event);
}