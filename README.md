# KorusTest

Проект собран на **Maven**.

### Команды запуска

Для запуска web тестов используется команда
```
mvn clean test -DsuiteXmlFile=web.xml -DbrowserWeb=Opera
```

Доступны следующие браузеры:
* Chrome
* Opera
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
Распологается он здесь: **\target\allure-report**

К упавшим веб тестам аттачатся скриншоты, а к api тестам аттачится содержимое http запросов
