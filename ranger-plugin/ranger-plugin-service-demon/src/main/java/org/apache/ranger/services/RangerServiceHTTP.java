package org.apache.ranger.services;

import org.apache.log4j.Logger;
import org.apache.ranger.plugin.service.RangerBaseService;
import org.apache.ranger.plugin.service.ResourceLookupContext;

import java.util.*;

/**
 * @author created by guanchen on 2020/8/13 16:36
 */
public class RangerServiceHTTP extends RangerBaseService {
    private static final Logger LOG = Logger.getLogger(RangerServiceHTTP.class);


    @Override
    public Map<String, Object> validateConfig() throws Exception {
        LOG.info("====  ==== ==== ====RangerServiceHTTP.validateConfig() services_list_url: " + configs.get("services_list_url"));

        Map<String, Object> ret = new HashMap<String, Object>();

        ret.put("connectivityStatus", true);
        ret.put("message", "ConnectionTest Successful.");
        ret.put("description", "ConnectionTest Successful.");
        ret.put("objectId", null);
        ret.put("fieldName", null);
        return ret;
    }

    @Override
    public List<String> lookupResource(ResourceLookupContext resourceLookupContext) throws Exception {
        LOG.info("====  ==== ==== ==== RangerServiceHTTP.lookupResource ");
        String serviceName = getServiceName();
        Map<String,String> configs = getConfigs();
        LOG.info(String.format("serviceName: %s look up resource"));
        configs.forEach((k,v) -> {
            LOG.info(k + "," + v);
        });

        //TODO: request ES to get all index name
        return Arrays.asList("a","b","d");
    }
}
