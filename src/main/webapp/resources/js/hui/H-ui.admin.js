function tabNavallwidth() {
	var taballwidth = 0, $tabNav = $(".acrossTab"), $tabNavWp = $(".Hui-tabNav-wp"), $tabNavitem = $(".acrossTab li"), $tabNavmore = $(".Hui-tabNav-more");
	if (!$tabNav[0]) {
		return;
	}
	$tabNavitem.each(function(index, element) {
		taballwidth += Number(parseFloat($(this).width() + 60));
	});
	$tabNav.width(taballwidth + 25);
	var w = $tabNavWp.width();
	if (taballwidth + 25 > w) {
		$tabNavmore.show();
	} else {
		$tabNavmore.hide();
		$tabNav.css({
			left : 0
		});
	}
}

/* 全选 */
$("table thead th input:checkbox").on(
		"click",
		function() {
			var that = this;
			$(this).closest("table").find("tr > td:first-child input:checkbox")
					.each(function() {
						this.checked = that.checked;
						$(this).closest("tr").toggleClass("selected");
					});
		});
/* 批量删除 */
function datadel() {
	layer.confirm('确认要删除吗？', function(index) {
		alert("测试");
		layer.msg('已删除!', 1);
	});
}

/* 弹出层 */
function layer_show(w, h, title, url) {
	if (w == null || w == '') {
		w = 800;
	}
	;
	if (h == null || h == '') {
		h = ($(window).height() - 50);
	}
	;
	if (title == null || title == '') {
		title = false;
	}
	;
	if (url == null || url == '') {
		url = "404.html";
	}
	;
	$.layer({
		type : 2,
		shadeClose : true,
		title : title,
		maxmin : false,
		shadeClose : true,
		closeBtn : [ 0, true ],
		shade : [ 0.8, '#000' ],
		border : [ 0 ],
		offset : [ '20px', '' ],
		area : [ w + 'px', h + 'px' ],
		iframe : {
			src : url
		}
	});
}
/*----------用户管理------------------*/
/* 用户-添加 */
function user_add(w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 用户-查看 */
function user_show(id, w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 用户-密码-修改 */
function user_password_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}

/* 用户-编辑 */
function user_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 用户-编辑-保存 */
function user_edit_save(obj, id) {
	var i = parent.layer.getFrameIndex();
	parent.layer.close(i);
}

/* 用户-停用 */
function user_stop(obj, id) {
	$(obj)
			.parents("tr")
			.find(".user-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="user_start(this,\'10001\')" href="javascript:;" title="启用"><i class="icon-hand-up"></i></a>');
	$(obj).parents("tr").find(".user-status").html(
			'<span class="label">已停用</span>');
	$(obj).remove();
}
/* 用户-启用 */
function user_start(obj, id) {
	$(obj)
			.parents("tr")
			.find(".user-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="user_stop(this,\'10001\')" href="javascript:;" title="停用"><i class="icon-hand-down"></i></a>');
	$(obj).parents("tr").find(".user-status").html(
			'<span class="label label-success">已启用</span>');
	$(obj).remove();
}
/*------------资讯管理----------------*/
/* 获取分类值 */
function SetSubID(obj) {
	$("#hid_ccid").val($(obj).val());
}
/* 资讯-分类-添加 */
function artice_class_add(obj) {
	var v = $("#artice-class-val").val();
	if (v == "" || v == null) {
		return false;
	} else {
		// ajax请求 添加分类
	}
}

/* 资讯-分类-编辑 */
function artice_class_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 资讯-添加 */
function artice_add(w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 资讯-编辑 */
function artice_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 资讯-下架 */
function artice_xiajia(obj, id) {
	$(obj)
			.parents("tr")
			.find(".artice-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="artice_fabu(this,\'10001\')" href="javascript:;" title="发布"><i class="icon-hand-up"></i></a>');
	$(obj).parents("tr").find(".artice-status").html(
			'<span class="label">已下架</span>');
	$(obj).remove();
}
/* 资讯-发布 */
function artice_fabu(obj, id) {
	$(obj)
			.parents("tr")
			.find(".artice-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="artice_xiajia(this,\'10001\')" href="javascript:;" title="下架"><i class="icon-hand-down"></i></a>');
	$(obj).parents("tr").find(".artice-status").html(
			'<span class="label label-success">已发布</span>');
	$(obj).remove();
}
/*------------图片库--------------*/
/* 图片库-分类-添加 */
function picture_class_add(obj) {
	var v = $("#picture-class-val").val();
	if (v == "" || v == null) {
		return false;
	} else {
		// ajax请求 添加分类
	}
}

/* 图片库-分类-编辑 */
function picture_class_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 图片库-添加 */
function picture_add(w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 图片库-编辑 */
function picture_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 图片库-下架 */
function picture_xiajia(obj, id) {
	$(obj)
			.parents("tr")
			.find(".picture-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="picture_fabu(this,\'10001\')" href="javascript:;" title="发布"><i class="icon-hand-up"></i></a>');
	$(obj).parents("tr").find(".picture-status").html(
			'<span class="label">已下架</span>');
	$(obj).remove();
}
/* 图片库-发布 */
function picture_fabu(obj, id) {
	$(obj)
			.parents("tr")
			.find(".picture-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="picture_xiajia(this,\'10001\')" href="javascript:;" title="下架"><i class="icon-hand-down"></i></a>');
	$(obj).parents("tr").find(".picture-status").html(
			'<span class="label label-success">已发布</span>');
	$(obj).remove();
}

/*------------管理员管理--------------*/
/* 管理员-角色-添加 */
function admin_role_add(w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 管理员-角色-编辑 */
function admin_role_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}
/* 管理员-角色-删除 */
function admin_role_del(obj, id) {
	layer.confirm('角色删除须谨慎，确认要删除吗？', function(index) {
		$(obj).parents("tr").remove();
		layer.msg('已删除!', 1);
	});
}

/* 管理员-权限-添加 */
function admin_permission_add() {

}
/* 管理员-权限-编辑 */
function admin_permission_edit(id, w, h, title, url) {
	layer_show(w, h, title, url);
}

/* 管理员-权限-删除 */
function admin_permission_del(obj, id) {
	layer.confirm('角色删除须谨慎，确认要删除吗？', function(index) {
		$(obj).parents("tr").remove();
		layer.msg('已删除!', 1);
	});
}

/* 管理员-编辑-保存 */
function admin_edit_save(obj, id) {
	var i = parent.layer.getFrameIndex();
	parent.layer.close(i);
}
/* 管理员-删除 */
function admin_del(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		$(obj).parents("tr").remove();
		layer.msg('已删除!', 1);
	});
}
/* 管理员-停用 */
function admin_stop(obj, id) {
	$(obj)
			.parents("tr")
			.find(".admin-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="admin_start(this,\'10001\')" href="javascript:;" title="启用"><i class="icon-hand-up"></i></a>');
	$(obj).parents("tr").find(".admin-status").html(
			'<span class="label">已停用</span>');
	$(obj).remove();
}
/* 管理员-启用 */
function admin_start(obj, id) {
	$(obj)
			.parents("tr")
			.find(".admin-manage")
			.prepend(
					'<a style="text-decoration:none" onClick="admin_stop(this,\'10001\')" href="javascript:;" title="停用"><i class="icon-hand-down"></i></a>');
	$(obj).parents("tr").find(".admin-status").html(
			'<span class="label label-success">已启用</span>');
	$(obj).remove();
}
/*------------系统管理--------------*/
/* 系统管理-日志-删除 */
function system_log_del(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		$(obj).parents("tr").remove();
		layer.msg('已删除!', 1);
	});
}
/* ======================================================= */
$(function() {
	/* 菜单处于当前状态 */
	var webSite = "";
	var loc = location.href;
	var url = loc.replace(webSite, "");
	$(".menu_dropdown ul li").each(function() {
		var current = $(this).find("a");
		$(this).removeClass("current");
		if (url == $(current[0]).attr("href")) {
			$(this).addClass("current");
		}
	});

	$("#nav-toggle").click(function() {
		$(".Hui-aside").slideToggle();
	});

	$(".dislpayArrow a").click(function() {
		if ($(".Hui-aside").is(":hidden")) {
			$(".Hui-aside").show();
			$(this).removeClass("open");
			$(".Hui-article,.dislpayArrow").css({
				"left" : "200px"
			});
		} else {
			$(this).addClass("open");
			$(".Hui-aside").hide();
			$(".Hui-article,.dislpayArrow").css({
				"left" : "0"
			});
		}
	});

	/* 选项卡导航 */
	var topWindow = $(window.parent.document);
	$(".Hui-aside .menu_dropdown a").click(function() {
		var bStop = false;
		var bStopIndex = 0;
		var _href = $(this).attr('_href');
		var _titleName = $(this).html();
		var show_navLi = topWindow.find("#min_title_list li");
		show_navLi.each(function() {
			if ($(this).find('span').attr("data-href") == _href) {
				bStop = true;
				bStopIndex = show_navLi.index($(this));
				return false;
			}
		});
		if (!bStop) {
			creatIframe(_href, _titleName);
			min_titleList();
		} else {
			show_navLi.removeClass("active").eq(bStopIndex).addClass("active");
			var iframe_box = topWindow.find("#iframe_box");
			iframe_box.find(".show_iframe").hide().eq(bStopIndex).show();
		}
	});
	min_titleList()
	function min_titleList() {
		var show_nav = topWindow.find("#min_title_list");
		var aLi = show_nav.find("li");
	}
	;
	function creatIframe(href, titleName) {
		var show_nav = topWindow.find('#min_title_list');
		show_nav.find('li').removeClass("active")
		var iframe_box = topWindow.find('#iframe_box');
		show_nav.append('<li class="active"><span data-href="' + href + '">'
				+ titleName + '</span><i></i><em></em></li>');
		tabNavallwidth();
		var iframeBox = iframe_box.find('.show_iframe')
		iframeBox.hide();
		iframe_box
				.append('<div class="show_iframe"><div class="loading"></div><iframe frameborder="0" src="'
						+ href + '"></iframe></div>');
		var showBox = iframe_box.find('.show_iframe:visible')
		showBox.find('iframe').hide().load(function() {
			showBox.find('.loading').hide();
			$(this).show()
		});
	}

	var num = 0;
	var oUl = $("#min_title_list");
	var hide_nav = $("#Hui-tabNav");
	$(document).on(
			"click",
			"#min_title_list li",
			function() {
				var bStopIndex = $(this).index();
				var iframe_box = $("#iframe_box");
				$("#min_title_list li").removeClass("active").eq(bStopIndex)
						.addClass("active");
				iframe_box.find(".show_iframe").hide().eq(bStopIndex).show();
			});
	$(document).on("click", "#min_title_list li i", function() {
		var aCloseIndex = $(this).parents("li").index();
		$(this).parent().remove();
		$('#iframe_box').find('.show_iframe').eq(aCloseIndex).remove();
		num == 0 ? num = 0 : num--;
		tabNavallwidth();
	});
	tabNavallwidth();

	$('#js-tabNav-next')
			.click(
					function() {
						num == oUl.find('li').length - 1 ? num = oUl.find('li').length - 1
								: num++;
						toNavPos()
					});
	$('#js-tabNav-prev').click(function() {
		num == 0 ? num = 0 : num--;
		toNavPos();
	});

	function toNavPos() {
		oUl.stop().animate({
			'left' : -num * 100
		}, 100)
	}
	/*
	 * jQuery("#Hui-tabNav").slide({mainCell:".Hui-tabNav-wp #min_title_list
	 * li",prevCell:"#js-tabNav-prev",nextCell:"#js-tabNav-next",autoPage:false,effect:"leftLoop",vis:10,pnLoop:false,trigger:"click"});
	 */

});

function user_hover() {
	var _left = $("#userbox_span").offset().left;
	var _top = $("#userbox_span").offset().top;
	var height = $("#userbox_span").height();
	$("#user-dropDown-menu").css({
		"left" : _left,
		"top" : _top + height
	});
	$("#user-dropDown-menu").show();

}
function user_mout() {
	$("#user-dropDown-menu").hide();
}
function language_hover() {
	var _left = $("#language_span").offset().left;
	var _top = $("#language_span").offset().top;
	var height = $("#language_span").height();
	$("#language-dropDown-menu").css({
		"left" : _left,
		"top" : _top + height
	});
	$("#language-dropDown-menu").show();
}
function language_mout() {
	$("#language-dropDown-menu").hide();
}