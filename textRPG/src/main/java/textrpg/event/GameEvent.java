
package textrpg.event;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

/**
 * Pelitapahtuma.
 */
public abstract class GameEvent {
    protected String startMessage;
    protected List<Command> commands;
    private ImageIcon eventImage;
    
    /**
     * Tapahtumien yliluokkakonstruktori.
     * @param startMessage Tapahtuman aloitusviesti. Näytetään, kun tapahtuma aloitetaan.
     * @param commands Tapahtumaan liittyvät komennot.
     */
    public GameEvent(String startMessage, List<Command> commands) {
        this.startMessage = startMessage;
        this.commands = commands;
    }
    
    public String getStartMessage() {
        return this.startMessage;
    }
    
    public List<Command> getCommands() {
        return this.commands;
    }
    
    public ImageIcon getEventImage() {
        return this.eventImage;
    }
    
    public void setEventImage(ImageIcon image) {
        this.eventImage = image;
    }
    
    /**
     * Suorittaa pelaajan valitseman komennon indeksin perusteella. Metodi tarkistaa, onko indeksi hyväksyttävä. 
     * @param commandId pelaajan valitseman komennon indeksi
     * @return  GameEventReturnValues-olio sisältää viestit ja totuusarvon joka ilmaisee, että jatkuuko tapahtuma.
     * Palauttaa null, jos indeksi on väärä.
     */
    public GameEventReturnValues initiateEvent(int commandId) {
        if (commandId < 0 || commandId > this.commands.size() - 1) {
            return null;
        }
        Command command = this.commands.get(commandId);
        CommandReturnValues returnValues = command.executeCommand();
        this.commands = returnValues.getNewCommands();
        
        List<String> returnMessages = new ArrayList();
        returnMessages.addAll(returnValues.getMessages());
        
        boolean eventContinues = true;
        if (this.commands == null) {
            eventContinues = false;
        }
        return new GameEventReturnValues(returnMessages, eventContinues);
    }
    
    /**
     * Asettaa oletuskomennot.
     */
    protected abstract void setDefaultCommands();
    
}
