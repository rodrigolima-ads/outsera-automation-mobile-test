package setup.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.JSONCapabilitiesProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppiumSessionFactory {
    private final List<JSONCapabilitiesProvider> sessions = new ArrayList<>();

    public AppiumSessionFactory(File jsonPath) {
        this.sessions.add(new JSONCapabilitiesProvider(jsonPath));
    }

    public AppiumDriver<MobileElement>  getSession() {
        return this.sessions.stream().findFirst().map(JSONCapabilitiesProvider::returnSessionConfiguration).orElseThrow(() -> new RuntimeException("Invalid path to Capabilities JSON"));
    }



}