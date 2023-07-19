package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.List;

public interface ICommand {
    void execute(List<String> tokens) throws URISyntaxException;
}
