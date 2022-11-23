$(function() {
    apendScheduleTaskRecords();
});

function apendScheduleTaskRecords(){
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getScheduleTask",{isUserSelfAndSharer:true},function (data) {

        var scheduletask_records_container_div = document.getElementById("scheduletask_records_container_div");
        var scheduletask_records_slides_div = document.createElement("div");
        scheduletask_records_slides_div.className = "w3_slider";
        var scheduletask_records_slides = document.createElement("ul");
        scheduletask_records_slides.style.width = "100%"
        scheduletask_records_slides.className = "slides";

        let slideLi = null;
        let objarr = $.parseJSON(data);
        if(null != objarr){
            if(objarr.length > 0){
                $.each(objarr, function (i, object) {

                    if(i%4 ==0 && i != 0){
                        var clearFixDiv = document.createElement("div");
                        clearFixDiv.className = "clearfix";
                        slideLi.appendChild(clearFixDiv);
                        scheduletask_records_slides.appendChild(slideLi);
                    }

                    if(i%4 == 0){
                        slideLi = document.createElement("li");
                        slideLi.style.width = "100%";
                        slideLi.className = "slide";
                    }
                    let slidechilDiv = document.createElement("div");
                    slidechilDiv.className = "col-md-3 wthree_team_grid";

                    let gridPos = document.createElement("div");
                    gridPos.className = "agile_events_grid_pos1";

                    let scheduleTaskTitle = object[0].scheduleTaskTitle;
                    let scheduleTaskContent = object[0].scheduleTaskContent;
                    let createDateTime = new Date(object[0].scheduleTaskCreateTime);
                    let scheduleTaskId = object[0].scheduleTaskId;
                    let scheduleTaskType = object[0].scheduleTaskType;
                    let creatorId = object[1].familyUserId;
                    let creator = object[1].familyUserName;

                    gridPos.innerHTML =
                        "<h5><span>"+createDateTime.getDate()+"</span>"+createDateTime.getMonth()+" / "+createDateTime.getFullYear()+"</h5>"+
                        "<h4><a href=\"javascript:initScheduleShow("+scheduleTaskId+");\">"+scheduleTaskTitle+"</a></h4>"+
                        "<textarea rows=\"7\">"+scheduleTaskContent+"</textarea>";
                    slidechilDiv.appendChild(gridPos);

                    let gridW3 = document.createElement("div");
                    gridW3.className = "wthree_team_grid_w3";


                    gridW3.innerHTML =
                        "<h4>"+gettimeShowByScheduleTaskType(scheduleTaskType,object[0])+"</h4>"+
                        "<p>"+creator+"</p>"+
                        "<div class=\"wthree_team_grid_w3_pos\">"+
                        "<ul class=\"agileinfo_social_icons\">"+
                        "<li><a href=\"#\" class=\"w3ls_dribble\"><i class=\"fa fa-image\" aria-hidden=\"true\"></i></a></li>"+
                        "<li><a href=\"#\" class=\"agileits_facebook\"><i class=\"fa fa-file-audio-o\" aria-hidden=\"true\"></i></a></li>"+
                        "<li><a href=\"javascript:deleteEvent("+scheduleTaskId+","+creatorId+");\" class=\"w3l_google\"><i class=\"fa fa-remove\" aria-hidden=\"true\"></i></a></li>"+
                        "</ul>"+
                        "</div>";

                    slidechilDiv.appendChild(gridW3);
                    slideLi.appendChild(slidechilDiv);

                    if(i == objarr.length-1){
                        var clearFixDiv = document.createElement("div");
                        clearFixDiv.className = "clearfix";
                        slideLi.appendChild(clearFixDiv);
                        scheduletask_records_slides.appendChild(slideLi);
                    }
                });

                scheduletask_records_slides_div.appendChild(scheduletask_records_slides);
                scheduletask_records_container_div.appendChild(scheduletask_records_slides_div);
            }
        }
    },"text");
}

function gettimeShowByScheduleTaskType(scheduleTaskType,scheduleTaskObj){
    let timeShowStr = "";
    let scheduleTaskStartDate = scheduleTaskObj.scheduleTaskStartDate;
    let scheduleTaskStartTime = scheduleTaskObj.scheduleTaskStartTime;
    let scheduleTaskEndDate = scheduleTaskObj.scheduleTaskEndDate;
    let scheduleTaskEndTime = scheduleTaskObj.scheduleTaskEndTime;

    let Date_startDate = new Date(scheduleTaskStartDate);
    let Date_startTime = new Date(scheduleTaskStartTime);
    let Date_endDate = new Date(scheduleTaskEndDate);
    let Date_endTime = new Date(scheduleTaskEndTime);
    switch (scheduleTaskType){
        case 0://一次
            if(scheduleTaskStartDate == scheduleTaskEndDate){
                timeShowStr += "(周"+getWeekDayFromDate(Date_startDate)+") "+$.fullCalendar.formatDate(Date_startDate,"yyyy/MM/dd ");
                timeShowStr += $.fullCalendar.formatDate(Date_startTime,"HH:mm");
                timeShowStr += "~"+$.fullCalendar.formatDate(Date_endTime,"HH:mm");
            }else {
                timeShowStr += "(周"+getWeekDayFromDate(Date_startDate)+") "+$.fullCalendar.formatDate(Date_startDate,"yyyy/MM/dd ");
                timeShowStr += $.fullCalendar.formatDate(Date_startTime,"HH:mm");
                timeShowStr += "~"+"(周"+getWeekDayFromDate(Date_endDate)+") "+$.fullCalendar.formatDate(Date_endDate,"yyyy/MM/dd ");
                timeShowStr += $.fullCalendar.formatDate(Date_endTime,"HH:mm");
            }
            break;
        case 1://每周
            if(scheduleTaskStartDate == scheduleTaskEndDate){
                timeShowStr += "每周"+getWeekDayFromDate(Date_startDate) +
                    $.fullCalendar.formatDate(Date_startTime,"HH:mm") + "~" +$.fullCalendar.formatDate(Date_endTime,"HH:mm");
            }else {
                timeShowStr += "每周"+getWeekDayFromDate(Date_startDate) + $.fullCalendar.formatDate(Date_startTime,"HH:mm")
                     + "~" +"每周"+getWeekDayFromDate(Date_endDate) + $.fullCalendar.formatDate(Date_endTime,"HH:mm");
            }
            break;
        case 2:
            break;
    }
    return timeShowStr;
}

function initScheduleShow(taskId){
    var pathName = window.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    $.post(projectName+"/getScheduleTask",{isReqByTaskId:true,taskId:taskId},function (data) {
        var dataObj = $.parseJSON(data);
        var scheduleTaskobj = dataObj[0];
        var familyobj = dataObj[1];

        let scheduleTaskId = scheduleTaskobj.scheduleTaskId;
        let scheduleTaskType = scheduleTaskobj.scheduleTaskType;
        let scheduleTaskTitle = scheduleTaskobj.scheduleTaskTitle;
        let scheduleTaskContent = scheduleTaskobj.scheduleTaskContent;
        let scheduleTaskPicPath = scheduleTaskobj.scheduleTaskPicPath;
        let scheduleTaskAudioPath = scheduleTaskobj.scheduleTaskAudioPath;
        let scheduleTaskStatus = scheduleTaskobj.scheduleTaskStatus;
        let scheduleTaskFullShare = scheduleTaskobj.scheduleTaskFullShare;
        let scheduleTaskRemindTime = scheduleTaskobj.scheduleTaskRemindTime;
        let scheduleTaskIsReminded = scheduleTaskobj.scheduleTaskIsReminded;
        let scheduleTaskCreatorId = familyobj.familyUserId;
        let scheduleTaskCreator = familyobj.familyUserName;
        let scheduleTaskComment = scheduleTaskobj.scheduleTaskComment;
        let scheduleTaskCreateTime = scheduleTaskobj.scheduleTaskCreateTime;
        let scheduleTaskUpdateTime = scheduleTaskobj.scheduleTaskUpdateTime;

        document.getElementById("showScheduleTaskRecord_title").innerText = scheduleTaskTitle;
        document.getElementById("showScheduleTaskRecord_content").innerText = scheduleTaskContent;
        if(null != scheduleTaskPicPath){

        }
        if(null != scheduleTaskAudioPath){

        }

        document.getElementById("showScheduleTaskRecord_time").innerText = gettimeShowByScheduleTaskType(scheduleTaskType,scheduleTaskobj);
        if(null != scheduleTaskFullShare){
            if(1 == scheduleTaskFullShare){
                document.getElementById("showScheduleTaskRecord_fullshare").innerText = "家庭全员共享";
            }else {
                document.getElementById("showScheduleTaskRecord_fullshare").innerText = "不共享";
            }
        }else {
            document.getElementById("showScheduleTaskRecord_fullshare").innerText = "不共享";
        }
        let remindtimeElement = document.getElementById("showScheduleTaskRecord_remindtime");
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
        document.getElementById("showScheduleTaskRecord_creator").innerText = scheduleTaskCreator;
        let createTime = new Date(scheduleTaskCreateTime);
        document.getElementById("showScheduleTaskRecord_createtime").innerText = $.fullCalendar.formatDate(createTime,"yyyy-MM-dd HH:mm:ss");
        $('#showScheduleTaskRecordModal').modal('show');
    });
}

function deleteEvent(taskId,creatorId){
    let scheduleTaskId = taskId;
    let scheduleTaskCreatorId = creatorId;
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