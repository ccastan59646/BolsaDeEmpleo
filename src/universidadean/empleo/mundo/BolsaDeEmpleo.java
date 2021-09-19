/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�a de la Informaci�n y Comunicaciones
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
 * En el vector de aspirantes no hay dos o m�s con el mismo nombre
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
    // M�todos
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
     * @param profesionA        La profesi�n del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA A�os de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El tel�fono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @return Se retorn� true si el aspirante fue adicionado o false de lo contrario
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
     * <b>post: </b>La lista de aspirantes est� ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        // TODO: Realizar el ejercicio correspondiente
        // Se declara la variable num_espirantes y retorna el n�mero de elementos de la lista aspirantes - 1.
        int num_aspirantes = aspirantes.size()-1;
        // Se declara una variable min como referencia para que exista una m�nima comparaci�n > 0 de aspirantes
        int min = 0;
        // Se recorre la lista de aspirantes iniciando en 0 hasta aspirantes.size()-1
        for (int i = 0; i < num_aspirantes; i++) {
            // Se recorrre nuevamente la lista de num_aspirantes - i
            for (int j = 0; j < (num_aspirantes - i); j++) {
                // Se utiliza el m�todo compareTo() para comparar el arrayList seg�n los recorridos de cada bucle.
                // Y debe ser mayor a 0
                if(aspirantes.get( j+1 ).darNombre().compareTo(aspirantes.get( j ).darNombre()) > min) {
                    Aspirante aumenta = aspirantes.get(j + 1);
                    // Reemplaza el elemento en la posici�n especificada en esta lista con el elemento especificado
                    aspirantes.set(j + 1, aspirantes.get(j));
                    aspirantes.set(j, aumenta);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selecci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por edad
     */
    public void ordenarPorEdad() {
        // TODO: Realizar el ejercicio correspondiente
        // Se asigna la clase aspirante.
        Aspirante asp;
        // Se declara variable num_aspirantes al n�mero de elementos de la lista.
        int num_aspirantes = aspirantes.size();
        // Se recorre el primer bucle desde 0 y menor al n�mero de aspirantes.
        for(int i = 0; i < num_aspirantes; i++){
            // Se recorre el segundo bucle, iniciando con i+1
            for(int j = i+1; j < num_aspirantes; j++){
                // Condici�n de la edad del segundo bucle en j debe ser menor para la edad en bucle en i.
                if(aspirantes.get(j).darEdad() < aspirantes.get(i).darEdad()){
                    asp = aspirantes.get(j);
                    // Reemplaza el elemento en la posici�n especificada en esta lista con el elemento especificado
                    aspirantes.set(j, aspirantes.get(i));
                    aspirantes.set(i,asp);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por profesi�n usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesi�n
     */
    public void ordenarPorProfesion() {
        // TODO: Realizar el ejercicio correspondiente
        // Se asigna la clase aspirante.
        Aspirante asp;
        // Se declara una variable min como referencia para que exista una m�nima comparaci�n > 0 de aspirantes
        int min = 0;
        // Se recorre el primer bucle desde 0 y menor al n�mero de aspirantes.
        for(int i = 0;i < aspirantes.size()-1;i++){
            // Se recorre el primer bucle desde 0 y menor al n�mero de aspirantes.
            for(int j = 0;j < aspirantes.size()-i-1;j++){
                // Se utiliza el m�todo compareTo() para comparar el arrayList seg�n los recorridos de cada bucle.
                // Y debe ser mayor a 0
                if(aspirantes.get(j+1).darProfesion().compareTo(aspirantes.get(j).darProfesion()) < min){
                    asp = aspirantes.get(j+1);
                    // Reemplaza el elemento en la posici�n especificada en esta lista con el elemento especificado
                    aspirantes.set(j+1,aspirantes.get(j));
                    aspirantes.set(j,asp);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por a�os de experiencia usando el algoritmo de inserci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por a�os de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
        // TODO: Realizar el ejercicio correspondiente
        // Se declara variable num_aspirantes al n�mero de elementos de la lista.
        int num_aspirantes = aspirantes.size();
        // Se recorre el primer bucle desde 0 y menor al n�mero de aspirantes.
        for (int i = 1; i < num_aspirantes; i++) {
            // se asigna la clase Aspirante, retorna el elemento espcificado (del bucle i) de la lista.
            Aspirante x_asp = aspirantes.get(i);
            // Se resta uno a cada recorrido en el bucle.
            int j = i - 1;
            // Se usa un while || mientras cumpla las condiciones darAniosExperencia - 1
            while ((j > - 1) && (aspirantes.get(j).darAniosExperiencia() > (x_asp.darAniosExperiencia()))) {
                // Reemplaza el elemento en la posici�n especificada en esta lista con el elemento especificado
                aspirantes.set(j + 1, aspirantes.get(j));
                // Se resta en J
                j--;
            }
            // Se setea aspirantes a j+1 y x_asp (Por aspirante)
            aspirantes.set(j + 1, x_asp);
        }
    }

    /**
     * Busca un Aspirante seg�n su nombre y retorna la posici�n en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retorn� la posici�n donde se encuentra un aspirante con el nombre dado. Si no se encuentra ning�n aspirante con ese nombre se retorn� -1.
     */
    public int buscarAspirante(String nombre) {
        int posicion = -1;
        // TODO: Realizar el ejercicio correspondiente
        // Se declara una variable contador que se inicializa en 0.
        int count = 0;
        // Se recorre el bucle del arrayList Aspirante
        for (Aspirante asp:aspirantes) {
            // Condici�n del nombre ingresado es igual al m�todo darNombre que recorre cada uno.
            if(asp.darNombre().equals(nombre)){
                // Se asigna el valor de contador a posicion.
                posicion = count;
            }
            // Aumenta el contador
            count++;
        }
        return posicion;
    }

    /**
     * Busca un aspirante utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retorn� la posici�n del aspirante con el nombre dado. Si el aspirante no existe se retorn� -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        int posicion = -1;
        int ini = 0;
        int fin = aspirantes.size() - 1;

        // TODO: Realizar el ejercicio correspondiente
        // Mientras inicio (cero) sea mejor o igual al n�mero de aspirantes -1
        while (ini <= fin) {
            // se promedia la posici�n
            posicion = (ini+fin) / 2;
            // Compara dos strings || nombre de cada aspirante con nombre ingresado
            if ( aspirantes.get(posicion).darNombre().equalsIgnoreCase(nombre) )
                // Retorna posicion.
                return posicion;
            // si no, debe cumplir devuelve el valor de car�cter en el �ndice especificado. del nombre ingresado
            // con respecto al nombre seg�n posici�n
            else if ( aspirantes.get(posicion).darNombre().charAt(0) < nombre.charAt(0) ) {
                // Reasigna ini a posici�n + 1
                ini = posicion+1;
            } else {
                // Si no cumple // Reasigna ini a posici�n + 1
                fin = posicion-1;
            }
        }

        return posicion;
    }


    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante m�s joven. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMasJoven() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        // Se declara variable edad (Edad m�xima ejemplo)
        int edad = 100;
        // Se declara variable contador que empieza en Cero.
        int count = 0;
        // Se recorre en bucle el arrayList de Aspirante
        for (Aspirante asp:aspirantes) {
            // Se eval�a se la edad de cada aspirante es menor a la edad m�xima definida anteriormente
            if(asp.darEdad() < edad){
                // Se asigna cada darEdad() a edad.
                edad = asp.darEdad();
                // Se reasigna posici�n
                posicion = count;
            }
            // Se incrementa el contador
            count++;
        }
        return posicion;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con m�s edad. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorEdad() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        // Se declara variable edad (Edad m�nima laboral ejemplo)
        int edad = 18;
        // Se declara variable contador que empieza en Cero.
        int count = 0;
        // Se recorre en bucle el arrayList de Aspirante
        for (Aspirante asp:aspirantes) {
            // Se eval�a se la edad de cada aspirante es mayor a la edad m�xima (18 a�os) definida anteriormente
            if(asp.darEdad() > edad){
                // Se asigna cada darEdad() a edad.
                edad = asp.darEdad();
                // Se reasigna posici�n
                posicion = count;
            }
            // Se incrementa el contador
            count++;
        }
        return posicion;
    }

    /**
     * Busca el aspirante con m�s a�os de experiencia en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con mayor experiencia. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        // Se declara variable num_aspirantes al n�mero de elementos de la lista.
        int num_aspirantes = aspirantes.size();
        // Se declara variable minima experiencia en cero (Para la condici�n de que sea mayor a cero)
        int min_exp = 0;
        // Se recorre el primer bucle desde 0 y menor al n�mero de aspirantes.
        for(int i = 0; i < num_aspirantes; i++) {
            // Condici�n que eval�a los a�os de experiencia sean superior a cero.
            if(aspirantes.get(i).darAniosExperiencia() > min_exp ){
                // Se asigna nuevamente el valor de los a�os de expericencia de cada aspirante a min_exp
                min_exp = aspirantes.get(i).darAniosExperiencia();
                // SE reasigna posici�n con cada iteraci�n de aspirante.
                posicion = i;
            }
        }
        return posicion;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se elimin� el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retorn� true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;

        // TODO: Realizar el ejercicio correspondiente
        // Se define variable con el m�todo buscarAspirante pasando el argumento nombre.
        int posicion = buscarAspirante(nombre);
        // Se declara posicion en -1
        int psc = -1;
        // S� la posici�n es diferente a -1 entra al condicional
        if (psc != posicion) {
            // El booleano contratado cambia a true
            contratado = true;
            // se remueve la posici�n del aspirante con el m�todo remove()
            var remove = aspirantes.remove(posicion);
        }
        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos a�os de experiencia <br>
     * son menores a la cantidad de a�os especificada <br>
     *
     * @param aniosExperiencia La cantidad de a�os con relaci�n a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;

        // TODO: Realizar el ejercicio correspondiente
        // Se declara variable num_aspirantes al n�mero de elementos de la lista.
        int num_aspirantes = aspirantes.size()-1;
        // Se recorre el primer bucle desde el n�mero de aspirantes -1 y debe ser mayor a cero y disminuye con respecto
        // a num_aspirtantes
        for (int i = num_aspirantes; i >= 0; i--) {
            // S� los a�os de experiencia ingresados son iguales a los que tenga el aspirante cumple la condici�n
            if (aspirantes.get(i).darAniosExperiencia() == aniosExperiencia) {
                // remueve el aspirante.
                aspirantes.remove(i);
                // incrementa eliminados.
                eliminados++;
            }
        }
        return eliminados;
    }

}