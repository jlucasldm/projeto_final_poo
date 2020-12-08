import java.util.ArrayList;

public class Playlist extends Coletanea {
    private Usuario autor;  //retorna

    public Playlist(String nome, String id, Usuario autor){
        super(nome, id);
        this.autor = autor;
    }

    //metodos
    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
    }

    public void adicionarArtista(Artista artista){
        this.listaArtistas.add(artista);
    }

    public String retornarDados(){
        String musicas = "";
        for(Musica aux : listaMusicas){
            musicas += aux.retornaDados() + "___________" + "\n";
        }
        return "Playlist: " + this.nome + "\n" +
                "Id: " + this.id + "\n" +
                "Quantidade de faixas: " + this.qtdMusicas + "\n" +
                "Duracao: " + this.duracao + "\n" +
                "Autor: " + this.autor.getNome() + "\n" +
                "___________" + musicas;
    }

    //pensar metodo de reproducao
    public boolean removerMusica(Musica musica){
        for(Musica aux: this.listaMusicas){
            if(musica.getId().equals(aux.getId())){
                this.listaMusicas.remove(musica);
                return true;
            }
        }
        return false;
    }
}