<%-- 
    Document   : editNoteDiv
    Created on : 25-Jul-2016, 11:02:55 AM
    Author     : apprentice
--%>
<form class="form-horizontal" role="form">
    <div class="form-group">
        <label for="edit-note" class="col-md-4 control-label">
            Note:
        </label>
        <div class="col-md-8">
            <input type="text" class="form-control" id="edit-note-note"
                   placeholder="Note"/>
        </div>
    </div>
    <input type="hidden" id="edit-note-id">
    <input type="hidden" id="edit-note-dvdId">
    <div class="form-group">
        <div class="col-md-offset-4 col-md-8">
            <button type="submit" id="edit-note-button" class="btn btn-default">
                Submit
            </button>


        </div>
    </div>
</form>
