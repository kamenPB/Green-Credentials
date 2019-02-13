package green.cred.GreenCredSpring;

import green.cred.GreenCredSpring.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ArticleController {
//    @Autowired
    private ArticleService articleService;


    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }
}
