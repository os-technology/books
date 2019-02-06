<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>2019 送给最优秀的你~</title>

    <style type="text/css">
        body{
            background: #f5faff;
        }
        .demo_con{
            width: 960px;
            margin:40px auto 0;
        }
        .button{
            width: 200px;
            line-height: 40px;
            text-align: center;
            font-weight: bold;
            color: #fff;
            text-shadow:1px 1px 1px #333;
            border-radius: 5px;
            margin:0 20px 20px 0;
            position: relative;
            overflow: hidden;
        }
        .button.red{
            border:1px solid #b42323;
            box-shadow: 0 1px 2px #e99494 inset,0 -1px 0 #954b4b inset,0 -2px 3px #e99494 inset;
            background: -webkit-linear-gradient(top,#d53939,#b92929);
            background: -moz-linear-gradient(top,#d53939,#b92929);
            background: linear-gradient(top,#d53939,#b92929);
        }
        .red.side:after{
            border-top: 1px solid #aa1e1e;
            box-shadow:-2px 0 1px #c75959 inset;
            background:-webkit-linear-gradient(right,#b82929,#d73f3f 60%);
            background:-moz-linear-gradient(top,#b82929,#d73f3f 60%);
            background:linear-gradient(top,#b82929,#d73f3f 60%);
        }
        .font{
            font-size: 100px;
        }
    </style>
</head>

<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/placeholderForJSP.js"></script>
<body style="text-align:center;">
<br><br><br><br><br><br><br><br><br>
<form action="/happy" method="post" target="_blank">

    <table align="center">
        <tr>
            <td align="center"><input style="width: fit-content;height: 100px" name="name" id="username" type="text" placeholder="请输入您的姓名"></td>
        </tr>
        <tr>
            <td><br><br><br></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;<input style="width: fit-content;height: 200px" type="submit" id="sub" class="button red font" value="获取祝福"></td>
        </tr>

    </table>

</form>

<script type="text/javascript">
    $("#sub").click(function(){
        var value = $("#username").val();
        if(value==null||value==""){
            alert("请填写您的名称");
            return false;
        }
    });
</script>

</body>
</html>