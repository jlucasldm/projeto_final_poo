import java.util.ArrayList;

public abstract class Coletanea {
    protected String nome;
    protected static int controleId = 0;    //Atributo estático cujo objetivo é gerenciar e garantir, a medida que os
    //objetos são instanciados, um id único para cada instância.
    protected int qtdMusicas;
    protected double duracao;

    protected ArrayList<Musica> listaMusicas = new ArrayList<>();

    protected Coletanea(String nome){
        this.nome = nome;
        this.duracao = 0;
        this.qtdMusicas = 0;
    }

    //Gets e Sets
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(!(nome instanceof String)){
            throw new IllegalArgumentException("APENAS STRINGS");
        }
        else {
            this.nome = nome;
        }
    }

    public static int getControleId() {
        return controleId;
    }

    public static void setControleId(int id) {
        if(!(Integer.class.isInstance(id))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            controleId = id;
        }
    }

    public int getQtdMusicas() {
        return this.qtdMusicas;
    }

    public void setQtdMusicas(int qtdMusicas) {
        if(!(Integer.class.isInstance(qtdMusicas))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            this.qtdMusicas = qtdMusicas;
        }
    }

    public double getDuracao() {
        return this.duracao;
    }

    public void setDuracao(double duracao) {
        if(!(Double.class.isInstance(duracao))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            this.duracao = duracao;
        }
    }

    public ArrayList<Musica> getListaMusicas() {
        return this.listaMusicas;
    }

    public void setListaMusicas(ArrayList<Musica> listaMusicas) {
        if(!(listaMusicas instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<MUSICA>");
        }
        else {
            this.listaMusicas = listaMusicas;
        }
    }

    //Métodos

    //É declarado o método para o uso de classes filhas.
    public abstract String retornaDados();

    //Passando uma instância de Música como parâmetro, o método adicionarMusica() insere-o no arrayList da
    //Coletânea(Playlist ou Álbum), modificando os atributos referentes à duração e quantidade de músicas.
    public void adicionarMusica(Musica musica){
        this.listaMusicas.add(musica);
        this.duracao += musica.getDuracao();
        this.qtdMusicas ++;
    }

    //Passando uma instância de Música como parâmetro, o método adicionarMusica() confere se o objeto está presente no
    //arrayList da Coletânea(Playlist ou Álbum), remove-o e modifica os atributos referentes à duração e quantidade de
    //músicas.
    public boolean removerMusica(Musica musica){
        for(Musica aux: this.listaMusicas){
            if(musica.getId() == aux.getId()){
                this.listaMusicas.remove(musica);
                this.duracao -= musica.getDuracao();
                this.qtdMusicas--;
                return true;
            }
        }
        return false;
    }

    //O método controla a quantidade de instâncias criadas. O método deve ser chamado a cada instanciamento de Álbum e
    //Playlist.
    public static void incrementarId(){
        controleId++;
    }
}
