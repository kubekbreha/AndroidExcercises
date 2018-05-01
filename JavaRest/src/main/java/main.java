import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

public class main {

    public static void main(String[] args) {

        Client client = Client.create();
        WebResource webResource = client.resource("https://us-south.certificate-manager.bluemix.net/api/v2/crn%3Av1%3Abluemix%3Apublic%3Acloudcerts%3Aus-south%3Aa%2Fc89f8363618521e0457ad288a1070861%3Adcb2b9c4-34d7-4dd6-b5f2-fd1799ef6602%3A%3A/certificates?order=expires_on&page_number=0&page_size=100");
        String appKey = "Bearer eyJraWQiOiIyMDE3MTAzMC0wMDowMDowMCIsImFsZyI6IlJTMjU2In0.eyJpYW1faWQiOiJJQk1pZC01MFUyMkdXNFJIIiwiaWQiOiJJQk1pZC01MFUyMkdXNFJIIiwicmVhbG1pZCI6IklCTWlkIiwiaWRlbnRpZmllciI6IjUwVTIyR1c0UkgiLCJnaXZlbl9uYW1lIjoiSmFrdWIiLCJmYW1pbHlfbmFtZSI6IkJyZWh1diIsIm5hbWUiOiJKYWt1YiBCcmVodXYiLCJlbWFpbCI6Ikpha3ViLkJyZWh1dkBpYm0uY29tIiwic3ViIjoiamFrdWIuYnJlaHV2QGlibS5jb20iLCJhY2NvdW50Ijp7ImJzcyI6ImM4OWY4MzYzNjE4NTIxZTA0NTdhZDI4OGExMDcwODYxIiwiaW1zIjoiMTUwMzc1NyJ9LCJpYXQiOjE1MjUwNzc5MTQsImV4cCI6MTUyNTA4MTUxNCwiaXNzIjoiaHR0cHM6Ly9pYW0uYmx1ZW1peC5uZXQvaWRlbnRpdHkiLCJncmFudF90eXBlIjoidXJuOmlibTpwYXJhbXM6b2F1dGg6Z3JhbnQtdHlwZTpwYXNzY29kZSIsInNjb3BlIjoiaWJtIG9wZW5pZCIsImNsaWVudF9pZCI6ImJ4IiwiYWNyIjoxLCJhbXIiOlsicHdkIl19.DIa4xMB0UdsAAh1x-4-ZGOJFJvgpQpPlpl4Biqri9Z9dFMoN8oGBycD-riMHADbiBsoxyRrqpkT2-oKXK-lg4D9TzXxSIYrBV_l9cna_10DmGJLhVemm-9JQyiZyFNgB0Smzlf_5nfUrQWjJrP6w-iBTxdkXZysczOOJloagehlglrSAemdbzo8VIscHIowtf82hC-ZWp2PfNxnbkIgWSDOjacBO-XkepW1EO9YLgKUb230sMaox_W0SM5w_gEj77ZPcx7MAd30kc_A_aIssylWSLDtm4xo6qbNNiHlZq-l03bHf7kQT4Ig4OzrNsg0eWcrJoCLZWif12XZjLsETHg" ; // appKey is unique number

        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        ClientResponse response = webResource.queryParams(queryParams)
                .header("Authorization", appKey)
                .get(ClientResponse.class);

        String jsonStr = response.getEntity(String.class);

        System.out.println(jsonStr);
    }
}
