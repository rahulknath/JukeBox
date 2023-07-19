package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.Map;
import com.crio.jukebox.entities.PlayList;

public class PlayListRepository {
    private final Map<String,PlayList> playListMap;
    private Integer autoIncrement = 0;

    public PlayListRepository()
    {
        this.playListMap = new HashMap<String,PlayList>();
    }

    public PlayListRepository(Map<String, PlayList> playListMap) {
        this.playListMap = playListMap;
        this.autoIncrement = playListMap.size();
    }

    public PlayList save(PlayList entity)
    {
        if( entity.getId() == null ){
            autoIncrement++;
            PlayList c = new PlayList(Integer.toString(autoIncrement),entity.getUserId(),entity.getPlayListName(),entity.getAllSongs());
            playListMap.put(c.getId(),c);
            return c;
        }
        playListMap.put(entity.getId(),entity);
        return entity;
    }

    public Integer count()
    {
        return playListMap.size();
    }

    public Boolean checkPlayListId(String id)
    {
        if(playListMap.containsKey(id))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public PlayList deletePlayList(String id)
    {
        return playListMap.remove(id);
    }

    public PlayList getPlayList(String id)
    {
        return this.playListMap.get(id);
    }
}
