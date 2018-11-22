package demo.kotlin.repository;

import demo.kotlin.model.Cow;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface CowRepository extends ReactiveMongoRepository<Cow, UUID> {
    Mono<Cow> findByName(String name);
}