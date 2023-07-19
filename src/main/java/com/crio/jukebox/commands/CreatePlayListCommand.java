package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.exceptions.SongNotFoundException;
import com.crio.jukebox.exceptions.UserNotFoundException;
import com.crio.jukebox.services.IPlayListService;

public class CreatePlayListCommand implements ICommand{

    private final IPlayListService playListService;

    public CreatePlayListCommand(IPlayListService playListService) {
        this.playListService = playListService;
    }

    @Override
    public void execute(List<String> tokens) throws URISyntaxException {

        try{
            if(tokens.get(0).equals("CREATE-PLAYLIST"))
            {
                List<String> lSongs = new ArrayList<>();
                for(int i = 3;i<tokens.size();i++)
                {
                    lSongs.add(tokens.get(i));
                }

                PlayList t_obj = playListService.createPlayList(tokens.get(1), tokens.get(2), lSongs);
                
                if(t_obj==null)
                {
                    System.out.println("Some Requested Songs Not Available. Please try again.");
                }
                else{
                    System.out.println("Playlist ID - " + t_obj.getId());
                }
            }
        }
        catch(UserNotFoundException | SongNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
