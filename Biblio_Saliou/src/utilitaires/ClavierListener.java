/**
 * 
 */
package utilitaires;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 * @author salioubah
 *
 */
public class ClavierListener implements KeyListener{
    JTextComponent jtc;
    String message;
    String titre;
    
    /**
     * @param jtc
     */
    public ClavierListener(JTextComponent jtc,String message,String titre) {
            this.jtc = jtc;
            this.message=message;
            this.titre=titre;
    }



    public void keyReleased(KeyEvent event) {
            
            if(!isNumeric(event.getKeyChar())){
                    JOptionPane.showMessageDialog(null,message, titre, JOptionPane.WARNING_MESSAGE);
                    jtc.setText(jtc.getText().replace(String.valueOf(event.getKeyChar()), ""));
            }                        
    }
    
    //Inutile de redefinir ces methodes
    //Nous n'en avons plus l'utilite !
    public void keyPressed(KeyEvent event) {}
    public void keyTyped(KeyEvent event) {}
    
    /**
     * @param carac
     * @return Boolean
     * vrai si le parametre est numerique
     * Faux sinon
     */
    private boolean isNumeric(char carac){
        try {
                    Integer.parseInt(String.valueOf(carac));
            } catch (NumberFormatException e) {
                    return false;                                
            }
            return true;
}
}