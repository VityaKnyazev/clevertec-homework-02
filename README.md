<h1>CLEVERTEC (homework-02) - GRADLE</h1>

<p>Задание:</p>

<ol>
<li>Установить Gradle</li>
<li>Проект должен быть совместим с java 17</li>
<li>Создать файл .jar, например, «utils-1.3.5.jar»</li>
<li>Манифест файл должен содержать имя и версию вашего .jar файла </li>
<li>В вашем .jar файле должен быть class StringUtils с методом boolean isPositiveNumber(String str)</li>
<li>Написать один unit test для проверки этого метода (использовать JUnit 5).</li>
<li>Заполнить и отправить форму</li>
</ol>

<p>Дополнительно:</p>

<ol>
<li>Сделать gradle плагин, который также опубликовать и подключить к проекту, например плагин по формированию отчёта</li>
<li>Создать мульти-модульный проект с двумя модулями: core, api</li>
<li>В модуле core должен быть class Utils с методом boolean isAllPositiveNumbers(String… str)</li>
<li>Использовать utils-1.3.5.jar сделанный на предыдущих этапах, для возможности переиспользовать метод boolean isPositiveNumber(String str) в модуле core</li>
<li>В модуле api должен быть class App с методом main. </li>
<li>Из модуля api в методе main вызвать Utils.isAllPositiveNumbers("12", "79")</li>
<li>Написать один unit test для проверки этого метода boolean isAllPositiveNumbers(String… str)(использовать JUnit 5).</li>
</ol>

<p>Дополнительно:</p>

![alt text](https://github.com/VityaKnyazev/clevertec-homework-02/tree/feature/multimodule/tag-task.jpg?raw=true)

<h2>Что сделано:</h2>

<ol>
<li>Установлен Gradle</li>
<li>Проект совместим с java 17</li>
<li>Создан файл .jar, «utils-1.3.5.jar» в build/libs в проекте util. </li>
<li>Манифест файла содержит имя и версию .jar файла: 'Specification-Title', 'Specification-Version'.</li>
<li>В .jar файле присутствует class StringUtils с методом boolean isPositiveNumber(String str)</li>
<li>Написаны unit тесты для проверки этого метода (использован в т.ч. JUnit 5).</li>
<li>Заполнена и отправлена форма: https://forms.gle/K7ZduD93J9BCVHuH9</li>
</ol>

<p>Дополнительно:</p>

<ol>
<li>Сделан gradle плагин (id 'report') и подключен к проекту homework-02, плагин выводит информацию о пути к проекту и версии gradle.</li>
<li>Создан мульти-модульный проект homework-02 с двумя модулями: core, api</li>
<li>В модуле core присутствует class Utils с методом boolean isAllPositiveNumbers(String… str)</li>
<li>Использован utils-1.3.5.jar, сделанный в проекте util, переиспользуется метод boolean isPositiveNumber(String str) в модуле core</li>
<li>В модуле api присутствует class App с методом main. </li>
<li>Из модуля api в методе main вызвается Utils.isAllPositiveNumbers("12", "79")</li>
<li>Написаны unit тесты для проверки этого метода boolean isAllPositiveNumbers(String… str)(использован в т.ч. JUnit 5).</li>
</ol>

<p>Дополнительно:</p>

<ol>
<li>Плагин, написанный на java, добавляет задачу tag в проект.</li>
<li>Задача запускается автоматически при вызове build и финалится на test</li>
<li>
В зависимости от того в какой ветке задача была запущена - формируется новая версия tag по заданному
на картинке правилу.
</li>
<li>Присваивается соответствующий git tag текущему коммиту.</li>
</ol>
<p>*Если текущему коммиту присвоен tag, то новый не присваивается.</p>
<p>*Если в рабочей директории есть незакоммиченные изменения, то новый tag не присваивается.</p>

<p><i>Важно: представленный tag java-плагин для gradle пока не тестировался.</i></p>

<h3>Как запускать</h3>
<ol>
<li>Собрать проект util: cd util и .\gradlew build</li>
<li>Собрать мультимодульный проект: cd .. и .\gradlew build</li>
<li>Запустить собранный jar api подпроекта: cd api/build/libs и java -jar api-1.0-SNAPSHOT.jar</li>
</ol>

<p>Запускаем таску report плагина report:</p>
<p>Выходим из /libs в корень проекта: cd ../../.. и вызываем таску: .\gradlew report</p>

<p>Запускаем таску tag java-плагина tag:</p>
<p>вызываем таску: .\gradlew tag</p>
