/*Напиши автотест, который добавит новую карточку, а потом её удалит. Используй поиск по классу.
Создай автотест, который нажмёт на кнопку добавления нового контента. Откроется новое окно.
Введи «Москва» в поле «Название». Вставь в поле для ссылки ссылку на изображение
https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg.
Используй поиск по атрибуту name.
Сохрани контент. Примени поиск по XPath. После корневого элемента ищи элемент form и его атрибут name.
Найди кнопку сохранения через поиск по типу элемента и тексту.
Новую карточку нужно удалить, чтобы привести тестовый стенд в изначальное состояние.
Найди кнопку удаления карточки. Используй поиск по XPath — относительный путь до элемента и значению его
атрибута class. Кликни по ней.
 */

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

public class Task_2 {

    @Before
    public void setUp() {
        // Настройка Selenide для использования ChromeDriver версии 128
        Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0";
        Configuration.driverManagerEnabled = false; // Отключаем автоматическую загрузку драйвера*/
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
        // Кликни по кнопке добавления нового контента
        $(byClassName("profile__add-button")).click();
        // В поле названия введи «Москва»
        $(byName("name")).setValue("Москва");
        // В поле ссылки на изображение введи ссылку
        $(byName("link")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        // Сохрани контент
        $(byXpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        // удали добавленную карточку, кликнув по кнопке удаления
        $(byXpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }
}

