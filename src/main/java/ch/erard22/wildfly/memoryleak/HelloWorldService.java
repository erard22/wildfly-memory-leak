package ch.erard22.wildfly.memoryleak;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.opentracing.Traced;

@ApplicationScoped
@Traced
public class HelloWorldService {

    public String sayHello() {
        return "Hello World!";
    }
}
