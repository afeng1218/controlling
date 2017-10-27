/**
 * Created by guofeng on 2017/10/27.
 */
define(['jquery', 'common', 'layer'], function ($, COMMON, layer) {
    var af={
        init:function(){
            COMMON.LAYER_CONFIG.config();
            var a=this.loaDing();a=null;
            return null;
        },
        //渲染主框架元素
        loaDing:function(){
            alert(1123321);
        }
    };
    //返回入口
    return {
        "init": af.init
    };
});
