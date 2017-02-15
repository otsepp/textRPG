
package textrpg.event;

import java.util.List;

/**
 * Käytetään tapahtumien palautusarvona. Sisältää viestit ja totuusarvon joka ilmaisee, että jatkuuko tapahtuma.
 */
public class GameEventReturnValues {
    private List<String> messages;
    private boolean eventContinues;
    
    /**
     * Luo uuden olion.
     * @param messages Tapahtuman luomat viestit
     * @param eventContinues Ilmaisee, että jatkuuko tapahtuma vai ei
     */
    public GameEventReturnValues(List<String> messages, boolean eventContinues) {
        this.messages = messages;
        this.eventContinues = eventContinues;
    }
    
    public List<String> getMessages() {
        return messages;
    }
    
    public boolean getEventContinues() {
        return eventContinues;
    }
    
    public void setEventContinues(boolean newValue) {
        this.eventContinues = newValue;
    }
    
}
