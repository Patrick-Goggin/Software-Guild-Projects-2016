/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the searchor.
 */


$('#search-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
        $.ajax({
            type: 'POST',
            url: 'dvd',
// Build a JSON object from the data in the form 
            data: JSON.stringify({
                title: $('#search-title').val(),
                director: $('#search-director').val(),
                studio: $('#search-studio').val(),
                rating: $('#search-rating').val(),
                year: $('#search-year').val,
                note: $('#search-note').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'}).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary table
            $('#search-title').val(),
                    $('#search-director').val();
            $('#search-studio').val();
            $('#search-rating').val();
            $('#search-year').val;
            $('#search-note').val();

            loadLibrary();

            return false;
        });

    });