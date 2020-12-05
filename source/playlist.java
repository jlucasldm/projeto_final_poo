//playlist e album são coletaneas de musicas. é pertinente utilizar uma classe abstrata
import java.util.ArrayList;

public class Playlist{
    private String nome;    //retorna
    private String id;  //retorna
    private int qtdMusica;
    private float duracao;  //retorna
    private Usuario autor;  //retorna

    private ArrayList<Genero> listaGeneros = new ArrayList<Genero>();   //retorna
    private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();   //retorna
    private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();    //retorna

    public Playlist(String nome, String id, Usuario autor){
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
        this.autor = autor;
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

    public void setAutor(Usuario autor){
        this.autor = autor;
    }

    public Usuario getAutor(){
        return this.autor;
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
    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
    }

    public void adicionarArtista(Artista artista){
        this.listaArtistas.add(artista);
    }

    public String retornaDados(){
        String musicas = "";
        for(Musica aux : listaMusicas){
            musicas += aux.retornaDados() + "___________" + "\n";
        }
        return "Playlist: " + this.nome + "\n" + 
                "Id: " + this.id + "\n" + 
                "Quantidade de faixas: " + this.qtdMusica + "\n" 
                "Duracao: " + this.duracao + "\n" + 
                "Autor: " + this.autor.getNome() + "\n" +
                "___________" + musicas;
    }

    //pensar metodo de reproducao
    public boolean removerMusica(Musica musica){
        for(Musica aux: this.listaMusicas){
            if(musica.getId().equals(aux.getId())){
                this.listaMusicas.remove(musica);
                return true;
            }
        }
        return false;
    }
}