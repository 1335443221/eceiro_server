var $tr; //全局变量，保存更新和删除时被选中的行
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});
		$("#sel").click(function() {
			$("input[type='checkbox']").each(function() {
				if ($(this).attr("checked") == "checked") {
					$(this).removeAttr("checked");
				} else {
					$(this).attr("checked", "true");
				}
			})
		});
		$('#dlg').dialog('close');
	});

	/*
	 打开更新作者的对话框
	 */
	function openUpdateDialog(btn, id) {
		$tr = $(btn).parent().parent();
		$.ajax({
			type : "GET",
			url : "admin/basicinfo/factory/toupdate.action",
			data : {
				json : 'json',
				id : id
			},
			dataType : "json",
			async : false,
			success : function(factory) {
				$("#id").val(id);
				$("#fullName").val(factory.fullName);
				$("#factoryName").val(factory.factoryName);
				$("#contacts").val(factory.contacts);
				$("#phone").val(factory.phone);
				$("#mobile").val(factory.mobile);
				$("#fax").val(factory.fax);
				$("#inspector").val(factory.inspector);
				$("#orderNo").val(factory.orderNo);
				$("#cnote").val(factory.cnote);
			},
			error : function(xhr) { //xhr实际上是XmlHttpRequest
				alert(xhr.readyState);
				//ajax调用出错时，可以通过xhr参数获得错误信息。
				alert(xhr.responseText);
			}
		});
		$('#dlg').dialog({
			title : '修改厂家',
			width : 850,
			height : 400,
			closed : false,
			cache : false,
			collapsible : true,
			maximizable : true,
			resizable : true,
			shadow : true,
			left : 100,
			top : $(document).scrollTop() + 30,
			modal : true
		});
	}

	/*
	 更新厂家
	 */
	function updateFactory() {
		$.post('admin/basicinfo/factory/update.action', {
			id : $("#id").val(),
			fullName : $("#fullName").val(),
			factoryName : $("#factoryName").val(),
			contacts : $("#contacts").val(),
			phone : $("#phone").val(),
			mobile : $("#mobile").val(),
			fax : $("#fax").val(),
			inspector : $("#inspector").val(),
			orderNo : $("#orderNo").val(),
			cnote : $("#cnote").val()
		}, function(result) {
			$('#dlg').dialog('close');
			$tr.children('td').eq(2).text($("#fullName").val());
			$tr.children('td').eq(3).text($("#factoryName").val());
			$tr.children('td').eq(4).text($("#contacts").val());
			$tr.children('td').eq(5).text($("#phone").val());
			$tr.children('td').eq(6).text($("#mobile").val());
			$tr.children('td').eq(7).text($("#fax").val());
			$tr.children('td').eq(8).text($("#inspector").val());
		});
	}

	/*
	         删除多个厂家
	 */
	function delFactorys() {
		var ids = "";
		$("input[type='checkbox']").each(function() {
			if ($(this).attr("checked") == "checked") {
				ids += $(this).attr("value") + ",";
			}
		});
		ids = ids.substring(0, ids.length - 1);
		$.post('admin/basicinfo/factory/delete.action', {
			id : ids
		}, function(result) {
			if ($.trim(result) == "true") {
				$("input[type='checkbox']").each(function() {
					if ($(this).attr("checked") == "checked") {
						$(this).parent().parent().remove();
					}
				});
			}
		});
	}
	
	/*
	  删除厂家
	*/
	function delFactory(btn) {
		$tr = $(btn).parent().parent();
		var id = $tr.children('td').eq(0).children('input').eq(0).val();
		var name = $tr.children('td').eq(2).text();
		var result = confirm("请问确认要删除" + name + "吗？");
		if(result) {
			$.post('admin/basicinfo/factory/deleteById.action', {
				id : id,
			}, function() {
				$tr.remove();
			});
		}
	}
	
	/*
	打开新增厂家的对话框
	*/
	function openAddDialog() {
		$("#id").val('');
		$("#fullName").val('');
		$("#factoryName").val('');
		$("#contacts").val('');
		$("#phone").val('');
		$("#mobile").val('');
		$("#fax").val('');
		$("#inspector").val('');
		$("#orderNo").val('');
		$("#cnote").val('');
		$('#dlg').dialog({
			title : '新增厂家',
			width : 850,
			height : 400,
			closed : false,
			cache : false,
			collapsible : true,
			maximizable : true,
			resizable : true,
			shadow : true,
			left : 100,
			top : $(document).scrollTop() + 30,
			modal : true
		});
	}
	
	/*
	新增厂家
	*/
	function addFactory() {
		$.post('admin/basicinfo/factory/insert.action', {
			fullName : $("#fullName").val(),
			factoryName : $("#factoryName").val(),
			contacts : $("#contacts").val(),
			phone : $("#phone").val(),
			mobile : $("#mobile").val(),
			fax : $("#fax").val(),
			inspector : $("#inspector").val(),
			orderNo : $("#orderNo").val(),
			cnote : $("#cnote").val()
		}, function(uuid) {
			 //得到最后一行的序号值
			 var index = Number($('.list_table tr:last').find('td').eq(1).text());
			 index++;
			 if($(".list_table").find("tr").length<11) {
				 var row = "<tr>";
				 row += "<td align='center'><input type='checkbox' name='id' value='"+uuid+"' /></td>";
				 row += "<td align='center'>"+index+"</td>";
				 row += "<td>"+$("#fullName").val()+"</td>";
				 row += "<td align='center'>"+$("#factoryName").val()+"</td>";
				 row += "<td align='center'>"+$("#contacts").val()+"</td>";
				 row += "<td align='center'>"+$("#phone").val()+"</td>";
				 row += "<td align='center'>"+$("#mobile").val()+"</td>";
				 row += "<td align='center'>"+$("#fax").val()+"</td>";
				 row += "<td align='center'>"+$("#inspector").val()+"</td>";
				 row += "<td align='center'><a href='stop.action?id="+uuid+"'><font color='green'>启用</font></a></td>";
				 row += "<td align='center'><input type='button' name='button' onclick='openUpdateDialog(this,\""+uuid+"\")' class='btn btn82 btn_config' value='修改'></td>";
				 row += "<td align='center'><input type='button' name='button' onclick='delFactory(this)' class='btn btn82 btn_config' value='删除'></td></td>";
				 row += "</tr>";
				 $(".list_table tr:last").after(row);
			} 
			$('#dlg').dialog('close');
		});
	}
	
	/*
	操作
	*/
	function oper() {
		if($("#id").val()=="" || $("#id").val()==null) {
			addFactory();
		} else {
			updateFactory();
		}
	} 