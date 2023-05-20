import org.w3c.dom.traversal.NodeIterator;

public class ListaDobleCircular {
   
   public NodoDoble primero;
   public NodoDoble ultimo;
   public Integer size;

   public ListaDobleCircular(){
      this.primero = null;
      this.ultimo = null;
      this.size = 0;
   }
   
   public boolean empty(){
      if(size == 0)
         return true;
      return false;
   }

   public void insertarInicio(Integer dato){
      NodoDoble tmp = new NodoDoble(dato);
      if(empty()){
         primero = tmp;
         ultimo = tmp;
         primero.siguiente = primero;
      }else{
         tmp.siguiente = primero;
         primero.anterior = tmp;
         primero = tmp;
         ultimo.siguiente = primero;
         primero.anterior = ultimo;
      }
      size++;
   }

   public void mostrarLista(){
      NodoDoble tmp = primero;
      do{
         System.out.print(tmp.dato + " ");
         tmp = tmp.siguiente;
      }while(tmp != primero);
      System.out.println();
   }

   public void ordenarLista(){
      NodoDoble tmp = primero;
      do{
         NodoDoble tmp2 = primero;
         while(tmp2.siguiente != primero){   
            if(tmp2.dato > tmp2.siguiente.dato){
               int aux = tmp2.dato;
               tmp2.dato = tmp2.siguiente.dato;
               tmp2.siguiente.dato = aux;
            }
            tmp2 = tmp2.siguiente;
         };
         tmp = tmp.siguiente;
      }while(tmp != primero);

   }

   public void eliminarInicio(){
      if(!empty()){
         primero = primero.siguiente;
         ultimo.siguiente = primero;
         primero.anterior = ultimo;
      }
   }

   public void eliminarUltimo(){
      if(!empty()){
         ultimo = ultimo.anterior;
         primero.anterior = ultimo;
         ultimo.siguiente = primero;
      }
   }

   public void eliminarElemento(Integer dato){
      boolean encontrado = false;
      if(primero.dato == dato){
         eliminarInicio();
      }else if(ultimo.dato == dato){
         eliminarUltimo();
      }else{
         NodoDoble tmp = primero;
         do{
            if(tmp.dato == dato){
               tmp.anterior.siguiente = tmp.siguiente;
               tmp.siguiente.anterior = tmp.anterior;
               encontrado = true;
            }
            tmp = tmp.siguiente;
         }while(tmp != primero);
      }

      if(!encontrado)
         System.out.println("No se hallo el elemento");
   }

   public void eliminarPosicion(Integer posicion){
      int contador = 0;

      if(posicion == 0){
         eliminarInicio();
      }else if(posicion == size - 1){
         eliminarUltimo();
      }else{
         NodoDoble tmp = primero;
         do{

            if(contador == posicion){
               tmp.anterior.siguiente = tmp.siguiente;
               tmp.siguiente.anterior = tmp.anterior;
            }

            tmp = tmp.siguiente;
            contador++;
         }while(tmp != primero);
      }

   }






























}
