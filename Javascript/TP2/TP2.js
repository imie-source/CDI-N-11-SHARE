var obj1 = new Object();
obj1.attr1 = "bonjour";
obj1.methode1 = function () {
    alert(this.attr1)
};
//obj1.methode1();

var obj2 = {
        attr1: "bonjour",
        methode1: function () {
            alert(this.attr1)
        }
    }
    //obj2.methode1();

function constructeurObj3(value) {
    var attr1 = value;
    this.methode1 = function () {
        alert(attr1)
    }
}

var obj3 = new constructeurObj3('bonjour');
//obj3.methode1();

function constructeurObj4(value) {
    var attr1 = value;
    var methode1 = function () {
        alert(attr1)
    }
}
var obj4 = new constructeurObj4('bonjour');
//console.log(obj4.attr1);
try {
    //obj4.methode1();
} catch (e) {
    console.log(e);
}

function constructeurObj5(value) {
    var attr1 = value;
    this.methode1 = function () {
        alert(attr1)
    }
}
var obj5 = new constructeurObj5('bonjour');
try {
    //obj5.methode1();
} catch (e) {
    console.log(e);
}

function constructeurObj6(config) {
    this.attr1 = config.attr1 || 'valeur pas initialisé';
    this.methode1 = config.methode1 || function () {
        alert('methode pas implémentée')
    };
}
var obj6_1 = new constructeurObj6({
    methode1: function () {
        alert(this.attr1);
    },
    attr1: 'initilisé'
});
//obj6.methode1();


constructeurObj6.prototype.methode2 = function () {
    console.log(this.attr1)
};
obj6_1.methode2();
var obj6_2 = new constructeurObj6({});
obj6_2.methode2();
constructeurObj6.prototype = {
    methode3: function () {
        document.write(this.attr1)
    }
};
try {
    obj6_1.methode3();
} catch (e) {
    console.log(e);
}
var obj6_3 = new constructeurObj6({});
//obj6_3.methode3();
try {
    obj6_3.methode2();
} catch (e) {
    console.log(e);
}

function afficherTitre(textColor, bgColor) {
    var h1 = document.createElement('h1');
    h1.appendChild(document.createTextNode(this.titre));
    h1.style.color = textColor;
    h1.style.backgroundColor = bgColor;
    document.body.appendChild(h1);
}

var article = {
    titre: 'super titre d\'article'
};
//afficherTitre.call(article,'white','blue');


function Human(name) {
    this.name = name;
    this.speak = function () {
        return ' bonjour je m\'appelle ' + this.name
    };
}

function Hulk(name) {
    Human.call(this,name);
    this.speak2 = function () {
        return this.name+' : je sais dire /' + this.speak()
    }
}

// hulk hérite de Human
var humanProto= Object.create(Human.prototype);
console.log(humanProto);
Hulk.prototype = humanProto;
Hulk.prototype.constructor=Hulk;
hulk1 = new Hulk('bruce');
console.log(hulk1.constructor);
console.log(hulk1.speak());
console.log(hulk1.speak2());
