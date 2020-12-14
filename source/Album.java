public class Album extends Coletanea {
    private Artista autorAlbum; //autor do Álbum
    private int id;

    public Album(String nome, Artista autorAlbum){
        super(nome);
        this.autorAlbum = autorAlbum;
        this.autorAlbum.getAlbumsProprios().add(this); //Ao instanciar esse álbum, insere-o na lista de álbuns do artista.
        incrementarId();    //Acrescenta em 1 o atributo estático controleId. Dessa forma, é controlada a criação de
        // todas as instâncias de Coletânea, garantindo sempre um id único ao próximo objeto instanciado.
        this.id = controleId;   //O id da instânicia Álbum possui valor atualizado do atributo estático controleId.
    }

    //Gets e Sets
    public Artista getAutorAlbum(){
        return this.autorAlbum;
    }

    public void setAutorAlbum(Artista autorAlbum){
        if(!(autorAlbum instanceof Artista)){
            throw new IllegalArgumentException("APENAS ARTISTA");
        }
        else {
            this.autorAlbum = autorAlbum;
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

    //Métodos

    /*
    Passando uma instância de Playlist como parâmetro, o método adicionarAlbumPlaylist() itera sobre todas as músicas da
    instância Álbum inserindo-as na playlist.
     */
    public void adicionarAlbumPlaylist(Playlist playlist){
        for(Musica aux : this.listaMusicas){
            playlist.adicionarMusica(aux);
        }
    }

    /*
    O método retornaDados() retorna não apenas os dados da instância Álbum como também retorna os dados das instâncias
    Música inseridas em seu arrayList.
     */
    public String retornaDados(){
        String musicas = "";
        if(!this.listaMusicas.isEmpty()){
            for (Musica aux : this.listaMusicas) {
                musicas += aux.retornaDados() + "\n___________\n";
            }
        }
        return "Album: " + this.nome + "\n" +
                "Id: " + this.id + "\n" +
                "Duracao: " + this.duracao + "\n" +
                "Quantidade de faixas: " + this.qtdMusicas + "\n" +
                musicas;
    }

}