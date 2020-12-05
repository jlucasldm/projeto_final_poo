import java.util.ArrayList;

public class Artista{
    private String nome;    //retorna
    private String id;  //retorna
    private ArrayList<Genero> listaGeneros = new ArrayList<Genero>();   //retorna
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
    private ArrayList<Album> listaAlbuns = new ArrayList<Album>();  //retorna
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>(); //usuarios que segem o artista

    public Artista(String nome, String id){
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

    public void setListaGeneros(ArrayList<Genero> listaGeneros){
        this.listaGeneros = listaGeneros;
    }

    public ArrayList<Genero> getListaGeneros(){
        return this.listaGeneros;
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

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Usuario> getListaUsuarios(){
        return this.listaUsuarios;
    }

    //metodos
    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
    }

    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void adicionarAlbum(Album album){
        this.listaAlbuns.add(album);
    }

    public void adicionarUsuario(Usuario usuario){
        this.listaUsuarios.add(usuario);
    }

    public String retornaDados(){
        String musicas = "";
        for(Musica aux : listaMusicas){
            musicas += aux.retornaDados() + "___________" + "\n";
        }
        return "Artista: " + this.nome + "\n" + 
                "Id: " + this.id + "\n" +
                "___________" + musicas;
    }

}