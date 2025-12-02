# Guía de Contribución

¡Gracias por tu interés en contribuir a Liga Fútbol API! 🙌

## Cómo Contribuir

### 1. Preparar el Entorno

```bash
# Clonar el repositorio
git clone https://github.com/sebacure/liga-futbol.git
cd liga-futbol

# Crear una rama para tu feature
git checkout -b feature/mi-feature

# Instalar dependencias
mvn clean install
```

### 2. Hacer Cambios

- Seguir el estilo de código del proyecto
- Escribir código limpio y legible
- Añadir comentarios donde sea necesario
- Usar Lombok para reducir boilerplate

### 3. Testing

```bash
# Ejecutar tests localmente
mvn test

# Verificar construcción
mvn clean package
```

### 4. Commit

```bash
# Usar mensajes descriptivos
git add .
git commit -m "feat: descripción clara del cambio"
```

**Formato de mensajes:**
- `feat:` - Nueva característica
- `fix:` - Corrección de error
- `docs:` - Cambios en documentación
- `style:` - Cambios de formato
- `refactor:` - Refactorización de código
- `test:` - Adición de tests
- `chore:` - Cambios en configuración

### 5. Push y Pull Request

```bash
# Subir cambios
git push origin feature/mi-feature
```

Luego crear un Pull Request en GitHub con:
- Descripción clara del cambio
- Referencias a issues relacionadas (#123)
- Screenshots si aplica

## Estándares de Código

### Naming Conventions
- **Clases:** `PascalCase` (ej: `EquipoService`)
- **Métodos:** `camelCase` (ej: `obtenerEquipo()`)
- **Constantes:** `UPPER_SNAKE_CASE` (ej: `MAX_EQUIPOS`)

### Estructura de Clases
```java
@Service
@RequiredArgsConstructor
public class EquipoService {
    
    // Inyecciones
    private final EquipoRepository equipoRepository;
    
    // Métodos públicos
    public Equipo obtenerPorId(Long id) {
        // Implementación
    }
    
    // Métodos privados
    private void validar(Equipo equipo) {
        // Implementación
    }
}
```

### Validaciones
```java
// Usar Bean Validation
@Entity
public class Equipo {
    
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @Min(value = 1900, message = "Año inválido")
    private Integer fundacion;
}
```

## Directorios del Proyecto

```
src/main/java/com/liga/futbol/
├── controller/      # Controladores REST
├── service/         # Lógica de negocio
├── repository/      # Acceso a datos
├── model/           # Entidades JPA
├── exception/       # Excepciones personalizadas
├── dto/             # Data Transfer Objects
└── config/          # Configuraciones
```

## Checklist para Pull Request

- [ ] Código sigue el estilo del proyecto
- [ ] Tests pasan localmente (`mvn test`)
- [ ] Compilación exitosa (`mvn clean package`)
- [ ] Documentación actualizada
- [ ] Mensajes de commit descriptivos
- [ ] Sin conflictos con rama principal

## Reportar Bugs

Usar GitHub Issues con:
1. Título descriptivo
2. Descripción del problema
3. Pasos para reproducir
4. Comportamiento esperado vs actual
5. Versión de Java y Spring Boot

## Sugerencias de Mejora

Abrir un Issue con:
- Descripción clara
- Caso de uso
- Beneficios esperados
- Posible implementación (opcional)

## Licencia

Al contribuir, aceptas que tus cambios estén bajo la licencia MIT.

---

**¡Esperamos tu contribución!** 🚀
