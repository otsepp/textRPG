
package textrpg.items;

import textrpg.characters.GameCharacter;

/**
 * Rajapinta tavaroille, joita voi käyttää.
 */
public interface Usable {
    
    /**
     * Metodi, jolla tavara käytetään hahmoon.
     * @param character Hahmo, johon tavara käytetään.
     * @return Viesti, joka kuvaa tavaran käyttämistä.
     */
    public String use(GameCharacter character);
    
    /**
     * Poistaa tavaran repusta.
     */
    public void removeFromInventory();
    
}
