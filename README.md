<!-- INICIO DE LA DOCUMENTACIÓN DEL PROYECTO -->
<br />
<div align="center">
  <a href="https://github.com/Los-Malditos-del-i03-Ciclo-V/yven-quantums-optics">
    <img src="https://i.imgur.com/NYzNmSM.png" alt="Logo" width="250" height="250">
  </a>

  <h3 align="center">Yven Quantum Optics</h3>

  <p align="center">
    Ayuda a un laboratorio de óptica cuántica a manejar mejor sus datos y recursos
    <br />
    <a href="https://github.com/Los-Malditos-del-i03-Ciclo-V/yven-quantums-optics"><strong>Explora la documentación »</strong></a>
    <br />
    <br />
    <a href="https://github.com/Los-Malditos-del-i03-Ciclo-V/yven-quantums-optics">Ver demostración</a>
    ·
    <a href="https://github.com/Geraldow/documentations/issues/new?assignees=&labels=bug&projects=&template=reportar-bug.md">Reportar bug</a>
    ·
    <a href="https://github.com/Geraldow/documentations/issues/new?assignees=&labels=enhancement&projects=&template=solicitar-nueva-caracter%C3%ADstica-%E2%9C%A8.md">Solicitar característica</a>
  </p>
</div>

<!-- ACERCA DEL PROYECTO -->
## Acerca del Proyecto
<div align="center">
  <a href="https://github.com/Geraldow/documentations">
    <img src="https://cdn.dribbble.com/userupload/14912902/file/original-12c002c69215970cd2eaf4824b287a4f.png?resize=700x" alt="Logo">
  </a>
</div>

YQO es un proyecto diseñado para maximizar el flujo de trabajo en el laboratorio, permitiendo realizar análisis precisos y oportunos para mejorar la gestión de recursos financieros y materiales. Este software tiene como objetivo reducir la cantidad de trabajo humano, minimizar los errores de procesamiento de datos y garantizar que los recursos se utilicen de forma eficaz. Está dirigido a un equipo de tres científicos para que les permita analizar los datos de forma eficiente y presentar proyecciones precisas, también ofrece ventajas como generación de reportes y estadísticas.

### Tecnologías
<div style="display: flex; flex-wrap: wrap; justify-content: center;">

  [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
  [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/downloads/)
  [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)
  [![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=for-the-badge&logo=mysql&labelColor=4479A1&logoColor=FFF)](https://dev.mysql.com/downloads/workbench/)
  [![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-grey?style=for-the-badge&logo=tailwind-css&logoColor=38B2AC)](https://tailwindcss.com/)
  [![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)](https://www.thymeleaf.org/)
  [![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/HTML)
  [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/download/)
  [![Figma](https://img.shields.io/badge/figma-%239400D3.svg?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com/downloads/)

</div>

<!-- GETTING STARTED -->
## Comenzando con YQO

Esta sección te proporcionará instrucciones detalladas sobre cómo configurar tu proyecto localmente. A continuación, encontrarás los pasos necesarios para obtener una copia de trabajo y empezar a utilizarlo.

### Prerrequisitos

Asegúrate de tener los siguientes requisitos previos instalados:
* Java 17 o superior
* MySQL (o el motor SQL que prefieras)
* Node.js y npm

### Instalación

A continuación, se detalla el proceso para clonar, configurar e instalar el proyecto.

1. Clona el repositorio
   ```sh
   git clone https://github.com/tu_usuario/tu_repositorio.git
   ```
   
2. Entra en el directorio del proyecto
   ```sh
   cd tu_repositorio
   ```
   
3. Dirigirse a la carpeta frontend e instala las dependencias de npm
   ```sh
   cd frontend
   npm install
   ```
   
5. Importa el archivo SQL a tu base de datos
   - Abre MySQL Workbench
   - Ve a **File > Open SQL Script**
   - Selecciona el archivo _base_de_datos.sql_ que se encuentra en el directorio del proyecto
   - Ejecuta el escript para cargar la base de datos
  
6. Configura las credenciales de acceso a la base de datos en el archivo application.properties
   ```sh
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
   
8. Vuelve a la carpeta raíz y ejecuta el proyecto con Maven
   ```sh
   cd ..
   mvn spring-boot:run
   ```
   
9. Accede a la aplicación desde la URL http://localhost:8001

### Miembros de equipo
- <img src="https://i.imgur.com/TszSrEx.jpeg" width="50" height="50"/> [Geraldo Fair Jaramillo Florida](https://github.com/Geraldow)
- <img src="https://i.imgur.com/iQaXHnb.jpeg" width="50" height="50"/> [Alessandro Miguel Arias Marquina](https://github.com/76287712)
- <img src="https://i.imgur.com/xYIFOqK.png" width="50" height="50"/> [Dayne Fiorella Ruiz Fernandez](https://github.com/73987271)
  
