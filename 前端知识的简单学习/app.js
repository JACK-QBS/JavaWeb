function load() {
    <!-- alert 是弹出框内容 -->
    alert("ok");
}

$(function () { //jquery的方式：body加载完之后执行的代码
    alert("load ok");
    // jquery 的 ajax 方法，异步的方式发起 http 网络请求
    // 方法的传入参数，是json格式对象
    let data = {
        username:"abc",
        password:"123"
    };
    $.ajax({
        type:"POST", //请求方法
        url:"data/login.json", //请求路径
        contentType:"application/json", //请求数据类型（默认）
        // data:"name=John&location=Boston", //请求数据，如果数据类型是 json,需要将 json 对象转换为字符串
        data: JSON.stringify(data),
        success:function(r){
            if (r.success) {
                alert(JSON.stringify(r))
            } else {
                alert("success=false")
            }
        },error:function (XMLHttpRequest,textStatus,errorThrown) {
            // 通常 textStaus 和 errorThrown 之中
            // 只有一个会包含信息
            this;// 调用本次AJAX请求时传送的options参数
        }
    });
});