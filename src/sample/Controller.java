package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable {

    @FXML JFXToggleButton businessButton;
    @FXML JFXToggleButton financeButton;
    @FXML JFXToggleButton politicsButton;
    @FXML JFXToggleButton technologyButton;
    @FXML JFXToggleButton artButton;
    @FXML JFXToggleButton eatButton;
    @FXML JFXToggleButton sportButton;
    @FXML AnchorPane mainAnchorPain;
    @FXML ImageView imageView;


    AnchorPane anchorPane;
    Group group;
    Text titleText;
    Text descText;
    JFXButton read;
    JFXButton add;

    List<String> listOfCategories;

    double top = 50;
    double left = 20;
    double right;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listOfCategories = new ArrayList<>();
        mainAnchorPain.getChildren().clear();

        businessButton.setOnAction(event -> {

            if (businessButton.isSelected()) {
                listOfCategories.add(businessButton.getText());
            } else {
                listOfCategories.remove(businessButton.getText());
            }

            parseInfo(listOfCategories);
            System.out.println(listOfCategories);
        });

        financeButton.setOnAction(event -> {

            if (financeButton.isSelected()) {
                listOfCategories.add(financeButton.getText());
            } else {
                listOfCategories.remove(financeButton.getText());
            }

            parseInfo(listOfCategories);
            System.out.println(listOfCategories);
        });

        politicsButton.setOnAction(event -> {

            if (politicsButton.isSelected()) {
                listOfCategories.add(politicsButton.getText());
            } else {
                listOfCategories.remove(politicsButton.getText());
            }

            parseInfo(listOfCategories);
            System.out.println(listOfCategories);
        });

        technologyButton.setOnAction(event -> {

            if (technologyButton.isSelected()) {
                listOfCategories.add(technologyButton.getText());
            } else {
                listOfCategories.remove(technologyButton.getText());
            }

            parseInfo(listOfCategories);
            System.out.println(listOfCategories);
        });

        artButton.setOnAction(event -> {

            if (artButton.isSelected()) {
                listOfCategories.add(artButton.getText());
            } else {
                listOfCategories.remove(artButton.getText());
            }

            parseInfo(listOfCategories);
            System.out.println(listOfCategories);
        });

        eatButton.setOnAction(event -> {

            if (eatButton.isSelected()) {
                listOfCategories.add(eatButton.getText());
            } else {
                listOfCategories.remove(eatButton.getText());
            }

            parseInfo(listOfCategories);
            System.out.println(listOfCategories);
        });

        sportButton.setOnAction(event -> {

            if (sportButton.isSelected()) {
                listOfCategories.add(sportButton.getText());
            } else {
                listOfCategories.remove(sportButton.getText());
            }

            parseInfo(listOfCategories);
            System.out.println(listOfCategories);
        });
    }

    public static void openWebpage(String url) {
        try {
            new ProcessBuilder("start \""+ url +"\"").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToUI(String title, String description, String link) {

        anchorPane = new AnchorPane();
        group = new Group();
        titleText = new Text();
        descText = new Text();
        read = new JFXButton();
        add = new JFXButton();
        imageView = new ImageView();

        if (getLinkImage(description).equals("Error")) {
            try {
                imageView.setImage(new Image(new File("D:\\Учеба\\IdeaProjects\\Практика\\RSSFeed\\src\\sample\\img\\newspapers2.jpg").toURI().toURL().toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            imageView.setImage(new Image(getLinkImage(description)));
        }
        imageView.setFitWidth(401);
        imageView.setFitHeight(261);
        AnchorPane.setTopAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 0.0);

        if (title.length() > 55) {
            titleText.setText(title.substring(0, 55) + "...");
        } else {
            titleText.setText(title);
        }

        titleText.setWrappingWidth(300.0);
        titleText.setFont(new Font("SansSerif",20));
        AnchorPane.setTopAnchor(titleText, 270.0);
        AnchorPane.setLeftAnchor(titleText, 15.0);
        AnchorPane.setRightAnchor(titleText, 40.0);

        System.out.println("LIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIINK " + getLinkImage(description));

        if (getDescription(description).length() > 255) {
            descText.setText(getDescription(description).substring(0, 255) + "...");
        } else {
            descText.setText(getDescription(description));
        }

        descText.setWrappingWidth(344.1);
        descText.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(descText, 360.0);
        AnchorPane.setLeftAnchor(descText, 15.0);

        read.setText("Читать");
        read.setStyle("-fx-background-color: #0f1899;");
        read.setFont(new Font("System", 12));
        read.setTextFill(Color.WHITE);
        read.setOnAction(event -> {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        AnchorPane.setTopAnchor(read, 500.0);
        AnchorPane.setBottomAnchor(read, 20.0);
        AnchorPane.setLeftAnchor(read, 270.0);
        AnchorPane.setRightAnchor(read, 50.0);

        add.setText("Добавить в закладки");
        add.setStyle("-fx-background-color: #617BFF;");
        add.setFont(new Font("System", 12));
        add.setTextFill(Color.WHITE);
        AnchorPane.setTopAnchor(add, 500.0);
        AnchorPane.setBottomAnchor(add, 20.0);
        AnchorPane.setLeftAnchor(add, 15.0);
        AnchorPane.setRightAnchor(add, 250.0);

        anchorPane.getChildren().addAll(imageView, titleText, descText, read, add);
        anchorPane.setMaxWidth(401);
        anchorPane.setMaxHeight(538);
        anchorPane.setStyle("-fx-background-color: #fff;");
        group.getChildren().addAll(new AnchorPane(), anchorPane);
        AnchorPane.setTopAnchor(group, top);
        AnchorPane.setLeftAnchor(group, left);
        AnchorPane.setRightAnchor(group, right);


        if (mainAnchorPain.getChildren().size() % 2 == 0) {
            top += 0;
            left += 430;
            right += 10;
        } else {
            top += 600;
            left -= 430;
            right -= 10;
        }

        mainAnchorPain.getChildren().add(group);
        System.out.println(mainAnchorPain.getChildren().size());
    }

    public void onClick() {
        try {
            addToUI("ЗаголовокЗаголовокЗаголовокЗаголовокЗаголовокЗаголовокЗаголовокЗаголовок", "Частота преобразует жидкий подшипник подвижного объекта. Точность курса безусловно представляет собой резонансный ньютонометр с учётом интеграла собственного кинетического момента ротора. Астатическая система координат Булгакова, несмотря на некоторую погрешность, различна. Внутреннее кольцо, в соответствии с модифицированным уравнением Эйлера, велико.", new File("D:\\Учеба\\IdeaProjects\\Практика\\RSSFeed\\src\\sample\\img\\newspapers2.jpg").toURI().toURL().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLinkImage(String description) {
        Pattern pattern = Pattern.compile("http(.*).jpg");
        Matcher matcher = pattern.matcher(description);
        if (matcher.find()) {
            return matcher.group();
        }
        return "Error";
    }

    public String getDescription(String description) {
        Pattern pattern = Pattern.compile(">(.*)$");
        Matcher matcher = pattern.matcher(description);
        if (matcher.find()) {
            return matcher.group();
        }
        return "Error description!";
    }


    public void parseInfo(List<String> listOfCategories) {
        ArrayList<RSSItem> list = constructor((ArrayList<String>) listOfCategories);
        mainAnchorPain.getChildren().clear();

        top = 50;
        left = 20;
        right = 0;

        for (RSSItem rssItem : list) {
            System.out.println("guid: " + rssItem.getGuid());
            System.out.println("title: " + rssItem.getTitle());
            System.out.println("description: " + rssItem.getDescription());
            System.out.println("link: " + rssItem.getLink());
            System.out.println("pubDate: " + rssItem.getPubDate());
            System.out.println("");

            addToUI(rssItem.getTitle(), rssItem.getDescription(), rssItem.getLink());

        }

        System.out.println(mainAnchorPain.getChildren());

    }

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
