package com.qaprosoft.carina.demo.location;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.location.DeleteLocationMethod;
import com.qaprosoft.carina.demo.api.location.GetLocationMethod;
import com.qaprosoft.carina.demo.api.location.PostLocationMethod;
import com.qaprosoft.carina.demo.api.location.PutLocationMethod;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class LocationApiTest extends AbstractTest {

    @Test
    public void postLocation () {
        PostLocationMethod postLocationMethod = new PostLocationMethod();
        postLocationMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postLocationMethod.callAPI().asString();
        postLocationMethod.validateResponse();
        String place_id = new JsonPath(rs).getString("place_id");
        GetLocationMethod getLocationMethod = new GetLocationMethod(String.valueOf(place_id));
        getLocationMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getLocationMethod.callAPI();
        getLocationMethod.validateResponse();
        String rq = "{\"place_id\":\""+place_id+"\"}";
        DeleteLocationMethod deleteLocationMethod = new DeleteLocationMethod(rq);
        deleteLocationMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteLocationMethod.callAPI();
        deleteLocationMethod.validateResponse();

    }

    @Test
    public void putLocation () {
        PostLocationMethod postLocationMethod = new PostLocationMethod();
        postLocationMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postLocationMethod.callAPI().asString();
        String place_id = new JsonPath(rs).getString("place_id");
        postLocationMethod.validateResponse();

        String rq="{\"place_id\":\""+place_id+"\",\n" +
                "  \"address\":\"Gorkogo 26, UA\",\n" +
                "  \"key\":\"qaclick123\"\n" +
                "}";
        System.out.println("RQ IS :"+rq);
        PutLocationMethod putLocationMethod = new PutLocationMethod(rq);
        putLocationMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putLocationMethod.callAPI();
        putLocationMethod.validateResponse();

        String delete = "{\"place_id\":\""+place_id+"\"}";
        DeleteLocationMethod deleteLocationMethod = new DeleteLocationMethod(delete);
        deleteLocationMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteLocationMethod.callAPI();
        deleteLocationMethod.validateResponse();
    }


}
