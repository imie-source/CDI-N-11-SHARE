$(function () {
    var decalage = 0;

    $('#fileSelector').hide();
    $('#buttonFileSelector').on('click', function () {
        $('#fileSelector').trigger('click');
    });
    $('#sortable1').sortable({
        connectWith: "ul",
        placeholder: "ui-state-highlight",
        cursor: "grabbing"
    });
    $('#sortable2').sortable({
        connectWith: "ul",
        placeholder: "ui-state-highlight",
        cursor: "grabbing"
    });
    $('#cardModel').hide();
    var nbCard = parseInt($('#cardModel').attr('data-nb'));
    for (var i = 0; i < nbCard; i++) {
        console.log('clone');
        var card = $('#cardModel').clone();
        $('#cardContainer').append(card);
        card.removeAttr('id');
        card.attr('data-index', i);
        buttonEdit = card.find('.buttonEdit');
        buttonEdit.on('click', function (e) {
            var index = $(this).parents('.card').attr('data-index');
            index = parseInt(index);
            var item = fileShow[index + decalage];
            dialogForm.attr('data-index', index);
            fillForm(item);
            dialogForm.dialog('open');

        });

    }

    var dialogForm = $('#editPanel').dialog({
        autoOpen: false,
        resizable: true,
        modal: true,
        buttons: {
            Next: function () {
                dialogForm.dialog('close');
                fileQueueNext();
            },
            Add: function () {
                console.log('add');
                var callbackDone = function (file) {
                    fileShow.unshift(file);
                    renderFiles();
                };
                var callbackAlways = function () {
                    dialogForm.dialog('close');
                    fileQueueNext();
                };
                var file = fillItem();
                addDocument(file, callbackDone, callbackAlways);

            },
            Edit: function () {
                console.log('edit');
                var index = dialogForm.attr('data-index');
                fileShow[index + decalage] = fillItem();
                renderFiles();
                dialogForm.dialog('close');
                fileQueueNext();
            },

        },
    });
    $('.slideNavigationLeft').on('click', function () {
        if (decalage > 0) {
            decalage--;
            renderFiles();
        }
    });
    $('.slideNavigationRight').on('click', function () {
        console.log('right');
        if (decalage + nbCard < fileShow.length) {
            decalage++;
            renderFiles();
        }
    });

    var fileShow = [];
    var fileQueue = [];
    var callBackFileRead = function (file, data) {
        console.log('push');
        fileQueue.push({
            file: file,
            data: data
        });
        fileQueueNext();

    };
    var fileQueueNext = function () {
        console.log(fileQueue.length);
        if (!dialogForm.dialog('isOpen') && fileQueue.length > 0) {
            var item = fileQueue.shift();
            fillForm({
                src: item.data,
                name: item.file.name
            });
            dialogForm.dialog('open');
        }
    };
    var options = ['icone', 'pĥoto', 'technique', 'scan'];
    var fillForm = function (item) {
        $('#editImg').attr('src', item.src);
        $('#editFileName').val(item.name);
        $('#sortable1').empty()
        $('#sortable2').empty()
        if (item.tags) {
            $.each(item.tags, function (index, value) {
                $('#sortable2').append(
                    $('<li class="ui-state-default"></li>').text(value));
            });
        }
        $.each($(options).not(item.tags), function (index, value) {
            $('#sortable1').append(
                $('<li class="ui-state-default"></li>').text(value));
        });
    }

    var fillItem = function () {
        var tags = [];
        $('#sortable2').children('li').each(function (index, value) {
            tags.push($(value).text());
        });
        return {
            src: $('#editImg').attr('src'),
            name: $('#editFileName').val(),
            titre: $('#editTitre').val(),
            tags: tags
        }
    }

    var renderFiles = function () {
        $('#cardContainer').children().each(function (index) {

            var file = fileShow[index + decalage];
            console.log(index + decalage);
            if (file) {
                $(this).find('.fileName').val(file.name);
                $(this).find('.fileTitle').text(file.titre);
                $(this).find('.fileImage').attr('src', file.src);
                $(this).show();
                $(this).find('.fileTags').empty();
                if (file.tags) {
                    $.each(file.tags, (function (index, value) {
                        $(this).find('.fileTags').append($('<li>').text(value));
                    }).bind(this));
                }
            }
        });

    };
    var fileReader = fr.imie.inputFileListener.build();
    fileReader.listen('#fileSelector', callBackFileRead);

    var addDocument = function (file, callbackDone, callbackAlways) {
        $.ajax({
            url: 'https://api.mongolab.com/api/1/databases/portfolio/collections/folio?apiKey=UQ2Ntsjbtjk7LkK7B1aHQLEBUgrE0SX9',
            dataType: 'json',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                titre: file.titre,
                tags: file.tags,
                src: file.src,
            })
        }).done(function (data) {
            callbackDone(data);
        }).fail(function (xhr, err) {
            console.log('fail');
            console.log(err);
        }).always(function () {
            callbackAlways();
        });
    }

    var getAllDocument = function (callbackDone, callbackAlways) {
        $.ajax({
            url: 'https://api.mongolab.com/api/1/databases/portfolio/collections/folio?apiKey=UQ2Ntsjbtjk7LkK7B1aHQLEBUgrE0SX9',
            dataType: 'json',
            method: 'GET',
        }).done(function (data) {
            callbackDone(data);
        }).fail(function (xhr, err) {
            console.log('fail');
            console.log(err)
        }).always(function () {
            callbackAlways()
        });
    };
    
    getAllDocument(function (data) {
        $.each(data, function (index, value) {
            fileShow.push(value);
        })
    }, function () {
        renderFiles();
    });


});
