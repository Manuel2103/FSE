import java.util.List;

public class ExporterContext {
    private IExportable exporter;

    public ExporterContext(IExportable exporter) {
        this.exporter = exporter;
    }

    public void setExporter(IExportable exp)
    {
        this.exporter = exp;
    }

    public void doExport(List<Article> articleList)
    {
        this.exporter.export(articleList);
    }
}
