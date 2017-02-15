
package textrpg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.event.GameEvent;
import textrpg.event.GameEventReturnValues;
import textrpg.event.battle.BattleEvent;
import textrpg.event.ending.EndingEvent;
import textrpg.event.straightpath.StraightPathEvent;

//RENAME
public class GameInterpreter {
    private Player player;
    private ArrayDeque<GameEvent> events;
    private GameEvent currentEvent;
    private List<String> latestMessages;
    
    
    public GameInterpreter() {
        this.latestMessages = new ArrayList();
        setDefaultState();
    }

    
    public GameEvent getCurrentEvent() {
        return this.currentEvent;
    }
    
    public List<String> getLatestMessages() {
        return this.latestMessages;
    }
    
    public GameStatus executeCommand(int commandId) {
        GameEventReturnValues ret = this.currentEvent.initiateEvent(commandId);
        
        if (this.player.isDead()) {
            this.events.clear();
        }
        if (!ret.getEventContinues()) {
            return setUpNextEvent();
        }
        this.latestMessages = ret.getMessages();
        return GameStatus.GAME_CONTINUE;
    }
    
    private GameStatus setUpNextEvent() {
        if (this.events.isEmpty()) {
            setDefaultState();
            return GameStatus.GAME_END;
        }
        this.events.removeFirst();
        this.currentEvent = getNextEvent();
        
        if (this.currentEvent == null) {
            setDefaultState();
            return GameStatus.GAME_END;
        
        } else {
            this.latestMessages.clear();
            this.latestMessages.add(this.currentEvent.getStartMessage());
            return GameStatus.GAME_CONTINUE;
        }
    }
    
    private GameEvent getNextEvent() {
        if (this.events.peek() != null) {
            return this.events.getFirst();
        }
        return null;
    }
    
    private void setDefaultState() {
        this.player = new Player("Player");
        this.events = getDefaultEvents();
        this.currentEvent = this.events.getFirst();
        this.latestMessages.clear();
        this.latestMessages.add(this.currentEvent.getStartMessage());
    }
    
    private ArrayDeque<GameEvent> getDefaultEvents() {
        ArrayDeque<GameEvent> events = new ArrayDeque();
        
        events.addLast(new StraightPathEvent());
        events.addLast(new BattleEvent(this.player, new Enemy("Bandit")));
        events.addLast(new EndingEvent());
        
        return events;
    }
    
    
    public enum GameStatus {
        GAME_CONTINUE, GAME_END;
    }
}

