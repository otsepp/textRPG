
package textrpg.items;

/**
 * Kuvaa tavaraa.
 */
public abstract class Item {
    private String name;
    
    public Item(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item otherItem = (Item) obj;
        
        if (otherItem.getName().equals(this.getName())) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.getName().length();
    }
    
}
