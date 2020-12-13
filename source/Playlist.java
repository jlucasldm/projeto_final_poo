public class Playlist extends Coletanea {
    private Usuario autor;  //retorna
    private int id;

    public Playlist(String nome, Usuario autor){
        super(nome);
        this.autor = autor;
        incrementarId();
        this.id = controleId;
    }

    //gets e sets
    public Usuario getAutor(){
        return this.autor;
    }

    public void setAutor(Usuario autor){
        this.autor = autor;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    //metodos
    public String retornaDados(){
        String musicas = "";
        if(!this.listaMusicas.isEmpty()){
            for (Musica aux : this.listaMusicas) {
                musicas += aux.retornaDados() + "\n___________\n";
            }
        }
        return "Playlist: " + this.nome + "\n" +
                "Id: " + this.id + "\n" +
                "Quantidade de faixas: " + this.qtdMusicas + "\n" +
                "Duracao: " + this.duracao + "\n" +
                "Autor: " + this.autor.getNome() + "\n" +
                musicas;
    }

}