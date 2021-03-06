
package textrpg.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import textrpg.main.Game;
import textrpg.event.GameEvent;
import textrpg.main.GameStatus;

/**
 * Kuuntelee komentonappuloita ja tiettyyn nappulaan liittyvän komennon.
 */
public class CommandButtonListener  implements ActionListener {
    private Game game;
    private GameScreen gameScreen;
    private int commandId;

    /**
     * Luo uuden kuuntelija-olion.
     * @param game Peli, jota käyttöliittymä käsittelee
     * @param gameScreen Peliruutu
     * @param commandId Komennon indeksi komentolistalla
     */
    public CommandButtonListener(Game game, GameScreen gameScreen, int commandId) {
        this.game  = game;
        this.gameScreen = gameScreen;
        this.commandId = commandId;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GameStatus result = this.game.executeCommand(commandId);
        
        GameEvent event = this.game.getCurrentEvent();
        
        this.gameScreen.updateEventImage(event.getEventImage());
        this.gameScreen.updateMessagesArea(this.game.getLatestMessages());
        this.gameScreen.updateCommandsArea(event.getCommands());
        
        if (result == GameStatus.GAME_END)  {
            this.gameScreen.returnToMenu();
        }
    }

}