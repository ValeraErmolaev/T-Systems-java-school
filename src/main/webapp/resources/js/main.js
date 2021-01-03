let btn = document.getElementById("show-modal");
let modal = document.getElementById("modal");
var supportObj = {
    hasAncestorOf: function(elem, possibleAncestor) {
        /*
        from Dmitri
        */
        var res;

        if (elem === possibleAncestor)
            res = true;
        else if (elem.parentElement !== null)
            res = supportObj.hasAncestorOf(elem.parentElement, possibleAncestor);
        else
            res = false;

        return res;
    }
};
let modalObj = {

        init: function () {
            let loginBlock = document.getElementById("login");
            modal.addEventListener("click", function (e) {
               if (supportObj.hasAncestorOf(e.target,loginBlock)) {
                   return;
               }
               else{
                   modal.classList.remove("active")
                   }

            });

        }
    }
;


window.addEventListener("load", function () {
    modalObj.init();
    btn.addEventListener("click", function () {
        // console.log("clicked me!");
        modal.classList.add("active");

    });
});