# BeanPostProcessor

BeanPostProcessor provides hooks or callback methods that are called before and after the initialization of a bean.

The original idea is from  
https://medium.com/@yaroslavprozorov213/adding-validation-logic-to-spring-context-a-step-by-step-guide-15e378c33ae8

# BeanDefinitionRegistryPostProcessor - Dynamic Bean Registration

BeanDefinitionRegistryPostProcessor allows for custom modification or registration of bean definitions before the Spring
application context is fully initialized.
This is useful for scenarios where you need to dynamically register or modify bean definitions based on certain
conditions.

The original idea is from
https://medium.com/@pratiyush1/dynamic-bean-registration-in-spring-based-on-properties-a3f504ad4f04