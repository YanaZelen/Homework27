<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Продукты</title>
    <style>
        table {
            width: 100%;
            margin-bottom: 20px;
            border: 1px solid rgba(133, 116, 42, 0.91);
            border-collapse: collapse;
        }
        table th {
            font-weight: bold;
            padding: 5px;
            background: #004600;
            border: 1px solid #004600;
        }
        table td{
            border: 1px solid #004600;
            padding: 5px;
        }
    </style>
</head>
<body>
<div id="header">
    <h2>Продукты</h2>
</div>
<div id="content">
    <table class="datatable">
        <h3>Список продуктов</h3>
        <tr>
            <td>Идентификатор</td>
            <td>Название</td>
            <td>Цена</td>
            <td>Количество</td>
            <td>Действие</td>
        </tr>
        <#list productsList as product>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.value}</td>
                <td>
                    <a href="/products/edit/${product.id}">
                        <button>Редактировать</button>
                    </a>
                    <a href="/products/delete/${product.id}">
                        <button>Удалить</button>
                    </a>
                </td>
            </tr>
        </#list>
    </table>

    <br>

    <fieldset>
        <legend>Добавить продукт</legend>
        <form name="product" action="/products" method="post">
            Название : <input type="text" name="name" /><br/>
            Цена: <input type="number" name="price" /><br/>
            Количество: <input type="number" name="value" /><br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>
    <br/>

</div>
</body>
</html>