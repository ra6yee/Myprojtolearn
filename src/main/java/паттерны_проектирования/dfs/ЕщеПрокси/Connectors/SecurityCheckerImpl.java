package паттерны_проектирования.dfs.ЕщеПрокси.Connectors;

public class SecurityCheckerImpl implements SecurityChecker {
    @Override
    public boolean performSecurityCheck() {
        System.out.println("SECURITY OK!");
        return true;
    }
}
