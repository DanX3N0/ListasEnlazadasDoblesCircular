
public class Main {
   public static void main(String[] args) {
      
      ListaDobleCircular lista = new ListaDobleCircular();

      lista.insertarInicio(5);
      lista.insertarInicio(2);
      lista.insertarInicio(10);
      lista.insertarInicio(7);

      lista.mostrarLista();
      //System.out.println("******************************************");
      //lista.ordenarLista();
      //lista.mostrarLista();
      
      System.out.println("******************************************");
      lista.eliminarPosicion(1);
      lista.mostrarLista();

   }
}
