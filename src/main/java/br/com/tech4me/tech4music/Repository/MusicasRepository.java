package br.com.tech4me.tech4music.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4music.Model.Musicas;

public interface MusicasRepository extends MongoRepository<Musicas,String> {
    
}
