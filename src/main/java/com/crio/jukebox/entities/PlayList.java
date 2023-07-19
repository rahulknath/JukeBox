package com.crio.jukebox.entities;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayList extends BaseEntity{
    private final String userId;
    private final String playListName;
    private List<Songs> LSongs;

    public PlayList()
    {
        id = "";
        userId = "";
        playListName = "";
        LSongs = Collections.<Songs>emptyList();
    }

    public PlayList(String playListId, String userId,String playListName,List<Songs> LSongs)
    {
        this.id = playListId;
        this.userId = userId;
        this.playListName = playListName;
        this.LSongs = LSongs;
    }

    public void addSongsToList(List<Songs> lSongs)
    {
        for(Songs t : lSongs)
        {
            this.LSongs.add(t);
        }
        this.LSongs.stream().sorted((o1, o2)->o1.getId().compareTo(o2.getId())).collect(Collectors.toList());
    }

    public void deleteSongsFromList(List<Songs> lSongs)
    {
        for(Songs t : lSongs)
        {
            this.LSongs.remove(t);
        }
        this.LSongs.stream().sorted((o1, o2)->o1.getId().compareTo(o2.getId())).collect(Collectors.toList());
    }

    public String getUserId() {
        return userId;
    }

    public Songs getSongsById(Integer id) {
        return this.LSongs.get(id);
    }
    
    public Songs getSongsById1(Integer id) {
        for(Songs i : this.LSongs)
        {
            if(i.getId().equals(id.toString()))
            {
                return i;
            }
        }
        return null;
    }
    
    public String getPlayListName() {
        return playListName;
    }
    
    public List<Songs> getAllSongs()
    {
        return this.LSongs;
    }

    public Integer getSongsListSize()
    {
        return LSongs.size();
    }
    
    public Integer getIndexOfSong(Songs s)
    {
        return LSongs.indexOf(s);
    }
}
