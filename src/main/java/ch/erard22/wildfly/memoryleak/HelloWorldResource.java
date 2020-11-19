package ch.erard22.wildfly.memoryleak;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.opentracing.Traced;

@Traced
@Path("/")
public class HelloWorldResource {

    @Inject
    private HelloWorldService helloWorldService;

    @GET()
    @Path("hello")
    public String sayHello() {
        return helloWorldService.sayHello();
    }


}
