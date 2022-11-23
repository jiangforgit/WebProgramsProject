function checkSelectSet(e) {
    var input = document.getElementById(e);//e.target,
        list = input.getAttribute('list'),
        options = document.querySelectorAll('#' + list + ' option[value="'+input.value+'"]'),
        hiddenInput = document.getElementById(input.getAttribute('id').replace('-display', ''));
    if (options.length > 0) {
        hiddenInput.value = input.value;
        input.value = options[0].innerText;
    }
}

function addDataListListener(eid) {
    checkSelectSet(eid);
    // document.querySelector('#'+eid).addEventListener('input', checkSelectSet)
}

function isJSON(str) {
    if (typeof str == 'string') {
        try {
            var obj=JSON.parse(str);
            if(typeof obj == 'object' && obj ){
                return true;
            }else{
                return false;
            }

        } catch(e) {
            console.log('error：'+str+'!!!'+e);
            return false;
        }
    }
}
