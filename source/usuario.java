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

    public void getId(){
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
        this.listaArtistas = listaArtistas;
    }

    public ArrayList<Artista> getListaArtistas(){
        return this.listaArtistas;
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
        this.listaArtistas.add(artista);
    }

    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void adicionarPlaylist(Playlist playlist){
        this.listaPlaylists.add(playlist);
    }
}