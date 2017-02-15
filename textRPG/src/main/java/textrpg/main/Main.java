
package textrpg.main;

import textrpg.ui.GameUIManager;

public class Main {

    public static void main(String[] args) {
        startUIGame();
    }
    
    /**
     * Aloittaa käyttöliittymäversion pelistä.
     */
    public static void startUIGame() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameUIManager game = new GameUIManager();
                game.start();
            }
        });
    }
}
