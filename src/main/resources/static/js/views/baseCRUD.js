const apiURL = `api/${serviceEntity}`;

$(document).on("click", ".open-modal", function () {
    //Get the id from the button
    const currentEntityId = Number($(this).attr(idNameToUse));
    if (currentEntityId) {
        //Search the current entity by the id that we got from the button
        const currentEntity = listOfEntities.find(x => x.id === currentEntityId);
        for (const [key, value] of Object.entries(currentEntity)) {
            if (typeof currentEntity[key] === 'object') {
                const subObjectId = `${key}-id`;
                $(`#${subObjectId}`).val(value["id"]);
            } else {
                $(`#${key}`).val(value);
            }
        }
    }
});

$(document).on("click", "#saveEntity", function () {
    for (let [key, value] of Object.entries(defaultEntity)) {

        if (typeof defaultEntity[key] === 'object' && defaultEntity[key] !== null) {
            const subObjectId = `${key}-id`;
            defaultEntity[key]["id"] = $(`#${subObjectId}`).val();
        } else {
            defaultEntity[key] = $(`#${key}`).val();
        }

    }

    $.ajax({
        url: apiURL, contentType: 'application/json', dataType: 'json', type: 'POST', success: function (result) {
            location.reload();
        }, data: JSON.stringify(defaultEntity)
    });
})

//Delete
$(document).on("click", ".btnDeleteEntity", function () {
    const currentEntityId = Number($(this).attr(idNameToUse));
    const currentEntity = listOfEntities.find(x => x.id === currentEntityId);
    $.ajax({
        url: apiURL, contentType: "application/json", dataType: 'json', type: 'DELETE', success: function (result) {
            location.reload();
        }, //here we are serialization the object
        data: JSON.stringify(currentEntity)
    });
})