import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
public class App
{
public static void main(String[] args) throws FileNotFoundException 
{
   
//==================================================================================================================
// Arquivo Personagens
//==================================================================================================================
        Scanner scanner = new Scanner(System.in, "CP850");        

        LeitorDeArquivos leitor = new LeitorDeArquivos();

        //Carrega o dicionário de personagens
        Map<String, Personagem> personagens = leitor.carregarPersonagens("rsc/Personagens.txt");

//==================================================================================================================
// Arquivo Capítulos
//==================================================================================================================

        Scanner escaneador = new Scanner(System.in);
        
        Map<String, Capitulo> capitulos = leitor.carregarCapitulos("rsc/Capitulos.txt", personagens, escaneador);
        //Carrega o dicionário de capitulos
        
        Capitulo raiz = capitulos.get("Vixi, que coisa estranha!");

        System.out.println();

        raiz.executar();

        scanner.close();
}
}