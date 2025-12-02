# Liga Fútbol API 🏆

API REST desarrollada con **Spring Boot 3.5.0** para la gestión de ligas de fútbol, equipos, partidos y resultados.

## 📋 Características

- ✅ **Spring Boot 3.5.0** - Framework moderno y actualizado
- ✅ **Spring Data JPA** - Acceso a datos con Hibernate
- ✅ **PostgreSQL** - Base de datos relacional robusta
- ✅ **REST API** - Endpoints RESTful para gestión de recursos
- ✅ **Docker** - Contenedorización con Docker Compose
- ✅ **Java 21** - Última versión LTS de Java
- ✅ **Lombok** - Reducción de boilerplate code
- ✅ **Validación** - Bean Validation integrado

## 🚀 Requisitos Previos

- **Java 21** o superior
- **Maven 3.9.x** o superior
- **Docker & Docker Compose** (opcional, para ejecutar con PostgreSQL)

## 📦 Instalación y Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/liga-futbol.git
cd liga-futbol
```

### 2. Configurar variables de entorno (opcional)

Crear archivo `.env` en la raíz del proyecto:

```bash
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_DB=liga_futbol
```

### 3. Iniciar la base de datos con Docker

```bash
docker-compose up -d
```

Esto iniciará:
- **PostgreSQL 15** en puerto `5432`
- **PgAdmin** en puerto `5050`

### 4. Compilar el proyecto

```bash
mvn clean package -DskipTests
```

### 5. Ejecutar la aplicación

**Modo Desarrollo (H2 en memoria):**

```bash
mvn clean spring-boot:run
```

**Modo Producción (PostgreSQL):**

```bash
mvn clean spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=prod"
```

## 🌐 Acceso a la Aplicación

| Servicio | URL | Usuario | Contraseña |
|----------|-----|---------|-----------|
| **API** | http://localhost:8080/api | - | - |
| **PgAdmin** | http://localhost:5050 | admin@liga.com | admin |
| **PostgreSQL** | localhost:5432 | postgres | postgres |

## 📚 Estructura del Proyecto

```
liga-futbol/
├── src/
│   ├── main/
│   │   ├── java/com/liga/futbol/
│   │   │   ├── LigaFutbolApiApplication.java    # Aplicación principal
│   │   │   ├── model/
│   │   │   │   ├── entity/                      # Entidades JPA
│   │   │   │   │   ├── Equipo.java
│   │   │   │   │   ├── Liga.java
│   │   │   │   │   └── Partido.java
│   │   │   │   └── repository/                  # Repositorios Spring Data
│   │   │   │       └── EquipoRepository.java
│   │   │   ├── controller/                      # Controladores REST (próximamente)
│   │   │   ├── service/                         # Lógica de negocio (próximamente)
│   │   │   └── exception/                       # Manejo de excepciones (próximamente)
│   │   └── resources/
│   │       ├── application.yml                  # Configuración por defecto (H2)
│   │       └── application-prod.yml             # Configuración producción (PostgreSQL)
│   └── test/
│       └── java/                                # Tests unitarios (próximamente)
├── docker-compose.yml                           # Configuración Docker
├── pom.xml                                      # Dependencias Maven
├── .gitignore                                   # Archivos a ignorar en Git
└── README.md                                    # Este archivo

```

## 🛠️ Stack Tecnológico

### Backend
- **Java 21** - Lenguaje de programación
- **Spring Boot 3.5.0** - Framework web
- **Spring Data JPA** - Persistencia de datos
- **Hibernate 6.6** - ORM
- **PostgreSQL 15** - Base de datos

### Herramientas
- **Maven** - Gestor de dependencias
- **Docker** - Contenedorización
- **Lombok** - Reducción de código boilerplate

## 📖 Uso de la API

### Modelos de Datos

#### Equipo
```json
{
  "id": 1,
  "nombre": "Colo Colo",
  "ciudad": "Santiago",
  "fundacion": 1925
}
```

#### Liga
```json
{
  "id": 1,
  "nombre": "Liga Profesional",
  "anio": 2026,
  "pais": "Chile"
}
```

#### Partido
```json
{
  "id": 1,
  "equipoLocal": 1,
  "equipoVisitante": 2,
  "fecha": "2026-01-15",
  "golesLocal": 2,
  "golesVisitante": 1
}
```

## 🔄 Ciclo de Desarrollo

### Crear una rama para nuevo feature
```bash
git checkout -b feature/tu-feature
```

### Hacer cambios y commit
```bash
git add .
git commit -m "Descripción del cambio"
```

### Subir cambios
```bash
git push origin feature/tu-feature
```

### Crear Pull Request
Ir a GitHub y crear un Pull Request

## 🧪 Testing

```bash
# Ejecutar todos los tests
mvn test

# Tests con cobertura
mvn clean test jacoco:report
```

## 🐳 Comandos Docker Útiles

```bash
# Ver estado de los contenedores
docker-compose ps

# Ver logs
docker-compose logs -f postgres

# Detener servicios
docker-compose stop

# Reanudar servicios
docker-compose start

# Eliminar todo (incluyendo datos)
docker-compose down -v
```

## 📝 Variables de Entorno

| Variable | Valor Por Defecto | Descripción |
|----------|-------------------|-------------|
| `SPRING_PROFILES_ACTIVE` | default | Perfil de Spring (dev, prod) |
| `POSTGRES_USER` | postgres | Usuario de PostgreSQL |
| `POSTGRES_PASSWORD` | postgres | Contraseña de PostgreSQL |
| `POSTGRES_DB` | liga_futbol | Nombre de la base de datos |

## 🚨 Solución de Problemas

### Puerto 5432 ya está en uso
```bash
# Cambiar el puerto en docker-compose.yml o matar el proceso
lsof -i :5432
kill -9 <PID>
```

### Puerto 8080 ya está en uso
```bash
# Cambiar el puerto en application.yml
lsof -i :8080
kill -9 <PID>
```

### Conexión rechazada a PostgreSQL
```bash
# Verificar que Docker está corriendo
docker ps

# Reiniciar los servicios
docker-compose restart
```

## 📋 Próximas Mejoras

- [ ] Endpoints REST completos (CRUD)
- [ ] Autenticación JWT
- [ ] Tests unitarios e integración
- [ ] Documentación Swagger/OpenAPI
- [ ] Validaciones avanzadas
- [ ] Paginación y filtrado
- [ ] Caché con Redis
- [ ] Monitoreo con Actuator

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**. Ver el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

**Sebastián** - [GitHub](https://github.com/sebacure)

## 📞 Contacto

- Email: sebastian@example.com
- Issues: [GitHub Issues](https://github.com/sebacure/liga-futbol/issues)

## 🎯 Roadmap

### v1.0.0 (Actual)
- ✅ Configuración inicial del proyecto
- ✅ Entidades base (Equipo, Liga, Partido)
- ✅ Configuración de base de datos (PostgreSQL)
- ✅ Docker Compose para desarrollo

### v1.1.0 (Próxima)
- [ ] Endpoints REST CRUD completos
- [ ] Validaciones avanzadas
- [ ] Documentación Swagger

### v2.0.0 (Futuro)
- [ ] Autenticación y autorización
- [ ] Tests completos
- [ ] Caché y optimizaciones
- [ ] Integración CI/CD

---

**Última actualización:** 1 de Diciembre de 2025

**Versión:** 1.0.0
