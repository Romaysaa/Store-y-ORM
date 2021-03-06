<%-- 
    Document   : editProfile
    Created on : Mar 10, 2018, 11:31:16 PM
    Author     : Eman-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/UpdateProductStyle.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Store-Y</title>
    </head>
    <body onload="displayFields()" style="margin: 0; padding: 0;">
    <center>
        <div style="overflow: hidden; ">
            <div class="w3l_logo" style="text-align:center; margin-left: 40%;">
                <h1 ><a href="index.html">Store-Y<span>Your stores. Your place.</span></a></h1>
                <br>         
            </div>




            <!-- //header -->
            <!-- navigation -->

             
        </div>
        <div class="navigation" style="background:#ba3e9d; width: 100%; height:50px">
                <div class="container" >
                    <nav class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->

                    </nav>
                </div>
            </div>
            
    </center>
    <br>
    <div>
        <label>Name</label><br>
        <input type="text" name="name" id="name" maxlength="100" onblur="checkName()" required><br>
    </div>
    <label id="nameError"></label>

    <label>email</label><br>
    <input type="email" name="email" id="email" value="${userObject.email}" maxlength="50" onblur="checkEmail()" required><br>
    <label id="emailError"></label>

    <label>Password</label><br>
    <input type="password" name="password" value="${userObject.password}" maxlength="50" id="pass" onblur="checkPasswordStrength()" required><br>
    <label id="passStrength"></label>

    <label>Confirm Password</label><br>
    <input type="password" name="cpassword" value="${userObject.password}" maxlength="50" id="cpassword" onblur="checkPassword()" required><br>
    <label id="passwordError"></label>

    <label>Date OF Birth</label><br>
    <input type="date" max="2000-02-28" name="date" id="date" required><br>
    <label id="dateError"></label>

    <label for="uInterests"><b>Interests</b></label>
    <br>
    <input type="checkbox" class="uInterests" value="Baby" />Baby<br/>
    <input type="checkbox" class="uInterests" value="Beauty" />Beauty<br/>
    <input type="checkbox" class="uInterests" value="Computers" />Computers<br/>
    <input type="checkbox" class="uInterests" value="Home Decor & Furniture" />Home Decor & Furniture<br/>
    <input type="checkbox" class="uInterests" value="Jewelry & Accessories" />Jewelry & Accessories<br/>
    <input type="checkbox" class="uInterests" value="Mobile Phones, Tablets & Accessories" />Mobile Phones, Tablets & Accessories<br/>
    <label for="uJob"><b>Job</b></label>
    <br>
    <select id="uJob">
        <option value="student" >Student</option>
        <option value="teacher">Teacher</option>
        <option value="engineer">Engineer</option>
        <option value="doctor">Doctor</option>
        <option value="other">Other</option>
    </select>
    <br>
    <label>User Credit</label><br>
    <input type="number" name="credit" min="1" id="credit" required><br>
    <label id="creditLimitError"></label>

    <label>Address</label><br>
    <input type="text" maxlength="70" value="${userObject.address}" name="address" id="address" required><br>

    <input type="hidden" id="uCategory" name="uCategory" value="done">
    <input type="hidden" id="userJob" name="userJob" value="done">

    <input type="button" id="submit" value="Edit"/><br>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
    <script>

        var validName = true;
        var validEmail = true;
        var validPass = true;

        function displayFields()
        {
            document.getElementById('name').value = "${sessionScope.userObject.name}";
            document.getElementById('credit').value = "${sessionScope.userObject.creditlimit}";
            document.getElementById('date').value = "${sessionScope.userObject.birthdate}";
            var job = "${sessionScope.userObject.job}";
            console.log(job);
            //document.getElementById('uJob').value = 
            var sel = document.getElementById('uJob');

            for (var i = 0, j = sel.options.length; i < j; ++i) {
                if (sel.options[i].innerText.toLowerCase() == job.toLowerCase()) {
                    sel.selectedIndex = i;
                    break;
                }
            }



        }
        function checkPasswordStrength()
        {
            var strength = {
                0: "Worst",
                1: "Bad",
                2: "Weak",
                3: "Good",
                4: "Strong"
            }
            var val = document.getElementById('pass').value;
            var result = zxcvbn(val);

            // Update the text indicator
            if (val !== "") {
                document.getElementById('passStrength').innerHTML = "Strength: " + strength[result.score];
            } else {
                document.getElementById('passStrength').innerHTML.innerHTML = "";
            }
        }

        function checkName()
        {
            var nameRegex = /^[a-zA-Z]+([ ][a-zA-Z]*)*$/;
            if (document.getElementById('name').value.match(nameRegex))
            {
                document.getElementById('nameError').innerHTML = "";
                validName = true;
                console.log(validName);
            } else {
                validName = false;
                console.log(validName);
                document.getElementById('nameError').innerHTML = "Wrong Format";
            }
        }

        function checkEmail()
        {
            var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

            if (emailRegex.test(document.getElementById('email').value))
            {
                document.getElementById('emailError').innerHTML = "";

                $.ajax({
                    url: "SignUpServlet",
                    type: 'GET',
                    contentType: 'application/json',
                    data: {'temail': document.getElementById('email').value},
                    error: function (xhr, status, error) {
                        console.log(xhr);
                        console.log(status);
                        console.log(error);
                    },
                    success: function (data)
                    {
                        $("#emailError").text(data);
                        console.log(data);
                        if (data !== null && data !== '')
                        {
                            validEmail = false;
                        } else
                        {
                            validEmail = true;
                        }
                        console.log(validEmail);
                    }});

                console.log(validEmail);
            } else {
                document.getElementById('emailError').innerHTML = "Wrong Format";
                validEmail = false;
            }
        }

        function checkPassword()
        {

            if (document.getElementById('pass').value === document.getElementById('cpassword').value)
            {

                document.getElementById('passwordError').innerHTML = "";
                validPass = true;
                console.log(validPass);
            } else {
                validPass = false;
                console.log(validPass);
                document.getElementById('passwordError').innerHTML = "Passwords do not match";
            }
        }


        function beforeSubmit()
        {

            document.getElementById('userJob').value = document.getElementById("uJob").value;

            var checkedValue = '';
            var inputElements = document.getElementsByClassName('uInterests');
            for (var i = 0; inputElements[i]; i++) {
                if (inputElements[i].checked) {
                    checkedValue = checkedValue + inputElements[i].value + ";";
                }
            }
            console.log(checkedValue);
            console.log("entered before submit");
            if (checkedValue != null) {
                document.getElementById('uCategory').value = checkedValue;
            }
        }


        $(document).ready(function () {
            $("#submit").click(function () {
                if (validEmail && validName && validPass) {
                    beforeSubmit();
                    console.log(validName);
                    console.log(validEmail);
                    console.log(validPass);
                    name_var = $("#name").val();
                    password_var = $("#pass").val();
                    email_var = $("#email").val();
                    credit_var = $("#credit").val();
                    job_var = $("#uJob option:selected").text();
                    address_var = $("#address").val();
                    birthdate_var = $("#date").val();
                    interests_var = $("#uCategory").val();
                    $.post("UpdateUserServlet",
                            {
                                name: name_var,
                                email: email_var,
                                password: password_var,
                                birthdate: birthdate_var,
                                job: job_var,
                                address: address_var,
                                credit: credit_var,
                                interests: interests_var
                            },
                            function () {
                                window.location.href = "home.jsp";
                            });
                }
            });

        });




    </script>
</body>
</html>
