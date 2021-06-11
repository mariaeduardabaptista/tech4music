package br.com.tech4me.tech4music.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.Model.Musicas;
import br.com.tech4me.tech4music.Service.MusicasService;
import br.com.tech4me.tech4music.Shared.MusicasDTO;

@RestController
@RequestMapping("/api/musicas")

public class MusicasController {
    @Autowired

    private MusicasService service;

    @GetMapping
    public ResponseEntity<List<MusicasDTO>> obterMusicas(){
        return new ResponseEntity<>(service.obterTodos(),HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<MusicasDTO> obterPorId(@PathVariable String id){
        Optional<MusicasDTO> musica = service.obterPorId(id);

        if (musica.isPresent()){
            return new ResponseEntity<>(musica.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<MusicasDTO> criarMusica(@RequestBody Musicas musica){
        return new ResponseEntity<>(service.criarMusica(musica), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerMusica(@PathVariable String id){
        Optional<MusicasDTO> musica = service.obterPorId(id);
        if(musica.isPresent()){
            service.removerMusica(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PutMapping(value="/{id}")
    public ResponseEntity<MusicasDTO> atualizarMusica(@PathVariable String id, @RequestBody Musicas musicaNova){
        return new ResponseEntity<>( service.atualizarMusica(id, musicaNova),HttpStatus.OK);
    }
 
    
}



    

