import java.util.ArrayList;

public class Usuario extends Pessoa{
    private String nome;
    private int id;
    private ArrayList<Artista> listaArtista = new ArrayList<Artista>();
    private ArrayList<Playlist> listaPlaylists = new ArrayList<Playlist>();

    public Usuario(String nome){
        super(nome);
        this.id = controleId;
    }

    //gets e sets
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Artista> getListaArtista() {
        return this.listaArtista;
    }

    public void setListaArtista(ArrayList<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public ArrayList<Playlist> getListaPlaylists() {
        return this.listaPlaylists;
    }

    public void setListaPlaylists(ArrayList<Playlist> listaPlaylists) {
        this.listaPlaylists = listaPlaylists;
    }

    //metodos
    public void seguirArtista(Artista artista){
        artista.getListaUsuarios().add(this);
        this.listaArtista.add(artista);
    }

    public void adicionarPlaylist(Playlist playlist){
        this.listaPlaylists.add(playlist);
    }

    public String retornaDados(){
        String playlists = "";
        for(Playlist aux : listaPlaylists){
            playlists += aux.retornarDados() + "//////////" + "\n";
        }
        return "Usuario: " + this.nome + "\n" +
                "Id Usuario: " + this.id + "\n" +
                "//////////" + playlists;
    }

    public void criarPlaylist(String nome){
        Playlist playlist = new Playlist(nome,  this);
        this.listaPlaylists.add(playlist);
    }

    public boolean removerPlaylist(Playlist playlist){
        for(Playlist aux : this.listaPlaylists){
            if(playlist.getId() == aux.getId()){
                this.listaPlaylists.remove(playlist);
                return true;
            }
        }
        return false;
    }

    public boolean adicionarMusicaPlaylist(Playlist playlist, Musica musica){
        for(Playlist aux: this.listaPlaylists){
            if(playlist.getId() == aux.getId()){
                playlist.adicionarMusica(musica);
                return true;
            }
        }
        return false;
    }

    public boolean removerMusicaPlaylist(Playlist playlist, Musica musica){
        for(Playlist aux: this.listaPlaylists){
            if(playlist.getId() == aux.getId()){
                for(Musica mus : aux.getListaMusicas()){
                    if(mus.getId() == musica.getId()){
                        aux.getListaMusicas().remove(musica);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}