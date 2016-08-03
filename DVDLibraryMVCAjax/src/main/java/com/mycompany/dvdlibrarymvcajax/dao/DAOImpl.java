/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarymvcajax.dao;

import com.mycompany.dvdlibrarymvcajax.dto.DVD;
import com.mycompany.dvdlibrarymvcajax.dto.SearchTerm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DAOImpl implements DAO {

    private String file;
    private String title;
    private String director;
    private int year;
    private String rating;
    private String studio;
    private int dvdId;
    private HashMap<Integer, DVD> library = new HashMap<Integer, DVD>();
    private HashMap<Integer, HashMap<Integer, String>> notesMap = new HashMap<Integer, HashMap<Integer, String>>();
    private static int dvdIdCounter = 0;

    public DAOImpl() {
        this.library = library;
        this.notesMap = notesMap;
    }

    @Override
    public List<DVD> searchLibrary(Map<SearchTerm, String> criteria) {
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String yearCriteria = criteria.get(SearchTerm.YEAR);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String ratingCriteria = criteria.get(SearchTerm.RATING);

        Predicate<DVD> titleMatches;
        Predicate<DVD> directorMatches;
        Predicate<DVD> yearMatches;
        Predicate<DVD> studioMatches;
        Predicate<DVD> ratingMatches;

        Predicate<DVD> truePredicate = (DVD c) -> {
            return true;
        };

        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getTitle().equals(titleCriteria);

        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getDirector().equals(directorCriteria);

        yearMatches = (yearCriteria == null || yearCriteria.isEmpty())
                ? truePredicate
                : (c) -> Integer.toString(c.getYear()).equals(yearCriteria);

        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getStudio().equals(studioCriteria);

        ratingMatches = (ratingCriteria == null || ratingCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getRating().equals(ratingCriteria);

        return library.values().stream()
                .filter(titleMatches
                        .and(directorMatches)
                        .and(yearMatches)
                        .and(studioMatches)
                        .and(ratingMatches))
                .collect(Collectors.toList());

    }

      @Override
    public List<String> getNotes(int dvdId) {
        ArrayList<String> theNotes = new ArrayList<>();
        HashMap<Integer, String> aMap = notesMap.get(dvdId);
        int mapSize = aMap.size();

        for (int i = 1; i < mapSize; i++) {
            String s = aMap.get(i);
            theNotes.add(s);
        }

        return theNotes;

    }
    @Override
    public List<DVD> getLibrary() {

        Collection<DVD> l = library.values();
        //  List<DVD> library = new ArrayList<DVD>(l);
        return new ArrayList<DVD>(l);
    }
// @Override
//    public Contact addContact(Contact contact) {
//        contact.setContactId(contactIdCounter);
//        contactIdCounter++;
//        contactMap.put(contact.getContactId(), contact);
//        return contact;
//    }

    @Override
    public void addDVD(DVD dvd) {
        dvdIdCounter++;
        dvd.setDvdId(dvdIdCounter);
        dvdId = dvd.getDvdId();
        library.put(dvd.getDvdId(), dvd);
        notesMap.put(dvd.getDvdId(), new HashMap<Integer, String>());
        int noteId = 0;
                notesMap.get(dvdId).put(0, "");
       
        if (dvd.getNote() == null || dvd.getNote().equals("")) {
            return;
        } else {
            notesMap.get(dvd.getDvdId()).put(notesMap.get(dvdId).size(), dvd.getNote());
        }

    }

    @Override
    public void addNote(int dvdId, String note) {
        int noteId = notesMap.get(dvdId).size()+1;
        //noteId = notesMap.get(dvdid)
        notesMap.get(dvdId).put(noteId, note);
       
//        DVD d = library.get(dvd.getDvdId());
//        HashMap<Integer, String> notes = d.getNotes();
//        String note = d.getNote();
//        int noteId = notes.size()+1;
//        notes.put(noteId, note);

        //  fw.writeLibrary(library, file); 
    }

    @Override
    public void updateDVD(DVD dvd) {
        dvdId = dvd.getDvdId();
      //  title = dvd.getTitle();

        library.put(dvdId, dvd);
       // return dvd;
    }
//@Override
//    public int getStock(String itemName) {
//        int stock = inventory.get(itemName).getStock();
//        return stock;
//    }

  

    @Override
    public void removeNote(int dvdId, int noteId) {

       notesMap.get(dvdId).remove(noteId);

    }

    @Override
    public void editNote(DVD dvd) {
int dvdId = dvd.getDvdId();
int noteId = dvd.getNoteId();
String note = dvd.getNote();

        notesMap.get(dvdId).put(noteId, note);

    }
    
    @Override
    public DVD getNote(int dvdId, int noteId) {
       String note = notesMap.get(dvdId).get(noteId);
       DVD dvd = library.get(dvdId);
       dvd.setNote(note);
       
       dvd.setNoteId(noteId);
        return dvd;

    }
    

    @Override
    public void removeDVD(int dvdId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        library.remove(dvdId);
        //fw.writeLibrary(library, file); 
    }

    @Override
    public DVD getDVD(int dvdId) {
        DVD dvd = library.get(dvdId);

        return dvd;
    }


    @Override
    public void testLibrary() {

        DVD dvd = new DVD();
        dvd.setTitle("A");
        dvd.setDirector("A");
        dvd.setRating("G");
        dvd.setYear(1);
        dvd.setStudio("A");
        dvd.setNote("note");
        dvd.setDvdId(1);

        addDVD(dvd);
        addNote(1, "AAA");
        addNote(1, "AAA");
        addNote(1, "AAA");
      
      
       

        DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");

        dvd2.setDvdId(2);

        addDVD(dvd2);
        addNote(2, "BBB");
        addNote(2, "BBB");
        addNote(2, "BBB");
        
        
        DVD dvd3 = new DVD();
        dvd3.setTitle("C");
        dvd3.setDirector("C");
        dvd3.setRating("PG-13");
        dvd3.setYear(3);
        dvd3.setStudio("C");

        dvd3.setDvdId(3);

        addDVD(dvd3);
        addNote(3, "CCC");
        addNote(3, "CCC");
        addNote(3, "CCC");

    }

}
