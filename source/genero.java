import java.util.ArrayList;

public class Genero{
    private String nome;
    private String id;
    private ArrayList<Album> listaAlbuns = new ArrayList<Album>();
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
    private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();

    public Genero(String nome, String id){
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

    public void setListaAlbuns(ArrayList<Album> listaAlbuns){
        this.listaAlbuns = listaAlbuns;
    }

    public ArrayList<Album> getListaAlbuns(){
        return this.listaAlbuns;
    }

    public void setListaMusicas(ArrayList<Musica> listaMusicas){
        this.listaMusicas = listaMusicas;
    }

    public ArrayList<Musica> getListaMusicas(){
        return this.listaMusicas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas){
        this.listaArtistas = listaArtistas;
    }

    public ArrayList<Artista> getListaArtistas(){
        return this.listaArtistas;
    }

    //metodos
    public void adicionarAlbum(Album album){
        this.listaAlbuns.add(album);
    }

    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
    }

    public void adicionarArtista(Artista artista){
        this.listaArtistas.add(artista);
    }

    public String retornaDados(){
        return "Genero: " + this.nome + "\n" + 
                "Id Genero: " + this.id;
    }
    
}