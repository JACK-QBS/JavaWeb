// document ：存在于 javaScript 的全局变量
// element.onclick：当这个元素被点击的时候，执行 function这个方法
/*document.getElementById("button").onclick = function () {
    console.log("点击成功");
    document.getElementById("content").innerHTML = "js";
}*/

/**
 * 找到 id 是 content 的元素
 * 当这个元素发生了 mouseover(鼠标越过)事件时
 * 执行我们传入的方法
 * 把 id 是 content 的元素内部 html 内容替换成 js
 */
/*
$(function main() {
    $("#content").on("mouseover", function () {
        $("#content").html("js");
    });

    $("#content").on("mouseout", function () {
        $("#content").html("html");
    });

});*/


$(function main() {
    setInterval(function () {
        let s1 = $(".s1");
        let s2 = $(".s2");
        s1.removeClass("s1").addClass("s2");
        s2.removeClass("s2").addClass("s1");
    },1000);
});
