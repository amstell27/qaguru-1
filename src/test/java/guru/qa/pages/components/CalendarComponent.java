package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {

        $("[class='react-datepicker__month-select']").selectOption(month);
        $("[class='react-datepicker__year-select']").selectOption(year);
        $("[aria-label$=']" + month + " " + day + "th, " + year + "']").click();

    }
}
