
package sudoku.textrpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sudoku.textrpg.characters.Player;
import sudoku.textrpg.commands.Command;
import sudoku.textrpg.game_events.GameEvent;
import sudoku.textrpg.game_events.GameEventReturnValues;
import sudoku.textrpg.game_events.straight_path_event.StraightPathEvent;

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
            handleEvent(e);
        }
    }
    
    public void handleEvent(GameEvent e) {
        System.out.println(e.getStartMessage());
        
        boolean continueEvent = true;
        while (continueEvent) {
            
             List<Command> commands = e.getCommands();
             for (int i = 0; i < commands.size(); i++) {
                 System.out.println((i + 1) + ". " + commands.get(i).getDescription());
             }
             System.out.println("");
             continueEvent = chooseAndExecuteCommand(e, commands);
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
                  GameEventReturnValues ret = e.executeCommand(commandId - 1);
                  
                  if (ret != null) {
                      System.out.println("\n" + ret.getEndMessage());
                      return ret.isEventContinues();
                      
                  } else {
                      System.out.println("Invalid command id.");
                  }
             }
        }
    
    public void createEvents() {
        this.events.add(new StraightPathEvent());
    }
    
}
