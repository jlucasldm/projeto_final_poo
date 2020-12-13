import java.util.ArrayList;

public class Usuario extends Pessoa{
    private int id;
    private ArrayList<Artista> listaArtista = new ArrayList<Artista>();
    private ArrayList<Playlist> listaPlaylists = new ArrayList<Playlist>();

    public Usuario(String nome){
        super(nome);
        incrementarId();
        this.id = controleId;
    }

    //gets e sets
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(!(nome instanceof String)){
            throw new IllegalArgumentException("APENAS STRINGS");
        }
        else {
            this.nome = nome;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if(!(Integer.class.isInstance(id))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            this.id = id;
        }
    }

    public ArrayList<Artista> getListaArtista() {
        return this.listaArtista;
    }

    public void setListaArtista(ArrayList<Artista> listaArtista) {
        if(!(listaArtista instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<ARTISTA>");
        }
        else {
            this.listaArtista = listaArtista;
        }
    }

    public ArrayList<Playlist> getListaPlaylists() {
        return this.listaPlaylists;
    }

    public void setListaPlaylists(ArrayList<Playlist> listaPlaylists) {
        if(!(listaPlaylists instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<PLAYLIST>");
        }
        else {
            this.listaPlaylists = listaPlaylists;
        }
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
        if(!this.listaPlaylists.isEmpty()){
            for (Playlist aux : this.listaPlaylists) {
                playlists += aux.retornaDados() + "//////////" + "\n";
            }
        }
        return "Usuario: " + this.getNome() + "\n" +
                "Id Usuario: " + this.getId() + "\n" + 
                playlists;
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