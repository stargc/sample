package com.ehualu.data.business.test.auth;

import lombok.val;
import org.apache.ranger.plugin.audit.RangerDefaultAuditHandler;
import org.apache.ranger.plugin.policyengine.RangerAccessRequestImpl;
import org.apache.ranger.plugin.policyengine.RangerAccessResourceImpl;
import org.apache.ranger.plugin.service.RangerBasePlugin;

/**
 * @author created by guanchen on 2020/8/13 16:29
 */
public class RangerTestAuthorizer {

    private RangerBasePlugin plugin;

    public RangerTestAuthorizer() {
        if (plugin == null) {
            plugin = new RangerBasePlugin("httpservice", "httpservice");
            plugin.setResultProcessor(new RangerDefaultAuditHandler());
            plugin.init();
        }
    }

    public boolean checkPermission(String path,String accessType,String username){
        RangerAccessResourceImpl resource = new RangerAccessResourceImpl();
        resource.setValue("path", path);
        val request = new RangerAccessRequestImpl(resource, accessType, username, null);
        val result = plugin.isAccessAllowed(request);
        return  result != null && result.getIsAllowed();
    }

}
