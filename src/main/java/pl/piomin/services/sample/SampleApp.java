package pl.piomin.services.sample;

import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.openshift.annotation.OpenshiftApplication;
import io.dekorate.option.annotation.JvmOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@SpringBootApplication
@OpenshiftApplication(replicas = 2, expose = true, envVars = {
        /*@Env(name="sample-app-config", configmap = "sample-app-config")*/
})
@JvmOptions( heapDumpOnOutOfMemoryError = true)
@EnableSwagger2
public class SampleApp {

    public static void main(String[] args) {
        SpringApplication.run(SampleApp.class, args);
    }

    @Autowired
    Optional<BuildProperties> buildProperties;
    @Autowired
    Optional<GitProperties> gitProperties;

    @Bean
    public Docket api() {
        String version = "1.0";
        if (buildProperties.isPresent() && gitProperties.isPresent()) {
            BuildProperties buildInfo = buildProperties.get();
            GitProperties gitInfo = gitProperties.get();
            version = buildInfo.getVersion() + "-" + gitInfo.getShortCommitId() + "-" + gitInfo.getBranch();
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.piomin.services.sample"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version(version).title("Person API").description("Documentation Person API v1.0").build());
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(java.lang.Boolean.TRUE, java.lang.Boolean.FALSE, 1, 1, ModelRendering.MODEL, java.lang.Boolean.FALSE, DocExpansion.LIST, java.lang.Boolean.FALSE, null, OperationsSorter.ALPHA, java.lang.Boolean.FALSE, TagsSorter.ALPHA, UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, null);
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
                .title("API - Person Service")
                .description("Persons Management")
                .version(version)
                .build();
    }

}
