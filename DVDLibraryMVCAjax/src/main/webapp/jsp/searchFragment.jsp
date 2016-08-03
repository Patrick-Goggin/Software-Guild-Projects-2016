<%-- 
    Document   : searchFragment
    Created on : 23-Jul-2016, 2:58:26 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-title"
                                       placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-director" class="col-md-4 control-label">
                                Director:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-director"
                                       placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-year" class="col-md-4 control-label">Year:</label>
                            <div class="col-md-8">
                                <input type="number" class="form-control" id="search-year"
                                       placeholder="Year"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-rating" class="col-md-4 control-label">Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-rating"
                                       placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
                      
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="search-button" class="btn btn-default">
                                    Search
                                </button>
                             
      
                            </div>
                        </div>
                    </form>
