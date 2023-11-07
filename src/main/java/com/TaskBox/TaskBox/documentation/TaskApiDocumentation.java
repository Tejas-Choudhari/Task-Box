package com.TaskBox.TaskBox.documentation;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;


@OpenAPIDefinition(
        info = @Info(

                title = "Task Box API Documentations ",
                description = "Spring Boot Application for recording the Task Provided by Team Leader Jyoti Sir ",
                termsOfService = "T&C apply",
                contact = @Contact(name = "Tejas Choudhari",email = "tejaschoudhari3419@gmail.com"),
                version = "v1.0.0"
        )
)


@SecuritySchemes({
        @SecurityScheme(
                name = "APIKeyAuth",
                type = SecuritySchemeType.APIKEY,
                in = SecuritySchemeIn.HEADER,
                paramName = "API"
        )
})
public class TaskApiDocumentation {
}
