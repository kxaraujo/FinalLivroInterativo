import java.util.ArrayList;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;

public class Controlador {


    private Capitulo raiz;

    @FXML
    private Label asciiCap;
    // Caixinha que recebe a imagem ascii
    
    @FXML
    private ButtonBar escolhasBar;
    // Barrinha (vazia) onde serão criados os botões das escolhas

    @FXML
    private Button startBTN;
    // Botão da tela inicial (START), quando clica, ele some e começa os capítulos

    @FXML
    private Label textoCap;
    // Caixinha que recebe os textos dos capítulos

    /**
     * Essa parte eu tô criando os métodos pra aparecer e desaparecer elementos na interface.
     * A função deles estão comentadas abaixo deles
     */

    public void mostrarTextoCapitulo(String texto) {
        // Insere os textos dos capítulos na caixinha "textoCap", ele é usado mais pra baixo
        
        textoCap.setText(texto);
        // Nessa linha o método "setText()" muda o nome do objeto referenciado, nesse caso o "textoCap"
    }


    public void mostrarImagemAscii(String imagem) {
        // Esse método tem a mesma lógica do de cima, só que com as imagens ascii, mas
        // não consegui
        // fazer funcionar '-'
        asciiCap.setText(imagem);
    }

    @FXML
    void iniciarHistoria(ActionEvent event) {
        // Esse método é pra quando clicar no botão "START"
        Leitor leitor = new Leitor();

        Map<String, Personagem> personagens = leitor.carregarPersonagens("rsc/Personagens.txt");
        // Carrega o dicionário de personagens

        Map<String, Capitulo> capitulos = leitor.carregarCapitulos("rsc/Capitulos.txt", personagens);
        // Carrega o dicionário de capitulos

        raiz = capitulos.get("Vixi, que coisa estranha!");

        mostrarCapitulo(raiz);
        // Usando o método para mostrar o texto do capítulo na caixinha



        /**
         * Esses três de baixo funciona assim:
         * Nome_do_objeto.setVisible(true / false)
         * 
         * O "Nome_do_objeto", é o nome dos elementos da interface,
         * você coloca o nome referenciando o que você quer manipular
         * 
         * ".setVisible", é um método para mudar a "visibilidade" do elemento
         * referênciado
         * (true) - o elemento referenciado fica visível / (false) invisível
         */

        startBTN.setVisible(false);
        // Deixando o botão Start invisível quando clica nele


        asciiCap.setVisible(true);
        // Barrinha da imagem ascii ficando visível
    }










    private void mostrarCapitulo(Capitulo capitulo) {

        mostrarTextoCapitulo(capitulo.getTexto());
        mostrarEscolhas(capitulo.getEscolhas());
    }










    /**
     * A seguir, vai começar a criar os botões das perguntas.
     * 
     * Lembra que te falei que usava o "Buttonbar" pra os botões das escolhas? Então, nós vamos usar ele agora.
     * 
     * Lembrando que "Button" é só um botão. Já o "ButtonBar", é um ORGANIZADOR de botões.
     * 
     * Primeiro vamos criar o método pra fazer as maracutaias
     */

    public void mostrarEscolhas(ArrayList<Escolha> escolhas) {
        // Aqui ele acessa o dicionário das escolhas

        escolhasBar.getButtons().clear();
        // "escolhasBar" foi o nome que a gente deu para o "ButtonBar"
        // ".getButtons()" vai selecionar os botões dentro dele pra manipular
        // ".clear()" vai escluir eles
        // Precisa usar isso por que se não usar, a cada novo capítulo vai aparecer um novo botão,
        // e os botões do capitulo anterior continuarão na tela


        escolhasBar.setPadding(new Insets(10));
        // Isso aqui é só pra eles terem uma distanciazinha de um pro outro, pra não ficarem roçando


        for (int i = 0; i < escolhas.size(); i++) {
            // O que tiver aqui dentro só vai acontecer enquanto existir "escolhas" no capítulo atual

            BotaoEscolha botao = new BotaoEscolha(escolhas.get(i));
            // Cria os botões na quantidade de escolhas, cada um com uma escolha
            
            
            botao.setOnAction(new EventHandler<ActionEvent>() {
                // Define o que acontece quando clica no botão

                @Override
                public void handle(ActionEvent event) {
                    // Quando clica em uma escolha
                    
                    System.out.println(botao.getText());
                    //Esse é só pra ver se o botão tá funcionando. 
                    //Ele vai imprimir no console o que estiver escrito no botão clicado


                    mostrarCapitulo(botao.getEscolha().getProximo());
                    // redireciona para o capítulo pre-definido como próximo

                }
            });

            /**
             * Lá em cima a gente criou o método de criar botões com as escolhas,
             * agora nós vamos usa-lo.
             * 
             * De novo:
             * "escolhasBar" para manipula-lo
             * ".getButtons()" para pegar todos os botões dentro dele (que no caso não vai ter nenhum, mas tudo bem)
             * ".add(botao)" para criar os botoes na tela
             */
            escolhasBar.getButtons().add(botao);
            
        }

    }
}
