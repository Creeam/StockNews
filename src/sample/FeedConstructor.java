package sample;
import java.util.ArrayList;
import java.util.HashMap;

public class FeedConstructor {
    public static ArrayList<RSSItem> constructor(ArrayList<String> active_categories){
        HashMap<String, ArrayList<String>> urls = new HashMap<String, ArrayList<String>>(){{
            put("Бизнес", new ArrayList<String>() {{
                add("http://static.feed.rbc.ru/rbc/logical/footer/news.rss");
            }});
            put("Финансы", new ArrayList<String>() {{
                add("https://news.tut.by/rss/economics.rss");
            }});
            put("Политика", new ArrayList<String>() {{
                add("A");
            }});
            put("Технологии", new ArrayList<String>() {{
                add("https://news.tut.by/rss/it.rss");
                add("https://dev.by/rss");
            }});
            put("Искусство", new ArrayList<String>() {{
                add("A");
            }});
            put("Еда", new ArrayList<String>() {{
                add("A");
            }});
            put("Спорт", new ArrayList<String>() {{
                add("https://news.tut.by/rss/sport.rss");
                add("https://www.sports.ru/rss/main.xml");
                add("https://www.sports.ru/rss/all_news.xml");
            }});
            put("Видеоигры", new ArrayList<String>() {{
                add("A");
            }});
        }};
        ArrayList<RSSItem> feed = new ArrayList<RSSItem>();

        for (String category:
                active_categories) {
            for(String url:
                    urls.get(category)){
                ArrayListRSSFeedStore feedStore = new ArrayListRSSFeedStore();
                RSSFeedReader.read("https://news.tut.by/rss/all.rss", feedStore);
                feed.addAll(feedStore.getList());
            }
        }
        feed.sort((a,b)->RSSItem.compareDate(a,b));
        return feed;
    }
}
