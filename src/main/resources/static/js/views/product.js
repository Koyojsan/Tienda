//CREATE AND UPDATE

//Esto no es JS puro
//DOM = igual a todo el documento web, apea el ID de Productos y lo obtiene de bases de Datos
$(document).on("click", ".open-modal", function () {
    const currentProductId = Number($(this).attr('idproduct'));

    if (currentProductId) {
        const currentProduct = products.find(x => x.id === currentProductId); //Encuentra un id para el producto, se podria decir que es similar a un autoincremento
        $("#id").val(currentProduct.id);
        $("#id_categoria").val(currentProduct.id_categoria);
        $("#descripcion").val(currentProduct.descripcion);
        $("#detalle").val(currentProduct.detalle);
        $("#precio").val(currentProduct.precio);
        $("#existencias").val(currentProduct.existencias);
        $("#ruta_imagen").val(currentProduct.ruta_imagen);
    }
});

$(document).on("click", "#saveProduct", function () {
    $("#formProduct").submit();
})

//Delete
$(document).on("click", ".btnDeleteProduct", function () {
    const currentProductId = Number($(this).attr('idproduct'));
    const currentProduct = products.find(x => x.id === currentProductId);
    $.ajax({
        url: 'product/delete',
        contentType: "application/json",
        dataType: 'json',
        type: 'POST',
        success: function (result) {
            location.reload();
        },
        //here we are serialization the object
        data: JSON.stringify(currentProduct)
    });
})