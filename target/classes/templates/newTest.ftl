<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<div>
    INV ITEM 1
    <#if invItem1??>${invItem1}<#else>something WRONG</#if>
</div>

<div>
    INV ITEM 2
    <#if invItem2??>${invItem2}<#else>something WRONG</#if>
</div>


</body>
</html>