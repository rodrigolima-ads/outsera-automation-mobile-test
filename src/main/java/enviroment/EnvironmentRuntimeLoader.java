package enviroment;

import org.apache.commons.lang3.StringUtils;

import static enviroment.Environment.*;
import static enviroment.Environment.UAT;

public class EnvironmentRuntimeLoader {
    private EnvironmentRuntimeLoader() {
        throw new IllegalStateException("Utility class");
    }

    public static Environment get() {
        String env = System.getProperty("env");
        if (StringUtils.isEmpty(env)) {
            return UAT;
        }
        switch (env) {
            case "dev":
                return DEV;
            case "tst":
                return TST;
            case "uat":
                return UAT;
            default:
                throw new IllegalArgumentException("Ambiente '" + env + "' não configurado para execução dos testes");
        }
    }
}

