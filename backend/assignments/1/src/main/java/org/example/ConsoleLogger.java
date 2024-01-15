package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleLogger {
    private static final Logger ls = LoggerFactory.getLogger(ConsoleLogger.class);

    public static void infoMethod(String logString){
        ls.info(logString);
    }


}
