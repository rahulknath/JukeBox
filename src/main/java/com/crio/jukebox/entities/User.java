package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.crio.jukebox.entities.PlayList;

public class User extends BaseEntity {
    private final String userName;
    private List<PlayList> playlist;
   
    public User(String userID,String userName) {
        this.id = userID;
        this.userName = userName;
        this.playlist = new ArrayList<PlayList>();
    }

    public void addPlayList(PlayList pl) {
        this.playlist.add(pl);
    }

    public User(User user){
        this(user.id,user.userName);
    }

    public String getUserName() {
        return userName;
    }

    public List<PlayList> getPlaylist() {
        return playlist;
    }

    public Optional<PlayList> getPlayListByPlayList(PlayList pl){
        return Optional.ofNullable(playlist.stream().filter(o->o.equals(pl)).findFirst().orElse(null));
    }
    
    public Optional<PlayList> getPlayListById(String pId){
        return Optional.ofNullable(playlist.stream().filter(o->o.getId().equals(pId)).findFirst().orElse(null));
    }
    

    @Override
    public String toString() {
        return "User [playlist=" + playlist + ", userName=" + userName + "]";
    }

    public void removePlayList(PlayList playList)
    {
        this.playlist.remove(playList);
    }
    
}
