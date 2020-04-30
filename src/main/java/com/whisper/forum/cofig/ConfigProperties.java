package com.whisper.forum.cofig;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.config")
public class ConfigProperties {
    private String name="root";
    private String password="password";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConfigProperties{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
