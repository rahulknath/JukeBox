package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.InvalidContestException;
import com.crio.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
         try{
            if(tokens.get(0).equals("LIST-CONTEST"))
            {
                if(tokens.size()==2)
                {
                    Level l = Enum.valueOf(Level.class, tokens.get(1));
                    System.out.println(contestService.getAllContestLevelWise(l));
                }
                if(tokens.size()==1){
                    System.out.println(contestService.getAllContestLevelWise(null));
                }
            }
        }
        catch(ContestNotFoundException | InvalidContestException e){
            System.out.println(e.getMessage());
        }
    }
    
}
