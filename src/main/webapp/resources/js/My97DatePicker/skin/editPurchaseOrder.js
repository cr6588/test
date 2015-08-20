var count=parent.document.getElementById("purchaseItemLocation").value;
$(function(){
	$.Huitab("#addBox .tabBar span","#addBox .tabCon","Current","click","0");
	var index = parent.layer.getFrameIndex(window.name);
	$("#save").on('click', (function() {
		//确认
		//alert("进入确认");
		//保存页面
	    saveUpload();
		//关闭页面
	    parent.layer.close(index);
	}));
	$("#cancel").on('click', (function() {
		//确认
		
		//关闭页面
	    parent.layer.close(index);
	}));
	$("#delete").on('click', (function() {
        //确认
       
        //alert(diva);
        delUpload();
        //关闭页面
        parent.layer.close(index);
    }));
	

});
function getEditPurchaseData(){
   // alert(count);
    var proName = parent.document.getElementById("purchaseItems["+count+"].proName").value;
    var description = parent.document.getElementById("purchaseItems["+count+"].description").value;
    var quantity = parent.document.getElementById("purchaseItems["+count+"].quantity").value;
    var amount = parent.document.getElementById("purchaseItems["+count+"].amount").value;
    var taxAmount = parent.document.getElementById("purchaseItems["+count+"].taxAmount").value;
    var totalAmount = parent.document.getElementById("purchaseItems["+count+"].totalAmount").value;
    $("#proName").val(proName);
    $("#description").val(description);
    $("#quantity").val(quantity);
    $("#amount").val(amount);
    $("#taxAmount").val(taxAmount);
    $("#totalAmount").val(totalAmount);
    }
function saveUpload() {    
    //alert(count);
    
    //if(count >= maxfile)    return;//限制最多maxfile个文件框
     
    //自增id不同的HTML对象，并附加到容器最后
    //var newDiv =  "<div id=divUpload" + count +">"
    //+"<button id=uploadForm"+ count +" onMouseOut=this.style.color=\"blue\" onMouseOver=this.style.color=\"red\">"+count+"</button>"
    //+"<button id=deleteUploadForm"+ count +" onMouseOut=this.style.color=\"blue\" onMouseOver=this.style.color=\"red\"  onclick=\"delUpload('divUpload" + count + "')\">删除</button>"
    //+ " </div>";   
//    var countPlus = parseInt(count)+1;
//    var newDiv = '<input type="button" class="box" id="Item'+count+'"  style="background-color:#caaddd" value="'+countPlus+'" onclick="showPurchaseItem('+count+')" onMouseover="changeButtonStyle()" onMouseout="recoverButtonStyle()"/>';
//    newDiv = newDiv + '<input type="hidden" id="purchaseItems['+count+'].proName" name="purchaseItems['+count+'].proName" value="'+$("#proName").val()+'">';
//    newDiv = newDiv + '<input type="hidden" id="purchaseItems['+count+'].description" name="purchaseItems['+count+'].description" value="'+$("#description").val()+'">';
//    newDiv = newDiv + '<input type="hidden" id="purchaseItems['+count+'].quantity" name="purchaseItems['+count+'].quantity" value="'+$("#quantity").val()+'">';
//    newDiv = newDiv + '<input type="hidden" id="purchaseItems['+count+'].amount" name="purchaseItems['+count+'].amount" value="'+$("#amount").val()+'">';
//    newDiv = newDiv + '<input type="hidden" id="purchaseItems['+count+'].taxAmount" name="purchaseItems['+count+'].taxAmount" value="'+$("#taxAmount").val()+'">';
//    newDiv = newDiv + '<input type="hidden" id="purchaseItems['+count+'].totalAmount" name="purchaseItems['+count+'].totalAmount" value="'+$("#totalAmount").val()+'">';
//    //alert(newDiv);
//    parent.$("#uploadContent").append(newDiv);
//    count++;
//    parent.document.getElementById("addPurchaseItemNum").value=count;
    parent.document.getElementById("Item"+count).value=$("#proName").val();
    parent.document.getElementById("purchaseItems["+count+"].proName").value=$("#proName").val();
    parent.document.getElementById("purchaseItems["+count+"].description").value=$("#description").val();
    parent.document.getElementById("purchaseItems["+count+"].quantity").value=$("#quantity").val();
    parent.document.getElementById("purchaseItems["+count+"].amount").value=$("#amount").val();
    parent.document.getElementById("purchaseItems["+count+"].taxAmount").value=$("#taxAmount").val();
    parent.document.getElementById("purchaseItems["+count+"].totalAmount").value=$("#totalAmount").val();
    //alert("修改成功，请记得提交数据到服务器");
}   
//删除指定元素
function delUpload() {  
    //alert(diva);
    var itemButton = 'Item'+count;
    var proName = 'purchaseItems['+count+'].proName';
    var description = 'purchaseItems['+count+'].description';
    var quantity = 'purchaseItems['+count+'].quantity';
    var amount = 'purchaseItems['+count+'].amount';
    var taxAmount = 'purchaseItems['+count+'].taxAmount';
    var totalAmount = 'purchaseItems['+count+'].totalAmount';
    parent.document.getElementById(itemButton).parentNode.removeChild(parent.document.getElementById(itemButton)); 
    parent.document.getElementById(proName).parentNode.removeChild(parent.document.getElementById(proName));
    parent.document.getElementById(description).parentNode.removeChild(parent.document.getElementById(description));
    parent.document.getElementById(quantity).parentNode.removeChild(parent.document.getElementById(quantity));
    parent.document.getElementById(amount).parentNode.removeChild(parent.document.getElementById(amount));
    parent.document.getElementById(taxAmount).parentNode.removeChild(parent.document.getElementById(taxAmount));
    parent.document.getElementById(totalAmount).parentNode.removeChild(parent.document.getElementById(totalAmount));
    parent.document.getElementById("purchaseItems["+count+"].activity").value=0;
}
