package java.com.github.SakuraMatrix.webflux.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class ItemController {
  private ItemRepository itemRepo;

  public ItemController(ItemRepository itemRepo){
    this.itemRepo = itemRepo;
  }

  public Mono<ServerResponse> all(ServerRequest req){
    return ServerResponse.ok().body(this.itemRepo.findAll(), Item.Class);
  }

  public Mono<ServerResponse> get(ServerRequest req){
    return this.itemRepo.findById(id.fromString(req.pathVariable("id")))
    .flatMap(item -> ServerResponse.ok().body(Mono.just(item), Item.class))
    .switchIfEmpty(ServerResponse.notFound().build());
  }

  public Mono<ServerResponse> create(ServerRequest req){
    return req.bodyToMono(Item.class)
      .flatMap(item -> this.itemRepo.save(item))
      .flatMap(item -> ServerResponse.created(URI.create("/items/" + item.getId())).build());
  }
}
