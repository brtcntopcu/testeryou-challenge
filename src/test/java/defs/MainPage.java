package defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPageObj;


public class MainPage {

    WebDriver driver;

    MainPageObj mainPageObj;

    public String MOVIE_STARS;

    public String MOVIE_WRITER;

    public String MOVIE_DIRECTOR;

    public MainPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        mainPageObj = new MainPageObj(driver);

    }
    @When("I enter IMDB page")
    public void i_enter_imdb_page() {
        driver.get("https://www.imdb.com/");
    }

    @When("I click menu then click oscars")
    public void i_click_menu_then_click_oscars() {
        mainPageObj.clickMenu();
        mainPageObj.clickOscars();
    }

    @When("I choose 1929 year on event history")
    public void chooseYearOnEventHistory() {
        mainPageObj.chooseYear();
    }

    @When("I click The Circus")
    public void clickMovieCircus() {
        mainPageObj.scrollUntilFindTheCircusAndClick();
    }

    @When("I click The Jazz Singer")
    public void clickMovieJazzSinger() {
        mainPageObj.scrollUntilFindTheJazzSingerAndClick();
    }

    @When("I save movie director, writer and stars")
    public void compriseKnowledge() {
        MOVIE_DIRECTOR = mainPageObj.getMovieDirectorName();
        MOVIE_WRITER = mainPageObj.getMovieWriter();
        MOVIE_STARS = mainPageObj.getMovieStar();
    }

    @When("I click IMDB button")
    public void clickImdbButton() {
        mainPageObj.clickImdbButton();
    }

    @When("I search {string} on searchbar and choose")
    public void i_search_on_searchbar_and_choose(String string) {
        mainPageObj.searchMovie(string);
        mainPageObj.clickFirstMovieWhenSearch();
    }

    @Then("I compare movie knowledge")
    public void compareKnowledge() {
        Assert.assertEquals(MOVIE_STARS, mainPageObj.getMovieStar());
        Assert.assertEquals(MOVIE_DIRECTOR, mainPageObj.getMovieDirectorName());
        Assert.assertEquals(MOVIE_WRITER, mainPageObj.getMovieWriter());
    }

    @When("I click photos")
    public void clickPhotos() {
        mainPageObj.clickPhotosSection();
    }

    @Then("I check broken images")
    public void checkBrokenImages() {
        Assert.assertEquals(0, mainPageObj.findBrokenImages());
    }


    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
