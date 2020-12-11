import java.util.ArrayList;

public class Artista extends Pessoa{
    private int id;
    protected ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>(); //usuarios que segem o artista

    public Artista(String nome){
        super(nome);
        incrementarId();
        this.id = controleId;
    }

    //gets e sets
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    //metodos
    public String retornaDados(){
        String usuarios = "";
        for(Usuario aux : listaUsuarios){
            usuarios += aux.retornaDados() + "||||||||||" + "\n";
        }
        return "Artista: " + this.nome + "\n" +
                "Id: " + this.id + "\n" +
                "||||||||||" + usuarios;
    }

    public Musica criarMusica(String nome, float duracao, Album album, ArrayList<Genero> listaGeneros){
        Musica novaMusica = new Musica(nome, duracao, this, album);
        novaMusica.setListaGeneros(listaGeneros);
        this.listaMusicas.add(novaMusica);
        return novaMusica;
    }

    public Album criarAlbum(String nome, ArrayList<Musica> listaMusicas){
        Album novoAlbum = new Album(nome, this);
        novoAlbum.setListaMusicas(listaMusicas);
        return novoAlbum;
    }
}