import java.util.Scanner;
import java.util.ArrayList;

public class Aplicacao{
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static ArrayList<Artista> listaArtistas = new ArrayList<>();
    private static ArrayList<Musica> listaMusicas = new ArrayList<>();
    private static ArrayList<Album> listaAlbuns = new ArrayList<>();
    private static ArrayList<Genero> listaGeneros = new ArrayList<>();
    private static ArrayList<Playlist> listaPlaylists = new ArrayList<>();


    //todos os metodos estao sujeitos à alteração em função das mudanças de suas classes correspondentes
    public static void cadastrarUsuario(){
        //String nome, String id
        Scanner var = new Scanner(System.in);
        String nome = "";
        System.out.println("Nome do usuário: ");
        nome = var.nextLine();

        Usuario cadastrado = new Usuario(nome);
        listaUsuarios.add(cadastrado);
        System.out.println("Usuario cadastrado");

        var.close();
    }

    public static void cadastrarArtista(){
        //String nome, String id
        Scanner var = new Scanner(System.in);
        String nome = "";
        System.out.println("Nome do artista: ");
        nome = var.nextLine();

        Artista cadastrado = new Artista(nome);
        listaArtistas.add(cadastrado);
        System.out.println("Artista cadastrado");

        var.close();
    }

    //função a ser removida. acesso à musicas estará disponível por meio de artista
    public static void cadastrarMusica(){
        //String nome, float duracao, Artista artista, Album album
        Scanner var = new Scanner(System.in);
        String nome = "";
        System.out.println("Nome da musica: ");
        nome = var.nextLine();

        float duracao = 0;
        System.out.println("Duracao da musica: ");
        duracao = var.nextFloat();

        //setando valores vazios para artista e album, já que a função será alterada
        /*a logica consistira em solicitar o id dos respectivos objetos (album e artista), iterar sobre
        o arrayList de cada tipo buscando a existencia da instancias. Caso possitivo, seria repassada a 
        referencia para a criação da instancia de musica. Caso contrario, sera passado um objeto vazio*/
        Artista auxArtista = new Artista("");
        Album auxAlbum = new Album("", auxArtista);

        Musica cadastrado = new Musica(nome, duracao, auxArtista, auxAlbum);
        listaMusicas.add(cadastrado);
        System.out.println("Musica cadastrada");

        var.close();
    }

    //função a ser removida. acesso à musicas estará disponível por meio de artista
    public static void cadastrarAlbum(){
        //String nome, Artista autorAlbum
        Scanner var = new Scanner(System.in);
        String nome = "";
        System.out.println("Nome do album: ");
        nome = var.nextLine();

        Artista auxArtista = new Artista("");

        Album cadastrado = new Album(nome, auxArtista);
        listaAlbuns.add(cadastrado);
        System.out.println("Album cadastrado");

        var.close();
    }

    //possívelmente depreciada
    public static void cadastrarGenero(){
        Scanner var = new Scanner(System.in);
        int indiceGenero = 0;
        System.out.println("1.  Pop \n" +
                            "2.  Rap \n" +
                            "3.  Hip Hop \n" +
                            "4.  Louvor \n" +
                            "5.  Indie \n" +
                            "6.  Art Pop \n" +
                            "7.  Rock \n" +
                            "8.  Sertanejo \n" +
                            "9.  Pagode \n" +
                            "10. Piseiro" +
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
        System.out.println("Genero cadastrado");

        var.close();
    }

    //todos os generos já previamente cadastrados
    public void criarGeneros(){
        for(int i = 0; i < 22; i++){
            EnumGenero enumGenero = EnumGenero.values()[i];
            Genero aux = new Genero(enumGenero);
            listaGeneros.add(aux);
        }
    }

    public static void cadastrarPlaylist(){
        //String nome, Usuario autor
        Scanner var = new Scanner(System.in);
        String nome = "";
        System.out.println("Nome da playlist: ");
        nome = var.nextLine();

        System.out.println("Id do autor: ");
        int idAutor = var.nextInt();

        Usuario autor = new Usuario("Nome");
        for(Usuario usuario : listaUsuarios){
            if(usuario.getId() == idAutor){
                autor = usuario;
            }
        }

        Playlist cadastrado = new Playlist(nome, autor);
        listaPlaylists.add(cadastrado);
        System.out.println("Playlist cadastrado");

        var.close();
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

        Musica musica = new Musica("Nome", (float) 30.0, auxArtista, auxAlbum);
        Playlist playlist = new Playlist("", auxUsuario);

        for(Musica aux : listaMusicas){
            if(aux.getId() == idMusica){
                musica = aux;
            }
        }

        if(musica.getNome().equals("")){
            System.out.println("Musica nao esta cadastrada");
            var.close();
            return false;
        }

        for(Playlist aux : listaPlaylists){
            if(aux.getId() == idPlaylist){
                playlist = aux;
            }
        }

        if(playlist.getNome().equals("")){
            System.out.println("Playlist nao esta cadastrada");
            var.close();
            return false;
        }

        playlist.adicionarMusica(musica);
        System.out.println("Musica adicionada");

        var.close();

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

        Musica musica = new Musica("Nome", (float) 30.0, auxArtista, auxAlbum);
        Playlist playlist = new Playlist("", auxUsuario);

        for(Musica aux : listaMusicas){
            if(aux.getId() == idMusica){
                musica = aux;
            }
        }

        if(musica.getNome().equals("")){
            System.out.println("Musica nao esta cadastrada");
            var.close();
            return false;
        }

        for(Playlist aux : listaPlaylists){
            if(aux.getId() == idPlaylist){
                playlist = aux;
            }
        }

        if(playlist.getNome().equals("")){
            System.out.println("Playlist nao esta cadastrada");
            var.close();
            return false;
        }

        boolean operacao = playlist.removerMusica(musica);

        if(operacao){
            System.out.println("Musica removida da playlist");
        }else{
            System.out.println("Playlist nao contem a musica");
        }

        var.close();

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
            var.close();
            return false;
        }

        for(Playlist aux : listaPlaylists){
            if(aux.getId() == idPlaylist){
                playlist = aux;
            }
        }

        if(playlist.getNome().equals("")){
            System.out.println("Playlist nao esta cadastrada");
            var.close();
            return false;
        }

        album.adicionarAlbumPlaylist(playlist); //é melhor rever essa função. com certeza deve ser otimizado
        //o lance é que existe pleonasmo em funções de adicao de musicas/albuns em playlists
        System.out.println("Album adicionado");
        var.close();
        return true;
    }

    public static void main(String[] args){
        int opcao = 0;
        Scanner var = new Scanner(System.in);

        do{
            System.out.println(
            "1. Cadastrar um usuario \n" +
            "2. Cadastrar um artista \n" +
            "3. Cadastrar uma musica \n" +
            "4. Cadastrar uma um album \n" +
            "5. Cadastrar uma playlist \n" +
            "6. Adicionar musica(s) a uma playlist \n" +
            "7. Remover musica(s) de uma playlist \n" +
            "8. Adicionar um album a uma playlist \n" +
            "9. Sair");

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
                    Aplicacao.cadastrarPlaylist();
                    break;
                case 6:
                    Aplicacao.adicionarMusicaPlaylist();
                    break;
                case 7:
                    Aplicacao.removerMusicaPlaylist();
                    break;
                case 8:
                    Aplicacao.adicionarAlbumPlaylist();
                    break;
                default:
                    break;
            }
        }while(opcao != 10);
        var.close();
    }
}