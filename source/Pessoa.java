import java.util.ArrayList;

public abstract class Pessoa {
    protected String nome;
    protected static int controleId = 0;
    protected ArrayList<Genero> listaGeneros = new ArrayList<>();
    protected ArrayList<Musica> listaMusicas = new ArrayList<>();
    protected ArrayList<Album> listaAlbuns = new ArrayList<>();

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public static void incrementarId(){
        controleId++;
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

    public ArrayList<Genero> getListaGeneros() {
        return this.listaGeneros;
    }

    public void setListaGeneros(ArrayList<Genero> listaGeneros) {
        if(!(listaGeneros instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<GENERO>");
        }
        else {
            this.listaGeneros = listaGeneros;
        }
    }

    public ArrayList<Musica> getListaMusicas() {
        return this.listaMusicas;
    }

    public void setListaMusicas(ArrayList<Musica> listaMusicas) {
        if(!(listaMusicas instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<MUSICA>");
        }
        else {
            this.listaMusicas = listaMusicas;
        }
    }

    public ArrayList<Album> getListaAlbuns() {
        return this.listaAlbuns;
    }

    public void setListaAlbuns(ArrayList<Album> listaAlbuns) {
        if(!(listaAlbuns instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<ALBUM>");
        }
        else {
            this.listaAlbuns = listaAlbuns;
        }
    }

    //metodos
    /*
    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
    }

    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void adicionarAlbum(Album album){
        this.listaAlbuns.add(album);
    }
     */

}
