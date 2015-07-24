function EX1() {
    var age = prompt('saisir l\'age du joueur');
    age = parseInt(age);
    console.log(age);
    var categorie;
    if (age >= 12) {
        categorie = "cadet";
    } else {
        switch (age) {
            case 6:
            case 7:
                categorie = 'poussin';
                break;
            case 8:
            case 9:
                categorie = 'pupille';
                break;
            case 10:
            case 11:
                categorie = 'minime';
                break;
        }
    }
    alert(categorie);
}

function EX2() {
    var nbPhotocop = prompt('saisir le nombre de photocopies à faire');
    nbPhotocop = parseInt(nbPhotocop);
    var prix = 0;
    var tabQu = [10, 20];
    var tabPrix = [0.1, 0.08, 0.05];
    for (keyPrix in tabPrix) {
        var currentPrix = tabPrix[keyPrix];
        var currentQu = tabQu[keyPrix];
        var currentNbPhotocop;
        if (currentQu) {
            currentNbPhotocop = Math.min(currentQu, nbPhotocop);
        } else {
            currentNbPhotocop = nbPhotocop;
        }
        prix += currentNbPhotocop * currentPrix;
        nbPhotocop -= currentNbPhotocop;
        if (nbPhotocop == 0) {
            break;
        }
    }
    alert(prix);
}

function EX3() {
    var value = prompt("saisir un nombre pour calculer sa factorielle");
    alert(fact(value));
}

function fact(operande) {
    if (operande <= 1) {
        return 1;
    } else {
        return fact(operande - 1) * operande;
    }
}

function EX4() {
    var tab = [10, 65, 43, 97, 21, 54];
    var sum = 0;
    for (keyValue in tab) {
        sum += tab[keyValue];
    }
    var moy = sum / tab.length;
    alert(moy);
}

function EX5() {
    var tab = [10, 65, 43, 97, 21, 54];
    var sum = 0;
    for (var stable = 0; stable < tab.length - 1; stable++) {
        for (var i = 0; i <= tab.length - (stable + 1); i++) {
            if (tab[i] > tab[i + 1]) {
                var tmp = tab[i];
                tab[i] = tab[i + 1];
                tab[i + 1] = tmp;
            }
        }
    }
    console.log(tab);
}

function EX6() {
    var tab = [10, 65, 43, 97, 21, 54];
    tab = tab.sort(function (a, b) {
        return a - b;
    });

    console.log(tab);
}

function EX7(displayFunction) {
    var tab = [10, 65, 43, 97, 21, 54];
    var sum = 0;
    displayFunction(tab);
    for (var stable = 0; stable < tab.length - 1; stable++) {
        var permut = false;
        for (var i = 0; i <= tab.length - (stable + 1); i++) {
            if (tab[i] > tab[i + 1]) {
                var tmp = tab[i];
                tab[i] = tab[i + 1];
                tab[i + 1] = tmp;
                permut = true;
            }
        }
        displayFunction(tab);
        if (!permut) {
            break;
        }
    }
    console.log(tab);
}


function EX8(displayFunction) {
    var tab = [10, 65, 43, 97, 21, 54];
    var sum = 0;
    var displayTab = [];
    for (var indexCompletion = 0; indexCompletion < tab.length; indexCompletion++) {
        displayTab.push({
            value: tab[indexCompletion]
        });
    }
    displayFunction(displayTab);
    for (var stable = 0; stable < tab.length - 1; stable++) {
        var permut = false;
        var currentPermut = false;
        displayTab = [];
        for (var i = 0; i <= tab.length - (stable + 1); i++) {
            var state=undefined;
            if (tab[i] > tab[i + 1]) {
                var tmp = tab[i];
                tab[i] = tab[i + 1];
                tab[i + 1] = tmp;
                permut = true;
                if (!currentPermut) {
                    state = 'start';
                } else {
                    state = 'middle';
                }
                currentPermut = true;
            } else {
                if (currentPermut) {
                    state = 'end';
                }
                currentPermut = false;
            }
            displayTab.push({
                value: tab[i],
                state: state
            });

        }
        for (var indexCompletion = tab.length - stable; indexCompletion < tab.length; indexCompletion++) {
            displayTab.push({
                value: tab[indexCompletion]
            });
        }
        displayFunction(displayTab);
        if (!permut) {
            break;
        }
    }
    console.log(tab);
}
