@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .info(new Info().title("Stock API").version("1.0"))
            .servers(List.of(new Server().url("https://9147.32procr.amypo.ai/")))
            // FIX: Use addSecurityItem instead of addSecurityRequirement
            .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
            .components(new Components()
                    .addSecuritySchemes("Bearer Authentication", new SecurityScheme()
                            .name("Bearer Authentication")
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")));
}