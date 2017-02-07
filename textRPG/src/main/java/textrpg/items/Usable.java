
package textrpg.items;

import textrpg.characters.Player;

public interface Usable {
    
    public String use(Player user);
    
    public void removeFromInvetory();
    
}
