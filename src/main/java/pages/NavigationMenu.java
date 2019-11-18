package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    public void openVacanciesItemMenu() {
        Markup.CareersMenu.careersMenu().hover();
        Markup.CareersMenu.vacanciesSubMenu().click();
        //VacanciesPage.getPageTitle().shouldHave(Condition.text(getValue("VacanciesTitle")));
    }

    private static class Markup{

        private static SelenideElement menu() { return $("#menu-main");}

        static class CareersMenu{
            private static SelenideElement careersMenu() { return menu().$("#menu-item-127");}
            private static SelenideElement vacanciesSubMenu() { return careersMenu().$("#menu-item-131"); }
        }

        private static SelenideElement HomeMenu() { return $("#menu-item-3421");}
        private static SelenideElement NewsMenu() { return $("#menu-item-136");}
        private static SelenideElement AboutUsMenu() { return $("#menu-item-98");}
        private static SelenideElement TrainingCenterMenu() { return $("#menu-item-137");}
        private static SelenideElement ContactsMenu() { return $("#menu-item-134");}

    }
}
