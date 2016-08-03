/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarymvcajax.dto;

import java.util.HashMap;
import java.util.Objects;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {
    
//       private int dvdId;
//    @NotEmpty(message="You must supply a value for First Name")
//    @Length(max=50, message="First Name must be no more than 50 characters in length.")
//    private String title;
//    @NotEmpty(message="You must supply a value for Last Name")
//    @Length(max=50, message="Last Name must be no more than 50 characters in length.")    
//    private String director;
//    @NotEmpty(message="You must supply a value for Company")
//    @Length(max=50, message="Company must be no more than 50 characters in length.")        
//    private String year;
//    @NotEmpty(message="You must supply a value for Phone")
//    @Length(max=10, message="Phone must be no more than 10 characters in length.")        
//    private String rating;
//    @NotEmpty(message="Please enter a valid email address.")
//    @Length(max=50, message="Email must be no more than 50 characters in length.")
//    private String studio;
//    @NotEmpty(message="You must supply a value for Company")
//    @Length(max=50, message="Company must be no more than 50 characters in length.")        
//    private String note;
//    @NotEmpty(message="You must supply a value for Company")
//    @Length(max=50, message="Company must be no more than 50 characters in length.")        

      private String title;
    private String director;
    private int year;
    private String rating;
    private String studio;   
    private int dvdId;
    private String pictureUrl;
//    private ArrayList<String> notes;
    private int noteId;
    //private String notes;
   private HashMap <Integer, String> notes;
    private String note;
    public DVD (){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.studio = studio;
        this.notes = new HashMap<Integer, String> ();
        this.dvdId = dvdId;
        this.note = note;
        this.noteId = noteId;
        this.pictureUrl = pictureUrl;
       // this.notes = new ArrayList<String>();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * @return the notes
     */
    public HashMap <Integer, String> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(HashMap <Integer, String> notes) {
        this.notes = notes;
    }

    /**
     * @return the dvdId
     */
    public int getDvdId() {
        return dvdId;
    }

    /**
     * @param dvdId the dvdId to set
     */
    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the pictureUrl
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * @param pictureUrl the pictureUrl to set
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * @return the noteId
     */
    public int getNoteId() {
        return noteId;
    }

    /**
     * @param noteId the noteId to set
     */
    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
// @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 47 * hash + this.dvdId;
//        hash = 47 * hash + Objects.hashCode(this.title);
//        hash = 47 * hash + Objects.hashCode(this.director);
//        hash = 47 * hash + Objects.hashCode(this.year);
//        hash = 47 * hash + Objects.hashCode(this.rating);
//        hash = 47 * hash + Objects.hashCode(this.studio);
//        hash = 47 * hash + Objects.hashCode(this.note);
//        return hash;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
//        if (this.contactId != other.contactId) {
//            return false;
//        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }      
}
    

