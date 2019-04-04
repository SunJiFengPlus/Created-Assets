    $(function(){

        // 登录
        $("#login").click(function(){
            var username = $(".phone").val();
            var password = $(".pw").val();
            var storage=window.localStorage;
            //alert(password);
            console.log(username);
            console.log(password);
            $.ajax({
                url: 'http://localhost:8080/ssmtest1/login',
                type: 'post',
                data: {"phone":username,"password":password},
                success: function(msg){

                    if(msg.result == "Success"){
                        // alert('成功');
                        // console.log(msg.token);
                        // alert(msg.token);

                        if(!window.localStorage){
                            alert("浏览器支持localstorage");
                            return false;
                        }else{
                            storage.s = msg.token;
                            storage.username = username;
                        }
                        window.location.href='../index.html';
                    }else{
                        alert('失败');
                        // console.log(msg);
                    }
                },
                error: function(){
                    alert('用户名或密码错误！');
                }

            });
        });
        
        // 注册
        $("#register").click(function(){
            var username = $(".name").val();
            var phone = $(".tel").val();
            var verificationCode = $(".num").val();
            var password = $(".password").val();
            var storage=window.localStorage;
            // alert(username + phone + verificationCode + password);
            // console.log(username);
            // console.log(password);
            $.ajax({
                url: 'http://localhost:8080/ssmtest1/register',
                type: 'post',
                data: {"username":username,"phone":phone,"verificationCode":verificationCode,"password":password},
                success: function(msg){
                    if(msg.result == "Success"){
                        // alert('成功');
                        // console.log(msg.token);
                        // alert(msg.token);

                       if(!window.localStorage){
                            alert("浏览器支持localstorage");
                            return false;
                        }else{
                            storage.s = msg.token;
                            storage.username = username;
                        }
                        window.location.href='../index.html';
                    }else{
                        alert('失败');
                        // console.log(msg);
                    }
                },
                error: function(){
                    alert('提交失败');
                }
                
            });
        });

        //获取验证码
        $("#verificationCode").click(function(){
            var tel = $(".tel").val();
            // alert(tel);
            $.ajax({
                url: 'http://localhost:8080/ssmtest1/sms-regist/' + tel,
                type: 'get'
            });
            var timer = null;
            clearInterval(timer);
            $(this)[0].disabled = true;
            $("#verificationCode")[0].style.backgroundColor = '#8aac6c';
            // $(this)[0].value = '(' + 60 + 's后再次获取)';
            var t = 60;
            timer = setInterval(function(){
                $("#verificationCode")[0].value = '(' + (t--) + 's后再次获取)';
                if(t==-1){
                    clearInterval(timer);
                    $("#verificationCode")[0].value = '获取验证码';
                    $("#verificationCode")[0].disabled = false;
                    $("#verificationCode")[0].style.backgroundColor = '#5ca11f';
                }

            },1000);
        });






        $(".signIn").each(function(){
            $(this).click(function(){
                $("#loginDiv").show();
            });
        });
        $("#close").click(function(){
            $("#loginDiv").hide();
        });


    $('input[name=register_name]').data('d',0);
    $('input[name=register_password]').data('d',0);
    $('input[name=register_repassword]').data('d',0);

    $('input[name=register_name]').blur(function(){
        if( this.value == '' ){
            //alert('用户名不能为空');
            $(this).data('d',0);
        }else if( !(/^[\u4e00-\u9fff\w]{4,16}$/.test(this.value)) ){
            // alert('用户名格式错误，4到16位');
            $(this).data('d',0);
        }else{
            $(this).data('d',1);
        }
    });
    $('input[name=register_password]').blur(function(){
        if( this.value == '' ){
            //alert('密码不能为空');
            $(this).data('d',0);
        }else if( !(/^.{6,20}$/.test(this.value)) ){
            alert('密码格式错误，6-20位的字符数字和字母');
            $(this).data('d',0);
        }else{
            $(this).data('d',1);
        }
    });

    $('.registerBtn').click(function(){
        var dTotal = 0;
        $('.register_info').blur();
        $('.register_info').each(function(){
            dTotal+=$(this).data('d');
        });

        if( !$('input[name=checkbox]')[0].checked ){
            //alert('请勾选用户使用协议');
            $('input[name=checkbox]').data('d',0);
            dTotal+=$('input[name=checkbox]').data('d');
        }else{
            $('input[name=checkbox]').data('d',1);
            dTotal+=$('input[name=checkbox]').data('d');
        }
        if( dTotal!=4 ){
            return false;
        }else{
            var username = $('input[name=register_name]').val();
            var password = $('input[name=register_password]').val();
            $.ajax({
                url: 'http://localhost:8080/ssmtest1/register',
                type: 'post',
                data: {'username':username,'password':password},
                success: function(msg){
                    // console.log(msg);
                    alert("成功注册请点击Sign In登录");
                    window.location.href='sign.html';
                },
                error: function(){
                    alert('error');
                }
            });
        }
    });
    });