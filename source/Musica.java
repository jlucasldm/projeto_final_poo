import java.util.ArrayList;


public class Musica{
    private String nome;
    private static int controleId = 0;
    private int id;
    private float duracao;
    private Artista artista;    //pode ter mais de um artista
    private Album album;
    private ArrayList<Genero> listaGeneros = new ArrayList<Genero>();

    public Musica(String nome, float duracao, Artista artista, Album album){
        this.nome = nome;
        incrementarId();
        this.id = controleId;
        this.duracao = duracao;
        this.artista = artista;
        this.album = album;
    }

    public void incrementarId(){
        controleId++;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
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
        String generos = "";
        for(Genero aux : listaGeneros){
            generos += aux.retornaDados() + "\n";
        }
        return "Musica: " + this.nome + "\n" +
                "Id Musica: " + this.id + "\n" +
                generos + "\n" +
                "Duracao: " + this.duracao + "\n" +
                "Artista: " + this.artista.getNome() + "\n" +
                "Album: " + this.album.getNome();
    }

    public void adicionarMusicaPlaylist(Playlist playlist){
        playlist.adicionarMusica(this);
    }

    public void adicionarMusicaPlaylist(Playlist playlist, Musica musica){
        playlist.adicionarMusica(musica);
    }

    //pensar sobre metodo de reproducao
}
/*
Gênero como enum?


Áudio (abstract class) -> [nome, id, genero]
    Rádio (class) AOVIVO BATEPAPO -> [estação]
    Podcast (class) GRAVADO BATEPAPO -> [participantes(Usuarios)]
    Música (class) GRAVADO MELODIA -> []

    Gravado (abstract class) -> [aumentarVelocidade(), diminuirVelocidade(), reproduzir()] [duracao, artista,  album, genero]
    AoVivo (abstract class) -> [sintonizarProxima(), sintonizarAnterior()] [horarioInicio, participantes(Usuarios)]

    BatePapo (interface) -> [adicionarParticipantes(),  removerParticipantes()]
    Melodia (interface) -> [removerPlaylist(), adicionarPlaylist()]

Audio <- AoVivo <- BatePapo <- Rádio
Audio <- Gravado <- BatePapo <- Podcast
Audio <- Gravado <- Melodia <- Musica
*/