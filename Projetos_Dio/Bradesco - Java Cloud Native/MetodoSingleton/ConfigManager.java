public class ConfigManager {
    private static ConfigManager instance;
    private String config;

    private ConfigManager() {
        this.config = "Configuração padrão";
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
