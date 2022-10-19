import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONExporter implements IExportable{

    /*
    JSON Format:
    [
    {"Number":1,
     "Name":"Win10",
     Manufacturer:"Microsoft"
    },
    {"Number":2,
     "Name":"MacOsX",
     "Manufacturer":"Apple"
    },
    {"Number":3,
     "Name":"Linux",
     "Manufacturer":"Suse"
    }
    ]
     */
    @Override
    public void export(List<Article> articleList) {
        try {
            FileWriter fileWriter = new FileWriter("JSONExport.json");
            fileWriter.write("[\n" );
            int length = articleList.size();
            for (Article article: articleList)
            {

                String line = "{\"Number\":"+ article.getNumber() + ","
                                + "\"Name\":\"" + article.getName() + "\"" + ","
                                + "\"Manufacturer\":\"" +article.getManufacturer() +"\"" +
                                "}";
                if(length>1){
                    line = line+ ",\n";
                }else {
                    line = line + "\n";
                }
                fileWriter.write(line);
                length--;

            }
            fileWriter.write("]" );
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
