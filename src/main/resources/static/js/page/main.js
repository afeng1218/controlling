/**
 * Created by guofeng on 2016/2/23. 主页面js
 */
define(['jquery', 'common', 'layer', 'bootstrap'], function ($, COMMON, layer) {

    function init(){
        /*用户名*/
        var username = COMMON.ECODE.Base64.decode($.cookie("username"));
        /*设置用户名*/
        $('#userName').text(username);
        /*设置隐藏用户名*/
        $('#hiddenName').val(username);
        /*设置主页面 菜单页面高度*/
        var height = ((screen.height * 6) / 7) - 100;
        $('#mainPageContent').css('height', height);
        $('#mainPageContent div').css('height', height);
        $('#mainPageContent div:last-child').css('height', 70);
        var uploadValue = {
            'username': username
        };
        /*监听iframe 加载完成*/
        $('#content').load(function () {
            /*获取页面权限*/
            var authority = $('.node-selected').find('input').eq(1).val();
            if (authority == 0) {
                $('#content').contents().find('#saveBtn').remove();
                $('#content').contents().find('#deleteBtn').remove();
            }
        });
    }
    return {
        "init": init
    };
});
