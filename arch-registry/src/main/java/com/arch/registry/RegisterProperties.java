package com.arch.registry;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
@ConditionalOnProperty(prefix = "arch.register.security", name = "enable", havingValue = "true")
@ConfigurationProperties(prefix = "arch.register")
public class RegisterProperties {

    private Security security = new Security();

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    /**
     * 访问认证
     */
    static class Security{
        /**
         * 是否启用
         */
        private Boolean enable = false;

        /**
         * 账号密码角色
         */
        @NestedConfigurationProperty
        private SecurityProperties.User user = new SecurityProperties.User();

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public SecurityProperties.User getUser() {
            return user;
        }

        public void setUser(SecurityProperties.User user) {
            this.user = user;
        }
    }
}
