package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Songs;

public interface IPlayListService {
    public PlayList createPlayList(String userId,String PlayListName,List<String> LsongIds);
    public PlayList deletePlayList(String userId,String playListId);
    public PlayList play(String userId,String playListId);
    public Songs playSong(String userId, String arg, PlayList cpList,Songs cSong);
    public PlayList addSongs(String userId,String playListId,List<String> songsIds);
    public PlayList deleteSongs(String userId,String playListId,List<String> songsIds);
}
