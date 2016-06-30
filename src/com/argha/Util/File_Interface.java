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

/**
 *
 * @author Argha
 */
public interface File_Interface {
    
    public void Writer (String location , String name , String type, String contents); //This method is for writing the file
    
    public void Check (String location_check , String name_check , String type_check); // This method is for checking some of the file details which was created
    
    public void Run_Bat (String locate, String locate_name, String locate_type); //This method is for running the file
    
}
