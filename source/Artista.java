import java.util.ArrayList;

public class Artista extends Usuario{
    private ArrayList<Musica> musicasProprias = new ArrayList<Musica>();
    private ArrayList<Album> albumsProprios = new ArrayList<Album>();

    public Artista(String nome){
        super(nome);
    }

    //Gets e Sets
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

    //Métodos
    /*
    O método retornaDados() retorna não apenas os dados da instância Artista como também retorna o atributo "nome" das
    instâncias Músicas e Álbuns inseridas em seus arrayLists.
     */
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