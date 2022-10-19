import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Entwurfsmuster (Strategy) Source: https://de.wikipedia.org/wiki/Strategie_(Entwurfsmuster)

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article("1", "Win10", "Microsoft"));
        articles.add(new Article("2", "MacOsX", "Apple"));
        articles.add(new Article("3", "Linux1", "Suse"));
        articles.add(new Article("4", "Android", "Google"));

        ExporterContext exporterContext = new ExporterContext(new JSONExporter());
        exporterContext.doExport(articles);


    }
}