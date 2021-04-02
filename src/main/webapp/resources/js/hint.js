let hintDOM = document.querySelector('.hint--box');

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

let hintObj = {
    activity: false,
    content: '',
    hintGeneratorsCollection: undefined,
    init: function() {
        this.hintGeneratorsCollection = document.querySelectorAll('.option-name.hint-responsive');
        console.log(this.hintGeneratorsCollection);

        for (let i = 0; i < this.hintGeneratorsCollection.length; i++) {
            addGeneratorReactivity(this.hintGeneratorsCollection[i]);
        }


        function addGeneratorReactivity(elem) {
            let optionName = hintDOM.querySelector('.hintbox-option-name');

            elem.addEventListener('mouseenter', function() {
                hintDOM.classList.add('active');
                hintObj.activity = true;
                hintObj.content = elem.dataset.name +"Related options: "+ elem.dataset.associated;
                optionName.textContent = hintObj.content;
            });
            elem.addEventListener('mouseleave', function() {
                hintDOM.classList.remove('active');
                hintObj.activity = false;
                hintObj.content = '';
                optionName.textContent = hintObj.content;
            });
            elem.addEventListener('mousemove', function(e) {
                if (hintObj.activity) {
                    console.log(window);
                    hintDOM.style.top = e.clientY - 200 + 'px';
                    hintDOM.style.left = e.clientX + 20 + 'px';
                }
            })
        }
    }
};

window.addEventListener("load", function () {
    hintObj.init();
});
