package ch.erard22.wildfly.memoryleak;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/hello-world")
public class HelloWorldApplication extends Application {
}
