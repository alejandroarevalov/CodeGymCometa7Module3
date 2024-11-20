package com.codegym.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyFloat;

@ExtendWith(MockitoExtension.class)
public class ServicioAtencionEstudiantesTest {

    @InjectMocks
    private ServicioAtencionEstudiantes servicioAtencionEstudiantes;
    @Mock
    private BaseDeDatosEstudiantes baseDeDatosEstudiantesMock;

    /*
    @BeforeEach
    public void inicializar() {
        baseDeDatosEstudiantesMock = Mockito.mock(BaseDeDatosEstudiantes.class);
        servicioAtencionEstudiantes = new ServicioAtencionEstudiantes(baseDeDatosEstudiantesMock);
    }
    */


    /**
     * AAA (JUnit) ->
     * Acomodar
     * Actuar
     * Aseverar - Asegurar
     *
     * GIVEN => WHEN => THEN (Mockito)
     * (Dadas unas condiciones iniciales, cuando algo suceda (lo que queremos probar),
     * entonces evaluamos los resultados obtenidos y los comparamos con resultados esperados
     */
    @Test
    public void deberiaObtenerCadenaConAlgunosNombresDeEstudiantesDeLaBaseDeDatos() {
        // GIVEN
        String nombreEsperado1 = "Alejandro Arevalo";
        String nombreEsperado2 = "Rafael Corona";
        List<Estudiante> estudiantesEsperados = List.of(
            new Estudiante(nombreEsperado1, 5.0f),
            new Estudiante(nombreEsperado2, 4.5f)
        );

        // WHEN
        // Simulacion de la invocacion de el metodo interno del mock
        Mockito.when(baseDeDatosEstudiantesMock.obtenerTodosLosEstudiantes()).thenReturn(estudiantesEsperados);
        String resultado = servicioAtencionEstudiantes.obtenerTodosLosEstudiantesParaImprimir();

        // THEN
        Assertions.assertNotNull(resultado);
        Assertions.assertTrue(resultado.contains(nombreEsperado1));
        Assertions.assertTrue(resultado.contains(nombreEsperado2));
        Assertions.assertTrue(resultado.charAt(0) == '{');
        Assertions.assertTrue(resultado.charAt(resultado.length() - 1) == '}');
    }

    @Test
    public void deberiaObtenerUnaCadenaVaciaPorEstudiantesNoExistentesConCalificacionSuperiorAUmbral() {
        // GIVEN
        float umbral = 3.9f;
        // WHEN
        Mockito.doReturn(List.of()).when(baseDeDatosEstudiantesMock)
            .obtenerEstudiantesConCalificacionSuperiorA(anyFloat());
        String resultado = servicioAtencionEstudiantes.obtenerEstudiantesDestacadosParaImprimir(umbral);
        // THEN
        Assertions.assertEquals("", resultado);
    }

    @Test void deberiaObtenerUnaCadenaConEstudiantesQueTienenCalificacionSuperiorAUmbral() {
        // Given
        float umbral = 3.9f;
        String nombreEsperado1 = "Alejandro Arevalo";
        String nombreEsperado2 = "Rafael Corona";
        List<Estudiante> estudiantesEsperados = List.of(
            new Estudiante(nombreEsperado1, 5.0f),
            new Estudiante(nombreEsperado2, 4.5f)
        );
        // WHEN
        Mockito.when(baseDeDatosEstudiantesMock.obtenerEstudiantesConCalificacionSuperiorA(anyFloat()))
            .thenReturn(estudiantesEsperados);
        String resultado = servicioAtencionEstudiantes.obtenerEstudiantesDestacadosParaImprimir(umbral);

        // THEN
        Assertions.assertTrue(resultado.contains(nombreEsperado1));
        Assertions.assertTrue(resultado.contains(nombreEsperado2));
    }

    @Test
    public void deberiaObtenerUnEstudianteConSuNombreEnMayusculas() {
        Estudiante esperado = new Estudiante("Claudio Lopez", 3.0f);
        Mockito.doAnswer(invocation -> {
            String nombreEstudiante = esperado.getNombre();
            nombreEstudiante = nombreEstudiante.toUpperCase();
            esperado.setNombre(nombreEstudiante);
            return esperado;
        }).when(baseDeDatosEstudiantesMock)
            .obtenerEstudiantePorNombre(ArgumentMatchers.anyString());
        String resultado = servicioAtencionEstudiantes
            .obtenerEstudiantePorNombreParaImprimir("Claudio Lopez");
        Assertions.assertTrue(resultado.contains(esperado.getNombre()));
        Mockito.verify(baseDeDatosEstudiantesMock, Mockito.times(1))
            .obtenerEstudiantePorNombre(ArgumentMatchers.anyString());
    }

    @Test
    public void deberiaInsertarTresEstudiantesCorrectamente() {
        // Given
        int cantidadEstudiantesAInsertar = 3;
        // When
        Mockito.doNothing().when(baseDeDatosEstudiantesMock).agregarEstudiante(Mockito.anyString(), anyFloat());
        servicioAtencionEstudiantes.agregarEstudiantes(cantidadEstudiantesAInsertar);
        // Then

        // Esto genera error porque el metodo verify con un unico parametro verifica la ejecucion del
        // metodo simulado 1 unica vez
        // Mockito.verify(baseDeDatosEstudiantes).agregarEstudiante(Mockito.anyString(), Mockito.anyFloat());

        Mockito.verify(baseDeDatosEstudiantesMock, Mockito.times(cantidadEstudiantesAInsertar))
            .agregarEstudiante(Mockito.anyString(), anyFloat());
    }

    // MOCKEANDO LLAMADAS A METODOS ESTATICOS
    @Test
    public void deberiaRetornarEstudianteSinInformacion() {
        // Se debe usar un try with resources
        // Given
        Estudiante estudianteEsperadoSinInformacion = new Estudiante();
        try (MockedStatic<BaseDeDatosEstudiantes> baseDeDatosStatic =
                 Mockito.mockStatic(BaseDeDatosEstudiantes.class)) {

            // When
            baseDeDatosStatic.when(BaseDeDatosEstudiantes::obtenerEstudianteSinInformacion)
                .thenCallRealMethod(); // Estamos llamando al metodo real, para que ejecute lo que está programado allí
            Estudiante resultado = servicioAtencionEstudiantes.obtenerEstudianteSinInformacion();

            // Then
            Assertions.assertEquals(estudianteEsperadoSinInformacion, resultado);
        }
    }



}
