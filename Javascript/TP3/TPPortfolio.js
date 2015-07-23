$(function () {

    var callBackFileRead = function (file, data) {
        console.log('draw');
        $('#preview').append($(
                '<div style="display:inline-block;border-style:solid;padding:5px;margin:5px;">'
            ).append($('<div>').text(file.name))
            .append($(
                '<img>'
            ).attr('src', data)));
    }
    var fileReader = fr.imie.inputFileListener.build();
    fileReader.listen('#fileSelector', callBackFileRead);

});
