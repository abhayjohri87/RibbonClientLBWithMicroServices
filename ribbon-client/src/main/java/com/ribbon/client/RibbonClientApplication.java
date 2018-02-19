package com.ribbon.client;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
//import com.ribbon.Employee.configuration.EmployeeConfiguration;
import com.ribbon.client.RibbonClientApplication.UserConfig;


@SpringBootApplication
@RestController
@RibbonClient(name = "employee-microservice", configuration = UserConfig.class)
public class RibbonClientApplication {

	  @LoadBalanced
	  @Bean
	  RestTemplate restTemplate(){
	    return new RestTemplate();
	  }

	  @Autowired
	  RestTemplate restTemplate;

	  @RequestMapping("/listEmployee")
	  public List getEmployeeList() {
	    List empList = this.restTemplate.getForObject("http://employee-microservice/employees", ArrayList.class);
	    return empList;
	  }

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
	
	
    @Configuration
    static class UserConfig {

        private String name = "employee-microservice";

        @Bean
        @ConditionalOnMissingBean
        public IClientConfig ribbonClientConfig() {
            DefaultClientConfigImpl config = new DefaultClientConfigImpl();
            config.loadProperties(this.name);
            return config;
        }

        @Bean
        ServerList<Server> ribbonServerList(IClientConfig config) {
            ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
            serverList.initWithNiwsConfig(config);
            return serverList;
        }

    }
}
