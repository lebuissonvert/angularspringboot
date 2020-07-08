package app.controller;


import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class SoapController {

    private static final String NAMESPACE_URI = "http://localhost:8080/";

    /*@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCoursByMonthAndYearSoapRequest")
    @ResponsePayload
    public GetCoursByMonthAndYearSoapResponse getCoursByMonthAndYearSoap(@RequestPayload GetCoursByMonthAndYearSoap request) {
        GetCoursByMonthAndYearSoapResponse response = new GetCoursByMonthAndYearSoapResponse();
        return response;
    }*/

}
