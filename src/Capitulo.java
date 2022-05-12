import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

    public class Capitulo 
    {
        private String texto;
        protected ArrayList<Escolha> escolhas; // Escolha[] escolhas;
        private Personagem personagem1;
        private Personagem personagem2;
        private int variacaoEnergiaPersonagem1;
        private int variacaoEnergiaPersonagem2;
        protected Scanner escaneador; 
        
//==================================================================================================================

        public Capitulo(String texto, 
                        Personagem personagem1, 
                        Personagem personagem2, 
                        int incrementoPersonagem1, 
                        int incrementoPersonagem2,
                        Scanner escaneador) 
        {
            this.texto = texto;
            this.personagem1 = personagem1;
            this.personagem2 = personagem2;
            this.variacaoEnergiaPersonagem1 = incrementoPersonagem1;
            this.variacaoEnergiaPersonagem2 = incrementoPersonagem2;
            this.escaneador = escaneador;
            this.escolhas = new ArrayList<Escolha>();
        }

        public Capitulo(
            Map<String, Personagem> personagem,
            Scanner escaneadorDoConsole,
            Scanner escaneador)
        {
            this.lerCapitulo(personagem, escaneador);
            this.escaneador = escaneadorDoConsole;
            this.escolhas = new ArrayList<>();
        }

        protected Capitulo()
        {
            this.texto = "";
            this.escolhas = new ArrayList<Escolha>();
        }

//==================================================================================================================
// lerCapitulo(); Usado para ler capitulos (ID, TEXTO, VARIAÇÃO DE ENERGIAS,...)
//==================================================================================================================


    protected void lerCapitulo(
        Map<String, Personagem> personagens,
        Scanner escaneador)

    {
    

        escaneador.nextLine(); // PERSONAGENS
        String idPerson1 = escaneador.nextLine();
        String idPerson2 = escaneador.nextLine();
        this.personagem1 = personagens.get(idPerson1);
        this.personagem2 = personagens.get(idPerson2);

        escaneador.nextLine(); // TEXTO

        String linha = escaneador.nextLine();
        this.texto = "";
        while (!linha.equals("VARIACOES")) 
        {
            if (linha.equals(idPerson1)) {
            texto = texto + personagem1.getNome();

        } 
        else if (linha.equals(idPerson2)) 
        {
            texto = texto + personagem2.getNome();
        } 
        else 
        {
            texto = texto + linha;
        }   
        linha = escaneador.nextLine();

    }

    this.variacaoEnergiaPersonagem1 = Integer.parseInt(escaneador.nextLine());
    this.variacaoEnergiaPersonagem2 = Integer.parseInt(escaneador.nextLine());
    

    
    }


            public void executar()
            {
                mostrar();
                
                if (getEscolhas().size() > 0)
                {

                    int idEscolhaCap = escolher();
                    escolhas.get(idEscolhaCap-1).getProximo().executar();
                }
                else
                {
                    System.out.println("CABOUSSE");
                }
            }

            protected void mostrar()
            {
                System.out.println(texto);
                personagem1.ajustarEnergia(variacaoEnergiaPersonagem1);
                personagem2.ajustarEnergia(variacaoEnergiaPersonagem2);
            
                for(int i = 0; i < escolhas.size(); i++)
                {
                    System.out.println("- " + escolhas.get(i).getTextoMostrado());
                }
                    
                System.out.println();
                System.out.println(". . .");
                System.out.println();
                // try {
                //     Thread.sleep(80);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }

            }

//==================================================================================================================

        // Mudei aqui
        private int escolher() 
        {
            int opcaoEscolhida = 0;
            String escolha;        
            boolean escolhaValida = false;
            
                while(!escolhaValida) 
                {
                    escolha = escaneador.nextLine();                
                    for(int i = 0; i < escolhas.size(); i++)
                    {                  
                        if(escolha.equalsIgnoreCase(escolhas.get(i).getTextoDigitado()))
                        {
                            escolhaValida = true;
                            opcaoEscolhida = i + 1;
                        }
                    }    
                    if(!escolhaValida) {
                        System.out.println("A escolha digitada não válida, digite novamente");
                    }
                }
            return opcaoEscolhida;
        }
//==================================================================================================================
// Criando métodos para usar os atributos, configurados como 'private', em outros lugares
//==================================================================================================================
        
                String getTexto(String texto)
                {
                    return this.texto;
                }
        
                ArrayList<Escolha> getEscolhas()
                {
                    return this.escolhas;
                }
        
                Personagem getPersonagem1()
                {
                    return this.personagem1;
                }
        
                Personagem getPersonagem2()
                {
                    return this.personagem2;
                }
        
                int getVariacaoEnergiaPersonagem1()
                {
                    return this.variacaoEnergiaPersonagem1;
                }
                
                int getVariacaoEnergiaPersonagem2()
                {
                    return this.variacaoEnergiaPersonagem2;
                }
    }