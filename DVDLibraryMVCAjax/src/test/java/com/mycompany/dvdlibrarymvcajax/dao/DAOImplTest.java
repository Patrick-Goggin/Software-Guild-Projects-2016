/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarymvcajax.dao;

import com.mycompany.dvdlibrarymvcajax.dto.DVD;
import com.mycompany.dvdlibrarymvcajax.dto.SearchTerm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DAOImplTest {

    private DAO dao;

    public DAOImplTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("dao", DAO.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of searchLibrary method, of class DAOImpl.
     */
    @Test
    public void testSearchLibrary() {
//        System.out.println("searchLibrary");
//        Map<SearchTerm, String> criteria = null;
//        DAOImpl instance = new DAOImpl();
//        List<DVD> expResult = null;
//        List<DVD> result = instance.searchLibrary(criteria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotes method, of class DAOImpl.
     */
    @Test
    public void testGetNotes() {
        DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");

        

        dao.addDVD(dvd2);
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        
        assertEquals(3, dao.getNotes(dvd2.getDvdId()).size());
        //assertEquals("BBB", dao.getNotes(dvd2.getDvdId()).get(0));
    
    }

    /**
     * Test of getLibrary method, of class DAOImpl.
     */
    @Test
    public void testGetLibrary() {
        DVD dvd = new DVD();
        dvd.setTitle("A");
        dvd.setDirector("B");
        dvd.setRating("G");
        dvd.setYear(1);
        dvd.setStudio("C");
        dvd.setNote("D");
      
        DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");

        dao.addDVD(dvd);
        dao.addDVD(dvd2);
        assertEquals(2, dao.getLibrary().size());
    }

    /**
     * Test of addDVD method, of class DAOImpl.
     */
//    DVD dvd = new DVD();
//        dvd.setTitle("A");
//        dvd.setDirector("B");
//        dvd.setRating("G");
//        dvd.setYear(1);
//        dvd.setStudio("C");
//        dvd.setNote("D");
//        dvd.setDvdId(1);
//
//        addDVD(dvd);
//        addNote(1, "A");
//      
//      
//       
//
//        DVD dvd2 = new DVD();
//        dvd2.setTitle("B");
//        dvd2.setDirector("B");
//        dvd2.setRating("G");
//        dvd2.setYear(2);
//        dvd2.setStudio("B");
//
//        dvd2.setDvdId(2);
//
//        addDVD(dvd2);
//        addNote(2, "BBB");
//        addNote(2, "BBB");
//        addNote(2, "BBB");
//        
//        
//        DVD dvd3 = new DVD();
//        dvd3.setTitle("C");
//        dvd3.setDirector("C");
//        dvd3.setRating("PG-13");
//        dvd3.setYear(3);
//        dvd3.setStudio("C");
//
//        dvd3.setDvdId(3);
//
//        addDVD(dvd3);
//        addNote(3, "CCC");
//        addNote(3, "CCC");
//        addNote(3, "CCC");
    @Test
    public void testAddDVD() {
        DVD dvd = new DVD();
        dvd.setTitle("A");
        dvd.setDirector("B");
        dvd.setRating("G");
        dvd.setYear(1);
        dvd.setStudio("C");
        dvd.setNote("D");
        dvd.setDvdId(1);

        dao.addDVD(dvd);

        assertEquals(1, dao.getLibrary().size());
        assertEquals(dvd, dao.getDVD(dvd.getDvdId()));
    }

    /**
     * Test of addNote method, of class DAOImpl.
     */
    @Test
    public void testAddNote() {
     DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");

        

        dao.addDVD(dvd2);
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        
        assertEquals(3, dao.getNotes(dvd2.getDvdId()).size());
        assertTrue(dao.getNote(dvd2.getDvdId(), 2).getNote().equals("BBB"));
    }

    /**
     * Test of updateDVD method, of class DAOImpl.
     */
    @Test
    public void testUpdateDVD() {
      
    }

    /**
     * Test of removeNote method, of class DAOImpl.
     */
    @Test
    public void testRemoveNote() {
        DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");

        

        dao.addDVD(dvd2);
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        
        assertEquals(3, dao.getNotes(dvd2.getDvdId()).size());
        dao.removeNote(dvd2.getDvdId(), dvd2.getNoteId());
        assertEquals(2, dao.getNotes(dvd2.getDvdId()).size());
    }

    /**
     * Test of editNote method, of class DAOImpl.
     */
    @Test
    public void testEditNote() {
       DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");

        

        dao.addDVD(dvd2);
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        
        dvd2.setNoteId(2);
        dvd2.setNote("PooP");
        dao.editNote(dvd2);
        assertEquals("PooP", dao.getNote(dvd2.getDvdId(), 2).getNote());
    }

    /**
     * Test of getNote method, of class DAOImpl.
     */
    @Test
    public void testGetNote() {
        DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");

        

        dao.addDVD(dvd2);
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        dao.addNote(dvd2.getDvdId(), "BBB");
        
        dvd2.setNoteId(2);
        dvd2.setNote("PooP");
        dao.editNote(dvd2);
        assertEquals("PooP", dao.getNote(dvd2.getDvdId(), 2).getNote());
    }

    /**
     * Test of removeDVD method, of class DAOImpl.
     */
    @Test
    public void testRemoveDVD() {
     DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");
        dao.addDVD(dvd2);
        
        dao.removeDVD(dvd2.getDvdId());
        assertNull(dao.getDVD(dvd2.getDvdId()));
    }

    /**
     * Test of getDVD method, of class DAOImpl.
     */
    @Test
    public void testGetDVD() {
      DVD dvd2 = new DVD();
        dvd2.setTitle("B");
        dvd2.setDirector("B");
        dvd2.setRating("G");
        dvd2.setYear(2);
        dvd2.setStudio("B");
        dao.addDVD(dvd2);
        
        assertEquals(dao.getDVD(dvd2.getDvdId()), dvd2);
    }

    /**
     * Test of titleSearch method, of class DAOImpl.
     */
//    @Test
//    public void testTitleSearch() {
//      
//    }
//
//    /**
//     * Test of directorSearch method, of class DAOImpl.
//     */
//    @Test
//    public void testDirectorSearch() {
//        
//    }
//
//    /**
//     * Test of ratingSearch method, of class DAOImpl.
//     */
//    @Test
//    public void testRatingSearch() {
//        
//    }
//
//    /**
//     * Test of yearSearch method, of class DAOImpl.
//     */
//    @Test
//    public void testYearSearch() {
//        
//    }
//
//    /**
//     * Test of pastNyears method, of class DAOImpl.
//     */
//    @Test
//    public void testPastNyears() {
//      
//    }
//
//    /**
//     * Test of averageAge method, of class DAOImpl.
//     */
//    @Test
//    public void testAverageAge() {
//        
//    }
//
//    /**
//     * Test of oldest method, of class DAOImpl.
//     */
//    @Test
//    public void testOldest() {
//       
//    }
//
//    /**
//     * Test of newest method, of class DAOImpl.
//     */
//    @Test
//    public void testNewest() {
//       
//    }
//
//    /**
//     * Test of averageNotes method, of class DAOImpl.
//     */
//    @Test
//    public void testAverageNotes() {
//        
//    }
//
//    /**
//     * Test of testLibrary method, of class DAOImpl.
//     */
//    @Test
//    public void testTestLibrary() {
//      
//    }

}
