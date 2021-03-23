package com.qaprosoft.carina.demo.albums;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.albums.GetAlbumMethod;
import com.qaprosoft.carina.demo.api.albums.PostAlbumMethod;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class AlbumsApiTest extends AbstractTest {

    @Test
    public void createAlbumTest () {
        PostAlbumMethod postAlbumMethod = new PostAlbumMethod();
        postAlbumMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String rs = postAlbumMethod.callAPI().asString();
        postAlbumMethod.validateResponse();
        int userId = new JsonPath(rs).getInt("userId");
        GetAlbumMethod getAlbumMethod = new GetAlbumMethod(String.valueOf(userId));
        getAlbumMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAlbumMethod.callAPI();

    }
}
