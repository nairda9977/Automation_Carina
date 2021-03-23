package com.qaprosoft.carina.demo.api.location;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostLocationMethod extends AbstractApiMethodV2 {

    public  PostLocationMethod (){
        super("api.location/_post/rq.json","api.location/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));

    }
}
