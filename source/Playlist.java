public class Playlist extends Coletanea {
    private Usuario autor;
    private int id;

    public Playlist(String nome, Usuario autor){
        super(nome);
        this.autor = autor;
        this.autor.getListaPlaylists().add(this);   //Assim que Playlist é instanciada, é inserida no arrayList do
        // Usuario passado como parâmetro.
        incrementarId();    //Acrescenta em 1 o atributo estático controleId. Dessa forma, é controlada a criação de
        // todas as instâncias de Coletânea, garantindo sempre um id único ao próximo objeto instanciado.
        this.id = controleId;   //O id da instânicia Álbum possui valor atualizado do atributo estático controleId.
    }

    //Gets e Sets
    public Usuario getAutor(){
        return this.autor;
    }

    public void setAutor(Usuario autor){
        if(!(autor instanceof Usuario)){
            throw new IllegalArgumentException("APENAS USUARIO");
        }
        else {
            this.autor = autor;
        }
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        if(!(Integer.class.isInstance(id))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            this.id = id;
        }
    }

    //metodos
    /*
    O método retornaDados() retorna não apenas os dados da instância Playlist como também retorna os dados das instâncias
    Música inseridas em seu arrayList.
    */
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