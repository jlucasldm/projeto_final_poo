import java.util.ArrayList;

public class Usuario{
    private String nome;    //retorna
    private String id;  //retorna
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
    private ArrayList<Album> listaAlbuns = new ArrayList<Album>();
    private ArrayList<Artista> listaArtista = new ArrayList<Artista>();
    private ArrayList<Genero> listaGeneros = new ArrayList<Genero>();
    private ArrayList<Playlist> listaPlaylists = new ArrayList<Playlist>(); //retorna

    public Usuario(String nome, String id){
        this.nome = nome;
        this.id = id;
    }

    //gets e sets
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setListaMusicas(ArrayList<Musica> listaMusicas){
        this.listaMusicas = listaMusicas;
    }

    public ArrayList<Musica> getListaMusicas(){
        return this.listaMusicas;
    }

    public void setListaAlbuns(ArrayList<Album> listaAlbuns){
        this.listaAlbuns = listaAlbuns;
    }

    public ArrayList<Album> getListaAlbuns(){
        return this.listaAlbuns;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas){
        this.listaArtista = listaArtistas;
    }

    public ArrayList<Artista> getListaArtistas(){
        return this.listaArtista;
    }

    public void setListaGeneros(ArrayList<Genero> listaGeneros){
        this.listaGeneros = listaGeneros;
    }

    public ArrayList<Genero> getListaGeneros(){
        return this.listaGeneros;
    }

    public void setListaPlaylist(ArrayList<Playlist> listaPlaylists){
        this.listaPlaylists = listaPlaylists;
    }

    public ArrayList<Playlist> getListaPlaylists(){
        return this.listaPlaylists;
    }

    //metodos
    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
    }

    public void adicionarAlbum(Album album){
        this.listaAlbuns.add(album);
    }

    public void adicionarArtista(Artista artista){
        this.listaArtista.add(artista);
    }

    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
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

    public void criarPlaylist(String nome, String id){
        Playlist playlist = new Playlist(nome, id, this);
        this.listaPlaylists.add(playlist);
    }

    public boolean removerPlaylist(Playlist playlist){
        for(Playlist aux : this.listaPlaylists){
            if(playlist.getId().equals(aux.getId())){
                this.listaPlaylists.remove(playlist);
                return true;
            }
        }
        return false;
    }

    public boolean adicionarMusicaPlaylist(Playlist playlist, Musica musica){
        for(Playlist aux: this.listaPlaylists){
            if(playlist.getId().equals(aux.getId())){
                playlist.adicionarMusica(musica);
                return true;
            }
        }
        return false;
    }

    public boolean removerMusicaPlaylist(Playlist playlist, Musica musica){
        for(Playlist aux: this.listaPlaylists){
            if(playlist.getId().equals(aux.getId())){
                for(Musica mus : aux.getListaMusicas()){
                    if(mus.getId().equals(musica.getId())){
                        aux.getListaMusicas().remove(musica);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}