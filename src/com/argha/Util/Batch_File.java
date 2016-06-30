/*
 * Copyright (C) 2016 Argha
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.argha.Util;

import com.argha.Dialogs.Error;
import com.argha.Dialogs.Log_Box;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Argha
 */
public class Batch_File implements File_Interface {

    Error error = new Error(new javax.swing.JFrame(), true);
    Log_Box log_box = new Log_Box(new javax.swing.JFrame(), true);
    
    String NAME, LOCATION, TYPE, CONTENTS;
    
    public Batch_File(String l, String n, String t, String c)
    {
        LOCATION = l;
        NAME = n;
        TYPE = t;
        CONTENTS = c;
        
        Over_Write(LOCATION, NAME, TYPE);
        Writer(LOCATION, NAME, TYPE, CONTENTS);
        Check(LOCATION, NAME, TYPE);
    }
    
    @Override
    public void Writer(String location, String name, String type, String contents) {
        
        FileWriter fw;
        File f;
        
        try {
            f = new File (location+name+type);
            fw = new FileWriter (f);
            fw.append(contents);
            fw.flush();
            fw.close();
        }
        catch (IOException ic){
            log_box.log_msg.setText(ic.toString());
        }
    }

    @Override
    public void Check(String location_check, String name_check, String type_check) {
        
        File f = new File (location_check + name_check + type_check);
        if(f.exists()){
            log_box.log_msg.setText("File has been created to "+location_check+" " + name_check+" " + type_check+"\n"
                    + "\nLocation :- "+location_check
                    + "\nName :- "+name_check
                    + "\nType :- "+type_check);
            
            log_box.show();
        }
        else {
            error.error_msg.setText(" Error :- Failed to write file "+location_check+" " + name_check+" " + type_check+"\n"
                    + "\nLocation :- "+location_check
                    + "\nName :- "+name_check
                    + "\nType :- "+type_check+"\n"
                    + "\n"
                    + "Fix :- Try again");
            
            error.show();
        }
        
    }

    @Override
    public void Run_Bat(String locate, String locate_name, String locate_type ) {
        
    }
    
    public void Over_Write(String location, String name , String loc){
        
        File over = new File (location+name+loc);
        if (over.exists()){
            over.delete();
        }
    }
}
