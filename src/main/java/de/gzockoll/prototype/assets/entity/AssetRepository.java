package de.gzockoll.prototype.assets.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface AssetRepository extends MongoRepository<Asset,String> {}
