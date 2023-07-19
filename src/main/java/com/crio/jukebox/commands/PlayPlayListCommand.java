package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.List;
import com.crio.jukebox.App;
import com.crio.jukebox.services.IPlayListService;

public class PlayPlayListCommand implements ICommand {

    private final IPlayListService playListService;

    public PlayPlayListCommand(IPlayListService playListService) {
        this.playListService = playListService;
    }

    @Override
    public void execute(List<String> tokens) throws URISyntaxException {
        if(tokens.get(0).equals("PLAY-PLAYLIST"))
        {
            App.currentPlayList  = playListService.play(tokens.get(1), tokens.get(2));
            if( App.currentPlayList != null && App.currentPlayList.getSongsListSize()>0)
            {
                App.currentSong =  App.currentPlayList.getSongsById(0);
                System.out.println("Current Song Playing");
                System.out.println("Song - "+App.currentSong.getSong_name());
                System.out.println("Album - "+App.currentSong.getAlbum_name());
                System.out.println("Artists - "+ String.join(",", App.currentSong.getArtist_list()));
            }
            else{
                System.out.println("Playlist is empty.");
            }
        }
    }
    
}
