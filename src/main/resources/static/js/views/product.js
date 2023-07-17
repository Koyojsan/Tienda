//CREATE AND UPDATE
const serviceEntity = "product";
const idNameToUse = "idproduct";
let listOfEntities = products;
let defaultEntity = productDefault;

$(document).on("click", "#btnSearch", function () {
    const currentUrl = document.location.href;
    const url = new URL(currentUrl);
    url.searchParams.set("lowerPrice", $('#inputLowerPrice').val());
    url.searchParams.set("higherPrice", $('#inputHigherPrice').val());
    window.location.href = url.href;
})

const currentUrl = document.location.href;
const url = new URL(currentUrl);
$('#inputLowerPrice').val(url.searchParams.get("lowerPrice"));
$('#inputHigherPrice').val(url.searchParams.get("higherPrice"));