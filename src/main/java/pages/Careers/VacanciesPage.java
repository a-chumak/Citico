package pages.Careers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class VacanciesPage {

    public static SelenideElement getPageTitle() {
        return Markup.title();
    }

    public void openVacancyWithTitle(String vacancy){
        Markup.listVacancies().findBy(text(vacancy)).click();
    }

    public ElementsCollection getQAProfSkills(){
        return Markup.listSkills();
    }

    public int countParagraphInSkills() {
        String a = Markup.listSkills().find(Condition.attribute("style")).innerHtml();
        String [] str = a.split("<br>");
        int b = str.length;
        return b;
    }

    private static class Markup {
        static SelenideElement title() { return $x("(//div[@class='text-block']//h1"); }

        static ElementsCollection listVacancies() { return $$x("//ul[@id='menu-main-1']//li/a"); }
        static ElementsCollection listSkills() { return $$x("//p[contains(text(),'Experience in web application testing;')]"); }
    }
}
