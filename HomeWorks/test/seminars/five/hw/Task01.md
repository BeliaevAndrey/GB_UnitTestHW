Юнит-тесты

```java
class TestUnitsPhoneBookService {
    
    // Объявление необходимых объектов
    
    @BeforeEach
    void setUp() {
    /*
    Создание mock-объекта хранилища (имитация интерфейса доступа к БД);
    Определение объекта сервиса записной книжки с mock хранилища;
    Создание dummy-объектов контактов;
    Определение ответов хранилища на запросы сервиса записной книжки;
     */
    }

    void testAddContactSuccess() {
    /*
    Вызов процедуры добавления контакта;
    
    Проверка, что сервис вызвал поиск контакта в хранилище (1 раз);
    Проверка, что сервис вызвал процедуру добавления контакта в хранилище (1 раз);
     */
    }

    void testAddContactFailContactExist() {
    /*
    Вызов процедуры добавления контакта и получение сообщения о том что контакт уже существует;
    
    Проверка, что сервис вызвал поиск контакта в хранилище (1 раз);
    Проверка, что сервис не вызывал процедуру добавления контакта в хранилище (0 раз);
    Сверка содержания сообщения об ошибке, типа исключения.
     */
    }

    void testAddContactFailWrongData() {
    /*
    Вызов процедуры добавления контакта и получение сообщения о том что контакт уже существует;
    
    Проверка, что сервис не вызывал поиск контакта в хранилище (0 раз);
    Проверка, что сервис не вызывал процедуру добавления контакта в хранилище (0 раз);
    Сверка содержания сообщения об ошибке, типа исключения.
     */
    }

    void testDelContactSuccess() {
    /*
    Вызов процедуры удаления контакта и получение сообщения об удалении;
    
    Проверка, что сервис вызвал процедуру поиска контакта в хранилище (1 раз);
    Проверка, что сервис вызвал процедуру удаления контакта в хранилище (1 раз);
    Сверка содержания сообщения об успешном удалении.
     */
    }

    void testDelContactFailContactNotFound() {
    /*
    Вызов процедуры удаления контакта и получение сообщения об ошибке/исключения;
    
    Проверка, что сервис вызвал процедуру поиска контакта в хранилище (1 раз);
    Проверка, что сервис не вызывал процедуру удаления контакта в хранилище (0 раз);
    Сверка содержания сообщения об ошибке.
     */
    }

    void testEditContactSuccess() {
    /*
    Вызов процедуры редактирования контакта и получение контакта;
    Изменение данных в контакте, сохранение и получение сообщения об успешном сохранении;
    
    Проверка, что сервис вызвал процедуру поиска контакта в хранилище (1 раз);
    Проверка, что сервис вызвал процедуру обновления данных в хранилище (1 раз); 
    Сверка содержания сообщения об успешном сохранении.
     */
    }

    void testEditContactFailContactNotFound() {
    /*
    Вызов процедуры редактирования контакта и получение сообщения об ошибке;
        
    Проверка, что сервис вызвал процедуру поиска контакта в хранилище (1 раз);
    Проверка, что сервис не вызывал процедуру обновления данных в хранилище (0 раз); 
    Сверка содержания сообщения об ошибке.
     */
    }

    void testEditContactFailWrongData() {
    /*
    Вызов процедуры редактирования контакта и получение сообщения об ошибке;
    Изменение данных в контакте, сохранение и получение сообщения об ошибке валидации данных;
            
    Проверка, что сервис вызвал процедуру поиска контакта в хранилище (1 раз);
    Проверка, что сервис не вызывал процедуру обновления данных в хранилище (0 раз); 
    Сверка содержания сообщения об ошибке.
     */
    }
}
```

Интеграционные тесты

```java
public class TestIntegrationPB {
    
    // Объявление необходимых объектов
    
    @BeforeEach
    void setUp() {
        
    /*
    Определение структуры данных, которая будет замещать реальную БД;
    Определение необходимых dummies и добавление их в структуру данных.
           
    */
    }
        contactList = new ArrayList<>() {{
            add(contactRight);
        }};
        dataAbsents = "Name0;12345";
        dataWrong = "12345;Name0";
        contactWrong = new PBContact("Non-existing", "00000");
        dataExists = contactRight.getName() + ";" + contactRight.getPhone();

        storage = new PhoneBookStorage(contactList);
        pbService = new PhoneBookService(storage);
    }

    @Test
    void testAddContactSuccess() {
        String[] expected = dataAbsents.split(";");
        pbService.add(dataAbsents);
        PBContact newContact = storage.get(dataAbsents);
        assertEquals(expected[0], newContact.getName());
        assertEquals(expected[1], newContact.getPhone());
    }

    @Test
    void testAddContactFailContactExists() {
        Exception errorAdd = assertThrows(IllegalStateException.class, () -> pbService.add(dataExists));
        PBContact newContact = storage.get(dataAbsents);
        assertThat(errorAdd).isInstanceOf(IllegalStateException.class).hasMessage("Contact exists");
        assertNull(newContact);
    }

    @Test
    void testAddContactFailWrongData() {
        Exception errorAdd = assertThrows(IllegalArgumentException.class, () -> pbService.add(dataWrong));
        PBContact newContact = storage.get(dataWrong);
        assertThat(errorAdd).isInstanceOf(IllegalArgumentException.class).hasMessage("Wrong data");
        assertNull(newContact);
    }

    @Test
    void testDelContactSuccess() {
        String actual = pbService.delete(contactRight);
        String expected = "Contact deleted";
        assertEquals(expected, actual);
        storage.get(contactRight.getName() + ";" + contactRight.getPhone());
    }

    @Test
    void testDelContactFailContactNotFound() {
        String expected = "Contact not found";
        String actual = pbService.delete(contactWrong);
        assertEquals(expected, actual);
    }

    @Test
    void testEditContactSuccess() {
        String newData = "Name1;9876543";
        String expected = "Contact successfully updated";
        String actual = pbService.edit(contactRight.getName() + ';' + contactRight.getPhone(), newData);
        assertEquals(expected, actual);
        PBContact updContact = storage.get(newData);
        assertEquals(newData, updContact.getName() + ';' + updContact.getPhone());
    }

    @Test
    void testEditContactFailContactNotFound() {
        String newData = "Name1;9876543";
        String expected = "Contact not found";
        String actual = pbService.edit(dataAbsents, newData);
        assertEquals(expected, actual);
        assertNull(storage.get(newData));
    }

    @Test
    void testEditContactFailWrongData() {
        String newData = "Name1;9876543";
        String expected = "Wrong new data";
        Exception error = assertThrows(IllegalArgumentException.class,
                () -> pbService.edit(contactRight.getName() + ";" + contactRight.getPhone(), dataWrong));
        assertThat(error).isInstanceOf(IllegalArgumentException.class).hasMessage(expected);
        assertNull(storage.get(newData));
    }
```