/**
 * Created by guofeng on 2017/10/27.
 */
define(['jquery', 'common', 'layer', 'bootstrap', 'editable', 'bootstraptable'], function ($, COMMON, layer) {

    var af = {
        init: function () {
            COMMON.LAYER_CONFIG.config();
            var a = af.load();
            a = null;//渲染JS代码
            return null;
        },
        //渲染主框架元素
        load: function () {
            var a = af.loadEvent();
            a = null;
            var b = af.table.load();
            b = null;
        },
        loadEvent: function () {
            var a = $('#btn_delete').click(af.event.delete);
            a = null;

        },
        event:{
            delete :function () {
                layer.confirm('是否删除所选择数据?', {icon: 3, title:'提示'}, function(index){
                    var updateValue = $('#tb_departments').bootstrapTable('getSelections')
                    var ids = new Array();
                    for (var i=0;i<updateValue.length;i++){
                        ids.push(updateValue[i].id);
                    }
                    var deletes = {
                        'ids': ids.toString()
                    };
                    COMMON.WS.local('test/deleteTest','post',deletes,true,function (data){
                        $('#tb_departments').bootstrapTable(
                            "refresh")
                    });
                    layer.close(index);
                });
            }
        },
        table: {
            load: function () {
                COMMON.WS.local('test/getTestList', 'get', null, true, function (data) {
                    var oTableInit = JSON.stringify(data);
                    $('#tb_departments').bootstrapTable({
                        url: 'test/getTestList',         //请求后台的URL（*）
                        method: 'get',
                        toolbar: '#toolbar',                //工具按钮用哪个容器
                        striped: true,                      //是否显示行间隔色
                        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                        //pagination: true,                   //是否显示分页（*）
                        sortable: false,                     //是否启用排序
                        sortOrder: "asc",                   //排序方式
                        queryParams: oTableInit,//传参
                        // sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                        pageNumber: 1,                       //初始化加载第一页，默认第一页
                        pageSize: 10,                       //每页的记录行数（*）
                        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                        search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                        strictSearch: true,
                        showColumns: true,                  //是否显示所有的列
                        showRefresh: true,                  //是否显示刷新按钮
                        minimumCountColumns: 2,             //最少允许的列数
                        clickToSelect: true,                //是否启用点击选中行
                        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                        uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                        cardView: false,                    //是否显示详细视图
                        detailView: false,                   //是否显示父子表
                        columns: [{
                            checkbox: true
                        }, {
                            field: 'name',
                            title: '姓名'
                        }, {
                            field: 'dept',
                            title: '部门'
                        }
                            ,
                        ]
                    });
                })
            }
        }
    }

    return {
        "init": af.init
    };
});
// var af = {
//     init: function () {
//         COMMON.LAYER_CONFIG.config();
//         var a = af.load();
//         a = null;//渲染JS代码
//         return null;
//     },
//     //渲染主框架元素
//     load: function () {
//         var a = af.loadEvent();
//         a = null;
//         var b = af.table.load();
//         b = null;
//     },
//     //绑定事件
//     loadEvent: function () {
//         var a = $('#submit').click(af.event.setNameAndDept);
//         a = null;
//         var b = $('#remove').click(af.event.remove);
//         b = null;
//         var c = $('#edit_btn').click(af.event.editDialog);
//         c = null;
//         var d = $('#save').click(af.event.saveedit);
//         d = null;
//         var e = $('#user_find').click(af.event.search);
//         e=null;
//
//     },
//     //事件集合
//     event: {
//         //查询
//         search : function () {
//           var user_name = $('#s_userName').val();
//           var dept_name = $('#s_deptName').val();
//           var url = 'test/findTestByDept';
//           var update_value = {
//               'name':user_name,
//               'dept':dept_name
//           }
//           if (user_name!=''&&dept_name==''){
//                url = 'test/findTestByName';
//           }
//           COMMON.WS.local(url, 'get', update_value, true, function (data){
//               $("#mainbody").html("");
//               for (var i = 0; i < data.length; i++) {
//                   $("#mainbody").append(
//                       "<tr>" +
//                       "<td>" +
//                       "<input name=\"checkbox\" type=\"checkbox\" value=\"" + data[i].id + "\" >\n" +
//                       "</td>" +
//                       "<td id=\"uname" + i + "\"></td>\n" +
//                       "<td id=\"udept" + i + "\"></td>\n" +
//                       "</td>" +
//                       "</tr>");
//                   $('#uname' + i + '').text(data[i].name);
//                   $('#udept' + i + '').text(data[i].dept);
//               }
//           });
//         },
//         //edit保存
//         saveedit: function () {
//             var id = $('#editid').val();
//             var name = $('#editname').val();
//             var dept = $('#editdept').val();
//             var updateValue = {
//                 'id': id,
//                 'name': name,
//                 'dept': dept,
//             };
//             id = null;
//             name = null;
//             dept = null;
//             COMMON.WS.local('test/updateTest', 'get', updateValue, true, function (data) {
//                 var flag = true;
//                 if (data == flag) {
//                     alert("保存成功");
//                     location.reload();
//                     return;
//                 }
//             });
//             updateValue = null;
//         },
//         //edit事件
//         editDialog: function () {
//             var checkedList = new Array();
//             $("input[name='checkbox']:checkbox:checked").each(function () {
//                 checkedList.push($(this).val());
//                 if (checkedList.length > 1) {
//                     alert("只能选择一条数据")
//                     location.reload();
//                 } else {
//                     var id = {
//                         'id': checkedList.toString()
//                     };
//                     COMMON.WS.local('test/findTest', 'get', id, true, function (data) {
//                         for (var i = 0; i < data.length; i++) {
//                             $('#editid').val((data[0]).id);
//                             $('#editname').val(data[0].name);
//                             $('#editdept').val(data[0].dept);
//                         }
//                     });
//                 }
//             })
//             document.getElementById("hiddendiv").style.display="";
//             layer.open({
//                 type: 1,
//                 area: ['600px', '200px'],
//                 scrollbar: false,//禁止浏览器滚动
//                 content: $('#editUser'),
//             });
//         },
//         //submit事件
//         setNameAndDept: function () {
//             var name = $('#name').val();
//             var dept = $('#dept').val();
//             var updateValue = {
//                 'name': name,
//                 'dept': dept,
//             };
//             name = null;
//             dept = null;
//             COMMON.WS.local('test/setNameAndDept', 'get', updateValue, true, function (data) {
//                 var flag = true;
//                 if (data == flag) {
//                     alert("保存成功");
//                     location.reload();
//                     return;
//                 }
//             });
//             updateValue = null;
//         },
//         //批量删除
//         remove: function () {
//             var checkedList = new Array();
//             $("input[name='checkbox']:checkbox:checked").each(function () {
//                 checkedList.push($(this).val());
//             })
//             var deletes = {
//                 'delitems': checkedList.toString()
//             };
//             alert(checkedList.toString());
//             COMMON.WS.local('test/deleteTest', 'post', deletes, true, function (data) {
//                 var flag = true;
//                 if (data == flag) {
//                     alert("删除成功");
//                     location.reload();
//                     return;
//                 }
//             });
//             return null;
//         }
//     },
//     table: {
//         load: function () {
//             COMMON.WS.local('test/getTestList', 'get', null, true, function (data) {
//                 for (var i = 0; i < data.length; i++) {
//                     $("#mainbody").append(
//                         "<tr>\n" +
//                         "<td>\n" +
//                         "<input  name=\"checkbox\" type=\"checkbox\" value=\"" + data[i].id + "\" >\n" +
//                         "</td>\n" +
//                         "<td class='uname' id=\"uname" + i + "\"></td>\n" +
//                         "<td class='udept' id=\"udept" + i + "\"></td>\n" +
//                         "<td >111</td>\n" +
//                         "<td  >1231231</td>\n" +
//                         "</tr>");
//                     $('#uname' + i + '').text(data[i].name);
//                     $('#udept' + i + '').text(data[i].dept);
//                 }
//                 //editable初始化
//                 $('.uname').editable({
//                     title: "姓名",
//                     mode:"inline",
//                     validate: function (value) { //字段验证
//                         if (!$.trim(value)) {
//                             return '不能为空';
//                         }
//
//                     },
//                     submit : function (value) {
//                       alert(value);
//                     }
//                 });
//                 $('.udept').editable({
//                     title: "部门",
//                     mode:"inline",
//                     validate: function (value) { //字段验证
//                         if (!$.trim(value)) {
//                             return '不能为空';
//                         }
//                     }
//                 });
//             });
//         },
//         add: function () {
//
//         },
//         remove: function () {
//             alert(1)
//         },
//         save: function () {
//
//         }
//     }
//     };
//     //返回入口
//     return {
//         "init": af.init
//     };
// });
