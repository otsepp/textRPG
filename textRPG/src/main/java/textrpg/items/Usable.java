
package textrpg.items;

import textrpg.characters.Player;

/**
 * Rajapinta tavaroille, joita voi käyttää.
 */
public interface Usable {
    
    /**
     * Metodi, jolla tavara käytetään pelaajaan.
     * @param user Pelaaja, johon tavara käytetään.
     * @return Viesti, joka kuvaa tavaran käyttämistä.
     */
    public String use(Player user);
    
    /**
     * Poistaa tavaran repusta.
     */
    public void removeFromInvetory();
    
}
