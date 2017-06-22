# scand_cafe
Simple CoffeShop
Задача. Интернет-кафе.

Необходимо написать интернет-кафе - сайт на которм каждый желающий может
заказать себе чашечку (или несколько) кофе на любой вкус.

Пользователь зайдя на сайт, может выбрать сорта кофе, которые он хочет
заказать, отметив соответствующие строки в списке возможных сортов.
Список сортов храниться в базе данных. В списке на UI не показываются
сорта с disabled='Y' (см. скрипт для создание БД).
Для каждого сорта кофе пользователь может ввести количество чашек.

После того как пользователь определился с выбором, он нажимает кнопку
"заказать" и вводит в появившейся странице свой адрес, на который
необходимо доставить заказ и имя. После окончательного подтверждения,
информация о заказе сохраняется в БД.

Правило подсчёта цены заказа:
  1. каждая n чашка кофе одного сорта бесплатна.
     Пример (n=5):
       2 чашки чёрного кофе по 1 TGR и 4 чашки со сливками по 2 TGR в
       сумме стоят 10 TGR
       но 6 чашек чёрного кофе по 1 TGR стоят 5 TGR, потому что 5 чашка
       бесплатная.
  2. если заказ был сделан более чем на x TGR, то доставка бесплатна,
     в противном случае стоимость доставки = m TGR

Требования к пользовательскому интерфейсу:
  1. интерфейс на 2-х языках (русский и английский).
  2. интернационализация i18n c языком по умолчанию - английским.
  3. Валидация (client side + server side).
     Пример:
       если пользователь ввёл невалидное количество, то должно появиться
       сообщение, что формат неверен, если же
       ему всё же удалось послать неверное количество на сервер (например,
       с помощью wget, curl или чего-нибуть аналогичного), то пользователь
       возвращается на страницу и видит сообщение об ошибочном формате
       числа.

       На второй странице поле адрес является обязательным и не может быть
       пустым.

Требования к реализации:
  1. Приложение должно работать на MySQL, MSSQL server, Oracle, PostgreSQL.
  2. Запускается или путем разворачивания на сервере приложения типа Tomcat
     или как независимое приложение (например, используя Spring Boot).

Конфигурация приложения:
  1. Конфигурирование коннекта к БД, как и другие вещи должно осуществляться
     из внешнего файла.
Используемые технологии:
Java, Spring core, Spring MVC, Tomcat, Maven, JSP, JSTL, JSP EL,  Filters (Spring Interceptors) , Plain JDBC, JUnit, Mockito,  SLF4J,  jQuery Validation, HTML, CSS
