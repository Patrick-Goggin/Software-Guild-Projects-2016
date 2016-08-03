<%-- 
    Document   : addDVDFragment
    Created on : 23-Jul-2016, 3:12:11 PM
    Author     : apprentice
--%>
<div id="addDvdDiv">
    <h3>Add a DVD to the Library</h3>
    <br>
 <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-title"
                                       placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-4 control-label">
                                Director:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-director"
                                       placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-year" class="col-md-4 control-label">Year:</label>
                            <div class="col-md-8">
                                <input type="number" class="form-control" id="add-year"
                                       placeholder="Year"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-rating" class="col-md-4 control-label">Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-rating"
                                       placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
     <div class="form-group">
                            <label for="add-studio" class="col-md-4 control-label">Notes:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-note"
                                       placeholder="Enter a note here"/>
                            </div>
                        </div>
                      
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                               <button type="submit" id="add-button" class="btn btn-default">
                                    ADD
                                </button>
                             
      
                            </div>
                        </div>
                    </form>
</div>