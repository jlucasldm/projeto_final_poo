import java.util.ArrayList;

public class Usuario extends Pessoa{
    private int id;
    private ArrayList<Playlist> listaPlaylists = new ArrayList<>();

    public Usuario(String nome){
        super(nome);
        incrementarId();    //Acrescenta em 1 o atributo estático controleId. Dessa forma, é controlada a criação de
        // todas as instâncias de Usuário, garantindo sempre um id único ao próximo objeto instanciado.
        this.id = controleId;   //O id da instânicia Álbum possui valor atualizado do atributo estático controleId.
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if(!(Integer.class.isInstance(id))){
            throw new IllegalArgumentException("APENAS INTEGER");
        }
        else {
            this.id = id;
        }
    }

    public ArrayList<Playlist> getListaPlaylists() {
        return this.listaPlaylists;
    }

    public void setListaPlaylists(ArrayList<Playlist> listaPlaylists) {
        if(!(listaPlaylists instanceof ArrayList<?>)){
            throw new IllegalArgumentException("APENAS ARRAYLIST<PLAYLIST>");
        }
        else {
            this.listaPlaylists = listaPlaylists;
        }
    }

    //Métodos

    /*
    O método retornaDados() retorna não apenas os dados da instância Usuário como também retorna os dados das instâncias
    Playlists inseridas em seu arrayList.
     */
    public String retornaDados(){
        String playlists = "";
        if(!this.listaPlaylists.isEmpty()){
            for (Playlist aux : this.listaPlaylists) {
                playlists += aux.retornaDados() + "//////////" + "\n";
            }
        }
        return "Usuario: " + this.getNome() + "\n" +
                "Id Usuario: " + this.getId() + "\n" +
                playlists;
    }
}