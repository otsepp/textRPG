
package sudoku.textrpg.game_events;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sudoku.textrpg.commands.Command;
import sudoku.textrpg.commands.CommandReturnValues;

public class StraightPathEvent extends GameEvent{

    
    
    public StraightPathEvent() {
        super("You see a straight path in front of you.",      
                new ArrayList());
        fillCommandList();
    }
    
    @Override
    protected final void fillCommandList() {
        this.commands.add(new GoForward());
    }
    
    //Tulostus pitäisi olla ulkopuolella!!!!! Tämä on testi!!! Kaatopaikkametodi!!!
    @Override
    public void initiateEvent() {
        Scanner s = new Scanner(System.in);
        System.out.println(this.startMessage);
        
        for (int i = 0; i < this.commands.size(); i++) {
                System.out.println((i + 1) + ". " + this.commands.get(i).getDescription());
            }
        
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
            
            if (commandId > 0 && commandId <= this.commands.size()) {
                
                Command command = this.commands.get(commandId - 1);
                CommandReturnValues ret = command.executeCommand();
                
                System.out.println("\n" + ret.getMessage());
                
                if (ret.getCommands() == null) {
                    break;
                }
                
            } else {
                System.out.println("Invalid command id.");
            }
        }
        
    }
    
    public class GoForward extends Command{
        
        public GoForward() {
            super("Go forward.",    //description
                    "You walk forward.",    //end message
                    null );  //new commands
        }
        
        @Override
        public CommandReturnValues executeCommand() {
            return new CommandReturnValues(this.endMessage, this.newCommands);
        }
    }
    
}
