// Document ready function
$(document).ready(function () {


});

////////***************************************////////////////////
$(function () {
    tinymce.init({
        selector: "myTextarea",
        statusbar: false,
        setup: function (editor) {
            editor.on('change', function () {
                tinymce.triggerSave();
            });
        }
    });

//
//    $('#postButton').click(function () {
//// we don’t want the button to actually submit
//// we'll handle data submission via ajax
//        event.preventDefault();
//// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
//               var $c = tinyMCE.activeEditor.getContent();
//                var msg = '';
//                  
//     
//        $('myTextarea').each(function (index, ta) {
//            var $ta = $(ta);
//            msg += $ta.val();
//            var $c = tinyMCE.activeEditor.getContent('myTextarea');
//     
//        $.ajax({
//            type: 'POST',
//            url: 'article',
//            data: JSON.stringify({
//                articleBody: $c
//
//            }),
//            headers: {
//                'Accept': 'application/json',
//                'Content-Type': 'application/json'
//            },
//            'dataType': 'json'}).success(function (data, status) {
//            $('#innerRight').html(data);
//            $('#myTextarea').val('');
//            
//
//            return false;
//        });   });
//    });
//});

function getHTML()
{
   tinymce.activeEditor.on('#postButton', function(e) {
     console.log(e.content);
        $.ajax({
            type: 'POST',
            url: 'article',
            data: JSON.stringify({
                articleBody: e.content

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'}).success(function (data, status) {
            $('#innerRight').html(data);
            $('#myTextarea').val('');
            

            return false;
        }); 
     
   });
}});