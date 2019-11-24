import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Careers.VacanciesPage;
import pages.HomePage;
import pages.NavigationMenu;

import static libs.ConfigData.getValue;

public class VacanciesTest extends BaseTest {

    NavigationMenu menu = new NavigationMenu();
    VacanciesPage vacanciesPage = new VacanciesPage();
    static HomePage homePage = new HomePage();

    @DisplayName("Open home page")
    @BeforeAll
    public static void setUp() {
        homePage.openHomePage();
        Assertions.assertEquals(getValue("Title") , homePage.getPageTitle());
    }

    @DisplayName("Verify quantity professional skills for Test Automation Engineer")
    @Test
    public void verifyTestAutomationVacancy() {
        menu.openVacanciesItemMenu();
        vacanciesPage.openVacancyWithTitle(getValue("vacancy_QA"));
        vacanciesPage.getQAProfSkills().shouldHave(CollectionCondition.texts("Experience in web application testing;"));

        Assertions.assertEquals(5, vacanciesPage.countParagraphInSkills());
    }
}
