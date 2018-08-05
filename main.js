$(document).ready(function () {

    $("#btnSubmit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    // Get form
    var form = $('#fileUploadForm')[0];

    var data = new FormData(form);

    data.append("CustomField", "This is some extra data, testing");

    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        type: "GET",
        enctype: 'multipart/form-data',
        url: "/getreviews",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        // success: function (data) {
        //
        //     $("#result").text(data);
        //     console.log("SUCCESS : ", data);
        //     $("#btnSubmit").prop("disabled", false);
        //
        // },

      success: function(data){
        $.each(data, function( index, value ) {
          var row = $("<td>" + value.author + "</td><td>" + value.name + "</td><td>" + value.count + "</td>");
          $("#myData").append(row);
        });
      },
        error: function (e) {

            $("#result").text(e.toString());
            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);

        }
    });

}