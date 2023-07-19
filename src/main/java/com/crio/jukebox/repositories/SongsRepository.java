package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.crio.jukebox.entities.Songs;

public class SongsRepository {
    private final Map<String,Songs> songsMap;
    private Integer autoIncrement = 0;

    public SongsRepository() {
        songsMap = new HashMap<String,Songs>();
    }

    public SongsRepository(Map<String, Songs> songsMap) {
        this.songsMap = songsMap;
        this.autoIncrement = songsMap.size();
    }

    public Songs save(Songs entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Songs c = new Songs(Integer.toString(autoIncrement),entity.getSong_name(),entity.getGenre(),entity.getAlbum_name(),entity.getAlbum_artist(),entity.getArtist_list());
            songsMap.put(c.getId(),c);
            return c;
        }
        songsMap.put(entity.getId(),entity);
        return entity;
    }

    public List<Songs> findSongs()
    {
        return  (List<Songs>)this.songsMap.values().stream().collect(Collectors.toList());
    }
    public Songs findSongById(String id)
    { 
        return  this.songsMap.get(id);
    }


    // public Boolean verifySongsId(List<String> SongsId)
    // {
    //     for(String t : SongsId)
    //     {
    //         if(!songsMap.containsKey(t))
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    
}
