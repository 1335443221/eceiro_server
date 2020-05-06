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
	         删除多个合同
	 */
	function delContracts() {
		var ids = "";
			
		$("input[type='checkbox']").each(function() {
			if ($(this).attr("checked") == "checked") {
				ids += $(this).attr("value") + ",";
			}
		});
		ids = ids.substring(0, ids.length - 1);
	
		$.post('basicinfo/contract/delete.action', {
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
	
	/*上报一条数据*/
	function submit(btn,id) {
		$tr = $(btn).parent().parent();
		$.post('basicinfo/contract/submit.action', {
			id : id
		}, function(result) {
			if ($.trim(result) == "true") {
				$tr.children("td").eq(5).html("<font color='green'>上报</font>");
			}
		});
	}
	/*
	  删除合同
	*/
	function delContract(btn) {
		$tr = $(btn).parent().parent();
		var id = $tr.children('td').eq(0).children('input').eq(0).val();
		var name = $tr.children('td').eq(3).text();
		var result = confirm("请问确认要删除" + name + "吗？");
		if(result) {
			$.post('basicinfo/contract/deleteById.action', {
				id : id,
			}, function() {
				$tr.remove();
			});
		}
	}
	

