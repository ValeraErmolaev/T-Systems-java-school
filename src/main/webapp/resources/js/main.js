let btn = document.getElementById("show-modal");
let modal = document.getElementById("modal");

var supportObj = {
    hasAncestorOf: function(elem, possibleAncestor) {
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
    loginObj: {
        loginFormElem: undefined,
        loginBtnElem: undefined,
        registerBtnElem: undefined,
        init: function() {

            this.loginFormElem = document.querySelector('.login-form');
            this.loginBtnElem = this.loginFormElem.querySelector('.login-btn');
            this.registerBtnElem = this.loginFormElem.querySelector('.reg-btn');

            this.registerBtnElem.addEventListener('click', function(e) {
                e.preventDefault();
            });
            this.loginBtnElem.addEventListener('click',async function(e) {

                // e.preventDefault();
                // let response = await fetch('/', {
                //     method: 'POST',
                //     headers: {
                //         'Content-Type': 'application/json;charset=utf-8'
                //     },
                //     body: JSON.stringify()
                // });
                // let result = await response.json();
                // console.log(result);

            })
        }
    },
    init: function() {
        this.loginObj.init();
        let loginBlock = document.getElementById("login");

        modal.addEventListener("click", function (e) {
            if (supportObj.hasAncestorOf(e.target,loginBlock)) {
                return;
            } else {
                modal.classList.remove("active")
            }
        });
    }
};

window.addEventListener("load", function () {
    modalObj.init();
    btn.addEventListener("click", function () {
        // console.log("clicked me!");
        modal.classList.add("active");
    });
});