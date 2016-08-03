/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarymvcajax.controller;

import com.mycompany.dvdlibrarymvcajax.dao.DAO;
import com.mycompany.dvdlibrarymvcajax.dto.DVD;
import com.mycompany.dvdlibrarymvcajax.dto.SearchTerm;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.TITLE;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.DIRECTOR;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.STUDIO;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.RATING;
import static com.mycompany.dvdlibrarymvcajax.dto.SearchTerm.YEAR;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class SearchController {
    
     

    @Inject
    public SearchController(DAO dao) {
        this.dao = dao;
    }
    DAO dao;
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }

    @RequestMapping(value = "search/library", method = RequestMethod.POST)
    @ResponseBody
    public List<DVD> searchLibrary(@RequestBody Map<String, String> searchMap) {
        // Create the map of search criteria to send to the DAO
        HashMap<SearchTerm, String> criteriaMap = new HashMap<>();

        // Determine which search terms have values, translate the String
        // keys into SearchTerm enums, and set the corresponding values
        // appropriately.
        
       // TITLE, DIRECTOR, YEAR, RATING, STUDIO
        String currentTerm = searchMap.get("title");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(TITLE, currentTerm);
        }
        currentTerm = searchMap.get("director");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(DIRECTOR, currentTerm);
        }
        currentTerm = searchMap.get("year");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(YEAR, currentTerm);
        }
        currentTerm = searchMap.get("rating");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(RATING, currentTerm);
        }
        currentTerm = searchMap.get("studio");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(STUDIO, currentTerm);
        }
        

        return dao.searchLibrary(criteriaMap);
    }
}