package com.kamaii.github.io.botigers;

import java.io.File;

public class configHandler {
    public configHandler(){

        //Start parsing the config
        new File("/config/botigers.yml");
        //We have to parse this jesus christ.
    }
    public File getSQLDatabase(){
        //returns the file path of the sqldatabase specified in botigers.yml
    }
}
