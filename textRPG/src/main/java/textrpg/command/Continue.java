
package textrpg.command;

import java.util.ArrayList;

/**
 * Komento, jolla tapahtuma "lopetetaan". Suorittamisen jälkeen jatketaan seuraavaan tapahtumaan.
 */
public class Continue extends Command {
    
    /**
     * Luo uuden olion. 
     */
    public Continue() {
        super("Continue", new ArrayList(), null);
    }
    
    @Override
    public CommandReturnValues executeCommand() {
        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
}
