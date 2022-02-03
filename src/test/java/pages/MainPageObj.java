package pages;

import org.openqa.selenium.WebDriver;

public class MainPageObj extends BasePage {

    private static final String MENU_BUTTON_XPATH = "//*[@id=\"imdbHeader-navDrawerOpen--desktop\"]";

    private static final String OSCARS_BUTTON_ON_MENU_LIST_XPATH = "/html/body/div[2]/nav/div[2]/aside/div/"
            + "div[2]/div/div[3]/span/div/div/ul/a[1]";

    private static final String EVENT_YEAR_XPATH = "/html/body/div[3]/div/div[2]/div[3]/div/div[2]/div[3]"
            + "/span/div/div/div[2]/div[16]/span[4]";

    public static final String THE_CIRCUS_MOVIE_XPATH = "/html/body/div[3]/div/div[2]/div[3]/div/div[1]/div[3]/span/div/div/div/"
            + "div[2]/h3/div/div/div/div[1]/div[2]/div[2]/div[1]/span/span/a";

    private static final String MOVIE_DIRECTOR_NAME_XPATH = "/html/body/div[2]/main/div/section[1]/section/div[3]/"
            + "section/section/div[3]/div[2]/div[1]/div[3]/ul/li[1]/div/ul/li/a";

    private static final String MOVIE_STAR_NAME_XPATH = "/html/body/div[2]/main/div/section[1]/section/div[3]/section"
            + "/section/div[3]/div[2]/div[1]/div[3]/ul/li[3]/div";

    private static final String MOVIE_WRITER_NAME_XPATH = "/html/body/div[2]/main/div/section[1]/section/div[3]/section"
            + "/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div/ul/li/a";

    private static final String IMDB_BUTTON_XPATH = "//*[@id=\"home_img_holder\"]";

    private static final String SEARCH_BAR_ID = "suggestion-search";

    private static final String FIRST_MOVIE_ON_SEARCH_XPATH = "/html/body/div[2]/nav/div[2]/div[1]/form/div[2]/div/div/div/ul/li[1]/a";

    public static final String THE_JAZZ_SINGER_MOVIE_XPATH = "/html/body/div[3]/div/div[2]/div[3]/div/div[1]/div[3]/span/div/"
            +" div/div/div[2]/h3/div/div/div/div[2]/div[2]/div[2]/div[1]/span/span/a";

    public static final String PHOTOS_SECTION_CSS_PATH = ".Header__PhotoSectionTitle-sc-14opf2q-0";

    public MainPageObj(WebDriver driver) {
        super(driver);
    }

    public void clickMenu() {
        clickForXpath(MENU_BUTTON_XPATH);
    }

    public void clickOscars() {
        clickForXpath(OSCARS_BUTTON_ON_MENU_LIST_XPATH);
    }

    public void chooseYear() {
        clickForXpath(EVENT_YEAR_XPATH);
    }

    public void scrollUntilFindTheCircusAndClick() {
        scrollUntilFindMovieAndClick(THE_CIRCUS_MOVIE_XPATH);
    }

    public void scrollUntilFindTheJazzSingerAndClick() {
        scrollUntilFindMovieAndClick(THE_JAZZ_SINGER_MOVIE_XPATH);
    }

    public String getMovieDirectorName() {
        return getTextXpath(MOVIE_DIRECTOR_NAME_XPATH);
    }

    public String getMovieWriter() {
        return getTextXpath(MOVIE_WRITER_NAME_XPATH);
    }

    public String getMovieStar() {
        return getTextXpath(MOVIE_STAR_NAME_XPATH);
    }

    public void clickImdbButton() {
        clickForXpath(IMDB_BUTTON_XPATH);
    }

    public void searchMovie(String text) {
        sendKeysForId(SEARCH_BAR_ID, text);
    }

    public void clickFirstMovieWhenSearch() {
        clickForXpath(FIRST_MOVIE_ON_SEARCH_XPATH);
    }

    public void clickPhotosSection() {
        clickForCSSPath(PHOTOS_SECTION_CSS_PATH);
    }
}
