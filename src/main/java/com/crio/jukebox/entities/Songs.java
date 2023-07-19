package com.crio.jukebox.entities;

import java.util.Collections;
import java.util.List;

public class Songs extends BaseEntity {
    private final String song_name;
    private final String genre;
    private final String album_name;
    private final String album_artist;
    private final List<String> artist_list;

    public Songs()
    {
        this("", "", "", "","",Collections.<String>emptyList());
    }
    
    public Songs(String id,String song_name, String genre, String album_name, String album_artist,
            List<String> artist_list) {
        this(song_name,genre,album_name,album_artist,artist_list);
        this.id = id;
    }

    public Songs(String song_name, String genre, String album_name, String album_artist,
            List<String> artist_list) {
        this.song_name = song_name;
        this.genre = genre;
        this.album_name = album_name;
        this.album_artist = album_artist;
        this.artist_list = artist_list;
    }

    public String getSongId(){
        return id;
    }

    public String getSong_name() {
        return song_name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public String getAlbum_artist() {
        return album_artist;
    }

    public List<String> getArtist_list() {
        return artist_list;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Songs [album_artist=" + album_artist + ", album_name=" + album_name
                + ", artist_list=" + artist_list + ", genre=" + genre + ", song_name=" + song_name
                + "]";
    }   
    
}
