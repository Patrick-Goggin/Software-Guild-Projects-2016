/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarymvcajax.dao;

import com.mycompany.dvdlibrarymvcajax.dto.DVD;
import com.mycompany.dvdlibrarymvcajax.dto.SearchTerm;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.DIRECTOR;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.RATING;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.STUDIO;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.TITLE;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.YEAR;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DAODbImpl implements DAO {

    private static final String SQL_INSERT_DVD
            = "insert into DVDs (title, director, year, rating, studio, note) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD
            = "delete from DVDs where dvdId = ?";
    private static final String SQL_SELECT_DVD
            = "select * from DVDs where dvdId = ?";
    private static final String SQL_UPDATE_DVD
            = "update DVDs set title = ?, director = ?, year = ?, rating = ?, studio = ? where dvdId = ?";
    private static final String SQL_SELECT_ALL_DVDS
            = "select * from DVDs";
    private static final String SQL_SELECT_DVDS_BY_TITLE
            = "select * from DVDs where title = ?";
    private static final String SQL_SELECT_DVDS_BY_DIRECTOR
            = "select * from DVDs where director = ?";
    private static final String SQL_SELECT_DVDS_BY_YEAR
            = "select * from DVDs where year = ?";
    private static final String SQL_SELECT_DVDS_BY_RATING            
            = "select * from DVDs where rating = ?";
    private static final String SQL_SELECT_DVDS_BY_STUDIO            
            = "select * from DVDs where studio = ?";
    private static final String SQL_SELECT_DVDS_BY_ANY
            = "select * from DVDs where title = '?' OR director = '?' OR year = '?' OR rating = '?' OR studio = '?"; 
    private static final String SQL_SEARCH_DVDS
            ="select * from DVDs where "
            + "title like ? and "
            + "director like ? and "
            + "year like ? and "
            + "rating like ? and "
            + "studio like ?";

    // #2a - Declare JdbcTemplate reference - the instance will be handed to us by Spring
    private JdbcTemplate jdbcTemplate;
    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // #3 - Wrap addContact in a transaction so the we are guaranteed to get the
    // correct LAST_INSERT_ID for our row.
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addDVD(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getDirector(),
                dvd.getYear(),
                dvd.getRating(),
                dvd.getStudio(),
                dvd.getNote(),
                dvd.getPictureUrl());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));
        //   return dvd;
    }

    @Override
    public void removeDVD(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public DVD getDVD(int dvdId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD,
                    new DVDMapper(), dvdId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just want to
            // return null in this case
            return null;
        }
    }

    @Override
    public List<DVD> getLibrary() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DVDMapper());
    }

    @Override
    public void editNote(DVD dvd) {

    }

//    public void updateContact(Contact contact) {
//        jdbcTemplate.update(SQL_UPDATE_CONTACT,
//                contact.getFirstName(),
//                contact.getLastName(),
//                contact.getCompany(),
//                contact.getPhone(),
//                contact.getEmail(),
//                contact.getContactId());
//    }
    @Override
    public void updateDVD(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getDirector(),
                dvd.getYear(),
                dvd.getRating(),
                dvd.getStudio(),
                dvd.getDvdId());
                

        
        //return dvd;
    }

    @Override
    public List<String> getNotes(int dvdId) {
        ArrayList<String> theNotes = new ArrayList<>();
        HashMap<Integer, String> aMap = new HashMap<Integer, String>()/*notesMap.get(dvdId)*/;
        int mapSize = aMap.size();

        for (int i = 1; i < mapSize; i++) {
            String s = aMap.get(i);
            theNotes.add(s);
        }

        return theNotes;

    }

    @Override
    public void removeNote(int dvdId, int noteId) {

        // notesMap.get(dvdId).remove(noteId);
    }

    @Override
    public DVD getNote(int dvdId, int noteId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD,
                    new DVDMapper(), dvdId);
        } catch (EmptyResultDataAccessException ex) {
            // String note = notesMap.get(dvdId).get(noteId);
            // DVD dvd = library.get(dvdId);
            // dvd.setNote(note);
            //DVD dvd = new DVD();
            //dvd.setNoteId(noteId);
            return null;
        }

    }

    @Override
    public List<DVD> searchLibrary(Map<SearchTerm, String> criteria) {
        
        
        List<DVD> titleResults = jdbcTemplate.query(SQL_SELECT_DVDS_BY_TITLE, new DVDMapper(), criteria.get(SearchTerm.TITLE));
        List<DVD> directorResults = jdbcTemplate.query(SQL_SELECT_DVDS_BY_DIRECTOR, new DVDMapper(), criteria.get(SearchTerm.DIRECTOR));
        List<DVD> yearResults = jdbcTemplate.query(SQL_SELECT_DVDS_BY_YEAR, new DVDMapper(), criteria.get(SearchTerm.YEAR));
        List<DVD> ratingResults = jdbcTemplate.query(SQL_SELECT_DVDS_BY_RATING, new DVDMapper(), criteria.get(SearchTerm.RATING));
        List<DVD> studioResults = jdbcTemplate.query(SQL_SELECT_DVDS_BY_STUDIO, new DVDMapper(), criteria.get(SearchTerm.STUDIO));
          
        
        HashMap<Integer, DVD> resultsMap = new HashMap<>();
          
          titleResults.stream()
                  .forEach(d -> resultsMap.put(d.getDvdId(), d));
          
          directorResults.stream()
                  .forEach(d -> resultsMap.put(d.getDvdId(), d));
          
          yearResults.stream()
                  .forEach(d -> resultsMap.put(d.getDvdId(), d));
          
          ratingResults.stream()
                  .forEach(d -> resultsMap.put(d.getDvdId(), d));
          
          studioResults.stream()
                  .forEach(d -> resultsMap.put(d.getDvdId(), d));
          
          
          
        ArrayList<DVD> results = new ArrayList<>();
        results.addAll(resultsMap.values());
//        results.addAll(directorResults);
//        results.addAll(yearResults);
//        results.addAll(ratingResults);
//        results.addAll(studioResults);
        
      
//      String titleCriteria = criteria.get(SearchTerm.TITLE);
//        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
//        String yearCriteria = criteria.get(SearchTerm.YEAR);
//        String studioCriteria = criteria.get(SearchTerm.STUDIO);
//        String ratingCriteria = criteria.get(SearchTerm.RATING);
//
//        Predicate<DVD> titleMatches;
//        Predicate<DVD> directorMatches;
//        Predicate<DVD> yearMatches;
//        Predicate<DVD> studioMatches;
//        Predicate<DVD> ratingMatches;
//
//        Predicate<DVD> truePredicate = (DVD c) -> {
//            return true;
//        };
//
//        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getTitle().equals(titleCriteria);
//
//        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getDirector().equals(directorCriteria);
//
//        yearMatches = (yearCriteria == null || yearCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> Integer.toString(c.getYear()).equals(yearCriteria);
//
//        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getStudio().equals(studioCriteria);
//
//        ratingMatches = (ratingCriteria == null || ratingCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getRating().equals(ratingCriteria);
//
//        return library.values().stream()
//                .filter(titleMatches
//                        .and(directorMatches)
//                        .and(yearMatches)
//                        .and(studioMatches)
//                        .and(ratingMatches))
//                .collect(Collectors.toList());
         return results;   
        }

    @Override
    public void addNote(int dvdId, String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testLibrary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class DVDMapper implements RowMapper<DVD> {

        public DVD mapRow(ResultSet rs, int rowNum) throws SQLException {
            DVD dvd = new DVD();
            dvd.setDvdId(rs.getInt("dvdId"));
            dvd.setTitle(rs.getString("title"));
            dvd.setDirector(rs.getString("director"));
            dvd.setYear(rs.getInt("year"));
            dvd.setRating(rs.getString("rating"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setNote(rs.getString("note"));
            dvd.setPictureUrl(rs.getString("pictureUrl"));
            return dvd;
        }
    }

}
