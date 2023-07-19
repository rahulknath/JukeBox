// package com.crio.jukebox.entities;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
// import com.crio.jukebox.exceptions.FileNotFoundException;
// import com.crio.jukebox.repositories.SongsRepository;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// @DisplayName("PlayListTest")
// public class PlayListTest {
    
//     private SongsRepository songsRepository;

//     @BeforeEach
//     void setup() throws FileNotFoundException{
//         String filePath = "/home/crio-user/workspace/rahulnath847-ME_OBJECT_MODELING_V2/songs.csv";
//         String line;
//         String delimiter = ",";
//         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//             while ((line = br.readLine()) != null) {
//                 String[] values = line.split(delimiter);
//                 List<String> t = Arrays.stream(values[5].split("#")).collect(Collectors.toList());
//                 Songs song = new Songs(values[0],values[1],values[2],values[3],values[4],t);
//                 songsRepository.save(song);
//             }
//         } catch (IOException e) {
//             throw new FileNotFoundException("File not found!");
//         }
//     }


//     @Test
//     @DisplayName("checkIfSongs are added to the list properly or not")
//     public void checkIfSongs_are_added_to_the_list()
//     {
//         PlayList pl = new PlayList();
        
//     }

//     @Test
//     @DisplayName("checkIfSongs are deleted to the list properly or not")
//     public void chechIfSongs_are_deleted_from_the_list()
//     {
        
//     }
// }
