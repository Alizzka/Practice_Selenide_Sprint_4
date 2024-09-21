/*Нужно поменять описание и имя.
Напиши автотест, который нажмёт кнопку редактирования профиля. Используй поиск по классу.
Откроется отдельное окно. В поле «Имя» введи «Аристарх Сократович» а в поле «Занятие» — «Автор автотестов».
Это можно сделать через поиск по атрибуту id.
Сохрани изменения. Примени поиск по XPath: после корневого элемента ищи элемент  form и его атрибут name.
Найди кнопку сохранения через поиск по типу элемента и тексту.
 */

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Task_3 {

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
        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("alizzka@mail.ru");
        $(byId("password")).setValue("1234");
        $(byText("Войти")).click();

        // кликни по кнопке редактирования профиля
        $(byClassName("profile__edit-button")).click();
        // введи «Аристарх Сократович» в поле «Имя»
        $(byId("owner-name")).setValue("Аристарх Сократович");
        // введи «Автор автотестов» в поле «Занятие»
        $(byId("owner-description")).setValue("Автор автотестов");
        // сохрани изменения
        $(byXpath(".//form[@name='edit']/button[text()='Сохранить']")).click();
    }
    @After
    public void tearDown() {
        closeWebDriver(); // Закрытие браузера после каждого теста
    }
}