package паттерны_проектирования.dfs.Кеш_прокси;

import java.util.Map;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever originalRetriever;
    private LRUCache lruCache;

    public CachingProxyRetriever(Storage storage) {
       this.originalRetriever = new OriginalRetriever(storage);
this.lruCache=new LRUCache(16);

    }

    @Override
    public Object retrieve(long id) {
       Object o=lruCache.find(id);

        if(o!=null)
            return lruCache.find(id);
        else{
            lruCache.set(id,originalRetriever.retrieve(id));
        }
    return originalRetriever.retrieve(id);
    }
}
