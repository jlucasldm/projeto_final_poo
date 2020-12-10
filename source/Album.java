//playlist e album são coletaneas de musicas. é pertinente utilizar uma classe abstrata
import java.util.ArrayList;

public class Album extends Coletanea {
    private Artista autorAlbum;
    private int id;

    public Album(String nome, Artista autorAlbum){
        super(nome);
        this.autorAlbum = autorAlbum;
        this.listaArtistas.add(autorAlbum);
        incrementarId();
        this.id = controleId;
    }

    // gets e sets
    public Artista getAutorAlbum(){
        return this.autorAlbum;
    }

    public void setAutorAlbum(Artista autorAlbum){
        this.autorAlbum = autorAlbum;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    //metodos

    //ajeitar para a aplicacao depois
    public void adicionarAlbumPlaylist(Playlist playlist){
        for(Musica aux : this.listaMusicas){
            playlist.adicionarMusica(aux);
        }
    }

    public boolean adicionarAlbumPlaylist(Playlist playlist, Musica musica){
        for(Musica aux: this.listaMusicas){
            if(musica.getId() == aux.getId()){
                playlist.adicionarMusica(musica);
                return true;
            }
        }
        return false;
    }

    public String retornarDados(){
        String musicas = "";
        for(Musica aux : listaMusicas){
            musicas += aux.retornaDados() + "___________" + "\n";
        }
        return "Album: " + this.nome + "\n" +
                "Id: " + this.id + "\n" +
                "Duracao: " + this.duracao + "\n" +
                "Quantidade de faixas: " + this.qtdMusicas + "\n" +
                "___________" + musicas;
    }

    //falta implementar o meotodo de reprodução
}