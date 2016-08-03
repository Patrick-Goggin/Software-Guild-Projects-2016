<%-- 
    Document   : editDivFragment
    Created on : 23-Jul-2016, 8:00:37 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form class="form-horizontal" role="form">
    <div class="form-group">
        <label for="edit-title" class="col-md-4 control-label">
            Title:
        </label>
        <div class="col-md-8">
            <input type="text" class="form-control" id="edit-title"
                   placeholder="Title"/>
        </div>
    </div>
    <div class="form-group">
        <label for="edit-director" class="col-md-4 control-label">
            Director:
        </label>
        <div class="col-md-8">
            <input type="text" class="form-control" id="edit-director"
                   placeholder="Director"/>
        </div>
    </div>
    <div class="form-group">
        <label for="edit-year" class="col-md-4 control-label">Year:</label>
        <div class="col-md-8">
            <input type="number" class="form-control" id="edit-year"
                   placeholder="Year"/>
        </div>
    </div>
    <div class="form-group">
        <label for="edit-rating" class="col-md-4 control-label">Rating:</label>
        <div class="col-md-8">
            <input type="text" class="form-control" id="edit-rating"
                   placeholder="Rating"/>
        </div>
    </div>
    <div class="form-group">
        <label for="edit-studio" class="col-md-4 control-label">Studio:</label>
        <div class="col-md-8">
            <input type="text" class="form-control" id="edit-studio"
                   placeholder="Studio"/>
        </div>
    </div>
    <input type="hidden" id="edit-dvd-id">
    <div class="form-group">
        <div class="col-md-offset-4 col-md-8">
            <button type="submit" id="edit-button" class="btn btn-default">
                Submit
            </button>


        </div>
    </div>
</form>
