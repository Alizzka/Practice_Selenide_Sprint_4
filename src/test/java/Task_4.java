/*Тебе нужно отметить все карточки. Потом выбери из них вторую, получи её подпись и положи в переменную.
Напиши автотест, который выберет все карточки в тестовом приложении. Используй $$ и поиск по классу.
Выбери вторую карточку на странице. Сохрани её подпись в переменную cardText.
тобы найти веб-элемент с подписью карточки, используй поиск по классу.
Чтобы найти веб-элемент внутри другого веб-элемента, используй метод find.
Например, так: $(byId("поиск веб-элемента по id")).find(byId("поиск вложенного веб-элемента по его id"))*/

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Task_4 {

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
        // Перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");

        // Выполни авторизацию
        $(byId("email")).setValue("alizzka@mail.ru");
        $(byId("password")).setValue("1234");
        $(byText("Войти")).click();

        // Выбери все карточки и найди вторую
        String cardText = $$(byClassName("card")).get(1).find(byClassName("card__title")).getText();

        // Выведи текст второй карточки в консоль (для проверки)
        System.out.println("Текст второй карточки: " + cardText);
    }
    @After
    public void tearDown() {
        closeWebDriver(); // Закрытие браузера после каждого теста
    }
}
