import javafx.scene.control.Button;

/**
 * Aqui a gente cria um "sub-tipo" de botão específico só para as escolhas
 * diferente do botão "start", esse recebe informações do dicionário (neste caso
 * as escolhas)
 * e coloca no texto dele
 */
public class BotaoEscolha extends Button {

  private Escolha escolha;

  public BotaoEscolha(Escolha escolha) {

    super(escolha.getTextoMostrado());
    this.escolha = escolha;
  }

  public Escolha getEscolha() {
    return this.escolha;
  }
}
