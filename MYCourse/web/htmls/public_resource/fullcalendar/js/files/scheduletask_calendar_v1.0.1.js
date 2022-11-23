$(function() {

    //===== Calendar =====//
    var fullcalendarObj = fullcalendarJsonObj('month');
    $('#scheduletask_calendar').fullCalendar(fullcalendarObj);

    $('#scheduletask_calendar').fullCalendar('removeEvents');
    getScheduleTasks();

    apendScheduleTaskTypes();
});

function getScheduleTasks(){
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getScheduleTask",{isUserSelfAndSharer:true},function (data) {
        var events = [];
        $.each($.parseJSON(data), function (i, object) {
            let eventArray = [];
            eventArray = getEventData(object);
            events = events.concat(eventArray);
        });
        var view = $('#scheduletask_calendar').fullCalendar('getView');
        var fullcalendarObj = fullcalendarJsonObj(view.name);
        fullcalendarObj['events'] = events;
        // console.log(JSON.stringify(fullcalendarObj));
        // console.log("view.name="+view.name);

        // $('#scheduletask_calendar').fullCalendar('destroy');
        // $('#scheduletask_calendar').fullCalendar(fullcalendarObj);
        $('#scheduletask_calendar').fullCalendar('addEventSource', events);
    },"text");
}

function fullcalendarJsonObj(defaultView){
    var jsonObj = {};

    jsonObj['header'] = {
        left: 'none',//'prev,next,today,prevYear,nextYear,today'
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
    };
    jsonObj['defaultView'] = defaultView;
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

    jsonObj['titleFormat'] = {month:"MMMM yyyy",week:"MMM d日 [ yyyy]{ '~'[ MMM] d日 yyyy}",day:"dddd, MMM d日, yyyy"};

    jsonObj['allDaySlot'] = false;
    jsonObj['allDayText'] = "全天";
    // jsonObj['theme'] = true;
    jsonObj['editable'] = true;

    jsonObj['eventBackgroundColor'] = '#5d92b7';

    jsonObj['firstHour'] = 8;
    jsonObj['minTime'] = 8;
    jsonObj['maxTime'] = 21;

    // jsonObj['monthNames'] = ["January","February","March","April","May","June","July","August","September","October","November","December"];
    // jsonObj['monthNames'] = ["一月", "二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
    jsonObj['monthNames'] = ["1月", "2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"];

    // jsonObj['monthNamesShort'] = ["Jan", "Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    // jsonObj['monthNamesShort'] = ["一月", "二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
    jsonObj['monthNamesShort'] = ["1月", "2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"];

    // jsonObj['dayNames'] = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    jsonObj['dayNames'] = ["周天","周一","周二","周三","周四","周五","周六"];

    // jsonObj['dayNamesShort'] = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
    jsonObj['dayNamesShort'] = ["周天","周一","周二","周三","周四","周五","周六"];

    jsonObj['dayClick'] = function(date, allDay, jsEvent, view) { //当单击日历中的某一天时，触发callback
        var sdate = $.fullCalendar.formatDate(date,"yyyy-MM-dd HH:mm:ss").replace(" ","T");
        var edate = $.fullCalendar.formatDate(date,"yyyy-MM-dd HH:mm:ss").replace(" ","T");
        $('#addScheduleTask_start').attr("value",sdate);
        $('#addScheduleTask_end').attr("value",edate);
        $('#addScheduleTaskModal').modal('show');
    };

    jsonObj['eventClick'] = function(event, jsEvent, view){//当点击日历中的某一日程（事件）时，触发此操作
        initEventShow(event);
    };

    jsonObj['eventMouseover'] = function (event, jsEvent, view){//鼠标划过的事件

    };

    jsonObj['eventMouseout'] = function( event, jsEvent, view ) { //鼠标离开的事件

    };
    return jsonObj;
}

function getEventData(object) {
    var eventArray = [];
    var scheduleTaskStartDate = object[0].scheduleTaskStartDate;
    var scheduleTaskStartTime = object[0].scheduleTaskStartTime;
    var scheduleTaskEndDate = object[0].scheduleTaskEndDate;
    var scheduleTaskEndTime = object[0].scheduleTaskEndTime;

    var scheduleTaskDate = new Date(scheduleTaskStartDate);
    var weekDay = scheduleTaskDate.getDay();
    var scheduleTaskType = object[0].scheduleTaskType;

    var currentCalendar = $('#scheduletask_calendar').fullCalendar('getView');
    var CalendarStartDate = currentCalendar.start;
    var CalendarEndDate = currentCalendar.end;
    var CalendarStartTime = CalendarStartDate.getTime();
    var CalendarEndTime  = CalendarEndDate.getTime();
    var deltDay = Math.abs(CalendarEndTime - CalendarStartTime)/ (1000 * 60 * 60 * 24);

    switch (scheduleTaskType){
        case 0://指定日期时间  一次性提醒
            let  event = initEventObj(object);
            let startDate = new Date(scheduleTaskStartDate);
            let startTime = new Date(scheduleTaskStartTime);
            startTime.setFullYear(startDate.getFullYear(),startDate.getMonth(),startDate.getDate());
            event['start'] = startTime;

            let endDate = new Date(scheduleTaskEndDate);
            let endTime = new Date(scheduleTaskEndTime);
            endTime.setFullYear(endDate.getFullYear(),endDate.getMonth(),endDate.getDate());
            event['end'] = endTime;
            eventArray.push(event);
            break;
        case 1://每周
            let mDate = new Date(CalendarStartDate);
            for(let i=0;i<deltDay; i++){
                mDate.setDate(CalendarStartDate.getDate()+i);
                if(weekDay == mDate.getDay()){
                    let  event = initEventObj(object);
                    let sdate = new Date();
                    sdate.setTime(scheduleTaskStartTime);
                    sdate.setFullYear(mDate.getFullYear(),mDate.getMonth(),mDate.getDate());
                    event['start'] = sdate;
                    let edate = new Date();
                    edate.setTime(scheduleTaskEndTime);
                    edate.setFullYear(mDate.getFullYear(),mDate.getMonth(),mDate.getDate());
                    event['end'] = edate;
                    eventArray.push(event);
                }
            }
            break;
        case 2://每周末
            break;
        case 5://每天
            break;
    }
    return eventArray;
}

function initEventObj(object){
    let  event = {};
    let scheduleTaskId = object[0].scheduleTaskId; event['scheduleTaskId'] = scheduleTaskId;
    let scheduleTaskTitle = object[0].scheduleTaskTitle;   event['title'] = null==scheduleTaskTitle?"title":scheduleTaskTitle;
    let scheduleTaskContent = object[0].scheduleTaskContent;   event['scheduleTaskContent'] = scheduleTaskContent;
    let scheduleTaskPicPath = object[0].scheduleTaskPicPath;   event['scheduleTaskPicPath'] = scheduleTaskPicPath;
    let scheduleTaskAudioPath = object[0].scheduleTaskAudioPath;   event['scheduleTaskAudioPath'] = scheduleTaskAudioPath;
    let scheduleTaskStatus = object[0].scheduleTaskStatus;    event['scheduleTaskStatus'] = scheduleTaskStatus;
    let scheduleTaskFullShare = object[0].scheduleTaskFullShare;   event['scheduleTaskFullShare'] = scheduleTaskFullShare;
    let scheduleTaskRemindTime = object[0].scheduleTaskRemindTime;   event['scheduleTaskRemindTime'] = scheduleTaskRemindTime;
    let scheduleTaskIsReminded = object[0].scheduleTaskIsReminded;   event['scheduleTaskIsReminded'] = scheduleTaskIsReminded;
    let scheduleTaskCreatorId = object[1].familyUserId;   event['scheduleTaskCreatorId'] = scheduleTaskCreatorId;
    let scheduleTaskCreator = object[1].familyUserName;   event['scheduleTaskCreator'] = scheduleTaskCreator;
    let scheduleTaskComment = object[0].scheduleTaskComment;   event['scheduleTaskComment'] = scheduleTaskComment;
    let scheduleTaskCreateTime = object[0].scheduleTaskCreateTime; event['scheduleTaskCreateTime'] = scheduleTaskCreateTime;
    let scheduleTaskUpdateTime = object[0].scheduleTaskUpdateTime; event['scheduleTaskUpdateTime'] = scheduleTaskUpdateTime;
    event['allDay'] = false;
    return event;
}

function apendScheduleTaskTypes(){
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getScheduleTask",{isScheduleTaskTypeReq:true},function (data) {
        var addScheduleTask_scheduletasktype = document.getElementById("addScheduleTask_scheduletasktype");
        if(null != addScheduleTask_scheduletasktype){
            addScheduleTask_scheduletasktype.remove();
        }
        $("#addScheduleTask_scheduletasktype_div").append("<select id=\"addScheduleTask_scheduletasktype\" name=\"addScheduleTask_scheduletasktype\" required=\"\"></select>");
        $.each($.parseJSON(data), function (i, object) {
            $("#addScheduleTask_scheduletasktype").append("<option value=\""+object.type+"\">"+object.typeDes+"</option>");
        });
    },"text");
}

function initEventShow(event){
    let scheduleTaskId = event.scheduleTaskId;
    let scheduleTaskTitle = event.title;
    let scheduleTaskContent = event.scheduleTaskContent;
    let scheduleTaskPicPath = event.scheduleTaskPicPath;
    let scheduleTaskAudioPath = event.scheduleTaskAudioPath;
    let scheduleTaskStatus = event.scheduleTaskStatus;
    let scheduleTaskFullShare = event.scheduleTaskFullShare;
    let scheduleTaskRemindTime = event.scheduleTaskRemindTime;
    let scheduleTaskIsReminded = event.scheduleTaskIsReminded;
    let scheduleTaskCreatorId = event.scheduleTaskCreatorId;
    let scheduleTaskCreator = event.scheduleTaskCreator;
    let scheduleTaskComment = event.scheduleTaskComment;
    let scheduleTaskCreateTime = event.scheduleTaskCreateTime;
    let scheduleTaskUpdateTime = event.scheduleTaskUpdateTime;

    let startDate = new Date(event.start);
    let endDate = new Date(event.end);

    document.getElementById("showScheduleTask_title").innerText = scheduleTaskTitle;
    document.getElementById("showScheduleTask_content").innerText = scheduleTaskContent;
    if(null != scheduleTaskPicPath){

    }
    if(null != scheduleTaskAudioPath){

    }
    document.getElementById("showScheduleTask_start").innerText = $.fullCalendar.formatDate(startDate,"yyyy-MM-dd HH:mm:ss");
    document.getElementById("showScheduleTask_end").innerText = $.fullCalendar.formatDate(endDate,"yyyy-MM-dd HH:mm:ss");
    if(null != scheduleTaskFullShare){
        if(1 == scheduleTaskFullShare){
            document.getElementById("showScheduleTask_fullshare").innerText = "家庭全员共享";
        }else {
            document.getElementById("showScheduleTask_fullshare").innerText = "不共享";
        }
    }else {
        document.getElementById("showScheduleTask_fullshare").innerText = "不共享";
    }
    let remindtimeElement = document.getElementById("showScheduleTask_remindtime");
    if(null != scheduleTaskIsReminded){
        if(1 == scheduleTaskIsReminded){
            remindtimeElement.innerText = "已经提前"+scheduleTaskRemindTime+"分钟提醒";
            remindtimeElement.css("background-color","gray");
        }else {
            remindtimeElement.innerText = "提前"+scheduleTaskRemindTime+"分钟提醒";
        }
    }else {
        remindtimeElement.innerText = "提前"+scheduleTaskRemindTime+"分钟提醒";
    }
    document.getElementById("showScheduleTask_creator").innerText = scheduleTaskCreator;
    let createTime = new Date(scheduleTaskCreateTime);
    document.getElementById("showScheduleTask_createtime").innerText = $.fullCalendar.formatDate(createTime,"yyyy-MM-dd HH:mm:ss");
    document.getElementById("showScheduleTask_delete_btn").onclick = function (){deleteEvent(event);}
    $('#showScheduleTaskModal').modal('show');
}

function deleteEvent(event){
    let scheduleTaskId = event.scheduleTaskId;
    let scheduleTaskCreatorId = event.scheduleTaskCreatorId;
    if(confirm("确定删除该日程计划吗？\n如果是周期日程计划会同步删除")){
        var pathName = window.location.pathname;
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        $.post(projectName+"/removeScheduleTask",{scheduleTaskCreatorId:scheduleTaskCreatorId,scheduleTaskId:scheduleTaskId},function (data) {
            if(isJSON(data)){
                let object = JSON.parse(data);
                let resultcode = object.resultcode;
                let resultdes = object.resultdes;
                if(null != resultcode && null != resultdes){
                    alert(resultdes);
                    if(1 == resultcode){
                        window.location.reload();
                    }
                }else {
                    alert("返回数据为空");
                }
            }else {
                alert("返回数据有误");
            }
        },"text");
    }
}

function preClick(){
    $('#scheduletask_calendar').fullCalendar('removeEvents');
    $('#scheduletask_calendar').fullCalendar('prev');
    getScheduleTasks();
}

function todayClick(){
    $('#scheduletask_calendar').fullCalendar('removeEvents');
    $('#scheduletask_calendar').fullCalendar('today');
    getScheduleTasks();
}

function nextClick(){
    $('#scheduletask_calendar').fullCalendar('removeEvents');
    $('#scheduletask_calendar').fullCalendar('next');
    getScheduleTasks();
}
