package green.cred.GreenCredSpring;

import green.cred.GreenCredSpring.model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {

    List<Article> articleList = new ArrayList<Article>(Arrays.asList(
            new Article("1", "Article 01", "Description 01"),
            new Article("2", "Article 02", "Description 02"),
            new Article("3", "Article 03", "Description 03")
    ));

    public List<Article> getAllArticles(){
        return articleList;
    }
}
