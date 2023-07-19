package com.crio.jukebox.dtos;

import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Songs;

public class PlayListDto {
    private PlayList currentPlayList;
    private Songs currentSong;
    public PlayListDto(PlayList currentPlayList, Songs currentSong) {
        this.currentPlayList = currentPlayList;
        this.currentSong = currentSong;
    }
    
    public PlayList getCurrentPlayList() {
        return currentPlayList;
    }



    public Songs getCurrentSong() {
        return currentSong;
    }
    

    @Override
    public String toString() {
        return "PlayListDto [currentPlayList=" + currentPlayList + ", currentSong=" + currentSong
                + "]";
    }





    
}
