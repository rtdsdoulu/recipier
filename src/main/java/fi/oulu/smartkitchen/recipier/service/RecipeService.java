package fi.oulu.smartkitchen.recipier.service;

import fi.oulu.smartkitchen.recipier.dao.AnalysisToolDao;
import fi.oulu.smartkitchen.recipier.dao.RecipeSourceDao;
import fi.oulu.smartkitchen.recipier.dao.TaggedTokensDao;
import fi.oulu.smartkitchen.recipier.model.AnalysisTool;
import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.model.Token;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedRecipe;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 12/14/2016.
 */

@Service
public class RecipeService {

    @Autowired
    private RecipeSourceDao recipeSourceDao;

    @Autowired
    private AnalysisToolDao analysisToolDao;

    @Autowired
    private TaggedTokensDao taggedTokensDao;

    public void saveTaggedRecipe(TaggedRecipe taggedRecipe){

        Map<String,List<TaggedToken>> taggedTokensMap = taggedRecipe.getTaggedTokens();

        Iterator<String> keyIterator = taggedTokensMap.keySet().iterator();

        while(keyIterator.hasNext()){
            String toolName= keyIterator.next();
            AnalysisTool tool = analysisToolDao.findByName(toolName);
            RecipeSource recipeSource = taggedRecipe.getRecipeSource();
            List<TaggedToken> taggedTokens = taggedTokensMap.get(toolName);
            for(TaggedToken token:taggedTokens){
                Token savedToken = new Token();
                savedToken.setCorrect(token.isCorrect());
                savedToken.setAnalysis_tool(tool);
                savedToken.setComment(token.getReason());
                savedToken.setCorrectTag(token.getCorrectTag());
                savedToken.setRecipes(recipeSource);
                String origToken = token.getTaggedToken().substring(0, token.getTaggedToken().indexOf("/"));
                String tag = token.getTaggedToken().substring(token.getTaggedToken().indexOf("/")+1);
                savedToken.setTag(tag);
                savedToken.setToken(origToken);
                taggedTokensDao.save(savedToken);
            }
        }
    }


}
