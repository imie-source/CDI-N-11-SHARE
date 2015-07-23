$(function () {
    $('#fileSelector').on('change', function (e) {
        if (window.File && window.FileReader && window.FileList && window.Blob) {
            for (i = 0; i < e.target.files.length; i++) {

                var picReader = new FileReader();
                picReader.addEventListener("load", function (event) {
                    var reader = event.target;
                    $('#preview').append($(
                            '<div style="display:inline-block;border-style:solid;padding:5px;margin:5px;">'
                        ).append($('<div>').text(reader.file.name))
                        .append($(
                            '<img>'
                        ).attr('src', reader.result)));
                    console.log(reader.result);
                });

                var f = e.target.files[i];
                if (f.type && !f.type.match('image.*')) {
                    continue;
                }
                picReader.file = f;
                picReader.readAsDataURL(f);

            }
        } else {
            console.log('non supporté');
        }
    });
});
