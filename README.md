# Тестовое задание "Реализация микросервиса" (WebRise)

## Локальный запуск
Локальный запуск через docker-compose:
1. Сборка jar-файла: <br/>*mvn clean package -DskipTests*
2. Создание docker-образа: <br/>*docker build -t app .*
3. Запуск: <br/>*docker-compose up*

После запуска приложение должно быть доступно по адресу:<br/>
*http://localhost:8080*<br/>

## Локальный запуск (без docker-compose)
Для запуска вручную необходимо передать 3 параметра: <br/>
*DB_URL* - адрес к локально запущенной бд <br/>
*DB_USERNAME* - логин к бд <br/>
*DB_PASSWORD* - пароль к бд <br/>

## Адреса для доступа к API

```diff
- text in red
+ text in green
! text in orange
# text in gray
@@ text in purple (and bold)@@
```
<span style="color:blue;">POST</span> */users* - создать пользователя <br/>
<span style="color:green;">GET</span> */users/{id}* - получить информацию о пользователе <br/>
<span style="color:cyan;">PUT</span> */users/{id}* - обновить пользователя <br/>
<span style="color:red;">DELETE</span> */users/{id}* - удалить пользователя <br/>
<span style="color:green;">GET</span> */users* - получить список всех пользователей <br/>

<span style="color:blue;">POST</span> */users/{id}/subscriptions* - добавить подписку <br/>
<span style="color:green;">GET</span> */users/{id}/subscriptions* - получить подписки пользователя <br/>
<span style="color:red;">DELETE</span> */users/{id}/subscriptions/{sub_id}* - удалить подписку <br/>

<span style="color:blue;">POST</span> */subscriptions* - создать подписку <br/>
<span style="color:green;">GET</span> */subscriptions/{id}* - получить информацию о подписке <br/>
<span style="color:cyan;">PUT</span> */subscriptions/{id}* - обновить подписку <br/>
<span style="color:red;">DELETE</span> */subscriptions/{id}* - удалить подписку <br/>
<span style="color:green;">GET</span> */subscriptions/top* - получить ТОП-3 популярных подписок <br/>
