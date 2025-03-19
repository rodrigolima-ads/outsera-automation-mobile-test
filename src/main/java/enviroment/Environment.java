package enviroment;

public enum Environment {
    DEV("configuration-dev.properties"),
    TST("configuration-tst.properties"),
    UAT("configuration-uat.properties");

    Environment(String filePath) {
    }

}
