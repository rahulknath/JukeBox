package com.crio.jukebox.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.exceptions.FileNotFoundException;

public interface ISongsService {
    public List<Songs> loadSongs(String filename) throws FileNotFoundException;
    
}
