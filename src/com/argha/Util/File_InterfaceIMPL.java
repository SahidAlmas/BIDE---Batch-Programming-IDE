package com.argha.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class File_InterfaceIMPL implements File_Interface {
    @Override
    public void Writer(String location, String name, String type, String contents) {

    }

    @Override
    public void Check(String location_check, String name_check, String type_check) {

    }

    @Override
    public void Run_Bat(String location) {
        try {
            runSomething("start cmd/k "+location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String runSomething(String cmdLine) throws Exception {
        cmdLine = "cmd /c " +cmdLine;
        Process process =
                new ProcessBuilder("bash", "-c", cmdLine)
                        .redirectErrorStream(true)
                        .directory(new File("."))
                        .start();


        BufferedReader br = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        String output= "";
        while ((line = br.readLine()) != null)
            output += line;
        output += "\n";

        return output;

    }
}
