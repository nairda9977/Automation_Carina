package com.qaprosoft.carina.demo.api.createUser;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetUserInfo extends AbstractApiMethodV2 {
    public GetUserInfo(){
        super(null,"api.gitHub/_get/rs.json",  new Properties());
        {
            replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_urlUser"));
        }
    }

}
