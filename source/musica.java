import java.util.ArrayList;

public class Musica{
    private String nome;
    private String id;
    private float duracao;
    private Artista artista;    //pode ter mais de um artista
    private Album album;
    private ArrayList<Genero> listaGeneros = new ArrayList<Genero>();

    public Musica(String nome, String id, float duracao, Artista artista, Album album){
        this.nome = nome;
        this.id = id;
        this.duracao = duracao;
        this.artista = artista;
        this.album = album;
    }

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

    public void setDuracao(float duracao){
        this.duracao = duracao;
    }

    public float getDuracao(){
        return this.duracao;
    }

    public void setArtista(Artista artista){
        this.artista = artista;
    }

    public Artista getArtista(){
        return this.artista;
    }

    public void setAlbum(Album album){
        this.album = album;
    }

    public Album getAlbum(){
        return this.album;
    }

    public void setListaGeneros(ArrayList<Genero> listaGeneros){
        this.listaGeneros = listaGeneros;
    }

    public ArrayList<Genero> getListaGeneros(){
        return this.listaGeneros;
    }

    //metodos
    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public String retornaDados(){
        return "Musica: " + this.nome + "\n" + 
                "Id: " this.id + "\n" + 
                "Duracao: " + this.duracao + "\n" + 
                "Artista: " + this.artista.getNome() + "\n" +
                "Album: " + this.album.getNome();
    }

    /*
    String nome;
    private String id;
    private float duracao;
    private Artista artista;
    private Album album;
     */
}