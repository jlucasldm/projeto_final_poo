import java.util.ArrayList;

public class Artista extends Usuario{
    private ArrayList<Musica> musicasProprias = new ArrayList<Musica>();
    private ArrayList<Album> albumsProprios = new ArrayList<Album>();

    public Artista(String nome){
        super(nome);
    }

    //gets e sets
    public ArrayList<Musica> getMusicasProprias() {
        return this.musicasProprias;
    }

    public void setMusicasProprias(ArrayList<Musica> musicasProprias) {
        this.musicasProprias = musicasProprias;
    }

    public ArrayList<Album> getAlbumsProprios() {
        return this.albumsProprios;
    }

    public void setAlbumsProprios(ArrayList<Album> albumsProprios) {
        this.albumsProprios = albumsProprios;
    }

    //metodos

    /*
    public Musica criarMusica(String nome, int duracao, Album album, ArrayList<Genero> listaGeneros){
        Musica novaMusica = new Musica(nome, duracao, this, album);
        novaMusica.setListaGeneros(listaGeneros);
        this.listaMusicas.add(novaMusica);
        this.musicasProprias.add(novaMusica);
        return novaMusica;
    }

    public Album criarAlbum(String nome, ArrayList<Musica> listaMusicas){
        Album novoAlbum = new Album(nome, this);
        novoAlbum.setListaMusicas(listaMusicas);
        this.listaAlbuns.add(novoAlbum);
        this.albumsProprios.add(novoAlbum);
        return novoAlbum;
    }

    public Album criarAlbum(String nome){
        Album novoAlbum = new Album(nome, this);
        this.listaAlbuns.add(novoAlbum);
        this.albumsProprios.add(novoAlbum);
        return novoAlbum;
    }
     */

    public Album adicionarMusicasAlbum(Album album, ArrayList<Musica> listaMusica){
        album.setListaMusicas(listaMusicas);
        for(Musica aux : listaMusica){
            this.listaMusicas.add(aux);
            this.musicasProprias.add(aux);
        }
        return album;
    }

    public Album adicionarMusicasAlbum(Album album, Musica musica){
        this.listaMusicas.add(musica);
        this.musicasProprias.add(musica);
        return album;
    }

    @Override
    public String retornaDados() {
        String albums = "Albums: \n";
        for(Album aux : this.albumsProprios){
            albums = albums + aux.getNome() + "\n";
        }
        String musicas = "Musicas: \n";
        for(Musica aux : this.musicasProprias){
            musicas = musicas + aux.getNome() + "\n";
        }

        return "Artista: " + this.getNome() + "\n" + "Id: " + this.getId() + "\n" + musicas + albums; //+ usuarios;
    }

}