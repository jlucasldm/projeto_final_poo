import java.util.ArrayList;

public abstract class Coletanea {
    protected String nome; //retorna
    protected static int controleId = 0;  //retorna
    protected int qtdMusicas; //é eum função da quantidade de elementos da lista de musicas
    protected float duracao;  //é eum função da quantidade da duração de cada musica (isso ainda nao foi implementado)

    //atributo estatico sinalizando a reproducao de musica
    protected ArrayList<Genero> listaGeneros = new ArrayList<Genero>();   //retorna
    protected ArrayList<Musica> listaMusicas = new ArrayList<Musica>();   //retorna
    protected ArrayList<Artista> listaArtistas = new ArrayList<Artista>();    //retorna

    public Coletanea(String nome){
        this.nome = nome;
        if(listaMusicas.size() == 0){
            this.duracao = 0;
        } else{
            this.duracao = 0;
            for(Musica aux : listaMusicas){
                this.duracao += aux.getDuracao();
            }
        }
    }

    // gets e sets
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static int getControleId() {
        return controleId;
    }

    public static void setControleId(int id) {
        controleId = id;
    }

    public int getQtdMusicas() {
        return this.qtdMusicas;
    }

    public void setQtdMusicas(int qtdMusicas) {
        this.qtdMusicas = qtdMusicas;
    }

    public float getDuracao() {
        return this.duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public ArrayList<Genero> getListaGeneros() {
        return this.listaGeneros;
    }

    public void setListaGeneros(ArrayList<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    public ArrayList<Musica> getListaMusicas() {
        return this.listaMusicas;
    }

    public void setListaMusicas(ArrayList<Musica> listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public ArrayList<Artista> getListaArtistas() {
        return this.listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    // metodos
    public abstract String retornarDados();

    // Ao adicionar uma música, automaticamente já adiciona os artistas e os generos da música ao album
    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);

        ArrayList<Genero> listaGeneroMusica = musica.getListaGeneros();

        for(Genero aux: listaGeneroMusica) {
            if(!this.listaGeneros.contains(aux)) {
                this.listaGeneros.add(aux);
            }
        }

        if(!this.listaArtistas.contains(musica.getArtista())) {
            this.listaArtistas.add(musica.getArtista());
        }
    }

    //pensar metodo de reproducao
    public boolean removerMusica(Musica musica){
        for(Musica aux: this.listaMusicas){
            if(musica.getId() == aux.getId()){
                this.listaMusicas.remove(musica);
                return true;
            }
        }
        return false;
    }

    public boolean removerMusica(ArrayList<Musica> listaMusicasRemover){
        for(int i = 0; i < listaMusicasRemover.size(); i++){
            for(int j = 0; j < this.listaMusicas.size(); j++){
                if(listaMusicasRemover.get(i).getId() == this.listaMusicas.get(j).getId()){
                    this.listaMusicas.remove(j);
                }
            }
        }

        return false;
    }

    public void adicionarGenero(Genero genero){
        this.listaGeneros.add(genero);
    }

    public void adicionarArtista(Artista artista){
        this.listaArtistas.add(artista);
    }

    public void incrementarId(){
        controleId++;
    }
}
