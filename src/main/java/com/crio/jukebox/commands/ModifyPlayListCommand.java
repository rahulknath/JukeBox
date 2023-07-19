package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.exceptions.PlayListNotFoundException;
import com.crio.jukebox.exceptions.UserNotFoundException;
import com.crio.jukebox.services.IPlayListService;

public class ModifyPlayListCommand implements ICommand {
    private final IPlayListService playListService;

    public ModifyPlayListCommand(IPlayListService playListService) {
        this.playListService = playListService;
    }
    @Override
    public void execute(List<String> tokens) throws URISyntaxException {
        try{
            if(tokens.get(0).equals("MODIFY-PLAYLIST"))
            {
                List<String> lSongsIds = new ArrayList<>();
                PlayList obj;
                for(int i = 4;i<tokens.size();i++)
                {
                lSongsIds.add(tokens.get(i));
                }

            if(tokens.get(1).equals("ADD-SONG"))
            {
                    obj = playListService.addSongs(tokens.get(2),tokens.get(3),lSongsIds);
                    if(obj!=null)
                    {
                        List<Songs> songs = obj.getAllSongs();
                        List<String> songsIds = new ArrayList<>();
                        for(Songs t : songs)
                        {
                            songsIds.add(t.getId());
                        }
                        System.out.println("Playlist ID - "+obj.getId());
                        System.out.println("Playlist Name - "+obj.getPlayListName());
                        System.out.println("Song IDs - "+String.join(" ", songsIds));
                    }
                    else{
                        System.out.println("Some Requested Songs Not Available. Please try again.");
                    }    
            }

            if(tokens.get(1).equals("DELETE-SONG"))
            {
                    obj = playListService.deleteSongs(tokens.get(2),tokens.get(3),lSongsIds);
                    if(obj!=null)
                    {
                        List<Songs> songs = obj.getAllSongs();
                        List<String> songsIds = new ArrayList<>();
                        for(Songs t : songs)
                        {
                            songsIds.add(t.getId());
                        }
                        System.out.println("Playlist ID - "+obj.getId());
                        System.out.println("Playlist Name - "+obj.getPlayListName());
                        System.out.println("Song IDs - "+String.join(" ", songsIds));
                    }
                    else{
                        System.out.println("Some Requested Songs for Deletion are not present in the playlist. Please try again.");
                    }  
            }
            }
        } catch(UserNotFoundException | PlayListNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
