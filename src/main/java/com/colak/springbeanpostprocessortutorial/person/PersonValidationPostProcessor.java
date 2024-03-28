package com.colak.springbeanpostprocessortutorial.person;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class PersonValidationPostProcessor implements BeanPostProcessor {

    private final PersonValidator personValidator;

    // This method is called before the initialization of a bean
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // No action needed before initialization, so return the bean as is.
        return bean;
    }

    // This method is called after the initialization of a bean
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Check if the bean is an instance of the Person class
        if (bean instanceof Person) {
            // Create a new Errors object to hold validation errors for the bean
            Errors errors = new BeanPropertyBindingResult(bean, beanName);
            // Perform validation on the Person bean using the PersonValidator
            personValidator.validate(bean, errors);
            // If validation errors are found
            if (errors.hasErrors()) {
                // Throw a RuntimeException with a message containing all validation errors
                throw new RuntimeException("Validation error occurred: " + errors.getAllErrors());
            }
        }
        // Return the validated bean
        return bean;
    }
}
