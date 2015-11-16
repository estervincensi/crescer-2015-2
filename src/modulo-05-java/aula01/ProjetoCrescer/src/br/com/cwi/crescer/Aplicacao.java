package br.com.cwi.crescer;

public class Aplicacao {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.addLast("quarto");
        linkedList.add(1, "teste");
        linkedList.remove(1);

        // Scanner scanner = new Scanner(System.in);
        // String str = scanner.nextLine();
        // int num = scanner.nextInt();

        // System.out.println(str);
        // System.out.println(num);

        System.out.println(linkedList.list());
    }
}
