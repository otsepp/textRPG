
package textrpg.event.druid;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import textrpg.characters.Player;
import textrpg.event.GameEvent;

/**
 * Pelaaja tapaa drudin, joka tarjoaa kaksi eri vaihtoehtoa.
 */
public class DruidEncounterEvent extends GameEvent {
    
    private Player player;
    
    /**
     * Luo uuden olion.
     * @param player Tapahtumaan liittyvä pelaaja
     */
    public DruidEncounterEvent(Player player) {
        super("You encounter a druid. He offers you healing or a blessing.", new ArrayList());
        this.player = player;
        setDefaultCommands();
        super.setEventImage(new ImageIcon(DruidEncounterEvent.class.getResource("/event_images/druid.png")));
    }
    
    @Override
    protected void setDefaultCommands() {
        super.commands.add(new ChooseHealing(this.player));
        super.commands.add(new ChooseBlessing(this.player));
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
}
