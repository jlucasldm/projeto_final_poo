//playlist e album são coletaneas de musicas. é pertinente utilizar uma classe abstrata
import java.util.ArrayList;

public class Album{
    private String nome; //retorna
    private String id;  //retorna
    private float duracao;  //é eum função da quantidade da duração de cada musica (isso ainda nao foi implementado)
    private int qtdMusicas; //é eum função da quantidade de elementos da lista de musicas
    //atributo estatico sinalizando a reproducao de musica
    private ArrayList<Genero> listaGeneros = new ArrayList<Genero>();   //retorna
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();   //retorna
    private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();    //retorna

    public Album(String nome, String id){
        this.nome = nome;
        this.id = id;
        if(listaMusicas.size()==0){
            this.duracao = 0;
        }else{
            this.duracao = 0;
            for(Musica aux : listaMusicas){
                this.duracao += aux.getDuracao();
            }
        }
        this.qtdMusicas = listaMusicas.size();
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

    public void setDuracao(float duracao){
        this.duracao = duracao;
    }

    public float getDuracao(){
        return this.duracao;
    }

    public void setQtdMusicas(int qtdMusicas){
        this.qtdMusicas = qtdMusicas;
    }

    public float getQtdMusicas(){
        return this.qtdMusicas;
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

    public void setListaArtistas(ArrayList<Artista> listaArtistas){
        this.listaArtistas = listaArtistas;
    }

    public ArrayList<Artista> getListaArtistas(){
        return this.listaArtistas;
    }

    //metodos
    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
    }

    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void adicionarArtista(Artista artista){
        this.listaArtistas.add(artista);
    }

    //ajeitar para a aplicacao depois
    public void adicionarMusicaPlaylist(Playlist playlist){
        for(Musica aux : this.listaMusicas){
            playlist.adicionarMusica(aux);
        }
    }

    public boolean adicionarMusicaPlaylist(Playlist playlist, Musica musica){
        for(Musica aux: this.listaMusicas){
            if(musica.getId().equals(aux.getId())){
                playlist.adicionarMusica(musica);
                return true;
            }
        }
        return false;
    }

    public String returnaDados(){
        String musicas = "";
        for(Musica aux : listaMusicas){
            musicas += aux.retornaDados() + "___________" + "\n";
        }
        return "Album: " + this.nome + "\n" + 
                "Id: " + this.id + "\n" + 
                "Duracao: " + this.duracao + "\n" + 
                "Quantidade de faixas: " + this.qtdMusicas + "\n" +
                "___________" + musicas;
    }

    //falta implementar o meotodo de reprodução
}