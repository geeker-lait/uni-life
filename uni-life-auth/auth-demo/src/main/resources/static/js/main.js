
    window.social = function (aa) {

        ajax({
            url: "/connect/"+aa,
            type: "POST",
            dataType: "JSON",
            data: {
                _method : 'delete'
            },
            success: function (res) {
                location.reload();
            },
            error: function (res) {
                alert("系统错误，发送失败！");
            }
        });

    };

    window.onnnn = function() {
        ajax({
            url: "/connect",
            type: "GET",
            dataType: "JSON",
            data: { },
            success: function (res) {
                var date = JSON.parse(res);
                if(date.qq || date.weixin || date.weibo){
                    document.getElementById('11').style.display="block";
                    if(date.qq){
                        document.getElementById('111').style.display="block";
                    }
                    if(date.weixin){
                        document.getElementById('112').style.display="block";
                    }
                    if(date.weibo){
                        document.getElementById('113').style.display="block";
                    }
                }
                if(!date.qq || !date.weixin || !date.weibo){
                    document.getElementById('21').style.display="block";
                    if(!date.qq){
                        document.getElementById('211').style.display="block";
                    }
                    if(!date.weixin){
                        document.getElementById('212').style.display="block";
                    }
                    if(!date.weibo){
                        document.getElementById('213').style.display="block";
                    }
                }

            },
            error: function (res) {
                alert("系统错误，发送失败！");
            }
        });
    }



    window.imgCodeRefresh = function () {
        document.getElementById('imgCodeRe').src = "/code/image";
    }

    window.sendSmsCode = function () {

        var mobile = document.getElementById('mobile').value;

        ajax({
            url: "/code/sms",
            type: "GET",
            dataType: "JSON",
            data: {
                mobile: mobile
            },
            success: function (res) {
                alert("验证码：" + res);
            },
            error: function (res) {
                alert("系统错误，发送失败！");
            }
        });

    };

//创建ajax函数
    window.ajax = function ajax(options) {
        options = options || {};
        options.type = (options.type || "GET").toUpperCase();
        options.dataType = options.dataType || "json";
        params = formatParams(options.data);

        //创建-第一步
        var xhr;
        //非IE6
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            //ie6及其以下版本浏览器
            xhr = ActiveXObject("Microsoft.XMLHTTP");
        }

        //接收-第三步
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var status = xhr.status;
                if (status >= 200 && status < 300) {
                    options.success &&
                    options.success(xhr.responseText, xhr.responseXML);
                } else {
                    options.error && options.error(status);
                }
            }
        };

        //连接和发送-第二步
        if (options.type == "GET") {
            xhr.open("GET", options.url + "?" + params, true);
            xhr.send(null);
        } else if (options.type == "POST") {
            xhr.open("POST", options.url, true);
            //设置表单提交时的内容类型
            xhr.setRequestHeader(
                "Content-Type",
                "application/x-www-form-urlencoded"
            );
            xhr.send(params);
        }else if(options.type == "DELETE"){
            xhr.open("DELETE", options.url, true);
            xhr.send(null);
        }
    }
//格式化参数
    window.formatParams = function formatParams(data) {
        var arr = [];
        for (var name in data) {
            arr.push(
                encodeURIComponent(name) + "=" + encodeURIComponent(data[name])
            );
        }
        /*  arr.push(('v='Math.random()).replace('.',''));*/
        return arr.join("&");
    };

