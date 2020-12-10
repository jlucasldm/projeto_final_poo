import java.util.ArrayList;

public class Genero{
<<<<<<< HEAD
    private String nome;
    protected static int controleId = 0;
    private int id;
=======
    private EnumGenero enumGenero;
>>>>>>> 9022159f1d8bc684423dd0d664bbbc5364914da8
    private ArrayList<Album> listaAlbuns = new ArrayList<Album>();
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
    private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();

<<<<<<< HEAD
    public Genero(String nome){
        this.nome = nome;
        this.incrementarId()
        this.id = controleId;
=======
    public Genero(EnumGenero enumGenero){
        this.enumGenero = enumGenero;
>>>>>>> 9022159f1d8bc684423dd0d664bbbc5364914da8
    }

    //gets e sets
    public EnumGenero getEnumGenero() {
        return this.enumGenero;
    }

    public void setEnumGenero(EnumGenero enumGenero) {
        this.enumGenero = enumGenero;
    }

<<<<<<< HEAD
    public static void setControleId(int id){
        controleId = id;
    }

    public static int getControleId(){
        return controleId;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
=======
    public ArrayList<Album> getListaAlbuns() {
        return this.listaAlbuns;
>>>>>>> 9022159f1d8bc684423dd0d664bbbc5364914da8
    }

    public void setListaAlbuns(ArrayList<Album> listaAlbuns) {
        this.listaAlbuns = listaAlbuns;
    }

    public ArrayList<Musica> getListaMusicas() {
        return this.listaMusicas;
    }

    public void setListaMusicas(ArrayList<Musica> listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public ArrayList<Artista> getListaArtistas() {
        return this.listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
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
        return "Genero: " + this.enumGenero.toString();
    }

<<<<<<< HEAD
    public void incrementarId(){
        controleId++;
    }
    
=======
>>>>>>> 9022159f1d8bc684423dd0d664bbbc5364914da8
}