import java.util.ArrayList;

public class Playlist extends Coletanea {
    private Usuario autor;  //retorna

    public Playlist(String nome, String id, Usuario autor){
        super(nome, id);
        this.autor = autor;
    }

    //gets e sets
    public Usuario getAutor(){
        return this.autor;
    }

    public void setAutor(Usuario autor){
        this.autor = autor;
    }

    //metodos
    public String retornarDados(){
        String musicas = "";
        for(Musica aux : listaMusicas){
            musicas += aux.retornaDados() + "___________" + "\n";
        }
        return "Playlist: " + this.nome + "\n" +
                "Id: " + this.id + "\n" +
                "Quantidade de faixas: " + this.qtdMusicas + "\n" +
                "Duracao: " + this.duracao + "\n" +
                "Autor: " + this.autor.getNome() + "\n" +
                "___________" + musicas;
    }

}