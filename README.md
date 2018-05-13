# KorusTest

Проект собран на **Maven**.

### Команды запуска

Для запуска web тестов используется команда
```
mvn clean test -DsuiteXmlFile=web.xml -DbrowserWeb=Firefox
```

Доступны следующие браузеры:
* Chrome
* Opera(для запуска требуется указать еще один параметр -Dopera.binary="Путь до вашего launcher.exe оперы")
* Firefox

Для запуска api тестов используется команда
```
mvn clean test -DsuiteXmlFile=api.xml -DhostApi=http://lkk.esphere.ru
```

По умолчанию параметры имеют следющие значения:
* -DsuiteXmlFile = **web.xml**
* -DbrowserWeb = **Chrome**
* -DhostApi = **http://lkk.esphere.ru**

То есть команда 
```
mvn clean test
```
запустит веб тесты на Хроме, а команда 
```
mvn clean test -DsuiteXmlFile=api.xml
```
запустит api тесты по урлу http://lkk.esphere.ru

### Отчет
Отчет формируется командой 
```
mvn allure:report
```
Располагается он здесь: **\target\allure-report**

К упавшим веб тестам аттачатся скриншоты, а к api тестам аттачится содержимое http запросов
