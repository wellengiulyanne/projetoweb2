package br.ueg.trindade.projetoweb2ueg_projeto_fullstack.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Perfil;
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }

    public Perfil buscarPorId(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    }

    public Perfil criar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public Perfil atualizar(Long id, Perfil perfilAtualizado) {

        Perfil perfil = buscarPorId(id);

        perfil.setNome(perfilAtualizado.getNome());

        return perfilRepository.save(perfil);
    }

    public void excluir(Long id) {
        perfilRepository.deleteById(id);
    }
}