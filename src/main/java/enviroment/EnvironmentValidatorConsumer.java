package enviroment;


import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class EnvironmentValidatorConsumer implements Consumer<Map.Entry<String, Object>> {
    public EnvironmentValidatorConsumer() {
    }

    public void accept(Map.Entry<String, Object> map) {
        while (map.getValue().toString().contains("{") && map.getValue().toString().contains("}")) {
            String environmentVariableName = StringUtils.substringBetween(map.getValue().toString(), "{", "}");
            Optional<String> optionalEnvironmentVariableValue = Optional.ofNullable(System.getenv(environmentVariableName));
            String newMapValue = map.getValue().toString().replace(String.format("{%s}", environmentVariableName), optionalEnvironmentVariableValue.orElse(""));
            map.setValue(newMapValue);
        }

    }
}