import java.util.ArrayList;

public class Playlist{
    private String nome;
    private String id;
    private int qtdMusica;
    private float duracao;
    private Usuario autor;

    private ArrayList<Genero> listaGeneros = new ArrayList<Genero>();
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
    private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();

}