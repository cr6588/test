function ulValue(url, ulId, liValue, liDisplay){
    siping.get(url, function (result){
        for(var i = 0; i < result.length; i++){
            $("#" + ulId).append('<li value="' + result[i][liValue] + '">' + result[i][liDisplay] + '</li>');
        }
    });
}
function ulValueWithData(url, ulId, liValue, liDisplay, dataName, dataValue){
    var data = {};
    data[dataName] = dataValue;
    siping.get(url, data,function (result){
        for(var i = 0; i < result.length; i++){
            $("#" + ulId).append('<li value="' + result[i][liValue] + '">' + result[i][liDisplay] + '</li>');
        }
    });
}
function selectControl(clickId, displayid, hiddenId, ulId){
    var selectListFlag = false;//下拉未展开
    $("#" + clickId).click(function(){
        var this_left = $("#" + displayid).offset().left;
        var this_top = $("#" + displayid).offset().top;
        var this_width = $("#" + displayid).width();
        var this_height = $("#" + clickId).height();
        $("#" + ulId).css({"position":"absolute","left":this_left,"top":this_top+this_height,"width":this_width});
        if(selectListFlag){
            $("#" + ulId).hide();
            selectListFlag = false;
        }else{
            $("#" + ulId).show();
            selectListFlag = true;
        }
    });
    $("#" + ulId).delegate("li", "click", function(e){
        $("#" + ulId).hide();
        selectListFlag = false;
        $("#" + displayid).val($(this).text());
        if(hiddenId != null){
            $("#" + hiddenId).val($(this).attr("value"));
        }
    });
}
function selectControlWithBefore(clickId, displayid, hiddenId, ulId, clickBefore){
    var selectListFlag = false;//下拉未展开
    $("#" + clickId).click(function(){
        if(clickBefore()) {
            var this_left = $("#" + displayid).offset().left;
            var this_top = $("#" + displayid).offset().top;
            var this_width = $("#" + displayid).width();
            var this_height = $("#" + clickId).height();
            $("#" + ulId).css({"position":"absolute","left":this_left,"top":this_top+this_height,"width":this_width});
            if(selectListFlag){
                $("#" + ulId).hide();
                selectListFlag = false;
            }else{
                $("#" + ulId).show();
                selectListFlag = true;
            }
        }
    });
    $("#" + ulId).delegate("li", "click", function(e){
        $("#" + ulId).hide();
        selectListFlag = false;
        $("#" + displayid).val($(this).text());
        if(hiddenId != null){
            $("#" + hiddenId).val($(this).attr("value"));
        }
    });
}
function selectControlWithAfter(clickId, displayid, hiddenId, ulId, clickAfter) {
    var selectListFlag = false;//下拉未展开
    $("#" + clickId).click(function(){
        var this_left = $("#" + displayid).offset().left;
        var this_top = $("#" + displayid).offset().top;
        var this_width = $("#" + displayid).width();
        var this_height = $("#" + clickId).height();
        $("#" + ulId).css({"position":"absolute","left":this_left,"top":this_top+this_height,"width":this_width});
        if(selectListFlag){
            $("#" + ulId).hide();
            selectListFlag = false;
        }else{
            $("#" + ulId).show();
            selectListFlag = true;
        }
    });
    $("#" + ulId).delegate("li", "click", function(e){
        
        $("#" + ulId).hide();
        selectListFlag = false;
        $("#" + displayid).val($(this).text());
        if(hiddenId != null){
            $("#" + hiddenId).val($(this).attr("value"));
        }
        clickAfter();
    });
}
function displayCodeName(url, displayId, dataName, dataValue){
    var data = {};
    data[dataName] = dataValue;
    siping.get(url, data,function (result){
        $("#" + displayId).val(result.codeName);
    });
}
function displayCustomer(url, displayId, dataName, dataValue){
    var data = {};
    data[dataName] = dataValue;
    siping.get(url, data,function (result){
        $("#" + displayId).val(result.shortName);
    });
}
function displayTrainSchedule(url, displayId, dataName, dataValue){
    var data = {};
    data[dataName] = dataValue;
    siping.get(url, data,function (result){
        $("#" + displayId).val(result.trainNo);
    });
}