package src;

import java.util.Scanner;

public class ListaDoble {

    private Nodo P;
    private Nodo F;
    private int size;

    private class Nodo {
        private String data;
        private Nodo sig;
        private Nodo ant;

        public Nodo(String data) {
            this.data = data;
        }
    }

    public ListaDoble() {
        this.P = null;
        this.F = null;
        this.size = 0;
    }


    // ! Inicializar / Borrar lista
    public boolean inicializar() {
        Nodo temp = P;
        while(temp != null){
            Nodo siguiente = temp.sig;
            temp.ant = null;
            temp.sig = null;

            temp = siguiente;
        }

        P = null;
        F = null;
        size = 0;

        return true;
    }

    // ! MOSTRAR ACENDENTE O DECENDENTE

    public void mostrarAD(int orden) {
        if (orden == 1) {
            Nodo temp = P;
            imprimir(temp, orden);

        } else if (orden == 2) {
            Nodo temp = F;
            imprimir(temp, orden);
        }
    }

    public void imprimir(Nodo temp, int orden) {
        if (orden == 1) {
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.sig;
            }
        } else if (orden == 2) {
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.ant;
            }
        }
    }

// ! Insertar al inicio manteniendo el orden alfabético
public void insertI(String data) {
    Nodo nuevo = new Nodo(data);

    if (P == null || data.compareTo(P.data) <= 0) {
        nuevo.sig = P;
        if (P != null) {
            P.ant = nuevo;
        } else {
            F = nuevo;
        }
        P = nuevo;
    } else {
        Nodo temp = P;

        while (temp.sig != null && data.compareTo(temp.sig.data) > 0) {
            temp = temp.sig;
        }

        nuevo.sig = temp.sig;
        nuevo.ant = temp;
        if (temp.sig != null) {
            temp.sig.ant = nuevo;
        } else {
            F = nuevo;
        }
        temp.sig = nuevo;
    }
    size++;
}

// ! Insertar al final manteniendo el orden alfabético
public void insertF(String v) {
    Nodo nuevo = new Nodo(v);

    if (F == null || v.compareTo(F.data) >= 0) {
        nuevo.ant = F;
        if (F != null) {
            F.sig = nuevo;
        } else {
            P = nuevo;
        }
        F = nuevo;
    } else {
        Nodo temp = F;

        while (temp.ant != null && v.compareTo(temp.ant.data) < 0) {
            temp = temp.ant;
        }

        nuevo.ant = temp.ant;
        nuevo.sig = temp;
        if (temp.ant != null) {
            temp.ant.sig = nuevo;
        } else {
            P = nuevo;
        }
        temp.ant = nuevo;
    }
    size++;
}


// ! Modificar elemento
public void modificar(String v, String nuevo) {
    int posicion = buscar(v);
    if(posicion == -1){
        System.out.println("No se encontró el elemento");
        return;
    }
    eliminar(v);
    insertI(nuevo);
}




    // ! ELIMINAR ELEMENTO
    public void eliminar(String v) {
        int posicion = buscar(v);
    
        if (posicion == -1) {
            System.out.println("No se encontró el elemento");
            return;
        }
    
        Nodo temp = P;
    
        while (posicion != 0) {
            temp = temp.sig;
            posicion--;
        }
    
        if (temp.ant != null) {
            temp.ant.sig = temp.sig;
        } else {
            P = temp.sig;
            if (P != null) {
                P.ant = null;
            } else {
                F = null; 
            }
        }
    
        if (temp.sig != null) {
            temp.sig.ant = temp.ant;
        } else {
            F = temp.ant;
            if (F != null) {
                F.sig = null;
            } else {
                P = null;  
            }
        }
    }
    

    // ! BUSCAR ELEMENTO
    public int buscaOptimizada(String v, int orden) {
        int posicion = 0;

        if (orden == 1) {
            Nodo temp = P;
            while (temp != null) {
                if (temp.data.equals(v)) {
                    return posicion;
                }
                posicion++;
                temp = temp.sig;
            }
        } else if (orden == 2) {
            Nodo temp = F;
            while (temp != null) {
                if (temp.data.equals(v)) {
                    return posicion;
                }
                posicion++;
                temp = temp.ant;
            }
        }
        return posicion;
    }

    public Integer buscar(String v) {
        Nodo temp = P;
        int posicion = 0;

        while (temp != null) {
            if (temp.data.equals(v)) {
                return posicion;
            }
            posicion++;
            temp = temp.sig;
        }

        return -1;
    }

}
