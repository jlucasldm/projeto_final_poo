import java.util.Scanner;
import java.util.ArrayList;

public class Aplicacao{
    private static final ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static final ArrayList<Artista> listaArtistas = new ArrayList<>();
    private static final ArrayList<Musica> listaMusicas = new ArrayList<>();
    private static final ArrayList<Album> listaAlbuns = new ArrayList<>();
    private static final ArrayList<Genero> listaGeneros = new ArrayList<>();
    private static final ArrayList<Playlist> listaPlaylists = new ArrayList<>();

    //Método para criar uma instância de Usuário e inseri-la no arrayList da Aplicação.
    public static void cadastrarUsuario(){
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome do usuário: ");
        nome = var.nextLine();

        Usuario cadastrado = new Usuario(nome);
        listaUsuarios.add(cadastrado);
        System.out.println("Usuario cadastrado\n" + cadastrado.retornaDados());

        //var.close();
    }

    //Método para criar uma instância de Artista e inseri-la no arrayList da Aplicação.
    public static void cadastrarArtista(){
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome do artista: ");
        nome = var.nextLine();

        Artista cadastrado = new Artista(nome);
        listaArtistas.add(cadastrado);
        System.out.println("Artista cadastrado\n" + cadastrado.retornaDados());

        //var.close();
    }

    //Método para criar uma instância de Música e inseri-la no arrayList da Aplicação.
    public static boolean cadastrarMusica(){
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome da musica: ");
        nome = var.nextLine();

        double duracao;
        System.out.println("Duracao da musica: ");
        duracao = var.nextDouble();

        int idArtista;
        System.out.println("Id do artista: ");
        idArtista = var.nextInt();

        //Garantindo a existência da instância Artista no arrayList da Aplicação.
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

        //Garantindo a existência da instância Álbum no arrayList da Aplicação.
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

    //Método para criar uma instância de Álbum e inseri-la no arrayList da Aplicação.
    public static boolean cadastrarAlbum(){
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome do album: ");
        nome = var.nextLine();

        int idArtista;
        System.out.println("Id do artista: ");
        idArtista = var.nextInt();

        //Garantindo a existência da instância Artista no arrayList da Aplicação.
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

    //Método para criar uma instância de Gênero e inseri-la no arrayList da Aplicação.
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

    //Método para criar uma instância de Playlist e inseri-la no arrayList da Aplicação.
    public static boolean cadastrarPlaylist(){
        Scanner var = new Scanner(System.in);
        String nome;
        System.out.println("Nome da playlist: ");
        nome = var.nextLine();

        System.out.println("Id do autor: ");
        int idAutor = var.nextInt();

        //Garantindo a existência da instância Usuario no arrayList da Aplicação.
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

    //Itera pelos elementos do arrayList de Usuário da Aplicação, retornando os dados de uma ou todas as instâncias.
    public static void consultarUsuario(){
        Scanner var = new Scanner(System.in);

        System.out.println("Consulta por id? (s/n)");
        String flag = var.nextLine();

        //Direcionando a busca.
        if(flag.equals("s")){
            System.out.println("Id do usuario: ");
            int idUsuario = var.nextInt();

            for(Usuario aux : listaUsuarios){
                if(aux.getId() == idUsuario){
                    System.out.println(aux.retornaDados());
                }
            }
        }else{
            for(Usuario aux : listaUsuarios){
                System.out.println(aux.retornaDados());
            }
        }
    }

    //Itera pelos elementos do arrayList de Artista da Aplicação, retornando os dados de uma ou todas as instâncias.
    public static void consultarArtista() {
        Scanner var = new Scanner(System.in);

        System.out.println("Consulta por id? (s/n)");
        String flag = var.nextLine();

        //Direcionando a busca.
        if(flag.equals("s")){
            System.out.println("Id do artista: ");
            int idArtista = var.nextInt();

            for (Artista aux : listaArtistas){
                if (aux.getId() == idArtista) {
                    System.out.println(aux.retornaDados());
                }
            }
        }else{
            for (Artista aux : listaArtistas){
                System.out.println(aux.retornaDados());
            }
        }
    }

    //Itera pelos elementos do arrayList de Musica da Aplicação, retornando os dados de uma ou todas as instâncias.
    public static void consultarMusica() {
        Scanner var = new Scanner(System.in);

        System.out.println("Consulta por id? (s/n)");
        String flag = var.nextLine();

        //Direcionando a busca.
        if(flag.equals("s")){
            System.out.println("Id da musica: ");
            int idMusica = var.nextInt();

            for (Musica aux : listaMusicas){
                if (aux.getId() == idMusica) {
                    System.out.println(aux.retornaDados());
                }
            }
        }else{
            for (Musica aux : listaMusicas){
                System.out.println(aux.retornaDados());
            }
        }
    }

    //Itera pelos elementos do arrayList de Álbum da Aplicação, retornando os dados de uma ou todas as instâncias.
    public static void consultarAlbum() {
        Scanner var = new Scanner(System.in);

        System.out.println("Consulta por id? (s/n)");
        String flag = var.nextLine();

        //Direcionando a busca.
        if(flag.equals("s")){
            System.out.println("Id do album: ");
            int idAlbum = var.nextInt();

            for (Album aux : listaAlbuns) {
                if (aux.getId() == idAlbum) {
                    System.out.println(aux.retornaDados());
                }
            }
        }else{
            for (Album aux : listaAlbuns) {
                System.out.println(aux.retornaDados());
            }
        }
    }

    //Itera pelos elementos do arrayList de Gênero da Aplicação, retornando os dados de uma ou todas as instâncias.
    public static void consultarGenero() {
        Scanner var = new Scanner(System.in);

        System.out.println("Consulta por id? (s/n)");
        String flag = var.nextLine();

        //Direcionando a busca.
        if(flag.equals("s")){
            System.out.println("Id do genero: ");
            int idGenero = var.nextInt();

            for (Genero aux : listaGeneros) {
                if (aux.getEnumGenero().ordinal() == idGenero-1) {
                    System.out.println(aux.retornaDados());
                }
            }
        }else{
            for (Genero aux : listaGeneros) {
                System.out.println(aux.retornaDados());
            }
        }
    }

    //Itera pelos elementos do arrayList de Playlist da Aplicação, retornando os dados de uma ou todas as instâncias.
    public static void consultarPlaylist() {
        Scanner var = new Scanner(System.in);

        System.out.println("Consulta por id? (s/n)");
        String flag = var.nextLine();

        //Direcionando a busca.
        if(flag.equals("s")){
            System.out.println("Id da playlist: ");
            int idPlaylist = var.nextInt();

            for (Playlist aux : listaPlaylists){
                if (aux.getId() == idPlaylist){
                    System.out.println(aux.retornaDados());
                }
            }
        }else{
            for (Playlist aux : listaPlaylists){
                System.out.println(aux.retornaDados());
            }
        }
    }

    //Insere instância de Gênero no arrayList correspondente de uma instância de Música.
    public static void definirGeneroMusica(){
        Scanner var = new Scanner(System.in);

        int idMusica;
        System.out.println("Id da musica");
        idMusica = var.nextInt();

        int indiceGenero;
        System.out.println("Codigo do genero");
        indiceGenero = var.nextInt();

        //Busca pela instância de Música, pelo Id, no arrayList da Aplicação. Caso encontre, busca pela instância de
        // Gênero no arrayList da Aplicação. Caso encontre, adiciona o Gênero no arrayList da Música.
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

    //Verifica a existência da instância de Música e Playlist nos respectivos arrayLists da Aplicação e insere a Música
    //no arrayList da Playlist.
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

        //Checa o cadastro da instância da Música.
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

        //Checa o cadastro da instância da Playlist.
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

    //Verifica a existência da instância de Música e Playlist nos respectivos arrayLists da Aplicação, e remove a Música
    //no arrayList da Playlist, caso exista.
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

        //Checa o cadastro da instância da Música.
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

        //Checa o cadastro da instância da Playlist.
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

    //Verifica a existência da instância de Álbum e Playlist nos respectivos arrayLists da Aplicação, itera sobre as
    // Músicas do Álbum e as insere no arrayList da Playlist.
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

        //Checa o cadastro da instância do Album.
        for(Album aux : listaAlbuns){
            if(aux.getId() == idAlbum){
                album = aux;
            }
        }

        if(album.getNome().equals("")){
            System.out.println("Album nao esta cadastrado");
            //var.close();
            return false;
        }

        //Checa o cadastro da instância da Playlist.
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

        album.adicionarAlbumPlaylist(playlist);
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

    //Método apenas para exibir informações mais detalhadas a respeito da Aplicação.
    public static void showInstrucoes(){
        System.out.println("\nINSTRUÇÕES E INFORMAÇÕES DA APLICAÇÃO\n" +
                "Olá! Bem vindo ao projeto final da matéria Programação Orientada à Objetos (MATA55)\n" +
                "da Universidade Federal da Bahia.\n" +
                "Desenvolvido por Gustavo Oliveira e João Melo, essa aplicação possui como objetivo\n" +
                "a criação e gerenciamento de uma biblioteca de música. Fez-se necessário, portanto,\n" +
                "a criação das classes Coletanea, Album, Playlist, Pessoa, Usuario, Artista, Genero,\n" +
                "EnumGenero, Audio, Musica e Aplicacao, visando corresponder aos requisitos do trabalho\n" +
                "e o desenvolvimento de elementos consistentes e coerentes com a aplicação.\n\n" +
                "1. DETALHES E INSTRUÇÕES\n" +
                "1.1 Antes de ser possível a execução de operações como adição e remoção de músicas\n" +
                "   em uma playlist, é necessário o cadastro de certas estruturas. O primeiro passo\n" +
                "   para o uso consiste no cadastramento dos elementos.\n" +
                "   Os elementos 'básicos' da aplicação são Usuário e Artista (eles são usados como\n" +
                "   parâmetros para a criação de outros elementos e apenas precisam de um nome para\n" +
                "   serem instanciados).\n\n" +
                "   As classes e seus respectivos argumentos para instancialização são:\n" +
                "   USUÁRIO:\n" +
                "       String nome\n" +
                "   ARTISTA:\n" +
                "       String nome\n" +
                "   ALBUM:\n" +
                "       String nome\n" +
                "       Artista autorAlbum\n" +
                "   MUSICA:\n" +
                "       String nome\n" +
                "       double duracao\n" +
                "       Artista artista\n" +
                "       Album album\n" +
                "   GENERO:\n" +
                "       EnumGenero enumGenero\n" +
                "   PLAYLIST:\n" +
                "       String nome\n" +
                "       Usuario autor\n" +
                "1.2 O acesso às informações de cada objeto pode ser realizado através da consulta\n" +
                "   por id. Vale ressaltar que optamos, durante o desenvolvimento da aplicação, assumir\n" +
                "   que uma música pode possuir diversos gêneros. Portanto, existe uma função na aplicação\n" +
                "   focada exclusivamente com esse propósito. Informações mais precisas a respeito\n" +
                "   das estruturas implementadas estão presentes no código em formato de comentário.\n");
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
            "20. Instruções e informações\n" +
            "21. Sair");

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
                case 20:
                    Aplicacao.showInstrucoes();
                    break;
                default:
                    break;
            }
        }while(opcao != 21);
        //var.close();
    }
}