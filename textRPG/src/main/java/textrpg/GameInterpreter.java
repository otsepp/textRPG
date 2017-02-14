
package textrpg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Player;
import textrpg.event.GameEvent;
import textrpg.event.GameEventReturnValues;
import textrpg.event.straightpath.StraightPathEvent;

public class GameInterpreter {
    private Player player;
    private ArrayDeque<GameEvent> events;
    private GameEvent currentEvent;
    private List<String> latestMessages;
    
    
    public GameInterpreter() {
        this.player = new Player("Player");
        this.events = getDefaultEvents();
        this.currentEvent = this.events.getFirst();
        
        this.latestMessages = new ArrayList();
        this.latestMessages.add(this.currentEvent.getStartMessage());
    }

    
    public GameEvent getCurrentEvent() {
        return this.currentEvent;
    }
    
    public List<String> getLatestMessages() {
        return this.latestMessages;
    }
    
    public boolean executeCommand(int commandId) {
        GameEventReturnValues ret = this.currentEvent.initiateEvent(commandId);
        
        if (ret == null || this.player.isDead()) {
            return false;
        }
        if (!ret.getEventContinues()) {
            this.events.removeFirst();
            this.currentEvent = getNextEvent();
            if (this.currentEvent == null) {
                return false;
            }
        }
        this.latestMessages = ret.getMessages();
        return true;
    }
    
    private GameEvent getNextEvent() {
        if (this.events.peek() != null) {
            return this.events.getFirst();
        }
        return null;
    }
    
    private ArrayDeque<GameEvent> getDefaultEvents() {
        ArrayDeque<GameEvent> events = new ArrayDeque();
        events.addLast(new StraightPathEvent());
//        events.addLast(new BattleEvent(this.player new Enemy("Bandit")));
//        events.addLast(new EndingEvent());
        return events;
    }
    
}
