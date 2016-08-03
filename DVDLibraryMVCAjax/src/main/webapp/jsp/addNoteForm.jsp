<%-- 
    Document   : addNoteForm
    Created on : 26-Jul-2016, 10:09:23 AM
    Author     : apprentice
--%>

<form class="form-horizontal" role="form">
    <div class="form-group">
        <label for="add-note" class="col-md-4 control-label">
            Note:
        </label>
        <div class="col-md-8">
            <input type="text" class="form-control" id="addNote-note"
                   placeholder="Note"/>
        </div>
    </div>
    <input type="hidden" id="addNote-id">
    <input type="hidden" id="addNote-dvdId">
    <div class="form-group">
        <div class="col-md-offset-4 col-md-8">
            <button type="submit" id="addNote-button" class="btn btn-default">
                Submit
            </button>


        </div>
    </div>
</form>
