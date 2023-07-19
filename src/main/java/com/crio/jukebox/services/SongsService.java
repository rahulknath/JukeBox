package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.exceptions.FileNotFoundException;
import com.crio.jukebox.repositories.SongsRepository;

public class SongsService implements ISongsService {

    private final SongsRepository songsRepository;
    public SongsService(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    @Override
    public List<Songs> loadSongs(String filename) throws FileNotFoundException{
        // File filePath = Paths.get(Thread.currentThread().getContextClassLoader().getResource(filename).toURI()).toFile();
        String filePath = "/home/crio-user/workspace/rahulnath847-ME_OBJECT_MODELING_V2/" + filename;
        List<Songs> lsongs = new ArrayList<>();
        String line;
        String delimiter = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                List<String> t = Arrays.stream(values[5].split("#")).collect(Collectors.toList());
                Songs song = new Songs(values[0],values[1],values[2],values[3],values[4],t);
                songsRepository.save(song);
            }
            lsongs = songsRepository.findSongs();
        } catch (IOException e) {
            throw new FileNotFoundException("File not found!");
        }
        return lsongs;
    }
    
   
}
