### Заметки:
* Паттерн "Observer" -> "Издатель-Подписчик". Пример: Издание (газета, журнал, youtube-канал) - Подписчики
* Паттерн "Strategy" -> "Контекст-Алгоритм". Пример: выбор разных методов сортировки, разработчик и разные стратегии его поведения в течение дня (сон, разработка, чтение, обед, ...)
* `Композиция - Наследование`. Если имеете дело с отношением между классами вида `ЯВЛЯЕТСЯ` и класс хочет предоставить все свои интерфейсы другому классу, то наследование предпочтительнее.
если отношение `ИМЕЕТ`, то предпочтительнее композиция.
* Нужно запомнить, что тип `int` эффективен из-за особенностей структуры вычислительных процессоров. Он 32-битный, как и процессоры 32-разрядные Просто примите на веру.
* По умолчанию в JAVA, если вы указываете конкретное число, то целое будет типом `integer`, а вещественное типа `double`
* `Не Забывай` про переполнение диапазона значений типа данных: `byte b = 255;` результатом присвоения будет `-1`, поскольку диапазон типа `byte` -127..128;
* Есть поток данных, а есть потоки выполнения/исполнения программы

* * * * *

### Сделать:
* Searching in INET `Hot keys list` for Mac Os. 
* Выяснить что такое `интерфейс - маркер`. -> +
* Доделать задачу с TV, где необходимо копировать каналы при создании объекта типа TV -> +
* Что такое ``композиция`` в JAVA? -> +
* Скопировать у Марселя или переделать метод findAll() -> +
* Доделать задание 16
* Заменить StringBuffer на StringBuilder +
* 2 подсказки от Intellij Idea - задание 18 +
* на базе 18 сделать задание 21 +
* на базе 17 сделать 20 +
#### 27.06.2019:
* Собрать пул вопросов, начиная с задания 17
* Сделать диаграмму Collection, Iterator, Map, Iterable и т.д.
* * * * * 

### Вопросы:
* Условие задачи 13 предусматривает зацикливание?
* Какие ошибки проектирования мной были допущены в задаче 13?
* Если у нас есть массив `ParentClass[]` экземпляров дочерних классов (`ChildClass1`, `ChildClass2`) класса `ParentClass`, причем у класса `ChildClass1` есть метод `run()`. Как вызвать метод при переборе элементов массива в цикле? Ответ: Это плохая практика, так лучше не делать.
* Как работает интерпретатор? JVM построчно выполняет код?
* Задание 17: "User UsersRepository.userByDataArray(String userData[])" в случае userData не по формату или же userData есть "null", то нужно ли
  1. выбрасывать исключение
  2. возвращать null  
`Ответ: выбрасывать исключение`  
* Задание 18: "int IntegerLinkedList.get(int index)". index должен быть в диапазоне [0, size) или [1, size]? `Ответ: [0, size)`
* Кто и какие методы ресурсы использует для разработки дизайна сайта?
#### 18.06.2019:
* 18: `IntegerLinkedList` : как правило `void remove(int element)` должен удалять все элементы в листе равные `element`?
* 18: `IntegerLinkedList` : `Intellej Idea` замечение в по `StringBuilder` в `toString`?
* 20: `SimpleService`: `public User findOneById(long id) {...}` не стал делать `Long id`, ибо `id` null быть не должно при поиске в репозиторие, сделал по принципу `только там, где возможно значение NULL`
* 21: `LinkedList с генериком`: обсудить замечания от `Intellej Idea`и корректность реализации в целом. 
#### 24.06.2019:
* прочитать про `optional`
* `private HashMap<E,Object> map;` здесь Object - это именно `Object`?
#### 27.06.2019:
* когда необходимо (на практике) при добавлении через Collection.add(Object o) объект клонировать, а не передавать по ссылке?
и как использовать конструктор в этом случае, если параметризованный, т.е. Collection<T>?
* как построить диаграммму Collection, Map в Intellij Idea с методами?
* Почему для String не используем Optional?https://github.com/MarselSidikov/JavaItis10/blob/master/Projects/%23%2035.%20SimpleService%20Extended/src/main/java/ru/itis/service/repositories/UsersRepositoryFileBasedImpl.java   
* Задание 25: кривой класс "UsersService"  
* Задание 25: Имеет ли смысл обертывать "Optional" метод public List<User> findAll()
* Неужели нельзя подменить исходники, к примеру String?
#### 30.07.2019:  
* На примере `# 47. SpringMvc Example` можем ли мы перенести `<context:component-scan base-package="ru.itis.web"/>` из `dispatcherServlet-servlet.xml` в `AppConfig.java`?
* Когда рекомендуется создавать корзину: в момент добавки товара в нее или же при регистрации клиента в системе? Если считать, что это относится к сервису "CartService", то логичнее добавлять при первой попытке добавить в корзину товар и, если ее нет, то создавать.

* * * * *
