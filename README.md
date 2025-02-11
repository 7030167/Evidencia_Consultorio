### INSTALACION Y CONFIGURACION  

Descargar el JDK:

1. Visita el sitio web de Oracle y descarga la versión más reciente del JDK desde aquí:

https://www.oracle.com/mx/java/technologies/javase/javase8-archive-downloads.html

2. Instalar el JDK:

Ejecuta el instalador que descargaste y sigue las instrucciones en pantalla. La instalación predeterminada debería estar bien para la mayoría de los usuarios.

Asegúrate de recordar la ruta donde se instala el JDK (por ejemplo, C:\Program Files\Java\jdk-XX.X.X).

3. Configurar las variables de entorno:

- Abre el Panel de Control y navega a Sistema y Seguridad > Sistema > Configuración avanzada del sistema.

- En la ventana Propiedades del sistema, haz clic en el botón Variables de entorno.

- En la sección Variables del sistema, busca la variable llamada Path y edítala.

- Añade una nueva entrada a la lista que apunte a la carpeta bin del directorio de instalación del JDK. Por ejemplo, C:\Program Files\Java\jdk-XX.X.X\bin.

- Además, agrega una variable de entorno llamada JAVA_HOME con el valor del directorio de instalación del JDK, como C:\Program Files\Java\jdk-XX.X.X.

4. Verificar la instalación:

- Abre una terminal o línea de comandos y escribe el siguiente comando para verificar que Java esté instalado correctamente:

 java -version

 - Deberías ver información sobre la versión de Java instalada.

Luego, escribe:

javac -version

Deberías ver información sobre la versión del compilador Java instalado.

# USO DEL PROGRAMA

**Inicio**

El programa inicia con una pantalla de autenticación de usuario donde socita las credenciales necesarias para dar el acceso al menu principal

-Usuario

-Contraseña

Una vez realizado el proceso correcto de autenticación se precenta un menú interactivo en el cual se podra seleccionar alguna de las siguientes opciones

- Dar de alta Doctor

- Dar de alta Paciente

- Crear una Cita

- Salir

Una vez seleccionada la opcion se podra realizar la capturar los datos para crear un registro dentro del programa, como se muestra a continuación :

**Doctores**

- Nombre

- Id

- Especialidad

**Pacientes**

- Nombre

- Id

**Citas**

- Hora
- Fecha

- Asignar Doctor

- Asignar Paciente

**Salir**

Termina la ejecución del programa

# CREDITOS

*Jorge Armando Martinez Ponce.*

Desarrollado en Java SE 11, Intellij IDEA 2024.3.1.1

Agradecimiento al Profesor del curso computacion en java Daniel Horacio Chávez Argott por compartir su experiencia y conocimiento.

# LICENCIA 

Licencia Publica 
