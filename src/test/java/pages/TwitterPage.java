package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TwitterPage {

    public TwitterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "article[data-testid='tweet']")
    public WebElement posts;

    @FindBy(css = "article[data-testid='tweet'] div[data-testid='tweetText']")
    public WebElement postsTitle;

    @FindBy(xpath = "(//article//a/time)[1]")
    public WebElement postTime;

    @FindBy(xpath = "(//div[@data-testid='tweetText'])[1]")
    public WebElement tweetText;

    @FindBy(css = "div[data-testid='reply'] span[data-testid='app-text-transition-container']")
    public WebElement postsReply;

    @FindBy(css = "div[data-testid='retweet'] span[data-testid='app-text-transition-container']")
    public WebElement postsRetweet;

    @FindBy(css = "div[data-testid='like'] span[data-testid='app-text-transition-container']")
    public WebElement postsLike;


}
