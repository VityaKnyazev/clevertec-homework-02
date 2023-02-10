<h1>CLEVERTEC (homework-02)</h1>

<p>CLEVERTEC homework-02:</p>
<ol>
<li>Install Gradle</li>
<li>Assemble custom jar utils-1.3.5.jar. It should be compatible with java 8. The manifest file should contain the name 
and version of your jar. The jar should contain class StringUtils with method boolean isPositiveNumber(String str). 
Use Apache Commons Lang 3.10 library to implement this method. Write one any unit test 
for your StringUtils.isPositiveNumber(String str) using JUnit 5.+.</li>
<li>Create a project multi-project with two subprojects core and api. The core subproject should contain class Utils with 
method boolean isAllPositiveNumbers(String... str). Use utils-1.3.5.jar from the previous task to implement this method. 
The api subproject should contain class App with the main method. Call Utils.isAllPositiveNumbers("12", "79") from the 
main method of api subproject.</li>
<ol> <p>Дополнительно:</p>
<li>Сделать gradle плагин, который также опубликовать и подключить к проекту.</li>
<li>Как пример функциональности плагина - тестирование и формирование отчета.</li>
</ol>
</ol>


<h2>What's done:</h2>
<ol>
<li>Created multi-module project compatible with java 8. Adjusted manifest file. Created jar contains class StringUtils with method boolean isPositiveNumber(String str).
Used Apache Commons Lang 3.10 library to implement this method. Wrote unit tests for StringUtils.isPositiveNumber(String str) using JUnit 5.</li>
<li>Created two subprojects core and api. The core subproject contains class Utils with 
method boolean isAllPositiveNumbers(String... str). Used dependencies from the previous task to implement this method. 
The api subproject contains class App with the main method. Called Utils.isAllPositiveNumbers("12", "79") from the 
main method of api subproject.</li>
<ol> <p>Дополнительно:</p>
<li>Сделан gradle плагин в отдельном проекте plugin, который можно опубликовать в локальную репозиторию maven (см. ниже). Подключен к проекту.</li>
<li>Плагин выводит информацию о Gradle и Project.</li>
</ol>
</ol>

<h3>Стек</h3>
<ol>
<li>Java 8, Gradle 7.5, Apache Commons Lang 3.10, JUnit 5.</li>
</ol>

<h4>Сборка и запуск приложения:</h4>
<ol>
<li>Создаем и публикуем плагин в локальной репозитории maven: $cd plugin затем $.\gradlew publish</li>
<li>Билдим мультимодульный проект: $cd .. затем $.\gradlew build</li>
<li>Запускаем созданную в плагине таску helloTask: $.\gradlew helloTask или $.\gradlew show</li>
<li>Запускаем приложение из модуля api: $cd api\build\libs затем $java -jar api-1.0.jar</li>
</ol>