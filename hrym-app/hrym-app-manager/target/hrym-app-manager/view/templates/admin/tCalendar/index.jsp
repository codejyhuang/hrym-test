<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>日历</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${pageContext.request.contextPath}/view/static/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/static/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/view/static/assets/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/view/static/assets/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/static/assets/css/style.css?v=4.1.0" rel="stylesheet">

    <style>
    table{
        width:100px;
        table-layout:fixed;/* 只有定义了表格的布局算法为fixed，下面td的定义才能起作用。 */
    }
    td{
        width:100%;
        word-break:keep-all;/* 不换行 */
        white-space:nowrap;/* 不换行 */
        overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
    }
    .table td:hover{
        overflow: scroll;
        white-space: nowrap;
        height: 20px;
    }
    /*设置input的内容*/
    .lW{
        width: 60%;
        margin-left: 3%;
    }
    /*模态框样式*/
    .modal-style{
        border:0px solid #bbe1f1;
        background:#eefaff;

    }
</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>日历</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row row-lg">
		                    <div class="col-sm-12">
		                        <!-- Example Card View -->
                                <div>
                                    <!-- 按钮触发模态框 -->
                                    <button class="btn btn-primary" data-toggle="modal" data-backdrop="static" data-target="#myModal" id=""onclick="rest();">
                                        日历添加
                                    </button>
                                </div>
		                        <div class="example-wrap">
		                            <div class="example">
		                            	<table id="table_list"></table>
		                            </div>
		                        </div>
		                        <!-- End Example Card View -->
		                    </div>
	                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content modal-style">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">
                        日历
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form" id="model_from" action="">
                        <input type="hidden" id="Id" name="Id" value="" placeholder="类目ID"/>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">开始时间:</label>
                            <div class="col-sm-10">
                                <input class="form-control lW" id="startTimes" name="startTimes" type="text"  value=""
                                       placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">结束时间:</label>
                            <div class="col-sm-10">
                                <input class="form-control lW" id="endTimes" name="endTimes" type="text"  value=""
                                       placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span class="oas-impInfo"></span>日历图片：</label>
                            <div class="col-sm-10">
                                <input name="datePic" id="datePic" class="form-control lW" type="text" value="" readonly>
                            </div>
                            <div class="col-sm-2 lW" style="margin-left: 36%">
                                <label class="col-sm-10 control-label">
                                    <input type="file" class="fileEdit" name="taskItemPic" class="itemPic oas-filebutton-default">
                                </label>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary save" id="btn">提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/view/static/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/view/static/assets/js/bootstrap.min.js?v=3.3.6"></script>

	<!-- Bootstrap table -->
    <script src="${pageContext.request.contextPath}/view/static/assets/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/static/assets/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/static/assets/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <!-- Peity -->
    <script src="${pageContext.request.contextPath}/view/static/assets/js/plugins/peity/jquery.peity.min.js"></script>

    <script src="${pageContext.request.contextPath}/view/static/assets/js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/view/static/assets/js/content.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/view/static/assets/js/plugins/layer/laydate/laydate.js"></script>


    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
        	//初始化表格,动态从服务器加载数据
			$("#table_list").bootstrapTable({
			    //使用get请求到服务器获取数据
                type: "POST",
			    //必须设置，不然request.getParameter获取不到请求参数
			    contentType: "application/json  ",
			    //获取数据的Servlet地址
			    url: "${pageContext.request.contextPath}/admin/findAllTcalend",
			    //表格显示条纹
			    striped: false,
			    //启动分页
			    pagination: true,
			    //每页显示的记录数
			    pageSize: 10,
			    //当前第几页
			    pageNumber: 1,
			    //记录数可选列表
			    pageList: [5, 10, 15, 20, 25],
			    //是否启用查询
			    search: false,
                showColumns: true, //是否显示所有的列
                showToggle:true, //是否显示详细视图和列表视图的切换按钮
                cardView: false, //是否显示详细视图
                clickToSelect: true, //是否启用点击选中行
			    //是否显示父子表信息
			    detailView:false,
			    detailFormatter:detailFormatter,
                //分页方式：client客户端分页，server服务端分页（*）
			    sidePagination: "server",
			    //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
			    //设置为limit可以获取limit, offset, search, sort, order
			    queryParamsType: "undefined",
			    //json数据解析
			    responseHandler: function(res) {
			        return {
			            "rows": res.rows,
			            "total": res.total
			        };
			    },
			    //数据列
			    columns: [{
			        title: "日历ID",
			        field: "Id",
			        sortable: true
			    },{
			        title: "日历图片",
			        field: "datePic"
			    },{
			        title: "开始时间",
			        field: "startTime"
			    },{
                    title: "结束时间",
                    field: "endTime"
                },{
			        title: "操作",
			        field: "empty",
                    formatter: function (value, row) {
                    	var operateHtml = '<button class="btn btn-primary btn-xs" type="button" data-toggle="modal" data-backdrop="static" data-target="#myModal" onclick="edit(\''+row.Id+'\')"><i class="fa fa-edit"></i>&nbsp;修改</button> &nbsp;';
                    	operateHtml = operateHtml + '<button class="btn btn-danger btn-xs" type="button" onclick="del(\''+row.Id+'\')"><i class="fa fa-remove"></i>&nbsp;删除</button> &nbsp;';
                        return operateHtml;
                    }
			    }]
			});
        });

        //请求服务数据时所传参数
        function queryParams(params){
            return{
                //每页多少条数据
                pageSize: params.limit,
                //请求第几页
                pageIndex:params.pageNumber,
                Name:$('#search_name').val(),
                Tel:$('#search_tel').val()
            }
        }
//input值初始化
        function rest() {
            $("#Id").val("");
        }
//        根据ID查找类目内容
        function edit(id) {
                $.ajax({
                    type:"get",
                    dataType:"json",
                    contentType:"application/json",
                    url :"${pageContext.request.contextPath}/admin/FindTcalendById/",
                    data:{"Id":id},
                    success:function (msg) {
                        $("#Id").val(msg.id);
                        $("#startTimes").val(msg.startTimes);
                        $("#endTimes").val(msg.endTimes);
                        $("#datePic").val(msg.datePic);
//                    document.getElementById("itemId1").value=msg.rows.itemId;
                    }
                });
        }

        //重命名保存
        $(document).on("click",".save",function(){
            debugger
            if (Id.value.length>0){
                url="${pageContext.request.contextPath}/admin/updateAllTcalend"
            }else {
                url="${pageContext.request.contextPath}/admin/insertAllTcalend"
            }
            var  form = new FormData($(model_from)[0]);
            layer.msg('正在提交中，请稍等。。。', {
                icon: 16,
                shade: 0.01,
                time:0
            });
            $.ajax({
                type: "POST",
                processData:false,
                contentType:false,
                url: url,
                data:form,
                success: function(msg){
                    if (msg.code==0){
                       layer.msg(msg.message);
                        layer.close();
                        $('#table_list').bootstrapTable("refresh");
                        return;
                    } else {
                        layer.msg('操作失败。。。');
                        layer.close();
                        $('#table_list').bootstrapTable("refresh");
                        return;
                    }
                }
            });
        });

        //商品类目添加
        $(document).on("click",".inssssert",function(){

            var  form = new FormData($(model_from)[0]);
            layer.msg('正在提交中，请稍等。。。', {
                icon: 16,
                shade: 0.01,
                time:0
            });
            $.ajax({
                type: "POST",
                processData:false,
                contentType:false,
                url: "${pageContext.request.contextPath}/admin/insertAllTcalend",
                data:form,
                success: function(msg){
                    debugger
                    if (msg.code==0){
                        layer.msg(msg.message);
                        layer.close();
                        $('#table_list').bootstrapTable("refresh");
                        return;
                    } else {
                        layer.msg('操作失败。。。');
                        layer.close();
                        $('#table_list').bootstrapTable("refresh");
                    }
                }
            });
        });
//        删除日历
        function del(id){
        	layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
                layer.msg('正在提交中，请稍等。。。', {
                    icon: 16,
                    shade: 0.01,
                    time:0
                });
        		$.ajax({
                    type: "GET",
                    dataType: "json",
                    contentType: "application/json",
                    url:"${pageContext.request.contextPath}/admin/deleteAllTcalend/",
                    data:{"Id":id},
                    success: function(msg){

	 	   	    			layer.msg(msg.message, {time: 2000},function(){
	 	   	    				$('#table_list').bootstrapTable("refresh");
	 	   	    				layer.close(index);
	 	   					});
    	    		   }
    	    	});
       		});
        }

        //上传文件
        $(document).on("change",".fileEdit",function(){

            var _this = $(this);
            var oMyForm = new FormData();
            if(!!!_this[0].files[0])
                return;
            oMyForm.append("file", _this[0].files[0]);
            layer.msg('正在提交中，请稍等。。。', {
                icon: 16,
                shade: 0.01,
                time:0
            });

            $.ajax({
                type: "POST",
                processData:false,
                contentType:false,
                url: "${pageContext.request.contextPath}/admin/uploadFile",
                data:oMyForm,
                success: function(msg){
                    if (msg==''){
                        parent.layer.msg('上传失败，请重新上传。。。');
                        return;
                    }
                    layer.msg('上传成功。。。', {time: 2000},function(){

                        _this.closest(".form-group").find(".form-control").val(msg);
                        layer.close();
                    });
                }
            });

        });

        function detailFormatter(index, row) {
	        var html = [];
	        html.push('<p><b>描述:</b> ' + row.description + '</p>');
	        return html.join('');
	    }
        //模态框关闭初始化事件
        $(function () { $('#myModal').on('hidden.bs.modal', function () {
            document.getElementById("model_from").reset();
            document.getElementById("btn").disabled = false;
        })
        });

    </script>
</body>

</html>
