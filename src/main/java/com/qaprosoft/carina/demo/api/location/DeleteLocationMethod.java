package com.qaprosoft.carina.demo.api.location;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteLocationMethod extends AbstractApiMethodV2 {

    public DeleteLocationMethod (String placeId) {
        super(null, "api.location/_post/_delete/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
       request.body(placeId);
    }

}
