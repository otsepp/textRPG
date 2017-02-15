
package textrpg.command;

import java.util.List;

/**
 * Yliluokka, josta kaikki tapahtumiin liittyvät komennot periytyvät. 
 */
public abstract class Command {
    protected String description;
    protected List<String> messages;
    protected List<Command> newCommands;
    
    /**
     * Komento-olioiden yliluokkakonstruktori.
     * @param description Komennon kuvaus
     * @param messages Komennon palauttamat viestit
     * @param newCommands Komennon palauttamat komennot
     */
    public Command(String description, List<String> messages, List<Command> newCommands) {
        this.description = description;
        this.messages = messages;
        this.newCommands = newCommands;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public List<String> getMessages() {
        return this.messages;
    }
    
    public List<Command> getNewCommands() {
        return this.newCommands;
    }
    
    /**
     * Aliluokissa ylikirjoitettava metodi, joka sisältää komennon logiikan. 
     * @return CommandReturnValues-olio sisältää viestit ja uudet komennot tapahtumaa varten.
     */
    public abstract CommandReturnValues executeCommand();

}
