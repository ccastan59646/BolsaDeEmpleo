/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 11 de marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo;

import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes <br>
 * <b>inv: </b> <br>
 * aspirantes != null <br>
 * En el vector de aspirantes no hay dos o más con el mismo nombre
 */
public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private ArrayList<Aspirante> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    public BolsaDeEmpleo() {
        aspirantes = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public ArrayList<Aspirante> darAspirantes() {
        ArrayList<Aspirante> copia = new ArrayList<>(aspirantes);
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesión del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA Años de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El teléfono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @return Se retornó true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA) {
        int aspiranteBuscado = buscarAspirante(nombreA);
        boolean agregado = false;
        if (aspiranteBuscado == -1) {
            Aspirante nuevoAspirante = new Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
            aspirantes.add(nuevoAspirante);
            agregado = true;
        }

        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes está ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        // TODO: Realizar el ejercicio correspondiente
        // Se declara la variable num_espirantes y retorna el número de elementos de la lista aspirantes - 1.
        int num_aspirantes = aspirantes.size()-1;
        // Se declara una variable min como referencia para que exista una mínima comparación > 0 de aspirantes
        int min = 0;
        // Se recorre la lista de aspirantes iniciando en 0 hasta aspirantes.size()-1
        for (int i = 0; i < num_aspirantes; i++) {
            // Se recorrre nuevamente la lista de num_aspirantes - i
            for (int j = 0; j < (num_aspirantes - i); j++) {
                // Se utiliza el método compareTo() para comparar el arrayList según los recorridos de cada bucle.
                // Y debe ser mayor a 0
                if(aspirantes.get( j+1 ).darNombre().compareTo(aspirantes.get( j ).darNombre()) > min) {
                    Aspirante aumenta = aspirantes.get(j + 1);
                    // Reemplaza el elemento en la posición especificada en esta lista con el elemento especificado
                    aspirantes.set(j + 1, aspirantes.get(j));
                    aspirantes.set(j, aumenta);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selección <br>
     * <b>post: </b>La lista de aspirantes está ordenada por edad
     */
    public void ordenarPorEdad() {
        // TODO: Realizar el ejercicio correspondiente
        // Se asigna la clase aspirante.
        Aspirante asp;
        // Se declara variable num_aspirantes al número de elementos de la lista.
        int num_aspirantes = aspirantes.size();
        // Se recorre el primer bucle desde 0 y menor al número de aspirantes.
        for(int i = 0; i < num_aspirantes; i++){
            // Se recorre el segundo bucle, iniciando con i+1
            for(int j = i+1; j < num_aspirantes; j++){
                // Condición de la edad del segundo bucle en j debe ser menor para la edad en bucle en i.
                if(aspirantes.get(j).darEdad() < aspirantes.get(i).darEdad()){
                    asp = aspirantes.get(j);
                    // Reemplaza el elemento en la posición especificada en esta lista con el elemento especificado
                    aspirantes.set(j, aspirantes.get(i));
                    aspirantes.set(i,asp);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por profesión usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesión
     */
    public void ordenarPorProfesion() {
        // TODO: Realizar el ejercicio correspondiente
        // Se asigna la clase aspirante.
        Aspirante asp;
        // Se declara una variable min como referencia para que exista una mínima comparación > 0 de aspirantes
        int min = 0;
        // Se recorre el primer bucle desde 0 y menor al número de aspirantes.
        for(int i = 0;i < aspirantes.size()-1;i++){
            // Se recorre el primer bucle desde 0 y menor al número de aspirantes.
            for(int j = 0;j < aspirantes.size()-i-1;j++){
                // Se utiliza el método compareTo() para comparar el arrayList según los recorridos de cada bucle.
                // Y debe ser mayor a 0
                if(aspirantes.get(j+1).darProfesion().compareTo(aspirantes.get(j).darProfesion()) < min){
                    asp = aspirantes.get(j+1);
                    // Reemplaza el elemento en la posición especificada en esta lista con el elemento especificado
                    aspirantes.set(j+1,aspirantes.get(j));
                    aspirantes.set(j,asp);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por años de experiencia usando el algoritmo de inserción <br>
     * <b>post: </b>La lista de aspirantes está ordenada por años de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
        // TODO: Realizar el ejercicio correspondiente
        // Se declara variable num_aspirantes al número de elementos de la lista.
        int num_aspirantes = aspirantes.size();
        // Se recorre el primer bucle desde 0 y menor al número de aspirantes.
        for (int i = 1; i < num_aspirantes; i++) {
            // se asigna la clase Aspirante, retorna el elemento espcificado (del bucle i) de la lista.
            Aspirante x_asp = aspirantes.get(i);
            // Se resta uno a cada recorrido en el bucle.
            int j = i - 1;
            // Se usa un while || mientras cumpla las condiciones darAniosExperencia - 1
            while ((j > - 1) && (aspirantes.get(j).darAniosExperiencia() > (x_asp.darAniosExperiencia()))) {
                // Reemplaza el elemento en la posición especificada en esta lista con el elemento especificado
                aspirantes.set(j + 1, aspirantes.get(j));
                // Se resta en J
                j--;
            }
            // Se setea aspirantes a j+1 y x_asp (Por aspirante)
            aspirantes.set(j + 1, x_asp);
        }
    }

    /**
     * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retornó la posición donde se encuentra un aspirante con el nombre dado. Si no se encuentra ningún aspirante con ese nombre se retornó -1.
     */
    public int buscarAspirante(String nombre) {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente

        return posicion;
    }

    /**
     * Busca un aspirante utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retornó la posición del aspirante con el nombre dado. Si el aspirante no existe se retornó -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        int posicion = -1;
        int ini = 0;
        int fin = aspirantes.size() - 1;

        // TODO: Realizar el ejercicio correspondiente

        return posicion;
    }


    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante más joven. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMasJoven() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente

        return posicion;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con más edad. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorEdad() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente

        return posicion;
    }

    /**
     * Busca el aspirante con más años de experiencia en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con mayor experiencia. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente

        return posicion;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se eliminó el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retornó true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;

        // TODO: Realizar el ejercicio correspondiente

        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos años de experiencia <br>
     * son menores a la cantidad de años especificada <br>
     *
     * @param aniosExperiencia La cantidad de años con relación a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;

        int cont = 0;

        // TODO: Realizar el ejercicio correspondiente

        return eliminados;
    }

}