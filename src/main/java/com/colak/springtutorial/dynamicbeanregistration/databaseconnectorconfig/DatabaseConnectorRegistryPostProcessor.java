package com.colak.springtutorial.dynamicbeanregistration.databaseconnectorconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * Register beans defined in the application.yaml
 */
public class DatabaseConnectorRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    private List<DatabaseConnector> connectors;

    public DatabaseConnectorRegistryPostProcessor(Environment environment) {
        Binder binder = Binder.get(environment);
        connectors = binder.bind("database.connectors", Bindable.listOf(DatabaseConnector.class)).get();
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        connectors.forEach(connector -> {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(DatabaseConnector.class);
            builder.addPropertyValue("type", connector.getType());
            builder.addPropertyValue("connectionString", connector.getConnectionString());
            registry.registerBeanDefinition("dbConnector_" + connector.getType(), builder.getBeanDefinition());
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // Not required for this example
    }
}
