package controllers;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


/**
 * Created by gwenli on 2017-09-19.
 */
public class RequestController {
    public static ResponseEntity<String> requestjsonfromapi(String requesttoapiurl) throws Exception{
        //String ans;
        //preparing request headers
       HttpEntity<String> weatherEntity = new HttpEntity<String>(null, null);
        RestTemplate restTemplate = new  RestTemplate() ;
        ResponseEntity<String> response;
        //response Handler
        try {
            response = restTemplate.exchange(requesttoapiurl, HttpMethod.GET, weatherEntity, String.class);
        } catch (HttpStatusCodeException e){
            HttpStatus statusCode = e.getStatusCode();
            String fillermessage = e.getResponseBodyAsString();
            response = new ResponseEntity<String>(fillermessage,statusCode);

            return response;
        }
        /**
         * //check status
        int status = response.getStatusCodeValue();
        if (status>=200&&status<300) {
           ans = response.getBody();
        } else
          ans = "OOPs! Something's wrong! Status code = " + status;
        **/

            return response;

    }
}
