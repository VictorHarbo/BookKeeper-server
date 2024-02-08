package dk.harbojohnston;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        // Add your JAX-RS resource classes here
        classes.add(ExampleResource.class);
        classes.add(DatabaseResource.class);
        // Add any additional resource classes as needed
        return classes;
    }
}

