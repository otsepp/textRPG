
package textrpg.event.druid;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import textrpg.characters.Player;
import textrpg.event.GameEvent;

public class DruidEncounterEvent extends GameEvent {
    
    private Player player;
    
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
    
}
