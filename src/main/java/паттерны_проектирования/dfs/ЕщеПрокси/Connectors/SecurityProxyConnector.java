package паттерны_проектирования.dfs.ЕщеПрокси.Connectors;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker;
    private SimpleConnector simpleConnector;
    public SecurityProxyConnector(String s) {
       this.simpleConnector=new SimpleConnector(s);
       this.securityChecker=new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
if(securityChecker.performSecurityCheck()){
    simpleConnector.connect();
}
    }
}
