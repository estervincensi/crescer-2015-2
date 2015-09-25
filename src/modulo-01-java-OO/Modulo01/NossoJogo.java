
public class NossoJogo
{
    public final static String NOME = "Bahhh of the rings";//membros estáticos e constantes podem ser public

    public static void main(String args[]){
        try{
            System.out.println("Olá,"+args[0]);
        }catch(IndexOutOfBoundsException ioobe){
            System.out.println("Parâmetros não informados. Tente novamente.");
        }catch(Exception e){
            System.out.println("Deu erro. Contate o Administrador");
        }finally{
            System.out.println("De qualquer forma, seja bem vindo "+NOME);
        }
    }
}
