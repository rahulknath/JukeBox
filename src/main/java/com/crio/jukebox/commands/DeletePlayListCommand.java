package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.exceptions.PlayListNotFoundException;
import com.crio.jukebox.exceptions.UserNotFoundException;
import com.crio.jukebox.services.IPlayListService;

public class DeletePlayListCommand implements ICommand{

    private final IPlayListService playListService;

    public DeletePlayListCommand(IPlayListService playListService) {
        this.playListService = playListService;
    }

    @Override
    public void execute(List<String> tokens) throws URISyntaxException {
        try{
            if(tokens.get(0).equals("DELETE-PLAYLIST"))
            { 
                PlayList t_obj =  playListService.deletePlayList(tokens.get(1), tokens.get(2));
                if(t_obj==null)
                {
                    System.out.println("Playlist Not Found");
                }
                else{
                    System.out.println("Delete Successful");
                }
            }
        }
        catch(UserNotFoundException | PlayListNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
