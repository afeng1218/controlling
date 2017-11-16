/**
 * Created by guofeng on 2017/10/27.
 */
define(['jquery', 'common', 'layer', 'bootstrap', 'editable', 'jqueryui'], function ($, COMMON, layer) {


    var af = {
        init: function () {
            COMMON.LAYER_CONFIG.config();
            var a = af.load();
            a = null;//渲染JS代码
            return null;
        },
        //渲染主框架元素
        load: function () {
            alert("view页面加载");
            var a = af.loadEvent();
            a = null;
        },
        loadEvent: function () {

        },
        event: {}
    };
    return {
        "init": af.init
    };

});
var model_counter = 0;
//初始化一个jsPlumb实例
var instance = jsPlumb.getInstance({
    DragOptions: {cursor: "pointer", zIndex: 2000},
    ConnectionOverlays: [
        ["Arrow", {
            location: 1,
            visible: true,
            width: 11,
            length: 11,
            direction: 1,
            id: "arrow_forwards"
        }],
        ["Arrow", {
            location: 0,
            visible: true,
            width: 11,
            length: 11,
            direction: -1,
            id: "arrow_backwards"
        }],
        ["Label", {
            location: 0.5,
            id: "label",
            cssClass: "aLabel"
        }]
    ],
    Container: "container"
});
instance.importDefaults({
    ConnectionsDetachable: true,
    ReattachConnections: true
});
var connectorPaintStyle = {
    stroke: "#84ACB3",
    strokeWidth: 2
};
var hollowCircle = {
    endpoint: ["Dot", {cssClass: "endpointcssClass"}], //端点形状
    connectorStyle: connectorPaintStyle,
//  connectorHoverStyle: connectorHoverStyle,
    paintStyle: {
        fill: "#84ACB3",
        radius: 6
    },      //端点的颜色样式
    isSource: true, //是否可拖动（作为连接线起点）
    connector: ["Flowchart", {stub: 30, gap: 0, coenerRadius: 0, alwaysRespectStubs: true, midpoint: 0.5}],
    isTarget: true, //是否可以放置（连接终点）
    maxConnections: -1
};
$().ready(function (e) {
    $('#catalog li').draggable({
        helper: "clone",//复制模式
        cursor: "move",//光标类型
        scope: "plant"

    });
    $("#container").droppable({
        scope: "plant",
        drop: function (event, ui) {
            //创建模型到拖拽区
            CreateModel(ui, $(this));
        }
    });

});

function getModelTable() {
    var table = "<div class=\"ui-widget-content ui-corner-tr\"><img src=\"img/timg.jpg\"></div><a href=\"javascript:void(0)\" onclick=\"removeElement(this);\" style=\"color:black;\">X</a><i class=\"glyphicon glyphicon-remove\"></i>删除</a>";
    return table;
}

function CreateModel(ui, selector) {
    var modelid = $(ui.draggable).attr("id");
    model_counter++;
    var id = modelid + "_model_" + model_counter;
    var type = 1;
    var add_html = getModelTable(ui, type);
    $(selector).append('<div class="model" id="'
        + id + '" modelType="' + type
        + '" >' + add_html + '</div>');
    var left = parseInt(ui.offset.left - $(selector).offset().left);
    var top = parseInt(ui.offset.top - $(selector).offset().top);
    $("#" + id).css("position", "absolute").css("left", left).css("top", top);
    //添加连接点
    instance.addEndpoint(id, {anchors: "TopCenter"}, hollowCircle);
    instance.addEndpoint(id, {anchors: "RightMiddle"}, hollowCircle);
    instance.addEndpoint(id, {anchors: "BottomCenter"}, hollowCircle);
    instance.addEndpoint(id, {anchors: "LeftMiddle"}, hollowCircle);

    $("#" + id).draggable({
        containment: "parent",
        drag: function (event, ui) {
            instance.repaintEverything();
        },
        stop: function () {
            instance.repaintEverything();
        }
    });

    return id;
}
function removeElement(obj)
{
    var element = $(obj).parents(".model");
    if(confirm("确定删除该模型？"))
        instance.remove(element);
}

// $(function () {
//     var options = {
//         float: true
//     };
//     $('.grid-stack').gridstack(options);
//
//     new function () {
//         this.items = [
//             {x: 0, y: 0, width: 2, height: 2},
//
//         ];
//
//         this.grid = $('.grid-stack').data('gridstack');
//
//         this.add_new_widget = function () {
//             var node = this.items.pop() || {
//                 x: 2,
//                 y: 2,
//                 width: 2,
//                 height: 2
//             };
//             this.grid.add_widget($('<div><div class="grid-stack-item-content"/><div/>'),
//                 node.x, node.y, node.width, node.height);
//         }.bind(this);
//
//         $('#add-new-widget').click(this.add_new_widget);
//     };
// });
// $().ready(function (e) {
//     //拖拽复制体
//
//     // $('#sortable').sortable({
//     //     placeholder: "portlet-placeholder ui-corner-all",
//     //     revert: true
//     // });
//     // counts = [17];
//     $('#table').draggable({
//
//     })
//
//
//     $('#catalog li').draggable({
//        // connectToSortable: "#sortable",
//         helper: "clone",//复制模式
//         revert: "invalid",
//         cursor: "move",//光标类型
//         stop: function () {
//
//         },
//         helper: function (event) {
//             //替换显示内容
//             var bar_id = event.target.id
//             if (bar_id == "chechuang"){
//                 var source = $("<div class=\"ui-widget-content ui-corner-tr\"><img src=\"img/timg.jpg\"></div>").draggable({});//主体
//             }if (bar_id=="xichuang"){
//                 var source = $("<div class=\"ui-widget-content ui-corner-tr\"><img src=\"img/box3.png\"></div>");//主体
//             }if(bar_id=="mochuang"){
//                 var source = $("<div class=\"ui-widget-content ui-corner-tr\"><img src=\"img/box1.png\"></div>");
//             }
//             //隐藏标签
//             var item = $("<a href=\"javascript:void(0);\" class=\"remove label label-danger\"><i class=\"glyphicon glyphicon-remove\"></i>删除</a>")
//
//             $(item).click(function (event) {
//                 source.remove();
//             });
//
//             $(item, {
//                 style: 'display:none',
//                 // click: function() {
//                 //      source.remove();
//                 //  }
//             }).appendTo(source);
//
//             source.mouseenter(function () {
//                 $(this).find(item).show();
//             });
//
//             source.mouseleave(function () {
//                 $(this).find(item).hide();
//             });
//
//             $(this).append(source);
//
//             return source
//
//         }
//
//
//     });
//
//     //     activeClass: "ui-state-default",
//     //     hoverClass: "ui-state-hover" ,
//     //     accept: ":not(.ui-sortable-helper)",
//     //     drop: function( event, ui ) {
//     //         $( this ).find( ".placeholder" ).remove();
//     //         $( "<li></li>" ).text( ui.draggable.text() ).appendTo( this );
//     //         alert("拖拽完毕")
//     //     }
//     // }).sortable({
//     //     items: "li:not(.placeholder)",
//     //     sort: function() {
//     //         // 获取由 droppable 与 sortable 交互而加入的条目
//     //         // 使用 connectWithSortable 可以解决这个问题，但不允许您自定义 active/hoverClass 选项
//     //         $( this ).removeClass( "ui-state-default" );
//     //     }
//     // });
// });
