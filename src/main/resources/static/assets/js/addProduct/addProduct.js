function validate() {
    var check = true;
    let productName = $("#productName").val();
    let weight = $("#weight").val();
    let categoryProduct = $("#categoryProduct").val();
    let image = $("#image").val();
    let Brands = $("#Brands").val();
    let productPrice = $("#productPrice").val();
    let inStock = $("#inStock").val();

    if (!categoryProduct) {
        $("#errorcategoryProduct").html("categoryProduct name is required");
        $("#categoryProduct").addClass("is-invalid");
        check = false;
    } else {
        $("#categoryProduct").removeClass("is-invalid");
    }
    if (!image) {
        $("#errorimage").html("image name is required");
        $("#image").addClass("is-invalid");
        check = false;
    } else {
        $("#image").removeClass("is-invalid");
    }
    if (!Brands) {
        $("#errorBrands").html("Brands name is required");
        $("#Brands").addClass("is-invalid");
        check = false;
    } else {
        $("#Brands").removeClass("is-invalid");
    }
    if (!productName) {
        $("#errorproductName").html("productName name is required");
        $("#productName").addClass("is-invalid");
        check = false;
    } else {
        $("#productName").removeClass("is-invalid");
    }
    if (!weight) {
        $("#errorweight").html("weight name is required");
        $("#weight").addClass("is-invalid");
        check = false;
    } else {
        $("#weight").removeClass("is-invalid");
    }
    if (!inStock) {
        $("#errorinStock").html("inStock name is required");
        $("#inStock").addClass("is-invalid");
        check = false;
    } else {
        $("#inStock").removeClass("is-invalid");
    }

    if (!productPrice) {
        $("#errorproductPrice").html("productPrice is required");
        $("#productPrice").addClass("is-invalid");
        check = false;
    } else if(productPrice<=0){
        $("#errorproductPrice").html("productPrice have to >0");
        $("#productPrice").addClass("is-invalid");
        check = false;
    }
    else {
        $("#productPrice").removeClass("is-invalid");
    }
    return check;
}
$(document).ready(function() {
    $("#addProduct").submit(function(e) {
        let check = validate();
        if (check == false) {
            e.preventDefault();
        }
    });
});
