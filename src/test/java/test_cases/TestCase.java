package test_cases;

import driver.BaseDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.TwitterPage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static utils.CommonMethod.*;

public class TestCase extends BaseDriver {
    @Test
    public void test_case() throws IOException {
        TwitterPage twitterPage = new TwitterPage(driver);

        JSONObject resultJson = new JSONObject();
        ArrayList<JSONObject> postJson = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            postJson.add(new JSONObject());
            String postTime, tweetText, postUrl, postsReply, postsRetweet, postLike;

            WebElement post = twitterPage.posts;
            WebElement postTitle = twitterPage.postsTitle;
            waitForVisibilityOfElement(post);
            waitForVisibilityOfElement(postTitle);
            scrollToElement(post);

            postsReply = getText(twitterPage.postsReply);
            postsRetweet = getText(twitterPage.postsRetweet);
            postLike = getText(twitterPage.postsLike);

            postTitle.click();

            postTime = getText(twitterPage.postTime);
            tweetText = getText(twitterPage.tweetText);
            postUrl = driver.getCurrentUrl();

            postJson.get(i).put("post_time", postTime);
            postJson.get(i).put("tweet_text", tweetText);
            postJson.get(i).put("post_url", postUrl);
            postJson.get(i).put("posts_reply", postsReply);
            postJson.get(i).put("posts_retweet", postsRetweet);
            postJson.get(i).put("post_like", postLike);
            resultJson.put("post_" + i, postJson.get(i));

            driver.navigate().back();

        }

        FileWriter fileWriter = new FileWriter("./src/main/resources/DATA.json");
        fileWriter.write(resultJson.toJSONString());
        fileWriter.close();


    }

}
