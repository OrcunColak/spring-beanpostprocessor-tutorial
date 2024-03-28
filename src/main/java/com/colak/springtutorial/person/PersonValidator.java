package com.colak.springtutorial.person;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        // ValidationUtils utility class offering convenient methods for invoking a Validator and for rejecting empty fields.
        // Check if the 'name' field is empty
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");

        // Cast the target object to Person class
        Person p = (Person) target;

        // Validate age field
        if (p.getAge() < 0) {
            // If age is negative, reject the value with a specific error code
            errors.rejectValue("age", "negative age value");
        } else if (p.getAge() > 110) {
            // If age is greater than 110, reject the value with a specific error code
            errors.rejectValue("age", "too.darn.old");
        }
    }
}
