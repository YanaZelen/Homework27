<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Вход</title>
    <style>

    </style>
</head>
<body>
<div id="header">
    <h2>Вход</h2>
</div>
<div id="content">

    <fieldset>
        <legend>Войти в систему</legend>
        <form name="user" action="/login" method="post">
            Email : <input type="text" name="email" /><br/>
            Пароль: <input type="text" name="password" /><br/>
            <input type="submit" value="Войти" />
        </form>
    </fieldset>
    <br/>

</div>
</body>
</html>