
package textrpg;

public class Main {

    public static void main(String[] args) {
        
    }
    
    /**
     * Aloittaa käyttöliittymäversion pelistä.
     */
    public static void startUIGame() {
       
    }
    
     /**
     * Aloittaa tekstipohjaisen version pelistä.
     */
    public static void startTextGame() {
        GameText game = new GameText();
        game.start();
    }
    
}
