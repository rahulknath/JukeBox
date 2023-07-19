package com.crio.jukebox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.jukebox.appConfig.ApplicationConfig;
import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.exceptions.NoSuchCommandException;



public class App {
    // To run the application  ./gradlew run --args="INPUT_FILE=jukebox-input.txt"
    public static PlayList currentPlayList;
    public static Songs currentSong;
    
	public static void main(String[] args) throws NoSuchCommandException, URISyntaxException{
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        String expectedSequence = "INPUT_FILE";
        String actualSequence = commandLineArgs.stream()
                .map(a -> a.split("=")[0])
                .collect(Collectors.joining("$"));
        
        if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        }
	}
    
    public static void run(List<String> commandLineArgs) throws NoSuchCommandException, URISyntaxException{
    // Complete the final logic to run the complete program.
    ApplicationConfig applicationConfig = new ApplicationConfig();
    CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
    BufferedReader reader;
    String inputFile = commandLineArgs.get(0).split("=")[1];
    commandLineArgs.remove(0);
    try {
        reader = new BufferedReader(new FileReader(inputFile));
        String line = reader.readLine();
        while (line != null) {
            List<String> tokens = Arrays.asList(line.split(" "));
            commandInvoker.executeCommand(tokens.get(0),tokens);
            // read next line
            line = reader.readLine();
        }
        reader.close();
    } catch (IOException | NoSuchCommandException | URISyntaxException e) {
        e.printStackTrace();
    }
    }
}
