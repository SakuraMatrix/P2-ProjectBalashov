package java.com.github.SakuraMatrix.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.github.SakuraMatrix.webflux.controller.ItemController;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
  @Bean
  public RouterFunction<ServerResponse> routes(ItemController itemController) {
    return route(GET("/items"), itemController::all)
      .andRoute(POST("/items"), itemController::create)
      .andRoute(GET("/items/{id}"), itemController::get);
  }  
}
