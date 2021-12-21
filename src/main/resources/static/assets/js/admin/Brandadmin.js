function validate() {
    var check = true;
    let Name = $("#Name").val();
    let category = $("#category").val();

    if (!category) {
        $("#errorcategory").html("category  is required");
        $("#category").addClass("is-invalid");
        check = false;
    } else {
        $("#category").removeClass("is-invalid");
    }

    if (!Name) {
        $("#errorName").html("Name  is required");
        $("#Name").addClass("is-invalid");
        check = false;
    } else {
        $("#Name").removeClass("is-invalid");
    }
    return check;

}
$(document).ready(function() {
    $("#addBrand").submit(function(e) {
        let check = validate();
        if (check == false) {
            e.preventDefault();
        }
    });
});
