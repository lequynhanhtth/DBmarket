function validate() {
    var check = true;
    let password = $("#password").val();
    let email = $("#email").val();
    if (!password) {
        $("#errorPassword").html("Password is required");
        $("#password").addClass("is-invalid");
        check = false;
    } else {
        $("#password").removeClass("is-invalid");
    }
    if (!email) {
        $("#errorEmail").html("Email is required");
        $("#email").addClass("is-invalid");
        check = false;
    }
    else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
        $("#errorEmail").html("Email is invalid");
        $("#email").addClass("is-invalid");
        check = false;
    }
    else {
        $("#email").removeClass("is-invalid");
    }
    return check;
}
$(document).ready(function() {
    $("#loginForm").submit(function(e) {
        let check = validate();
        if (check === false) {
            e.preventDefault();
        }
    });
});