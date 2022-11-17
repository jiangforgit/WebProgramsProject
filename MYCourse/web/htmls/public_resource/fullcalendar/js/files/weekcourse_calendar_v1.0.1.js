$(function() {

    //===== Calendar =====//
    var fullcalendarObj = fullcalendarJsonObj();
    $('#weekcourse_calendar').fullCalendar(fullcalendarObj);

    //======post FamilyStudents======//
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getFamilyStudents",function (data) {
        $("#calendar_head_div").append("<select id=\"familystudent_select\" onchange=\"changeStudentSelect()\"></select>");
        $.each($.parseJSON(data), function (i, object) {
           $("#familystudent_select").append("<option value=\""+object[1].studentId+"\">"+object[1].studentName+"</option>");
        });
        changeStudentSelect();
    },"text");

    apendWeekCourseTypes();
});

function changeStudentSelect(){
    var studentSelect = document.getElementById("familystudent_select");
    var studentSelectValue = studentSelect.value;
    var studentSelectText = studentSelect.options[studentSelect.selectedIndex].text;

    $("#addWeekCourse_course_student").attr("value",studentSelectValue);

    getWeekCourses(studentSelectValue);
}

function getWeekCourses(studentId){
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getWeekCourses",{studentId:studentId},function (data) {
        var events = [];
        $.each($.parseJSON(data), function (i, object) {
            let eventArray = [];
            eventArray = getEventData(object);
            events = events.concat(eventArray);
        });
        var fullcalendarObj = fullcalendarJsonObj();
        fullcalendarObj['events'] = events;
        // console.log(JSON.stringify(fullcalendarObj));
        $('#weekcourse_calendar').fullCalendar('destroy');
        $('#weekcourse_calendar').fullCalendar(fullcalendarObj);
        apendStudentCourses();
    },"text");
}

function fullcalendarJsonObj(){
    var jsonObj = {};

    jsonObj['header'] = {
        left: 'prev,next,today',//prevYear,nextYear,today
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
    };
    // jsonObj['defaultView'] = 'agendaWeek';
    jsonObj['buttonText'] =  {
        today: "今日",
        month: "月",
        agendaWeek: "周",
        agendaDay: "日"
    };
    // jsonObj['slotMinutes'] = 15,
    // jsonObj['height'] = 500;
    // jsonObj['contentHeight'] = 400;
    // jsonObj['aspectRatio'] = 1.50;

    jsonObj['allDaySlot'] = false;
    jsonObj['allDayText'] = "全天";
    // jsonObj['theme'] = true;
    jsonObj['editable'] = true;

    jsonObj['eventBackgroundColor'] = '#8702A8';

    jsonObj['firstHour'] = 8;
    jsonObj['minTime'] = 8;
    jsonObj['maxTime'] = 21;

    // jsonObj['monthNames'] = ["January","February","March","April","May","June","July","August","September","October","November","December"];
    jsonObj['monthNames'] = ["一月", "二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];

    // jsonObj['monthNamesShort'] = ["Jan", "Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    jsonObj['monthNamesShort'] = ["一月", "二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];

    // jsonObj['dayNames'] = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    jsonObj['dayNames'] = ["周天","周一","周二","周三","周四","周五","周六"];

    // jsonObj['dayNamesShort'] = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
    jsonObj['dayNamesShort'] = ["周天","周一","周二","周三","周四","周五","周六"];

    jsonObj['dayClick'] = function(date, allDay, jsEvent, view) { //当单击日历中的某一天时，触发callback
        var sdate = $.fullCalendar.formatDate(date,"yyyy-MM-dd HH:mm:ss").replace(" ","T");
        var edate = $.fullCalendar.formatDate(date,"yyyy-MM-dd HH:mm:ss").replace(" ","T");
        $('#addWeekCourse_start').attr("value",sdate);
        $('#addWeekCourse_end').attr("value",edate);
        $('#addWeekCourseModal').modal('show');
    };

    jsonObj['eventClick'] = function(event, jsEvent, view){//当点击日历中的某一日程（事件）时，触发此操作
        var title = event.title;
        var startDate = new Date(event.start);
        var endDate = new Date(event.end);
        document.getElementById("showWeekCourse_title").innerHTML = title;
        document.getElementById("showWeekCourse_start").innerHTML = $.fullCalendar.formatDate(startDate,"yyyy-MM-dd HH:mm:ss");
        document.getElementById("showWeekCourse_end").innerHTML =  $.fullCalendar.formatDate(endDate,"yyyy-MM-dd HH:mm:ss");
        $('#showWeekCourseModal').modal('show');
    };

    jsonObj['eventMouseover'] = function (event, jsEvent, view){//鼠标划过的事件

    };

    jsonObj['eventMouseout'] = function( event, jsEvent, view ) { //鼠标离开的事件

    };

    return jsonObj;
}

function getEventData(object) {
    var eventArray = [];

    var startDate = object[0].weekCourseStartDate;
    var startTime = object[0].weekCourseStartTime;
    var endDate = object[0].weekCourseEndDate;
    var endTime = object[0].weekCourseEndTime;
    var weekDay = object[0].weekCourseWeekDay;
    var weekType = object[0].weekCourseType;

    var title = object[1].courseName;

    // console.log("title="+title+",startDate="+startDate+",startTime="+startTime+",endDate="+endDate+",endTime="+endTime+",weekDay="+weekDay+",weekType="+weekType);

    var currentCalendar = $('#weekcourse_calendar').fullCalendar('getView');
    var CalendarStartDate = currentCalendar.start;
    var CalendarEndDate = currentCalendar.end;
    var CalendarStartTime = CalendarStartDate.getTime();
    var CalendarEndTime  = CalendarEndDate.getTime();
    var deltDay = Math.abs(CalendarEndTime - CalendarStartTime)/ (1000 * 60 * 60 * 24);

    switch (weekType){
        case 0://每周
            var mDate = new Date(CalendarStartDate);
            for(var i=0;i<deltDay; i++){
                mDate.setDate(CalendarStartDate.getDate()+i);
                if(weekDay == mDate.getDay()){
                    var  event = {};
                    event['title'] = null==title?"title":title;
                    var sdate = new Date();
                    sdate.setTime(startTime);
                    sdate.setFullYear(mDate.getFullYear(),mDate.getMonth(),mDate.getDate());
                    event['start'] = sdate;
                    var edate = new Date();
                    edate.setTime(endTime);
                    edate.setFullYear(mDate.getFullYear(),mDate.getMonth(),mDate.getDate());
                    event['end'] = edate;
                    event['allDay'] = false;
                    eventArray.push(event);
                }
            }
            break;
        case 1://每周工作日
            break;
        case 2://每周末
            break;
        case 5://每天
            break;
    }
    return eventArray;
}

function apendWeekCourseTypes(){
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getWeekCourses",{isWeekCourseTypeReq:true},function (data) {
        var addWeekCourse_courseType = document.getElementById("addWeekCourse_courseType");
        if(null != addWeekCourse_courseType){
            addWeekCourse_courseType.remove();
        }
        $("#addWeekCourse_courseType_div").append("<select id=\"addWeekCourse_courseType\" name=\"addWeekCourse_courseType\" required=\"\"></select>");
        $.each($.parseJSON(data), function (i, object) {
            $("#addWeekCourse_courseType").append("<option value=\""+object.type+"\">"+object.typeDes+"</option>");
        });
    },"text");
}

function apendStudentCourses(){
    var selectedStudentId = document.getElementById("addWeekCourse_course_student").value;
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getCourses",{studentId:selectedStudentId},function (data) {
        var addWeekCourse_course_select = document.getElementById("addWeekCourse_course");
        if(null != addWeekCourse_course_select){
            addWeekCourse_course_select.remove();
        }
        $("#addWeekCourse_course_div").append("<select id=\"addWeekCourse_course\" name=\"addWeekCourse_course\" required=\"\"></select>");
        $.each($.parseJSON(data), function (i, object) {
            $("#addWeekCourse_course").append("<option value=\""+object[1].courseId+"\">"+object[1].courseName+"</option>");
        });
    },"text");
}

