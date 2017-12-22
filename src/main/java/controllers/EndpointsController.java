package controllers;

/**
 * Created by gwenli on 2017-09-19.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class EndpointsController {

    //API URL configuration
    /**@Value("${localbase}")
    private String localbase;
    @Value("${apibase}")
    private String apibase;
     **/

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private String apibase = "http://api.openweathermap.org/data/2.5/weather";

    private String apikeys = "7728c4020a63efa19adb0f1a6a989881";
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to Gwen's weather station! (Yah it's Gwen's ...)";
    }


    @RequestMapping(value = "/gwen", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getWeatherReportJsonaswrapper(
            @RequestParam(value = "city", defaultValue="Toronto") String city,
            @RequestParam(value = "returndatatype", defaultValue="html") String returndatatype
            )
    throws Exception
    {

    if (!returndatatype.equals("json")&&!returndatatype.equals("xml")&&!returndatatype.equals("html")){
        log.info("OOPS! Request in unsupported data type!!");
        // return client error 400

        return new ResponseEntity<String>("only json, xml and html supported", HttpStatus.BAD_REQUEST);
    }
        String RequestURLtoapi = apibase + "?q=" + city + "&mode=" +returndatatype+"&appid=" + apikeys;
        ResponseEntity<String> Responsefromapi = RequestController.requestjsonfromapi(RequestURLtoapi);
        //return new ResponseEntity<>(Responsefromapi, HttpStatus.OK);//need to consider different circumstances
        return  Responsefromapi;
    }

}
