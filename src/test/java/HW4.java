import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HW4
{
    @BeforeAll
        static void testBrowseConfiguration() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://github.com";
            Configuration.pageLoadStrategy = "eager";
        }


        @Test
        void softAssertions() {

            //Selenide на GitHub
            open("/selenide/selenide");

            //Wiki
            $("#wiki-tab").click();

            //SoftAssertions - наличие
            $("#wiki-body").shouldHave(text("Soft assertions"));

            //Открыть SoftAssertions
            $("#wiki-body").$(byText("Soft assertions")).click();

            //Наличие примера кода
            $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
            $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                    "class Tests {\n" +
                    "  @Test\n" +
                    "  void test() {\n" +
                    "    Configuration.assertionMode = SOFT;\n" +
                    "    open(\"page.html\");\n" +
                    "\n" +
                    "    $(\"#first\").should(visible).click();\n" +
                    "    $(\"#second\").should(visible).click();\n" +
                    "  }\n" +
                    "}"));

        }
    }
