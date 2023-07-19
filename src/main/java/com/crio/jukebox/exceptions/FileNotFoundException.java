package com.crio.jukebox.exceptions;

import java.io.IOException;

public class FileNotFoundException extends IOException{
    public FileNotFoundException()
    {
     super();
    }
    public FileNotFoundException(String msg)
    {
     super(msg);
    }  
}
