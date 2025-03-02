$(document).ready(function () {
    // 选择提交按钮并绑定点击事件
    $("input[type='submit']").click(function (e) {
        // 阻止表单默认提交行为
        e.preventDefault();
        // 获取各个表单元素的值
        var username = $("#username").val();
        var password = $("#pwd").val();
        var email = $("#emali").val();
        var birthdate = $("#day").val();

        // 验证用户名是否必填
        if (username === "") {
            alert("Username is required");
            return;
        }

        // 验证密码是否必填且长度至少8位
        if (password === "") {
            alert("Password is required");
            return;
        } else if (password.length < 8) {
            alert("Password length must be at least 8 characters");
            return;
        }

        // 验证邮箱是否必填且格式正确
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (email === "") {
            alert("Email is required");
            return;
        } else if (!emailRegex.test(email)) {
            alert("Please enter a valid email");
            return;
        }

        // 验证出生日期是否必填且格式正确
        var dateRegex = /^\d{4}-\d{2}-\d{2}$/;
        if (birthdate === "") {
            alert("Birthdate is required");
            return;
        } else if (!dateRegex.test(birthdate)) {
            alert("Birthdate Must be yyyy - mm - dd format");
            return;
        }

        // 如果所有验证通过，提交表单
        // 这里使用ajax提交
        $.ajax({
            type: "POST",
            url: $(this).closest('form').attr('action'),
            data: {
                username: username,
                password: password,
                email: email,
                birthdate: birthdate
            },
            success: function (response) {
                alert("Registration successful");
            },
            error: function (error) {
                alert("Error: " + error.responseText);
            }
        });
    });
});