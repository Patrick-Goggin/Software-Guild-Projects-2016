// Document ready function
$(document).ready(function () {
    $("#container").hide();
    $("#container").show();
    $("#searchDiv").hide();
    $("#editNoteDiv").hide();
    //loadLibrary();
    hideSearchDiv();
    $("#addDiv").hide();
    $("#editDiv").hide();
    $("#addNoteDiv").hide();
    $('#add-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
        $.ajax({
            type: 'POST',
            url: 'dvd',
// Build a JSON object from the data in the form 
            data: JSON.stringify({
                title: $('#add-title').val(),
                director: $('#add-director').val(),
                year: $('#add-year').val(),
                rating: $('#add-rating').val(),
                studio: $('#add-studio').val(),
                note: $('#add-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'}).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary table
            $('#add-title').val('');
            $('#add-director').val('');
            $('#add-year').val('');
            $('#add-rating').val('');
            $('#add-studio').val('');
            $('#add-note').val('');
            $("#addDiv").hide();
            loadLibrary();
            return false;
        });
    });

    $('#edit-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
        $.ajax({
            type: 'PATCH',
            url: 'edit/' + $('#edit-dvd-id').val(),
// Build a JSON object from the data in the form 
            data: JSON.stringify({
                dvdId: $('#edit-dvd-id').val(),
                title: $('#edit-title').val(),
                director: $('#edit-director').val(),
                studio: $('#edit-studio').val(),
                rating: $('#edit-rating').val(),
                year: $('#edit-year').val(),
                note: $('#edit-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'}).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary table
            $('#edit-dvd-id').val('');
            $('#edit-title').val('');
            $('#edit-director').val('');
            $('#edit-year').val('');
            $('#edit-rating').val('');
            $('#edit-studio').val('');
            $('#edit-note').val('');
            $("#editDiv").hide();
            loadLibrary();
            return false;
        });
    });
    $('#search-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
        $.ajax({
            type: 'POST',
            url: 'search/library',
            data: JSON.stringify({
                title: $('#search-title').val(),
                director: $('#search-director').val(),
                year: $('#search-year').val(),
                rating: $('#search-rating').val(),
                studio: $('#search-studio').val(),
                note: $('#search-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#search-title').val('');
            $('#search-director').val('');
            $('#search-year').val('');
            $('#search-studio').val('');
            $('#search-rating').val('');
            $("#searchDiv").hide();
            $('#libraryDiv').show();
            fillLibraryDiv(data, status);
        });
    });

    $('#edit-note-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
        $.ajax({
            type: 'PATCH',
            url: 'editNote/' + $('#edit-note-dvdId').val() + '/' + $('#edit-note-id').val(),
            data: JSON.stringify({
                note: $('#edit-note-note').val(),
                noteId: $('#edit-note-id').val(),
                dvdId: $('#edit-note-dvdId').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#edit-note-dvdId').val('');
            $('#edit-note-id').val('');
            $('#edit-note-note').val('');
            $("#editNoteDiv").hide();
            loadLibrary();
            return false;
        });
    });
    $('#addNote-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
        $.ajax({
            type: 'PUT',
            url: 'addNote/' + $('#addNote-dvdId').val(),
            data: JSON.stringify({
                note: $('#addNote-note').val(),
                dvdId: $('#addNote-dvdId').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#addNote-dvdId').val('');

            $('#addNote-note').val('');

            $('#addNoteDiv').hide();

            loadLibrary();
            return false;
        });
    });
});
//======================
//FUNCTIONZZZZZZZZZZZZZZ
//======================
function showAddDiv() {
    $("#libraryDiv").hide();
    $("#editDiv").hide();
    $("#searchDiv").hide();
    $("#addDiv").show();
}


function hideAddDiv() {
    $("#addDiv").hide();
}

function loadSearch() {
    clearLibraryDiv();
    var searchDiv = $('#searchDiv');
// Make an Ajax GET call to the 'contacts' endpoint. Iterate through // each of the JSON objects that are returned and render them to the // summary table.
    $.ajax({
        url: "search"}).success(function (data, status) {
        fillSearchDiv(data, status);
    });
}

function hideSearchDiv() {

    $("#searchDiv").hide();
//     document.getElementById(searchDiv).style.visibility = "hidden";
//    document.getElementById('#searchDiv').style.visibility = "hidden";
//    document.getElementById('searchDiv').style.visibility = "hidden";
//   choiceButtons.style.display = "none";

}

function showSearchDiv(data, status) {
    $("#addDiv").hide();
    $("#editDiv").hide();
    $("#libraryDiv").hide();
    $("#searchDiv").show();
}


function loadLibrary() {
    hideSearchDiv();
    $("#addDiv").hide();
    $("#editDiv").hide();
    $("#editNotesDiv").hide();
    $("#addNoteDiv").hide();
    $("#searchDiv").hide();
    $("#notesDiv").hide();
    $("#libraryDiv").show();
    clearLibraryDiv();
    var libraryDiv = $('#libraryDiv');
// Make an Ajax GET call to the 'contacts' endpoint. Iterate through // each of the JSON objects that are returned and render them to the // summary table.
    $.ajax({
        url: "library"}).success(function (data, status) {
        fillLibraryDiv(data, status);
    });
}

function loadNotes(dvdId) {
    clearEditDiv();
    clearNotesDiv;
    $.ajax({
        type: 'POST',
        url: 'notes/' + dvdId}).success(function (data, status) {
        fillNotesDiv(data, status, dvdId);
    });
}


function fillLibraryDiv(libraryList, status) {

// clear the previous list
    clearLibraryDiv();
    // grab the tbody element that will hold the new list of contacts
    var lDiv = $('#libraryDiv');
    // render the new contact data to the table
    $.each(libraryList, function (index, dvd) {
        $('#libraryDiv').append($('<div>')

                .attr({
                    'id': 'dvdDiv',
                    'data-dvd-id': dvd.dvdId,
                    'data-dvd-title': dvd.title,
                    'data-dvd-director': dvd.director,
                    'data-dvd-year': dvd.year,
                    'data-dvd-rating': dvd.rating,
                    'data-dvd-studio': dvd.studio,
                    'data-dvd-notes': dvd.notes,
                    'data-target': '#dvdDiv'
                })


                .append($('<div>')
                        .attr({
                            'id': 'titleDiv',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.notes,
                            'data-target': '#titleDiv'
                        }).text('Title: ' + dvd.title))
                .append($('<div>')
                        .attr({
                            'id': 'pictureDiv',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.notes,
                            'data-dvd-pictureUrl': dvd.pictureUrl,
                            'data-target': '#pictureDiv'
                        }).append($('<img id="moviePic" src="/DVDLibraryMVCAjax'+ dvd.pictureUrl +'">')))
                .append($('<div>')
                        .attr({
                            'id': 'directorDiv',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.notes,
                            'data-target': '#directorDiv'
                        }).text('Director: ' + dvd.director))
                .append($('<div>')
                        .attr({
                            'id': 'yearDiv',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.notes,
                            'data-target': '#yearDiv'
                        }).text('Year: ' + dvd.year))
                .append($('<div>')
                        .attr({
                            'id': 'ratingDiv',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.notes,
                            'data-target': '#ratingDiv'
                        }).text('Rating: ' + dvd.rating))
                .append($('<div>')
                        .attr({
                            'id': 'studioDiv',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.notes,
                            'data-target': '#studioDiv'
                        }).text('studio: ' + dvd.studio))
                .append($('<a>')
                        .attr({
                            'id': 'notes',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.notes,
                            'data-target': '#notes',
                            'onclick': 'loadNotes(' + dvd.dvdId + ')'})
                        .append($('<div>')
                                .attr({
                                    'id': 'button',
                                    'data-dvd-id': dvd.dvdId,
                                    'data-dvd-title': dvd.title,
                                    'data-dvd-director': dvd.director,
                                    'data-dvd-year': dvd.year,
                                    'data-dvd-rating': dvd.rating,
                                    'data-dvd-studio': dvd.studio,
                                    'data-dvd-notes': dvd.notes,
                                    'data-target': '#button',
                                    'onclick': 'loadNotes(' + dvd.dvdId + ')'})
                                .text('Notes'))
                        ).append($('<br>'))
                .append($('<div>')
                        .attr({
                            'id': 'linkDiv',
                            'data-dvd-id': dvd.dvdId,
                            'data-dvd-title': dvd.title,
                            'data-dvd-director': dvd.director,
                            'data-dvd-year': dvd.year,
                            'data-dvd-rating': dvd.rating,
                            'data-dvd-studio': dvd.studio,
                            'data-dvd-notes': dvd.note,
//                            'data-dvd-pictureUrl': dvd.pictureUrl,
                            'data-target': '#linkDiv'
                        })
                        .append($('<a>')
                                .attr({
                                    'id': 'editLink',
                                    'data-dvd-id': dvd.dvdId,
                                    'data-dvd-title': dvd.title,
                                    'data-dvd-director': dvd.director,
                                    'data-dvd-year': dvd.year,
                                    'data-dvd-rating': dvd.rating,
                                    'data-dvd-studio': dvd.studio,
                                    'data-dvd-notes': dvd.note,
//                                    'data-dvd-pictureUrl': dvd.pictureUrl,
                                    'data-target': '#editLink',
                                    'onclick': 'loadEditDiv(' + dvd.dvdId + ')'
                                })
                                .text('Edit'))
                        .append($().text('|'))
                        .append($('<a>')
                                .attr({
                                    'id': 'deleteLink',
                                    'data-dvd-id': dvd.dvdId,
                                    'data-target': '#deleteLink',
                                    'onclick': 'deleteDVD(' + dvd.dvdId + ')'
                                })
                                .text('Delete'))
                        )



                );
    });
}
;

function clearLibraryDiv() {
    $('#libraryDiv').empty();
}

function deleteDVD(dvdId) {
    var answer = confirm("Do you really want to delete this dvd?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'removeDVD/' + dvdId
        }).success(function () {
            loadLibrary();
        });
    }
}

function deleteNote(dvdId, index) {
    var answer = confirm("Do you really want to delete this note?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'removeNote/' + dvdId + '/' + index
        }).success(function () {
            loadLibrary();
        });
    }

}


// Clear all content rows from the summary table
function clearNotesDiv() {
    $('#notesDiv').empty();
}


//function loadNotes(dvdId) {
//
// 
//    $.ajax({
//        type: 'POST',
//        url: 'notes/' + dvdId})
//            .success(function (data, status) {
//        fillNotesDiv(data, status, dvdId);
//    });
//    
//}


function fillNotesDiv(notesList, status, dvdId) {
    $("#editDiv").hide();
// clear the previous list
    clearLibraryDiv();
    clearEditDiv();
    clearNotesDiv();
    // grab the tbody element that will hold the new list of contacts

    // render the new contact data to the table
    $.each(notesList, function (index, note) {
        $('#libraryDiv').append($('<br>' + '<div>')
                .attr({'id': 'noteDiv'})
                .append($('<div>'))
                .attr({
                    'id': 'number',
                    'data-note-id': index,
                    'data-note-dvdId': dvdId
                })
                .append($('<div>')
                        .attr({'id': 'note'})

                        .text('Note #' + '  ' + (index + 1))))
                .append($('<div>')

                        .attr({'id': 'note',
                            'data-note-id': index})
                        .text(note))
                .append($('<a>')
                        .attr({
                            'id': 'editNoteLink',
                            'data-note-id': index,
                            'data-note-note': note,
                            'data-note-dvdId': dvdId,
                            'data-target': '#editNoteLink',
                            'onclick': 'loadEditNote(' + dvdId + ',' + '(' + index + ')' + ')'
                        })
                        .text('Edit'))
                .append($('<a>')
                        .attr({
                            'id': 'deleteNoteLink',
                            'data-note-id': index,
                            'data-note-dvdId': dvdId,
                            'data-note-note': note,
                            'data-target': '#deleteNoteLink',
                            'onclick': 'deleteNote(' + dvdId + ',' + '(' + index + ')' + ')'

                        })
                        .text('delete'))
                ;
    });
    $('#libraryDiv').append($('<br>'))
            .append($('<a>')
                    .attr({
                        'id': 'addLink',
                        'data-addNote-dvdId': dvdId,
                        'data-target': '#addLink',
                        'onclick': 'showAddNoteDiv(' + dvdId + ')'
                    })

                    .text('ADD'));
}
;
function loadEditNote(dvdId, index) {
    $.ajax({
        type: 'POST',
        url: 'getNote/' + dvdId + '/' + index
    }).success(function (data, status) {
        showEditNote(data, status);
    });
}
function showEditNote(dvd, status) {
    $('#libraryDiv').hide();
    $('#notesDiv').hide();
    $('#searchDiv').hide();
    $('#addDiv').hide();
    $("#editNoteDiv").show();

    var element = $(event.relatedTarget);
// Grab the contact id
//    var dvdId = element.data('note-dvdId');
//    var noteId = element.data('note-id');
    $('#edit-note-id').val(dvd.noteId);
    $('#edit-note-note').val(dvd.note);
    $('#edit-note-dvdId').val(dvd.dvdId);
}
;


function showAddNoteDiv(dvdId) {
    $("#addNoteDiv").show();
    $("#addDiv").hide();
    $("#editDiv").hide();
    $("#editNotesDiv").hide();
    $("#searchDiv").hide();
    $("#notesDiv").hide();
    $("#libraryDiv").hide();
    $.ajax({
        type: 'POST',
        url: 'addNoteForm/' + dvdId}).success(function (data, status) {
        fillAddNoteForm(data, status);
    });
}


function fillAddNoteForm(dvd, status) {


    // var element = $(event.relatedTarget);
//    var dvdId = element.data('dvdId');
//    var noteId = element.data('id');


    $('#addNote-dvdId').val(dvd.dvdId);
    $('#addNote-note').val(dvd.note);


}



function fillItemDiv(item, status) {
    // clear the previous list
    clearMoneyDiv();
    // grab the tbody element that will hold the new list of contacts
    var mDiv = $('#itemDiv');
    // render the new contact data to the table
    $('#itemDiv').append("$" + item.stock.size);
    //.text(funds.money); 
}
;
// Clear all content rows from the summary table
function clearItemDiv(status) {
    $('#itemDiv').empty();
}

function test() {
    $.ajax({
        type: 'GET',
        url: "test"}).success(function (data, status) {
        loadLibrary();
    });
}
function clearEditDiv() {
    $('#itemDiv').empty();
}

function loadEditDiv(dvdId) {
    $("#searchDiv").hide();
    $("#libraryDiv").hide();
    //hideSearchDiv();
    $("#addDiv").hide();

    clearEditDiv();


    $.ajax({
        type: 'POST',
        url: 'showEdit/' + dvdId}).success(function (data, status) {
        fillEditDiv(data, status);
    });
}

//$('#editModal').on('show.bs.modal', function (event) {
//// Get the element that triggered this event - in our case it is a contact
//// name link in the summary table. This link has an attribute that contains
//// the contactId for the given contact. We'll use that to retrieve the
//// contact's details.
//    var element = $(event.relatedTarget);
//// Grab the contact id
//    var contactId = element.data('contact-id');
//// PLACEHOLDER: Eventually we'll make an ajax call to the server to get the
//// details for this contact but for now we'll load the dummy
//// data
//    var modal = $(this);
//    $.ajax({
//        type: 'GET',
//        url: 'contact/' + contactId
//    }).success(function (contact) {
//        modal.find('#contact-id').text(contact.contactId);
//        modal.find('#edit-contact-id').val(contact.contactId);
//        modal.find('#edit-first-name').val(contact.firstName);
//        modal.find('#edit-last-name').val(contact.lastName);
//        modal.find('#edit-company').val(contact.company);
//        modal.find('#edit-email').val(contact.email);
//        modal.find('#edit-phone').val(contact.phone);
//    });
//});

function fillEditDiv(dvd, status) {
    $('#libraryDiv').hide();
    $('#searchDiv').hide();
    $('#addDiv').hide();
    $('#editDiv').show();
    var element = $(event.relatedTarget);
// Grab the contact id
    var dvdId = element.data('dvd-id');

    $('#edit-dvd-id').val(dvd.dvdId);
    $('#edit-title').val(dvd.title);
    $('#edit-director').val(dvd.director);
    $('#edit-year').val(dvd.year);
    $('#edit-rating').val(dvd.rating);
    $('#edit-studio').val(dvd.studio);

}

