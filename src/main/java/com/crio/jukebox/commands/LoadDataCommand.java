package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.List;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.exceptions.FileNotFoundException;
import com.crio.jukebox.services.ISongsService;

public class LoadDataCommand implements ICommand {

    private final ISongsService songsService;

    public LoadDataCommand(ISongsService songsService) 
    {
        this.songsService = songsService;
    }

    @Override
    public void execute(List<String> tokens){
        try{
            if(tokens.get(0).equals("LOAD-DATA"))
            { 
                if(songsService.loadSongs(tokens.get(1))!=null)
                {
                    System.out.println("Songs Loaded successfully");
                }
                
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
}
