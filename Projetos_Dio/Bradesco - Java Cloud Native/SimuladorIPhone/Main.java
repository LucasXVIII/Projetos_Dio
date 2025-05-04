public class Main {
    public static void main(String[] args) {
        iPhone meuIphone = new iPhone();

        meuIphone.selecionarMusica("Bohemian Rhapsody");
        meuIphone.tocar();
        meuIphone.pausar();

        meuIphone.ligar("11999999999");
        meuIphone.atender();
        meuIphone.iniciarCorreioVoz();

        meuIphone.exibirPagina("https://apple.com");
        meuIphone.adicionarNovaAba();
        meuIphone.atualizarPagina();
    }
}
