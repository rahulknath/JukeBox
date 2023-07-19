package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.List;
import com.crio.jukebox.App;
import com.crio.jukebox.services.IPlayListService;

public class PlaySongCommand implements ICommand {

    private final IPlayListService playListService;

    public PlaySongCommand(IPlayListService playListService) {
        this.playListService = playListService;
    }
    @Override
    public void execute(List<String> tokens) throws URISyntaxException {
        if(tokens.get(0).equals("PLAY-SONG"))
        {
            App.currentSong = playListService.playSong(tokens.get(1), tokens.get(2),App.currentPlayList,App.currentSong);
            if(App.currentSong != null)
            {
                System.out.println("Current Song Playing");
                System.out.println("Song - "+App.currentSong.getSong_name());
                System.out.println("Album - "+App.currentSong.getAlbum_name());
                System.out.println("Artists - "+ String.join(",", App.currentSong.getArtist_list()));
            }
            else{
                System.out.println("Given song id is not a part of the active playlist");
            }
        }
    }
    
}
