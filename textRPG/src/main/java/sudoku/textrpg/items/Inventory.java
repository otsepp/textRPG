
package sudoku.textrpg.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    
    private List<Item> items;
    
    public Inventory() {
        items = new ArrayList();
    }
    
    public List<Item> getItems() {
        return items;
    }
    
}
