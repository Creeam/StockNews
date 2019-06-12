package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class ParserWeather {

    private static Document getPage() throws IOException {
        String url = "http://6.pogoda.by/";
        Document page = Jsoup.parse(new URL(url), 10000);
        return page;
    }

    public static void start() throws IOException {
        Document page = getPage();

        Element tableWeather = page.select("table[id=forecast]").first();
        Elements days = tableWeather.select("b");
        Elements infoAfternoon = tableWeather.select("tr[onmouseover=\"this.className='yellowThing'\"]");

        System.out.println(infoAfternoon);
    }
}
