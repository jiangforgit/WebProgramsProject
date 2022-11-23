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

function getWeekDayFromDate(mDate){
    let day = "";
    switch (mDate.getDay()){
        case 0:
            day = "日";
            break;
        case 1:
            day = "一";
            break;
        case 2:
            day = "二";
            break;
        case 3:
            day = "三";
            break;
        case 4:
            day = "四";
            break;
        case 5:
            day = "五";
            break;
        case 6:
            day = "六";
            break;
        default:
            day = "日";
            break;
    }
    return day;
}
