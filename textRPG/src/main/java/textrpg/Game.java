
package textrpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.events.battle_event.BattleEvent;
import textrpg.events.ending_event.EndingEvent;
import textrpg.game_event.GameEvent;
import textrpg.game_event.GameEventReturnValues;
import textrpg.events.straight_path_event.StraightPathEvent;

public class Game {
    
    private Player player;
    private List<GameEvent> events;
    private Scanner s;
    
    public Game() {
        player = new Player("Player");
        events = new ArrayList();
        s = new Scanner(System.in);
    }
    
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
    
    public boolean handleEvent(GameEvent e) {
        System.out.println("****" + e.getStartMessage() + "****");
        
        boolean continueEvent = true;
        while (continueEvent) {
            
             List<Command> commands = e.getCommands();
             for (int i = 0; i < commands.size(); i++) {
                 System.out.println((i + 1) + ". " + commands.get(i).getDescription());
             }
             System.out.println("");
             continueEvent = chooseAndExecuteCommand(e, commands);
             System.out.println("");
        }
        
        if (player.getHealth() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean chooseAndExecuteCommand(GameEvent e, List<Command> commands) {
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
    
    public void createEvents() {
        this.events.add(new StraightPathEvent());
        this.events.add(new BattleEvent(this.player, new Enemy("Bandit")));
        this.events.add(new EndingEvent());
    }
    
}
