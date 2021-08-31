package java.com.github.SakuraMatrix.webflux.config;

import com.datastax.oss.driver.api.core.CqlSession;
//import com.github.SakuraMatrix.webflux.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath: application.properties")
public class AppConfig {
  @Value("server.port")
  String port;
  // @Autowired
  // ItemService itemService;

  @Bean
  public HttpServer httpServer(ApplicationContext appCon) {
    HttpHandler http = WebHttpHandlerBuilder.applicationContext(appCon).build();
    ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(http);
    return HttpServer.create().port(3000).handle(adapter);
  }
}

// return HttpServer.create().port(Integer.parse(this.port)).handle(adapter);

