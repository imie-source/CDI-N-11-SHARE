var fr =fr||{};
fr.imie = fr.imie||{};
fr.imie.inputFileListener = {};
fr.imie.inputFileListener.proto = {
    listen: function (selector, callback) {
        $(selector).on('change', function (e) {
            console.log('change');
            if (window.File && window.FileReader && window.FileList && window.Blob) {
                for (var i = 0; i < e.target.files.length; i++) {

                    var picReader = new FileReader();
                    picReader.addEventListener("load", function (event) {
                        var reader = event.target;
                        callback(reader.file, reader.result);
                    });

                    var f = e.target.files[i];
                    if (!f.type || !f.type.match('image.*')) {
                        continue;
                    }
                    picReader.file = f;
                    picReader.readAsDataURL(f);

                }
            } else {
                console.log('non supporté');
            }
        });

    }
}
fr.imie.inputFileListener.state = {};
fr.imie.inputFileListener.build = function () {
    return Object.create(fr.imie.inputFileListener.proto, fr.imie.inputFileListener.state);
};


