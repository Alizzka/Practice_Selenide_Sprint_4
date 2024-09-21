/*Тебе предстоит попрактиковаться с Selenide. Попробуй сменить аватарку в профиле.
Напиши автотест, который выполнит клик по изображению профиля. Используй CSS и класс элемента.
После клика откроется отдельное окно. В нём тебе нужно найти поле для ссылки на
изображение — по id. Помести в него ссылку
https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png.
Сохрани новое изображение: пользуйся поиском по XPath.
После корневого элемента ищи элемент form и его атрибут name.
Найди кнопку сохранения через поиск по типу элемента и тексту*/

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Task_1 {

    @Before
    public void setUp() {
        // Настройка Selenide для использования ChromeDriver версии 128
        Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0";
        Configuration.driverManagerEnabled = false; // Отключаем автоматическую загрузку драйвера
    }

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\chromedriver128.exe");

        // Перейти на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("alizzka@mail.ru");
        $(byId("password")).setValue("1234");
        $(byText("Войти")).click();
        // кликни по изображению профиля
        $(byCssSelector(".profile__image")).click();
        // в поле ссылки на изображение введи ссылку
        $(byId("owner-avatar")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png");
        // сохрани новое изображение
        $(byXpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }
    @After
    public void tearDown() {
        closeWebDriver(); // Закрытие браузера после каждого теста
    }
    // закрой браузер
}

/*Если подключать зависимость WebDriverManager (Селенид последеней версии будет сам подтягивать нужный драйвер):

Это библиотека, которая помогает установить WebDriver.
Но наличие пути к скачанному вебдрайверу браузера в переменных окружения (PATH) может быть причиной ошибки.
Вебдрайвер, который находится по этому пути, может использоваться вместо того, который управляется WebDriverManager.
При использовании вебдрайвер менеджера лучше удалить путь к папке с вебдрайвером и переменной окружения
1.	Подключи зависимость Selenium в pom.xml (или Selenide):
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>

2.	Добавь зависимость WebDriverManager:
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>4.4.3</version>
    <scope>test</scope>
</dependency>
И также может понадобиться:
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.7.32</version>
</dependency>

3.	Импортируй WebDriverManager в каждый тест:
import io.github.bonigarcia.wdm.WebDriverManager;

4.	Проинициализируй WebDriverManager в начале каждого теста.
Для Google Chrome это выглядит так:
WebDriverManager.chromedriver().setup();
 Чтобы не повторять этот код каждый раз, можно создать метод для инициализации public void startUp(). Понадобится аннотация @Before — тогда инициализация выполнится перед каждым тестом:

         @Before
          public void startUp() {
              WebDriverManager.chromedriver().setup();
           }*/


