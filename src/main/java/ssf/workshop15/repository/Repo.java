package ssf.workshop15.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ssf.workshop15.model.Corpus;

@Repository
public class Repo {

    @Autowired
    private RedisTemplate template;

    private static final String CORPUS_KEY = "corpus";

    public void saveCorpusResult(List<Corpus> reqArr){
        for(Corpus c : reqArr){template.opsForHash().put(CORPUS_KEY, c.getWordNextWord(), String.valueOf(c.getCount()));
        }
    }
}
