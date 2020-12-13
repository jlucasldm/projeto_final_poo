import java.util.ArrayList;

public class Genero{
    private EnumGenero enumGenero;
    private ArrayList<Album> listaAlbuns = new ArrayList<Album>();
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
    private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();

    public Genero(EnumGenero enumGenero){
        this.enumGenero = enumGenero;
    }

    //gets e sets
    public EnumGenero getEnumGenero() {
        return this.enumGenero;
    }

    public void setEnumGenero(EnumGenero enumGenero) {
        if(!(enumGenero instanceof EnumGenero)){
            throw new IllegalArgumentException("APENAS ENUMGENERO");
        }
        else {
            this.enumGenero = enumGenero;
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

    public ArrayList<Artista> getListaArtistas() {
        return this.listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        if(!(listaArtistas instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<ARTISTA>");
        }
        else {
            this.listaArtistas = listaArtistas;
        }
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

}