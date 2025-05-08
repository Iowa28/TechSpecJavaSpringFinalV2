# Тестовое задание "Реализация микросервиса" (WebRise)

## Локальный запуск
Локальный запуск через docker-compose:
1. Сборка jar-файла: <br/>*mvn clean package*
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

$${\color{blue}POST}$$ */users* - создать пользователя <br/>
$${\color{green}GET}$$ */users/{id}* - получить информацию о пользователе <br/>
$${\color{cyan}PUT}$$ */users/{id}* - обновить пользователя <br/>
$${\color{red}DELETE}$$ */users/{id}* - удалить пользователя <br/>
$${\color{green}GET}$$ */users* - получить список всех пользователей <br/>

$${\color{blue}POST}$$ */users/{id}/subscriptions* - добавить подписку <br/>
$${\color{green}GET}$$ */users/{id}/subscriptions* - получить подписки пользователя <br/>
$${\color{red}DELETE}$$ */users/{id}/subscriptions/{sub_id}* - удалить подписку <br/>

$${\color{blue}POST}$$ */subscriptions* - создать подписку <br/>
$${\color{green}GET}$$ */subscriptions/{id}* - получить информацию о подписке <br/>
$${\color{cyan}PUT}$$ */subscriptions/{id}* - обновить подписку <br/>
$${\color{red}DELETE}$$ */subscriptions/{id}* - удалить подписку <br/>
$${\color{green}GET}$$ */subscriptions/top* - получить ТОП-3 популярных подписок <br/>
