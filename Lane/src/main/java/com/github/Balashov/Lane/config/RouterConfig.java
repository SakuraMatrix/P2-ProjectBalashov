//package com.github.Balashov.Lane.config;
//
//import com.github.Balashov.Lane.controller.ItemController;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//import static org.springframework.web.reactive.function.server.RequestPredicates.*;
//
//@Configuration
//public class RouterConfig {
//
//    @Bean
//    public RouterFunction<ServerResponse> itemRoutes(ItemController itemController) {
//        return route(GET("/items/byCategory/{category}"), itemController::findByCategory) //get items by category
//                .andRoute(GET("/items/byId/{id}"), itemController::findById) //get item by id
//                .andRoute(GET("/items/byName/{name}"), itemController::findByName) //get items by name
//                .andRoute(PUT("/items/update/{id}"), itemController::update) //update item
//                .andRoute(POST("/items/create"), itemController::save) //create new item
//                .andRoute(GET("items"), itemController::findAll); //get all items
//    }
//
//}
