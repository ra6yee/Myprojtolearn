package паттерны_проектирования.dfs.ЕщеПрокси.Connectors;

public class SimpleConnector implements Connector {
    private String resourceString;

    public SimpleConnector(String resourceString) {
        this.resourceString = resourceString;
    }

    @Override
    public void connect() {
        System.out.println("Successfully connected to " + resourceString);
    }
}
