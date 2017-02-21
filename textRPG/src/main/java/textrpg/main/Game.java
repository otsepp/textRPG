
package textrpg.main;

import java.util.*;
import textrpg.characters.Bandit;
import textrpg.characters.Cyclops;
import textrpg.characters.Goblin;
import textrpg.characters.Player;
import textrpg.event.GameEvent;
import textrpg.event.GameEventReturnValues;
import textrpg.event.battle.BattleEvent;
import textrpg.event.druid.DruidEncounterEvent;
import textrpg.event.ending.EndingEvent;
import textrpg.event.straightpath.StraightPathEvent;

/**
 * Käsittelee pelin tapahtumia.
 */
public class Game {
    private Player player;
    private ArrayDeque<GameEvent> events;
    private GameEvent currentEvent;
    private List<String> latestMessages;
    
    /**
     * Luo uuden peliolion ja asettaa sen alkutilaan.
     */
    public Game() {
        this.latestMessages = new ArrayList();
        setDefaultState();
    }

    
    public Player getPlayer() {
        return this.player;
    }
    
    public ArrayDeque<GameEvent> getEvents() {
        return this.events;
    }
    
    public GameEvent getCurrentEvent() {
        return this.currentEvent;
    }
    
    public List<String> getLatestMessages() {
        return this.latestMessages;
    }
    
    
    /**
     * Suorittaa tämän hetken tapahtumaan liittyvän komennon.
     * @param commandId Komennon indeksi komentolistalla.
     * @return Palauttaa null, jos commandId ei vastaa mitään komentoa. Jos peli jatkuu, palautetaan 
     * GameStatus.GAME_END, muuten palautetaan GameStatus.GAME_CONTINUE.
     */
    public GameStatus executeCommand(int commandId) {
        GameEventReturnValues returnValues = this.currentEvent.initiateEvent(commandId);
        
        if (returnValues == null) {
            return null;
        }
        if (this.player.isDead()) {
            this.events.clear();
        }
        if (!returnValues.getEventContinues()) {
            return setUpNextEvent();
        }
        this.latestMessages = returnValues.getMessages();
        return GameStatus.GAME_CONTINUE;
    }
    
    /**
     * Vaihtaa seuraavaan tapahtumaan. 
     * @return GameStatus-arvo, joka ilmaisee, että jatkuuko peli vai päättyykö se.
     */
    private GameStatus setUpNextEvent() {
        if (this.events.size() <= 1) {
            setDefaultState();
            return GameStatus.GAME_END;
        }
        this.events.removeFirst();
        this.currentEvent = getNextEvent();
        
        this.latestMessages.clear();
        this.latestMessages.add(this.currentEvent.getStartMessage());
        return GameStatus.GAME_CONTINUE;
    }
    
    /**
     * Hakee jonosta seuraavan tapahtuman.
     * @return Seuraava tapahtuma. Jos sellaista ei ole, palauttaa null.
     */
    private GameEvent getNextEvent() {
        if (this.events.peek() != null) {
            return this.events.getFirst();
        }
        return null;
    }
    
    /**
     * Asettaa pelin alkutilaan.
     */
    private void setDefaultState() {
        this.player = new Player("Player");
        this.events = getDefaultEvents();
        this.currentEvent = this.events.getFirst();
        this.latestMessages.clear();
        this.latestMessages.add(this.currentEvent.getStartMessage());
    }
    
    /**
     * Määrittää peliin liittyvät tapahtumat.
     * @return ArrayDeque-jono pelin tapahtumista.
     */
    private ArrayDeque<GameEvent> getDefaultEvents() {
        ArrayDeque<GameEvent> events = new ArrayDeque();
        
        events.addLast(new StraightPathEvent());
        events.addLast(new BattleEvent(this.player,  new Bandit()));
        events.addLast(new BattleEvent(this.player,  new Goblin()));
        events.addLast(new DruidEncounterEvent(this.player));
        events.addLast(new BattleEvent(this.player,  new Cyclops()));
        events.addLast(new EndingEvent());
        
        return events;
    }
    
    

}

