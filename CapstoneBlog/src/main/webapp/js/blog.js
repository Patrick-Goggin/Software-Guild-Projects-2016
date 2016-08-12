// Document ready function
$(document).ready(function () {
    loadActiveArticles();
    loadActiveStaticPages();
    //var element = new CKEDITOR.dom.element
    showArticles();
    $('<a>').focus(function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    $('<div>').focus(function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    $('.staticNav').on("click", function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    $('#aStaticPage').on("click", function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    $('#staticLink').on("click", function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    $('#staticLink').focus(function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    $('.staticNav').focus(function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    $('#aStaticPage').focus(function () {
        $(this).css("background", "rgba(61, 0, 102, 100%)");
    });
    loadArticlesForReview();
    $('#staticPage').hide();
    $('#hashtagButton').click(function (event) {
        event.preventDefault();
        alert($('#hashtag').val());
        if(($('#hashtag').val().substring(0,1)) === ('#')){
            $('#hashtag').val($('#hashtag').val().substring(1));
        alert($('#hashtag').val());
        }
        
        $('#hashtag').val('');
        $('#hashtag').empty();
      
    });
});



////////***************************************////////////////////


$('#postButton').click(function () {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
    var C = CKEDITOR.instances.editor1.getData();
    CKEDITOR.instances["editor1"].setData('');
//CKEDITOR.instances.editor1.setData('');
  //  alert(C);
  var pDate = $("#postDate").val();
  var tDate = $("#takeDownDate").val();
  var static = $("input[type='radio'][name='staticPage']:checked").val();
  var head = $('#articleHead').val();
  var status = $("input[type='radio'][name='activeStatus']:checked").val();
 $('#inputDiv').hide();
  $('#inputDiv').show();
 //$('#inputForm').reset();
      
  $('textarea.editor1').val('');
  //$('#inputForm').reset();
  $('input[type=date]')[0].value = 0;
  $('#postDate').hide();
  $('#postDate').value(0);
  //$('input[type=date]').reset();
    //var postOn = $("#datepicker").datepicker("getDate");
    //var postOn2 = $("#datepicker2").datepicker("getDate");
    $.ajax({
        type: 'POST',
        url: 'article',
        data: JSON.stringify({
            articleBody: C,
            staticPage: static /*$("input[type='radio'][name='staticPage']:checked").val()*/,
            activeStatus: status /*$("input[type='radio'][name='activeStatus']:checked").val()*/,
            articleHead: head /*$('#articleHead').val()*/,
            postingDate: pDate /*$("#postDate").val()*/,
            takeDownDate: tDate /*$("#takeDown").val()*/
            
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'}).success(function (data, status) {
        $('textarea.editor1').val('');
        
        CKEDITOR.instances.editor1.setData("");
        loadActiveStaticPages();
        loadArticlesForReview();
        loadActiveArticles();
        $('#innerRight').html(data);
        $('#editor1').val('');
        $('editor1').val('');
        $('#articleHead').val('');
     
        $('#editor1').empty();
        $('#hashtag').empty();
        $('#articleHead').empty();
        $('#testForm').trigger("reset");
        CKEDITOR.instances.editor1.reset();
//        CKEDITOR.instances.editor1.hide();
//        CKEDITOR.instances.editor1.show();
        //CKEDITOR.instances.editor1.clearCustomData();
        var form = document.getElementById("inputForm");
       
        return false;
    });
}
);

function focus() {
    $(this).focus();
}

function clearForm() {
    $('#inputDiv').empty();
    $('#editor1').empty();
    $('#hashtag').empty();
    $('#articleHead').empty();
    $('editor1').empty();
    $('hashtag').empty();
    $('articleHead').empty();
}

function hideInputForm() {
    $('#inputDiv').hide();

}
function showInputForm() {
    $('#inputDiv').show();
};

function loadActiveArticles() {
    var adiv = $('#articleDiv');
// Make an Ajax GET call to the 'contacts' endpoint. Iterate through // each of the JSON objects that are returned and render them to the // summary table.
    $.ajax({
        url: "activeArticles"}).success(function (data, status) {
        showActiveArticles(data, status);
    });
}
function loadActiveStaticPages() {
    var adiv = $('#articleDiv');
// Make an Ajax GET call to the 'contacts' endpoint. Iterate through // each of the JSON objects that are returned and render them to the // summary table.
    $.ajax({
        url: "staticPages"}).success(function (data, status) {
        showActiveStaticPages(data, status);
    });
}
function showActiveStaticPages(activeStaticPages, status) {
    $.each(activeStaticPages, function (index, article) {
//        $('#staticPages').append($('<a>')
//                .attr({
//                    'id': 'staticLink' + ' ' +article.articleID,
//                   
//                    'class': 'staticNav',
//                    'data-article-id': article.articleID,
//                    'data-article-body': article.articleBody,
//                    'data-article-head': article.articleHead,
//                    'data-article-activeStatus': article.activeStatus,
//                    'data-article-postingDate': article.postingDate,
//                    'data-article-takeDownDate': article.takeDownDate,
//                    'data-article-staticPage': article.staticPage,
//                    'data-target': '#staticLink',
//                    'onclick': 'showStaticPage(' + article.articleID + ')'
//
//                })
//                .append($('<div>')
//                        .attr({'id': 'aStaticPage'})
//                        .text(article.articleHead))
//                );
        $('#dropDown').append($('<li>')
                .append($('<a>')

                        .attr({'data-article-id': article.articleID,
                            'data-article-body': article.articleBody,
                            'data-article-head': article.articleHead,
                            'data-article-activeStatus': article.activeStatus,
                            'data-article-postingDate': article.postingDate,
                            'data-article-takeDownDate': article.takeDownDate,
                            'data-article-staticPage': article.staticPage,
                            'data-target': '#staticLink',
                            'onclick': 'showStaticPage(' + article.articleID + ')'

                        }).text(article.articleHead)));
//          <ul class="dropdown-menu" id="dropDown">
//                                    <li><a href="#">Action</a></li>
//                                    <li><a href="#">Another action</a></li>
//                                    <li><a href="#">Something else here</a></li>
//                                    <li role="separator" class="divider"></li>
//                                    <li class="dropdown-header">Nav header</li>
//                                    <li><a href="#">Separated link</a></li>
//                                    <li><a href="#">One more separated link</a></li>
//                                </ul>
    });
}


function showStaticPage(articleID) {
    $('#articleDiv').hide();
    $('#right').hide();
    $('#static').empty();
    $('#staticPage').show();
    $.ajax({
        type: 'GET',
        url: 'article/' + articleID
    }).success(function (article) {
        $('#static').append($('<div>')
                .attr({
                    'id': 'headDiv'
                })
                .text(article.articleHead))
                .append($('<div>').attr({
                    'id': 'bodyDiv'
                }).html(article.articleBody));
    });}

function loadArticlesForReview() {
    var adiv = $('#articleDiv');
    $.ajax({
        url: "articlesForReview"}).success(function (data, status) {
        showArticlesForReview(data, status);
    });
}

function showArticlesForReview(articlesForReview, status) {
    $('#review').show();
    $('#review').empty();
    $.each(articlesForReview, function (index, article) {
        $('#review').append($('<div>')
                .attr({
                    'id': 'oneArticleForReview',
                    'data-article-id': article.articleID,
                    'data-article-body': article.articleBody,
                    'data-article-head': article.articlHead,
                    'data-article-activeStatus': article.activeStatus,
                    'data-target': '#oneArticleForReview'
                })
                .append($('<div>')
                        .attr({
                            'id': 'reviewHead',
                            'data-article-id': article.articleID,
                            'data-article-body': article.articleBody,
                            'data-article-head': article.articlHead,
                            'data-article-activeStatus': article.activeStatus,
                            'data-target': '#reviewHead'
                        }).html(article.articleHead + '<br>'))
                .append($('<div>')
                        .attr({
                            'id': 'reviewBody',
                            'data-article-id': article.articleID,
                            'data-article-body': article.articleBody,
                            'data-article-head': article.articlHead,
                            'data-article-activeStatus': article.activeStatus,
                            'data-target': '#reviewBody'
                        }).html(article.articleBody))
                .append($('<a>')
                        .attr({'id': 'approve'})
                        .append($('<div>')
                                .attr({'class': 'approveButton button',
                                    'id': 'linkDiv',
                                    'data-article-id': article.articleID,
                                    'data-article-body': article.articleBody,
                                    'data-article-head': article.articlHead,
                                    'data-article-activeStatus': article.activeStatus,
                                    'data-target': '#linkDiv',
                                    'onclick': 'approveArticle(' + article.articleID + ');'})
                                .text('approve'))).append($('<hr>')));
    });

}
;
//    'onclick': 'loadNotes(' + dvd.dvdId + ')'})
function approveArticle(articleID) {
    $.ajax({
        type: 'POST',
        url: 'approve',
        data: JSON.stringify({
            'articleID': articleID
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'}).success(function (data, status) {
        $('#review').empty();
        $('#articleDiv').empty();
        loadActiveArticles();
        showActiveArticles();

        loadArticlesForReview();
        showArticlesForReview();
    });
    $('#review').empty();
    $('#articleDiv').empty();
    loadActiveArticles();
    loadArticlesForReview();
}

function showArticles() {
    $('#articleDiv').empty();
    loadArticlesForReview();
    showArticlesForReview();
    loadActiveArticles();
    showActiveArticles();
    $('#articleDiv').show();

}

function showActiveArticles(activeArticles, status) {
    $('#articleDiv').show();
    $('#articleDiv').empty();
    //   var aDiv = $('#articleDiv');
    $.each(activeArticles, function (index, article) {
        $('#articleDiv').append($('<div>')
                .attr({
                    'id': 'oneArticle',
                    'data-article-id': article.articleID,
                    'data-article-body': article.articleBody,
                    'data-article-head': article.articleHead,
                    'data-article-activeStatus': article.activeStatus,
                    'data-article-postingDate': article.postingDate,
                    'data-article-takeDownDate': article.takeDownDate,
                    'data-article-staticPage': article.staticPage,
                    'data-target': '#oneArticle'
                }).append($('<div>')
                .attr({'id': 'headDiv',
                    'data-article-id': article.articleID,
                    'data-article-body': article.articleBody,
                    'data-article-head': article.articleHead,
                    'data-article-activeStatus': article.activeStatus,
                    'data-article-postingDate': article.postingDate,
                    'data-article-takeDownDate': article.takeDownDate,
                    'data-article-staticPage': article.staticPage,
                    'data-target': '#headDiv'}).html(article.articleHead))
                .append($('<div>')
                        .attr({'id': 'bodyDiv',
                            'data-article-id': article.articleID,
                            'data-article-body': article.articleBody,
                            'data-article-head': article.articleHead,
                            'data-article-activeStatus': article.activeStatus,
                            'data-article-postingDate': article.postingDate,
                            'data-article-takeDownDate': article.takeDownDate,
                            'data-article-staticPage': article.staticPage,
                            'data-target': '#bodyDiv'})
                        .html('<br>' + article.articleBody))
                .append($('<div>')
                        .attr({
                            'id': 'editRemove'
                        })
                        .append($('<a>')
                                .attr({
                                    'id': 'editLink',
                                    'class': 'button',
                                    'data-article-id': article.articleID,
                                    'data-article-body': article.articleBody,
                                    'data-article-head': article.articleHead,
                                    'data-article-activeStatus': article.activeStatus,
                                    'data-article-postingDate': article.postingDate,
                                    'data-article-takeDownDate': article.takeDownDate,
                                    'data-article-staticPage': article.staticPage,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')
                                )
                        .append($('<a>')
                                .attr({
                                    'id': 'removeLink',
                                    'class': 'button',
                                    'data-article-id': article.articleID,
                                    'data-article-body': article.articleBody,
                                    'data-article-head': article.articlHead,
                                    'data-target': '#removeLink',
                                    'onclick': 'removeArticle(' + article.articleID + ');'
                                })
                                .text('Remove')
                                )
                        ).append($('<div>').attr({'id': 'topLeft'}))
                .append($('<div>').attr({'id': 'topRight'}))
                .append($('<div>').attr({'id': 'bottomLeft'}))
                .append($('<div>').attr({'id': 'bottomRight'})))
                ;
    });
}
;

function removeArticle(articleID) {
    var answer = confirm("Delete article?");
    $.ajax({
        type: 'DELETE',
        url: 'removeArticle/' + articleID
    }).success(function () {
        loadActiveArticles();
        loadArticlesForReview();
    });
}

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var articleID = element.data('article-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'article/' + articleID
    }).success(function (article) {
        modal.find('#edit-article-id').val(article.articleID);
        modal.find('#edit-article-head').val(article.articleHead);
        //   modal.find('#edit-article-body').val(article.articleBody);
        modal.find('#edit-article-posting-date').val(article.postingDate);
        modal.find('#edit-article-take-down-date').val(article.takeDownDate);
        modal.find('#edit-article-active-status').val(article.activeStatus);
        //modal.find('#edit-article-static-page').val(article.staticPage);
        CKEDITOR.instances["edit-article-body"].setData(article.articleBody);
    });
});


$('#edit-button').click(function (event) {

    event.preventDefault();

    var C = CKEDITOR.instances.editor2.getData();
    var id = $('#edit-article-id').val();
    $.ajax({
        type: 'POST',
        url: 'article/' + id,
        data: JSON.stringify({
            articleId: $('#edit-article-id').val(),
            articleHead: $('#edit-article-head').val(),
            articleBody: C,
            postingDate: $('#edit-article-posting-date').val(),
            takeDownDate: $('#edit-article-take-down-date').val(),
            staticPage: $("input[type='radio'][name='staticPage']:checked").val(),
            activeStatus: $("input[type='radio'][name='activeStatus']:checked").val()
//<input type="text" id="edit-article-take-down-date">
//                    <input type="text" id="edit-article-posting-date">
//                    <input type="text" id="edit-article-static-page">
//                    <input type="text" id="edit-article-active-status">
//                    <input type="text" id="edit-article-article-id">
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadActiveArticles();
    });
});
$('#search-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
    $.ajax({
        type: 'GET',
        url: 'search/' + $('#search-hashtag').val(),
        data: JSON.stringify({
            hashtag: $('#search-hashtag').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#search-hashtag').val('');
        $('#search-article-id').val('');
        $('#search-article-head').val('');
        $('#search-article-body').val('');
        showActiveArticles(data, status);
    });
});


function loadAllHashtags() {
    $.ajax({
        url: "allHashtags"}).success(function (data, status) {
        showAllHashtags(data, status);
    });
}

function showAllHashtags(allHashtags, status) {
    $('#allHashtags').show();
    event.preventDefault();
    $('#allHashTags').empty();
    $.each(allHashtags, function (index, hashtag) {
     //   alert(hashtag);
        $('#allHashtags').append($('<a>')
                .attr({
                    'id': 'hashtag',
                    // 'class': 'button',
                    'data-article-articleHead': hashtag,
                    'data-target': '#hashtag',
                    'onclick': 'searchByHashtag(' + '"' + hashtag + '"' + ');'
                })
                .text('#'+hashtag));
    });

}
function searchByHashtag(hashtag) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    //alert(hashtag);

    $('#search-hashtag').val(hashtag);
  //  alert(hashtag);
    $.ajax({
        type: 'GET',
        url: 'search/' + hashtag,
        data: JSON.stringify({
            hashtag: hashtag
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        showActiveArticles(data, status);
    });
}
;