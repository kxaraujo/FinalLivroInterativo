import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Capitulo {
    private String texto;
    protected ArrayList<Escolha> escolhas;
    private Personagem personagem1;
    private Personagem personagem2;
    private int variacaoEnergiaPersonagem1;
    private int variacaoEnergiaPersonagem2;

    public Capitulo(String texto,
            Personagem personagem1,
            Personagem personagem2,
            int incrementoPersonagem1,
            int incrementoPersonagem2) {
        this.texto = texto;
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;
        this.variacaoEnergiaPersonagem1 = incrementoPersonagem1;
        this.variacaoEnergiaPersonagem2 = incrementoPersonagem2;
        this.escolhas = new ArrayList<Escolha>();
    }

    public Capitulo(
            Map<String, Personagem> personagem,
            Scanner escaneador) {

        this.lerCapitulo(personagem, escaneador);
        this.escolhas = new ArrayList<>();
    }

    protected Capitulo() {
        this.texto = "";
        this.escolhas = new ArrayList<Escolha>();
    }

    public String getTexto() {
        return this.texto;
    }

    protected void lerCapitulo(
            Map<String, Personagem> personagens,
            Scanner escaneador) {
        escaneador.nextLine();
        String idPerson1 = escaneador.nextLine();
        String idPerson2 = escaneador.nextLine();
        this.personagem1 = personagens.get(idPerson1);
        this.personagem2 = personagens.get(idPerson2);

        escaneador.nextLine();

        String linha = escaneador.nextLine();
        this.texto = "";
        while (!linha.equals("VARIACOES")) {
            if (linha.equals(idPerson1)) {
                texto = texto + personagem1.getNome();
            } else if (linha.equals(idPerson2)) {
                texto = texto + personagem2.getNome();
            } else {
                texto = texto + linha;
            }
            linha = escaneador.nextLine();

        }

        this.variacaoEnergiaPersonagem1 = Integer.parseInt(escaneador.nextLine());
        this.variacaoEnergiaPersonagem2 = Integer.parseInt(escaneador.nextLine());
    }

    ArrayList<Escolha> getEscolhas() {
        return this.escolhas;
    }

    Personagem getPersonagem1() {
        return this.personagem1;
    }

    Personagem getPersonagem2() {
        return this.personagem2;
    }

    int getVariacaoEnergiaPersonagem1() {
        return this.variacaoEnergiaPersonagem1;
    }

    int getVariacaoEnergiaPersonagem2() {
        return this.variacaoEnergiaPersonagem2;
    }
}