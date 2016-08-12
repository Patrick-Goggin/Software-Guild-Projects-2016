<%-- 
    Document   : inputFormFragment
    Created on : 1-Aug-2016, 7:37:12 PM
    Author     : apprentice
--%>

<form>
    Add a hashtag (one at a time):<br>
    <input type="text" name="hashtag" id="hashtag">    
    <button id="hashtagButton">Add</button>
</form>

<form id="inputForm" role="form">
    
    <textarea id="editor1" name="editor1"></textarea><br>
    
   
    
    <div class="row">
    <div id="formBottom"> 
    <div id="formRight">
       <div id="textRight">
    Enter a heading for the article: <br><input type="text" id="articleHead" name="articleHead"><br>
    This entry is meant to be a new:<br>
    <input type="radio" name="staticPage" value="false">Blog Post<br>
    <input type="radio" name="staticPage" value="true">Static Page<br>
     </div>
    </div><!--FORM RIGHT-->    
    
   
    
    <div id="formLeft">
    Pick the Active Status of the Article:
    <br>
    <input type="radio" name="activeStatus" value="3" checked="checked">Queued for Approval<br>
    <input type="radio" name="activeStatus" value="2">Approved, Awaiting Post Date<br>
    <input type="radio" name="activeStatus" value="1">Active<br>
    <br>
    </div><!--FORMLEFT-->
    
    </div><!--formBottom-->
    </div><!--/ROW-->
    
        
    
    

    <div class="row">
        <div id="formBottom">
    <div id="calendars">
    
    <div class="calendar" id="calendar1">
Select posting date:<br>
    <input type="date" name="postDate" id="postDate"/><br>
    Select take-down date:<br>
    <input type="date" name="takeDown" id="takeDown"/>
    </div><!--calendar-->
    
    <div class="calendar"id="calendar2">

    </div><!--calendar2-->
    
    </div><!--calendars-->
</div><!--formBottom-->    
    </div><!--row-->


    <br>
  <!--  <div class="row">-->
    <div id="buttonDiv">
    <button type="submit" id="postButton">Submit</button>
</div><!--buttonDiv-->

</div><!--row-->
</form>

