<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/new"/>
<c:url var="NewURL" value="/quan-tri/bai-viet/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul><!-- /.breadcrumb -->

        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}" >
                                ${message}
                        </div>
                    </c:if>

                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
                        <div class="form-group">
                            <label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-9">
                            <form:select path="categoryCode" id="categoryCode" >

<%--                                <option value="">--Chọn thể loại--</option>--%>
<%--                                <c:forEach var="item" items="${categorys}">--%>
<%--                                    <option value="${item.code}">${item.name}</option>--%>
<%--                                </c:forEach>--%>
                            <form:option value="" label="--Chọn thể loại--"/>
                                <form:options items="${categorys}"/>
                            </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="title" >Tên bài viết </label>

                            <div class="col-sm-9">
<%--                                <input type="text" class="col-xs-10 col-sm-5" id ="title" name="title" value="${model.title}" />--%>
                                <form:input path="title" class="col-xs-10 col-sm-5"/>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="thumbnail" >Ảnh đại diện </label>
                            <div class="col-sm-9">
                                <input type="file"  class="col-xs-10 col-sm-5" id="thumbnail"  name="thumbnail" value="${model.thumbnail}"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <label for="shortdese" class="col-sm-3 control-label no-padding-right"  >Mô tả ngắn</label>
                            <div class="col-sm-9">
<%--                            <textarea class="form-control" rows="5" cols="10" id="shortdese" name="shortdese" >${model.shortdese}</textarea>--%>
                                <form:textarea path="shortdese"  class="form-control" rows="5" cols="10" id="shortdese"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="content" class="col-sm-3 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-9">
<%--                            <textarea class="form-control" rows="5" cols="10" id="content" name="content" >${model.content}</textarea>--%>
                                <form:textarea path="content" class="form-control" rows="5" cols="10" id="content" />
                            </div>
                        </div>
                        <form:hidden path="id" id="newId"/>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Cập nhật bài viết
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Thêm bài viết
                                    </button>
                                </c:if>

                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Hủy
                                </button>
                            </div>
                        </div>

                    </form:form>

                </div>
            </div>
        </div>

    </div>
</div>
<script>
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
       var data = {};
       var formData = $('#formSubmit').serializeArray();
       $.each(formData , function (i,v) {
           data[""+v.name+""] = v.value;
       })
        var id = $('#newId').val();
        if(id == "")
        {
            addNew(data);
        }else
        {
            updateNew(data);
        }
     function addNew() {
         $.ajax({
             url:'${APIurl}',
             type:'POST',
             contentType:'application/json' , // clien gui len sever
             data : JSON.stringify(data),
             dataType : 'json',
             success: function (result) {
                 window.location.href = "${editNewURL}?message=insert_success";
             },
             error:function (result) {
                 window.location.href = "${NewURL}?page=1&limit=2&message=error_system";

             }
         });
     }
     function updateNew() {
         $.ajax({
             url:'${APIurl}',
             type:'PUT',
             contentType:'application/json', // clien gui len sever
             data : JSON.stringify(data),  // CHUYỂN ĐỔI OPJECT JAVASPRIT SANG JSON
             dataType : 'json',   // TỪ SEVER TRẢ VỀ CHO Client
             success: function (result) {
                 window.location.href = "${editNewURL}?message=update_success";
             },
             error:function (result) {
                 window.location.href = "${NewURL}?page=1&limit=2&message=error_system";

             }
         });
     }
    });

</script>
</body>
</html>
