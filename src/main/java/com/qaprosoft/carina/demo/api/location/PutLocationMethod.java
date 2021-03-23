package com.qaprosoft.carina.demo.api.location;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutLocationMethod extends AbstractApiMethodV2 {

    public PutLocationMethod (String place_id) {
        super(null, "api.location/_post/_put/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
       request.body( place_id);

    }

}
