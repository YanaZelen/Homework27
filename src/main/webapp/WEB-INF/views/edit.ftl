<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Редактировать список продуктов</title>
</head>
<body>
<br>

<fieldset>
    <legend>Редактировать продукт</legend>
    <form name="product" action="/products" method="post">
        Идентификатор : <input type="number" name="id" value="${product.id}" readonly /><br/>
        Название : <input type="text" name="name" value="${product.name}"/><br/>
        Цена: <input type="number" name="price" value="${product.price}"/><br/>
        Количество: <input type="number" name="value" value="${product.value}"/><br/>
        <input type="submit" value="Save" />
    </form>
</fieldset>
<br/>

</div>
</body>
</html>