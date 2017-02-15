
package textrpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.event.battle.BattleEvent;
import textrpg.event.ending.EndingEvent;
import textrpg.event.GameEvent;
import textrpg.event.GameEventReturnValues;
import textrpg.event.straightpath.StraightPathEvent;

/**
*Tekstipohjainen versio pelistä (Ei enää käytössä!).
*/
public class GameText {
    
    private Player player;
    private List<GameEvent> events;
    private Scanner s;
    
    
    public GameText() {
        player = new Player("Player");
        events = new ArrayList();
        s = new Scanner(System.in);
    }
    
    /**
     * Metodi, jolla peli aloitetaan. Iteroi luodut pelitapahtumat ja lopettaa pelin, jos joku tapahtuma tappaa pelaajan.
    */
    
    public void start() {
        System.out.println("Welcome...\n");
        createEvents();
        
        for (GameEvent e : events) {
            boolean playerSurvives = handleEvent(e);
            System.out.println("");
            
            if (!playerSurvives) {
                System.out.println("Game over!");
                break;
            }
        }
    }
    /**
    * Käsittelee pelitapahtuman. Esittää pelaajalle komennot. Palauttaa true, jos komennon suorittamisen
    * jälkeen pelaaja ei ole kuollut.
    * @param event Käsiteltävä tapahtuma.
    * @return true, jos pelaaja on hengissä tapahtuman jälkeen.
    */
    public boolean handleEvent(GameEvent event) {
        System.out.println("****" + event.getStartMessage() + "****");
        
        boolean continueEvent = true;
        while (continueEvent) {
            
            List<Command> commands = event.getCommands();
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getDescription());
            }
            System.out.println("");
            continueEvent = chooseAndExecuteCommand(event);
            System.out.println("");
        }
        
        if (player.getHealth() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    /**
     * Lukee pelaajan valitseman komennon, ja suorittaa sen.
     * @param e Tällä hetkellä käsiteltävä tapahtuma.
     * @return true, jos tapahtuma jatkuu.
     */
    public boolean chooseAndExecuteCommand(GameEvent e) {
        while (true) {
            System.out.print("Choose command: ");
            int commandId;
            
            if (s.hasNextInt()) {
                commandId = s.nextInt();
            } else {
                System.out.println("Please enter a number.");
                s.next();
                continue;
            }
            GameEventReturnValues ret = e.initiateEvent(commandId - 1);
            
            if (ret != null) {
                System.out.println("");
                for (String msg : ret.getMessages()) {
                    System.out.println(msg);
                }
                return ret.getEventContinues();
            
            } else {
                System.out.println("Invalid command id.");
            }
        }
    }
    
    /**
     * Luo pelin eri tapahtumat.
     */
    public void createEvents() {
        this.events.add(new StraightPathEvent());
        this.events.add(new BattleEvent(this.player, new Enemy("Bandit")));
        this.events.add(new EndingEvent());
    }

}
