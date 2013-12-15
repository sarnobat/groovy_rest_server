import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpServer;

public class Server {
        @Path("helloworld")
        public static class HelloWorldResource { // Must be public

                @GET
                @Path("json")
                @Produces("application/json")
                public Response json() throws JSONException {
                        JSONObject json = new JSONObject();
                        json.put("foo", "bar");
 					    return Response.ok().header("Access-Control-Allow-Origin", "*")
						 			.entity(json.toString()).type("application/json").build();
                }
        }

        public static void main(String[] args) throws URISyntaxException {
                HttpServer server = JdkHttpServerFactory.createHttpServer(
                                new URI("http://localhost:9099/"), new ResourceConfig(HelloWorldResource.class));
        }
}