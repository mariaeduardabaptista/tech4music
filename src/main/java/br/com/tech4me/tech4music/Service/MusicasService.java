package br.com.tech4me.tech4music.Service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4music.Model.Musicas;
import br.com.tech4me.tech4music.Shared.MusicasDTO;

public interface MusicasService {

    MusicasDTO criarMusica(Musicas musica);
    List<MusicasDTO> obterTodos();
    Optional<MusicasDTO> obterPorId(String id);
    void removerMusica(String id);
    MusicasDTO atualizarMusica(String id,Musicas musicaNova);
    
}
