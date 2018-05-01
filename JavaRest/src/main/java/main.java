import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

public class main {

    public static void main(String[] args) {

        Client client = Client.create();
        WebResource webResource = client.resource("url");
        String appKey = "auth" ;

        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        ClientResponse response = webResource.queryParams(queryParams)
                .header("Authorization", appKey)
                .get(ClientResponse.class);

        String jsonStr = response.getEntity(String.class);

        System.out.println(jsonStr);
    }
}
