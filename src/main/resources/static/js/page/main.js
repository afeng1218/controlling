/**
 * Created by guofeng on 2016/2/23. 主页面js
 */
define(['jquery', 'common', 'layer', 'bootstrap'], function ($, COMMON, layer) {
    var af={
        init:function(){
            COMMON.LAYER_CONFIG.config();
            /*设置主页面 菜单页面高度*/
            var height=$(window).height()-87;
            $('#mainPageContent').css('height', height);
            $('#homeDiv').css('height', height);//内容
            var a=af.loaDing();a=null;
            return null;
        },
        loaDing:function(){
            var a=af.loadMenu();a=null;
            var b=af.event();b=null;
            return null;
        },
        menuBtn:null,
        loadMenu:function(){
            /*用户名*/
            var username = COMMON.ECODE.Base64.decode($.cookie("username"));
            /*设置用户名*/
            $('#userName').text(username);
            /*设置隐藏用户名*/
            $('#hiddenName').val(username);
            var uploadValue = {
                'username': username
            };
            /*获取用户权限 加载权限菜单*/
            COMMON.WS.local('main/authority', 'get', uploadValue, true, function (data) {
                /*获取用户审批权限 设置隐藏用户审批权限信息*/
                $('#hiddenApprovalAuthority').val(data.applyAuthority);
                af.showMenuBtn(data.id,data.name);
                af.menuBtn=data.json;data=null;
            });
        },
        showMenuBtn:function(id,name){//后续中要ajax查询
            /*获取用户权限 加载权限菜单*/
            COMMON.WS.local('main/getMenuButton', 'get', {'id':id}, true, function (map) {
                if(map){
                    $("#but").empty();
                    $(".menuButton").unbind('click');
                    $("#content").attr("src",map[0].url);
                    $("#titleId").html(name+"-"+map[0].title);
                    for(var i=0;i<map.length;i++){
                        $("#but").append('<a class="menuButton button button-glow button-rounded button-raised button-primary" title="'+map[i].title+'" style="'+map[i].style+'" url="'+map[i].url+'">'+map[i].name+'</a>');
                    };map=null;
                    $(".menuButton").click(function(){
                        $("#content").attr("src",$(this).attr("url"));
                        $("#titleId").html(name+"-"+$(this).attr("title"));
                        return null;
                    });
                }else{
                    $(".menuButton").unbind('click');
                    $("#but").empty();
                    $("#content").attr("src",null);
                };map=null;
            });
        },
        event:function(){
            $("#Menu").click(function(){
                var this_=this;
                if(this.menu==null||this.menu==undefined){
                    this.menu=layer.open({
                        content:af.menuBtn.toString(),
                        area:['300px','565px'],
                        type:1,shade:0,title:'Menu',closeBtn:0,
                        offset:['42px', ($(window).width()-305)+'px'],
                        end:function(){this_.menu=null;this_=null;$(".menuClick").unbind('click');}
                    });
                    $(".layui-layer-title").css("background-color","#A9A9A9");
                    $(".layui-layer-content").css("background-color","#3F3F3F");
                    $('.layui-layer-btn').css("background-color","#3F3F3F");
                    $(".menuClick").click(function(){af.showMenuBtn($(this).attr("data"),$(this).html());return null;});
                    return null;
                };
                layer.close(this.menu);
                return null;
            });
            $("#icnLeft").click(function(){
                var t=$("#but").scrollLeft();
                var width=-$("#but").width()/1.5;
                $('#but').animate({'scrollLeft':t+width});
                return null;
            });
            $("#icnRight").click(function(){
                var t=$("#but").scrollLeft();
                var width=$("#but").width()/1.5;
                $('#but').animate({'scrollLeft':t+width});
                return null;
            });
        }
    }
    return {
        "init": af.init
    };
});
