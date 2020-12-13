import java.util.Scanner;
import java.util.ArrayList;

public class Aplicacao{
    private static final ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static final ArrayList<Artista> listaArtistas = new ArrayList<>();
    private static final ArrayList<Musica> listaMusicas = new ArrayList<>();
    private static final ArrayList<Album> listaAlbuns = new ArrayList<>();
    private static final ArrayList<Genero> listaGeneros = new ArrayList<>();
    private static final ArrayList<Playlist> listaPlaylists = new ArrayList<>();


    //todos os metodos estao sujeitos à alteração em função das mudanças de suas classes correspondentes
    public static void cadastrarUsuario(){
        //String nome, String id
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome do usuário: ");
        nome = var.nextLine();

        Usuario cadastrado = new Usuario(nome);
        listaUsuarios.add(cadastrado);
        System.out.println("Usuario cadastrado\n" + cadastrado.retornaDados());

        //var.close();
    }

    public static void cadastrarArtista(){
        //String nome, String id
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome do artista: ");
        nome = var.nextLine();

        Artista cadastrado = new Artista(nome);
        listaArtistas.add(cadastrado);
        System.out.println("Artista cadastrado\n" + cadastrado.retornaDados());

        //var.close();
    }

    //função a ser removida. acesso à musicas estará disponível por meio de artista
    public static boolean cadastrarMusica(){
        //String nome, float duracao, Artista artista, Album album
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome da musica: ");
        nome = var.nextLine();

        double duracao;
        System.out.println("Duracao da musica: ");
        duracao = var.nextDouble();

        //setando valores vazios para artista e album, já que a função será alterada
        /*a logica consistira em solicitar o id dos respectivos objetos (album e artista), iterar sobre
        o arrayList de cada tipo buscando a existencia da instancias. Caso possitivo, seria repassada a 
        referencia para a criação da instancia de musica. Caso contrario, sera passado um objeto vazio*/


        int idArtista;
        System.out.println("Id do artista: ");
        idArtista = var.nextInt();

        Artista auxArtista = new Artista("");
        for(Artista aux : listaArtistas){
            if(aux.getId() == idArtista){
                auxArtista = aux;
            }
        }

        if(auxArtista.getNome().equals("")){
            System.out.println("Artista nao cadastrado");
            return false;
        }

        int idAlbum;
        System.out.println("Id do album: ");
        idAlbum = var.nextInt();

        Album auxAlbum = new Album("", auxArtista);
        for(Album aux : listaAlbuns){
            if(aux.getId() == idAlbum){
                auxAlbum = aux;
            }
        }

        if(auxAlbum.getNome().equals("")){
            System.out.println("Album nao cadastrado");
            return false;
        }

        Musica cadastrado = new Musica(nome, duracao, auxArtista, auxAlbum);
        listaMusicas.add(cadastrado);
        System.out.println("Musica cadastrada\n" + cadastrado.retornaDados());

        return true;

        //var.close();
    }

    //função a ser removida. acesso à musicas estará disponível por meio de artista
    public static boolean cadastrarAlbum(){
        //String nome, Artista autorAlbum
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome do album: ");
        nome = var.nextLine();

        int idArtista;
        System.out.println("Id do artista: ");
        idArtista = var.nextInt();

        Artista auxArtista = new Artista("");
        for (Artista aux : listaArtistas) {
            if (aux.getId() == idArtista) {
                auxArtista = aux;
            }
        }

        if (auxArtista.getNome().equals("")) {
            System.out.println("Artista nao cadastrado");
            return false;
        }

        Album cadastrado = new Album(nome, auxArtista);
        listaAlbuns.add(cadastrado);
        System.out.println("Album cadastrado\n" + cadastrado.retornaDados());

        return true;

        //var.close();
    }

    //possívelmente depreciada
    public static void cadastrarGenero(){
        Scanner var = new Scanner(System.in);
        int indiceGenero;
        System.out.println("1.  Pop \n" +
                            "2.  Rap \n" +
                            "3.  Hip Hop \n" +
                            "4.  Louvor \n" +
                            "5.  Indie \n" +
                            "6.  Art Pop \n" +
                            "7.  Rock \n" +
                            "8.  Sertanejo \n" +
                            "9.  Pagode \n" +
                            "10. Piseiro \n" +
                            "11. MPB \n" +
                            "12. EDM \n" +
                            "13. RANDB \n" +
                            "14. Classica \n" +
                            "15. Soul \n" +
                            "16. Blues \n" +
                            "17. Punk \n" +
                            "18. K-Pop \n" +
                            "19. Samba \n" +
                            "20. Vaquejada \n" +
                            "21. Arrocha \n" +
                            "22. Pagodao \n" +
                            "Favor selecionar numero correspondente a opcao: ");
        indiceGenero = var.nextInt();

        EnumGenero enumGenero = EnumGenero.values()[indiceGenero - 1];

        Genero cadastrado = new Genero(enumGenero);
        listaGeneros.add(cadastrado);
        System.out.println("Genero cadastrado \n" + cadastrado.retornaDados());

        //var.close();
    }

    //todos os generos já previamente cadastrados
    public void criarGeneros(){
        for(int i = 0; i < 22; i++){
            EnumGenero enumGenero = EnumGenero.values()[i];
            Genero aux = new Genero(enumGenero);
            listaGeneros.add(aux);
        }
    }

    public static boolean cadastrarPlaylist(){
        //String nome, Usuario autor
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome da playlist: ");
        nome = var.nextLine();

        System.out.println("Id do autor: ");
        int idAutor = var.nextInt();

        Usuario autor = new Usuario("");
        for(Usuario usuario : listaUsuarios){
            if(usuario.getId() == idAutor){
                autor = usuario;
            }
        }

        if(autor.getNome().equals("")){
            System.out.println("Usuario nao cadastrado");
            return false;
        }

        Playlist cadastrado = new Playlist(nome, autor);
        listaPlaylists.add(cadastrado);
        System.out.println("Playlist cadastrada\n" + cadastrado.retornaDados());

        return true;

        //var.close();
    }

    public static void consultarUsuario(){
        Scanner var = new Scanner(System.in);

        System.out.println("Id do usuario: ");
        int idUsuario = var.nextInt();

        for(Usuario aux : listaUsuarios){
            if(aux.getId() == idUsuario){
                System.out.println(aux.retornaDados());
            }
        }
    }

    public static void consultarArtista() {
        Scanner var = new Scanner(System.in);

        System.out.println("Id do artista: ");
        int idArtista = var.nextInt();

        for (Artista aux : listaArtistas){
            if (aux.getId() == idArtista) {
                System.out.println(aux.retornaDados());
            }
        }
    }

    public static void consultarMusica() {
        Scanner var = new Scanner(System.in);

        System.out.println("Id da musica: ");
        int idMusica = var.nextInt();

        for (Musica aux : listaMusicas){
            if (aux.getId() == idMusica) {
                System.out.println(aux.retornaDados());
            }
        }
    }

    public static void consultarAlbum() {
        Scanner var = new Scanner(System.in);

        System.out.println("Id do album: ");
        int idAlbum = var.nextInt();

        for (Album aux : listaAlbuns) {
            if (aux.getId() == idAlbum) {
                System.out.println(aux.retornaDados());
            }
        }
    }

    public static void consultarGenero() {
        Scanner var = new Scanner(System.in);

        System.out.println("Id do genero: ");
        int idGenero = var.nextInt();

        for (Genero aux : listaGeneros) {
            if (aux.getEnumGenero().ordinal() == idGenero-1) {
                System.out.println(aux.retornaDados());
            }
        }
    }

    public static void consultarPlaylist() {
        Scanner var = new Scanner(System.in);

        System.out.println("Id da playlist: ");
        int idPlaylist = var.nextInt();

        for (Playlist aux : listaPlaylists){
            if (aux.getId() == idPlaylist){
                System.out.println(aux.retornaDados());
            }
        }
    }

    public static void definirGeneroMusica(){
        Scanner var = new Scanner(System.in);

        int idMusica;
        System.out.println("Id da musica");
        idMusica = var.nextInt();

        int indiceGenero;
        System.out.println("Codigo do genero");
        indiceGenero = var.nextInt();

        EnumGenero enumGeneroaux = EnumGenero.values()[indiceGenero - 1];
        for(Musica aux : listaMusicas){
            if(aux.getId() == idMusica){
                for (Genero auxGen : listaGeneros) {
                    if (auxGen.getEnumGenero().equals(enumGeneroaux)) {
                        aux.adicionarGenero(auxGen);
                    }
                }
            }
        }    
    }

    public static boolean adicionarMusicaPlaylist(){
        Scanner var = new Scanner(System.in);
        System.out.println("Id da musica: ");
        int idMusica = var.nextInt();

        System.out.println("Id da playlist: ");
        int idPlaylist = var.nextInt();

        Artista auxArtista = new Artista("");
        Album auxAlbum = new Album("", auxArtista);
        Usuario auxUsuario = new Usuario("Nome");

        Musica musica = new Musica("Nome", (int) 30.0, auxArtista, auxAlbum);
        Playlist playlist = new Playlist("", auxUsuario);

        for(Musica aux : listaMusicas){
            if(aux.getId() == idMusica){
                musica = aux;
            }
        }

        if(musica.getNome().equals("")){
            System.out.println("Musica nao esta cadastrada");
            //var.close();
            return false;
        }

        for(Playlist aux : listaPlaylists){
            if(aux.getId() == idPlaylist){
                playlist = aux;
            }
        }

        if(playlist.getNome().equals("")){
            System.out.println("Playlist nao esta cadastrada");
            //var.close();
            return false;
        }

        playlist.adicionarMusica(musica);
        System.out.println("Musica adicionada");

        //var.close();

        return true;
    }

    public static boolean removerMusicaPlaylist(){
        Scanner var = new Scanner(System.in);
        System.out.println("Id da musica: ");
        int idMusica = var.nextInt();

        System.out.println("Id da playlist: ");
        int idPlaylist = var.nextInt();

        Artista auxArtista = new Artista("");
        Album auxAlbum = new Album("", auxArtista);
        Usuario auxUsuario = new Usuario("");

        Musica musica = new Musica("Nome", (int) 30.0, auxArtista, auxAlbum);
        Playlist playlist = new Playlist("", auxUsuario);

        for(Musica aux : listaMusicas){
            if(aux.getId() == idMusica){
                musica = aux;
            }
        }

        if(musica.getNome().equals("")){
            System.out.println("Musica nao esta cadastrada");
            //;
            return false;
        }

        for(Playlist aux : listaPlaylists){
            if(aux.getId() == idPlaylist){
                playlist = aux;
            }
        }

        if(playlist.getNome().equals("")){
            System.out.println("Playlist nao esta cadastrada");
            //var.close();
            return false;
        }

        boolean operacao = playlist.removerMusica(musica);

        if(operacao){
            System.out.println("Musica removida da playlist");
        }else{
            System.out.println("Playlist nao contem a musica");
        }

        //var.close();

        return true;
    }

    public static boolean adicionarAlbumPlaylist(){
        Scanner var = new Scanner(System.in);
        System.out.println("Id do album: ");
        int idAlbum = var.nextInt();

        System.out.println("Id da playlist: ");
        int idPlaylist = var.nextInt();

        Artista auxArtista = new Artista("");
        Usuario auxUsuario = new Usuario("");

        Album album = new Album("", auxArtista);
        Playlist playlist = new Playlist("", auxUsuario);

        for(Album aux : listaAlbuns){
            if(aux.getId() == idAlbum){
                album = aux;
            }
        }

        if(album.getNome().equals("")){
            System.out.println("Album nao esta cadastrada");
            //var.close();
            return false;
        }

        for(Playlist aux : listaPlaylists){
            if(aux.getId() == idPlaylist){
                playlist = aux;
            }
        }

        if(playlist.getNome().equals("")){
            System.out.println("Playlist nao esta cadastrada");
            //var.close();
            return false;
        }

        album.adicionarAlbumPlaylist(playlist); //é melhor rever essa função. com certeza deve ser otimizado
        //o lance é que existe pleonasmo em funções de adicao de musicas/albuns em playlists
        System.out.println("Album adicionado");
        //var.close();
        return true;
    }

    public static boolean aposentarArtista(){
        Scanner var = new Scanner(System.in);
        System.out.print("Id do artista: ");
        int idArtista = var.nextInt();

        for (Artista aux : listaArtistas){
            if (aux.getId() == idArtista) {
                Usuario danielDayLewis = (Usuario) aux;
                listaArtistas.remove(aux);
                listaUsuarios.add(danielDayLewis);
                return true;
            }
        }
        return false;
    }

    public static void acelerarMusica() {
        Scanner var = new Scanner(System.in);

        System.out.println("Id da musica: ");
        int idMusica = var.nextInt();

        for (Musica aux : listaMusicas){
            if (aux.getId() == idMusica) {
                aux.aumentarVelocidade();
            }
        }
    }

    public static void desacelerarMusica() {
        Scanner var = new Scanner(System.in);

        System.out.println("Id da musica: ");
        int idMusica = var.nextInt();

        for (Musica aux : listaMusicas){
            if (aux.getId() == idMusica) {
                aux.diminuirVelocidade();
            }
        }
    }

    public static void main(String[] args){
        int opcao;
        Scanner var = new Scanner(System.in);

        do{
            System.out.println(
            "///////CADASTROS///////\n" +
            "1. Cadastrar um usuario \n" +
            "2. Cadastrar um artista \n" +
            "3. Cadastrar uma musica \n" +
            "4. Cadastrar um album \n" +
            "5. Cadastrar um genero \n" +
            "6. Cadastrar uma playlist \n\n" +
            "///////CONSULTAS///////\n" +
            "7. Consultar um usuario \n" +
            "8. Consultar um artista \n" +
            "9. Consultar uma musica \n" +
            "10. Consultar um album \n" +
            "11. Consultar um genero \n" +
            "12. Consultar uma playlist \n\n" +
            "///////DEMAIS OPERACOES///////\n" +
            "13. Definir genero de uma musica \n" +
            "14. Adicionar musica(s) a uma playlist \n" +
            "15. Remover musica(s) de uma playlist \n" +
            "16. Adicionar um album a uma playlist \n" +
            "17. Aposentar artista \n" +
            "18. Aumentar velocidade música \n" +
            "19. Diminuir velocidade música \n\n" +
            "20. Sair");

            opcao = var.nextInt();
            switch(opcao){
                case 1:
                    Aplicacao.cadastrarUsuario();
                    break;
                case 2:
                    Aplicacao.cadastrarArtista();
                    break;
                case 3:
                    Aplicacao.cadastrarMusica();
                    break;
                case 4:
                    Aplicacao.cadastrarAlbum();
                    break;
                case 5:
                    Aplicacao.cadastrarGenero();
                    break;
                case 6:
                    Aplicacao.cadastrarPlaylist();
                    break;
                case 7:
                    Aplicacao.consultarUsuario();
                    break;
                case 8:
                    Aplicacao.consultarArtista();
                    break;
                case 9:
                    Aplicacao.consultarMusica();
                    break;
                case 10:
                    Aplicacao.consultarAlbum();
                    break;
                case 11:
                    Aplicacao.consultarGenero();
                    break;
                case 12:
                    Aplicacao.consultarPlaylist();
                    break;
                case 13:
                    Aplicacao.definirGeneroMusica();
                    break;
                case 14:
                    Aplicacao.adicionarMusicaPlaylist();
                    break;
                case 15:
                    Aplicacao.removerMusicaPlaylist();
                    break;
                case 16:
                    Aplicacao.adicionarAlbumPlaylist();
                    break;
                case 17:
                    Aplicacao.aposentarArtista();
                    break;
                case 18:
                    Aplicacao.acelerarMusica();
                    break;
                case 19:
                    Aplicacao.desacelerarMusica();
                    break;
                default:
                    break;
            }
        }while(opcao != 20);
        //var.close();
    }
}