package com.millinch.springboot.autoconfigure.druid;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * See more: https://github.com/alibaba/druid/wiki
 *
 * @author John Zhang
 */
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDatasourceProperties {

    private Map<String, String> properties;

    private StatServlet statServlet = new StatServlet();

    private StatFilter statFilter = new StatFilter();

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public StatServlet getStatServlet() {
        return statServlet;
    }

    public void setStatServlet(StatServlet statServlet) {
        this.statServlet = statServlet;
    }

    public StatFilter getStatFilter() {
        return statFilter;
    }

    public void setStatFilter(StatFilter statFilter) {
        this.statFilter = statFilter;
    }

    public static class StatServlet {

        private String urlMapping = "/druid/*";

        private String allow;

        private String deny;

        private String loginUsername = "admin";

        private String loginPassword = "admin";

        private String resetEnable = "false";

        public String getUrlMapping() {
            return urlMapping;
        }

        public void setUrlMapping(String urlMapping) {
            this.urlMapping = urlMapping;
        }

        public String getAllow() {
            return allow;
        }

        public void setAllow(String allow) {
            this.allow = allow;
        }

        public String getDeny() {
            return deny;
        }

        public void setDeny(String deny) {
            this.deny = deny;
        }

        public String getLoginUsername() {
            return loginUsername;
        }

        public void setLoginUsername(String loginUsername) {
            this.loginUsername = loginUsername;
        }

        public String getLoginPassword() {
            return loginPassword;
        }

        public void setLoginPassword(String loginPassword) {
            this.loginPassword = loginPassword;
        }

        public String getResetEnable() {
            return resetEnable;
        }

        public void setResetEnable(String resetEnable) {
            this.resetEnable = resetEnable;
        }
    }

    public static class StatFilter {

        private String urlPattern = "/*";
        private String profileEnable;
        private String sessionStatEnable;
        private String sessionStatMaxCount;
        private String exclusions = "*.js,*.gif,*.jpg,*.png,*.css,*.ico";
        private String principalSessionName;
        private String principalCookieName;
        private String realIpHeader;

        public String getUrlPattern() {
            return urlPattern;
        }

        public void setUrlPattern(String urlPattern) {
            this.urlPattern = urlPattern;
        }

        public String getProfileEnable() {
            return profileEnable;
        }

        public void setProfileEnable(String profileEnable) {
            this.profileEnable = profileEnable;
        }

        public String getSessionStatEnable() {
            return sessionStatEnable;
        }

        public void setSessionStatEnable(String sessionStatEnable) {
            this.sessionStatEnable = sessionStatEnable;
        }

        public String getSessionStatMaxCount() {
            return sessionStatMaxCount;
        }

        public void setSessionStatMaxCount(String sessionStatMaxCount) {
            this.sessionStatMaxCount = sessionStatMaxCount;
        }

        public String getExclusions() {
            return exclusions;
        }

        public void setExclusions(String exclusions) {
            this.exclusions = exclusions;
        }

        public String getPrincipalSessionName() {
            return principalSessionName;
        }

        public void setPrincipalSessionName(String principalSessionName) {
            this.principalSessionName = principalSessionName;
        }

        public String getPrincipalCookieName() {
            return principalCookieName;
        }

        public void setPrincipalCookieName(String principalCookieName) {
            this.principalCookieName = principalCookieName;
        }

        public String getRealIpHeader() {
            return realIpHeader;
        }

        public void setRealIpHeader(String realIpHeader) {
            this.realIpHeader = realIpHeader;
        }
    }
}
