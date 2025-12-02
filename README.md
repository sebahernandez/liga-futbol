# Liga Fútbol API

API REST desarrollada con **Spring Boot 3.5.0** para gestión de equipos, ligas y partidos de fútbol.

## 🚀 Requisitos Previos

- **Java 21** o superior
- **Maven 3.9.x** o superior
- **Docker & Docker Compose** (para base de datos PostgreSQL)

## 📦 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/sebahernandez/liga-futbol.git
cd liga-futbol
```

### 2. Iniciar PostgreSQL con Docker

```bash
docker-compose up -d
```

Esto inicia PostgreSQL en puerto `5432` con base de datos `liga_futbol`.

### 3. Compilar

```bash
mvn clean package -DskipTests
```

### 4. Ejecutar

**Modo Desarrollo (H2 en memoria):**
```bash
mvn spring-boot:run
```

**Modo Producción (PostgreSQL):**
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=prod"
```

API disponible en: `http://localhost:8080/api`

## 📂 Estructura

```
liga-futbol/
├── src/main/java/com/liga/futbol/
│   ├── LigaFutbolApiApplication.java    # Aplicación principal
│   ├── model/
│   │   ├── entity/                      # Entidades JPA
│   │   │   ├── Equipo.java
│   │   │   ├── Liga.java
│   │   │   └── Partido.java
│   │   └── repository/                  # Repositorios
│   │       └── EquipoRepository.java
│   ├── controller/                      # REST Controllers (próximo)
│   ├── service/                         # Lógica de negocio (próximo)
│   └── exception/                       # Manejo de excepciones
├── src/main/resources/
│   ├── application.yml                  # Config. H2 (desarrollo)
│   └── application-prod.yml             # Config. PostgreSQL
├── docker-compose.yml                   # PostgreSQL + volumes
├── pom.xml                              # Dependencias Maven
└── README.md                            # Este archivo
```

## 🏆 Equipos

El proyecto incluye datos de ejemplo con principales equipos chilenos:

- **Colo Colo** - Santiago, fundado 1925
- **Universidad de Chile** - Santiago, fundado 1927
- **Deportes Iquique** - Iquique, fundado 1986
- **Huachipato** - Talcahuano, fundado 1947
- **Magallanes** - Punta Arenas, fundado 1911
- **Cobreloa** - Calama, fundado 1945
- **Palestino** - Santiago, fundado 1920
- **Deportes Puerto Montt** - Puerto Montt, fundado 1948
- **Audax Italiano** - Santiago, fundado 1910
- **Antofagasta** - Antofagasta, fundado 1945

## 🛠️ Tecnologías

- **Java 21** - Lenguaje
- **Spring Boot 3.5.0** - Framework
- **Spring Data JPA** - Persistencia
- **Hibernate 6.6** - ORM
- **PostgreSQL 15** - Base de datos
- **Maven** - Build tool
- **Docker** - Contenedorización
- **Lombok** - Boilerplate reduction

## 📖 Modelos de Datos

### Equipo
```json
{
  "id": 1,
  "nombre": "Colo Colo",
  "ciudad": "Santiago",
  "fundacion": 1925
}
```

### Liga
```json
{
  "id": 1,
  "nombre": "Liga Profesional",
  "anio": 2026,
  "pais": "Chile"
}
```

### Partido
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

## 🐳 Comandos Docker

```bash
# Ver contenedores activos
docker-compose ps

# Ver logs
docker-compose logs -f postgres

# Detener servicios
docker-compose stop

# Reiniciar servicios
docker-compose start

# Eliminar todo (incluyendo datos)
docker-compose down -v
```
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
