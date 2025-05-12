public class Main {
    public static void main(String[] args) {
        ConfigManager a = ConfigManager.getInstance();
        ConfigManager b = ConfigManager.getInstance();

        a.setConfig("Configuração nova");

        System.out.println(b.getConfig()); // Vai imprimir: Configuração nova
    }
}
