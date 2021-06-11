package br.com.tech4me.tech4music.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.Model.Musicas;
import br.com.tech4me.tech4music.Repository.MusicasRepository;
import br.com.tech4me.tech4music.Shared.MusicasDTO;

@Service
public class MusicasServiceImpl implements MusicasService{
    @Autowired
    private MusicasRepository repositorio;

    @Override
    public MusicasDTO criarMusica(Musicas musica) {
       repositorio.save(musica);

        return new ModelMapper().map(musica, MusicasDTO.class);

    }

    @Override
    public List<MusicasDTO> obterTodos() {
        List<Musicas> musica = repositorio.findAll();

        return musica.stream()
        .map(p -> new ModelMapper().map(p,MusicasDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<MusicasDTO> obterPorId(String id) {
        Optional<Musicas> musica = repositorio.findById(id);

        if(musica.isPresent()){
            return Optional.of(new ModelMapper().map(musica.get(),MusicasDTO.class));
        }
        return Optional.empty();
    }

	@Override
	public void removerMusica(String id) {
		repositorio.deleteById(id);
		
	}

    @Override
    public MusicasDTO atualizarMusica(String id, Musicas musicaNova) {
        musicaNova.setId(id);
        repositorio.save(musicaNova);
        return new ModelMapper().map(musicaNova,MusicasDTO.class);
    }

   
}

