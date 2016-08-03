/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarymvcajax.dao;
import com.mycompany.dvdlibrarymvcajax.dto.User;
import com.mycompany.dvdlibrarymvcajax.dto.DVD;
import com.mycompany.dvdlibrarymvcajax.dto.SearchTerm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DAO {
 public List<DVD> getLibrary();
 public List<DVD> searchLibrary(Map<SearchTerm, String> criteria);
public List <String> getNotes(int dvdId);
public void addNote(int dvdId, String s);      
public void removeNote(int dvdId, int noteId);
public void editNote(DVD dvd);
public void addDVD(DVD dvd);
public void removeDVD(int dvdId);
public DVD getNote(int dvdId, int noteId);
public DVD getDVD(int dvdId);    
public void updateDVD(DVD dvd);
public void testLibrary();
}

