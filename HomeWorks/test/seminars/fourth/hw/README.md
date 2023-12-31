## Урок 4. Зависимости в тестах

### Задание 1. Ответьте письменно на вопросы:

**1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?** <br>

Тестовые заглушки передаются тестируемой системе вместо реальных зависимостей, настраиваются таким образом, 
чтобы гарантировать правильность их работы. Если тест не проходит, можно быть уверенным, что ошибка не связана 
с тестовым дубликатом, и можно искать проблему в другом месте.
Возможно повысить скорость и надежность т.к. не требуется соединения с внешними ресурсами.

**2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?** <br>

Следует использовать Mock, для задания ожидаемых аргументов и соответствующей проверки вызова,
или Spy для записи информации о вызовах в т.ч. и аргументах этих вызовов.

**3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?** <br>

Следует использовать Stub для подмены возвращаемых значений фиксированными,
или Fake для имитации реального объекта.

**4) Какой тип тестовой заглушки вы бы использовали для имитации  взаимодействия с внешним API или базой данных?** <br>

Следует использовать Fake для имитации поведения внешнего API и предоставления, например, 
фиксированных значений в качестве ответов данного API. 

### Задание 2.

У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
