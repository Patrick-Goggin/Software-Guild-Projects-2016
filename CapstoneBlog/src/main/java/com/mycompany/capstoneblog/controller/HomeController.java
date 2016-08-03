/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstoneblog.controller;

import com.mycompany.capstoneblog.dto.Article;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    
//    @Inject
//    public HomeController(DAO dao) {
//        this.dao = dao;
//    }

    //private DAO dao;
    
@RequestMapping(value={"/mainAjaxPage"}, method=RequestMethod.GET)
 public String displayMainAjaxPage() {
 // This method does nothing except return the logical name of the
 // view component (/jsp/home.jsp) that should be invoked in response
 // to this request.
 return "mainAjaxPage";
 }
    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String home(HttpServletRequest req) {

        return "home";
    }
    
    @RequestMapping(value = {"/article"}, method = RequestMethod.POST)
    @ResponseBody
    public String addArticle(@RequestBody Article article) {
        
        return " \"" + article.getArticleBody()+ "\" ";
        
    }
//@RequestMapping(value= {"/searchFragment"}, method = RequestMethod.GET)
//@ResponseBody
//public String showSearch(HttpServletRequest req){
//    return "searchFragment";
//}
//    @RequestMapping(value = "/library", method = RequestMethod.GET)
//    @ResponseBody
//    public List<DVD> getLibrary() {
//        // get all of the Contacts from the data layer
//        List<DVD> libraryList = dao.getLibrary();
//        return libraryList;
//    }
//
//    @RequestMapping(value = "/removeDVD/{dvdId}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void removeDVD(@PathVariable("dvdId") int dvdId) {
//
//        dao.removeDVD(dvdId);
//
//    }
//    
//    @RequestMapping(value = "/removeNote/{dvdId}/{noteId}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void removeNote(@PathVariable("dvdId") int dvdId, @PathVariable("noteId") int noteId) {
//
//        dao.removeNote(dvdId, noteId);
//
//    }
//
//    
////    @RequestMapping(value="/itemStock", method=RequestMethod.GET)
////    @ResponseBody 
////    public Item getItemStock(@PathVariable Item item){
////        String itemName = item.getName();
////        int theStock = dao.getStock(itemName);
////        item.setStock(theStock);
////        return item;
////    }
//    @RequestMapping(value = "/notes/{dvdId}", method = RequestMethod.POST)
//    @ResponseBody
//    public List<String> getNotes(@PathVariable("dvdId") int dvdId) {
////        List<String> notesList = new ArrayList<String>();
//        List<String> notesList = dao.getNotes(dvdId);
// 
//
//        return  notesList;
//    }
//
////    @RequestMapping(value="/displayNotes", method=RequestMethod.GET)
////    public String displayNotes(HttpServletRequest req, Model model){
////       String title = req.getParameter("title");
////        ArrayList<String>notes = dao.getNotes(title);
////       model.addAttribute("notes", notes);
////    return "displayNotes";
////    }
//    @RequestMapping(value = "/addNoteForm/{dvdId}", method = RequestMethod.POST)
//    @ResponseBody
//    public DVD displayAddNoteForm(@PathVariable("dvdId") int dvdId) {
//        
//        DVD dvd = dao.getDVD(dvdId);
//      
//        dvd.setNote("");
//        dvd.setDvdId(dvdId);
//       // d.setDvdId(dvdId);
//        return dvd;
//    }
//
//    @RequestMapping(value = "/addNote/{dvdId}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public DVD addNote(@RequestBody DVD dvd) {
//
//        //int dvdId = dvd.getDvdId();
//        
//        String note = dvd.getNote();
//        
//        int dvdId = dvd.getDvdId();
//        
//        dao.addNote(dvdId, note);
//        DVD d = dao.getDVD(dvdId);
//        return d;
//    }
// 
//    @RequestMapping(value = "/getNote/{dvdId}/{index}", method = RequestMethod.POST)
//    @ResponseBody
//    public DVD getNote(@PathVariable("dvdId") int dvdId, @PathVariable("index") int index) {
//                
//        //int dvdId = dvd.getDvdId();
//      int noteId=index+1;
//        DVD dvd = dao.getNote(dvdId, noteId);
//        
//        //int dvdId = dvd.getDvdId();
//        //dao.addNote(dvdId, note);
//
//        return dvd;
//    }
//
//    @RequestMapping(value = "/displayAddDVDForm", method = RequestMethod.GET)
//    @ResponseBody
//    public String displayAddDVDForm(@RequestBody DVD dvd) {
//        //DVD dvd = new DVD();
//
//      //  model.addAttribute("dvd", dvd);
//
//        return "addDVDForm";
//    }
//
//    @RequestMapping(value = "/dvd", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public DVD addDVD(@RequestBody DVD dvd) {
//        dao.addDVD(dvd);
//
//        return dvd;
//    }
//
//    @RequestMapping(value = "/edit/{dvdid}", method = RequestMethod.GET)
//    @ResponseBody
//    public String displayEditNoteForm(HttpServletRequest req, Model model) {
//
//        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
//
//        int noteId = Integer.parseInt(req.getParameter("noteId"));
//
//        String note = dao.getNotes(dvdId).get(noteId);
//        String title = req.getParameter("title");
//        model.addAttribute("title", title);
//        model.addAttribute("dvdId", dvdId);
//        model.addAttribute("noteId", noteId);
//        model.addAttribute("note", note);
//        return "editNoteForm";
//    }
//
//    @RequestMapping(value = "/editNote/{dvdId}/{noteId}", method = RequestMethod.PATCH)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @ResponseBody
//    public void editNote(@PathVariable("dvdId") int dvdId, @PathVariable("noteId") int noteId, @RequestBody DVD dvd) {
//       // String note = req.getParameter("note");
//        
//        String note = dvd.getNote();
//        dvd.setNoteId(noteId);
//        dvd.setDvdId(dvdId);
////        model.addAttribute("note", note);
////        model.addAttribute("noteId", noteId);
////        model.addAttribute("dvdId", dvdId);
//        dao.editNote(dvd);
//        //return dao.getDVD(dvd.getDvdId());
//    }
//
//    @RequestMapping(value = "/edit/{dvdId}", method = RequestMethod.PATCH)
//    @ResponseBody
//    public DVD editDVD(@PathVariable("dvdId") int dvdId, @RequestBody DVD dvd) {
//        dvd.setDvdId(dvdId);
//
//        dao.updateDVD(dvd);
//        return dao.getDVD(dvdId);
//
//    }
//
//
//    @RequestMapping(value = "/removeNote", method = RequestMethod.GET)
//    @ResponseBody
//    public String removeNote(HttpServletRequest req, Model model) {
//        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
//        int noteId = Integer.parseInt(req.getParameter("noteId"));
//        String title = req.getParameter("title");
//        dao.removeNote(dvdId, noteId);
//
//        return "redirect:displayNotes";
//    }
//
////    @RequestMapping(value = "/displaySearchForm", method = RequestMethod.GET)
////    @ResponseBody
////    public String displaySearchForm(HttpServletRequest req, Model model) {
////
////        return "searchForm";
////    }
//
//    @RequestMapping(value = "/showEdit/{dvdId}", method = RequestMethod.POST)
//    @ResponseBody
//    public DVD displayEditDVDForm(@PathVariable("dvdId") int dvdId) {
//
//        DVD dvd = dao.getDVD(dvdId);
//        return dvd;
//    }
//
//
//
////    @RequestMapping(value="/displayEditContactFormNoAjax", method=RequestMethod.GET)
////    public String displayEditContactFormNoAjax(HttpServletRequest req, Model model){
////        int contactId = Integer.parseInt(req.getParameter("contactId"));
////    Contact c = dao.getContactById(contactId);
////    
////    model.addAttribute("contact", c);
////    return "editContactFormNoAjax";
////    }
//    @RequestMapping(value ={"/test"}, method = RequestMethod.GET)
//    @ResponseBody
//    public List<DVD> test() {
//
//        dao.testLibrary();
//       List<DVD> testLibrary = dao.getLibrary();
//        return testLibrary;
//    }
////@RequestMapping(value="/restock", method=RequestMethod.GET)
////    @ResponseBody
////    public List<Item> restock(){
////     // HashMap<String, Item> inventory = new HashMap<>();
////        
////        dao.restock();
////        return dao.getInventory();
////    
////    }
//}
}
