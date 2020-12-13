import java.util.ArrayList;

public class Musica implements Audio {
    private String nome;
    private static int controleId = 0;
    private int id;
    private double duracao;
    private Artista artista;
    private Album album;
    private ArrayList<Genero> listaGeneros = new ArrayList<>();

    public Musica(String nome, double duracao, Artista artista, Album album){
        this.nome = nome;
        incrementarId();
        this.id = controleId;
        this.duracao = duracao;
        this.artista = artista;
        this.artista.getListaMusicas().add(this);
        this.album = album;
        this.album.getListaMusicas().add(this);
        this.album.setDuracao(this.album.getDuracao() + this.duracao);
        this.album.setQtdMusicas(this.album.getQtdMusicas() + 1);
    }

    public void setNome(String nome){
        if(!(nome instanceof String)){
            throw new IllegalArgumentException("APENAS STRINGS");
        }
        else {
            this.nome = nome;
        }
    }

    public String getNome(){
        return this.nome;
    }

    public static void setControleId(int id){
        if(!(Integer.class.isInstance(id))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            controleId = id;
        }
    }

    public static int getControleId(){
        return controleId;
    }

    public void setId(int id){
        if(!(Integer.class.isInstance(id))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            this.id = id;
        }
    }

    public int getId(){
        return this.id;
    }

    public void setDuracao(double duracao){
        if(!(double.class.isInstance(duracao))){
            throw new IllegalArgumentException("APENAS DOUBLE");
        }
        else {
            this.duracao = duracao;
        }
    }

    public double getDuracao(){
        return this.duracao;
    }

    public void setArtista(Artista artista){
        if(!(artista instanceof Artista)){
            throw new IllegalArgumentException("APENAS ARTISTA");
        }
        else {
            this.artista = artista;
        }
    }

    public Artista getArtista(){
        return this.artista;
    }

    public void setAlbum(Album album){
        if(!(album instanceof Album)){
            throw new IllegalArgumentException("APENAS ALBUM");
        }
        else {
            this.album = album;
        }
    }

    public Album getAlbum(){
        return this.album;
    }

    public void setListaGeneros(ArrayList<Genero> listaGeneros){
        if(!(listaGeneros instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<GENERO>");
        }
        else {
            this.listaGeneros = listaGeneros;
        }
    }

    public ArrayList<Genero> getListaGeneros(){
        return this.listaGeneros;
    }

    //metodos
    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void aumentarVelocidade(){
        this.duracao = this.duracao * (1.25);
    };

    public void diminuirVelocidade(){
        this.duracao = this.duracao * (0.75);
    }

    public String retornaDados(){
        String generos = "";
        if(!this.listaGeneros.isEmpty()){
            for (Genero aux : this.listaGeneros) {
                generos += aux.retornaDados() + "\n";
            }
        }
        return "Musica: " + this.nome + "\n" +
                "Id Musica: " + this.id + "\n" +
                generos + "\n" +
                "Duracao: " + this.duracao + "\n" +
                "Artista: " + this.artista.getNome() + "\n" +
                "Album: " + this.album.getNome();
    }

    /*
    //Isso nao precisa existir
    public void adicionarMusicaPlaylist(Playlist playlist){
        playlist.adicionarMusica(this);
    }

    //nem isso
    public void adicionarMusicaPlaylist(Playlist playlist, Musica musica){
        playlist.adicionarMusica(musica);
    }
     */

    public static void incrementarId(){
        controleId++;
    }

}
