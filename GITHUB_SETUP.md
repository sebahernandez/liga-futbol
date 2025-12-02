# 🚀 Pasos para Subir a GitHub

## 1. Crear un Repositorio en GitHub

1. Ve a [GitHub](https://github.com/new)
2. Nombre: `liga-futbol`
3. Descripción: `API REST para gestión de ligas de fútbol con Spring Boot 3.5`
4. Haz el repositorio **Público** (para portafolio)
5. ⚠️ NO inicialices con README (ya tenemos uno)
6. Crea el repositorio

## 2. Configurar Git Remoto

```bash
cd /Users/sebacure/Desktop/proyectos/liga-futbol

# Agregar origen remoto
git remote add origin https://github.com/TU_USUARIO/liga-futbol.git

# Verificar que se agregó correctamente
git remote -v
```

## 3. Subir el Proyecto

```bash
# Primera vez - configurar rama upstream
git push -u origin master

# Siguientes veces
git push origin master
```

## 4. Configurar GitHub (Opcional pero Recomendado)

### Proteger la rama master
1. Ve a **Settings** → **Branches**
2. Click en **Add rule**
3. Branch name pattern: `master`
4. Activa:
   - ✅ Require pull request reviews before merging
   - ✅ Require status checks to pass before merging
   - ✅ Include administrators

### Configurar Topics (Etiquetas)
En **About** (esquina derecha), agrega topics:
- `java`
- `spring-boot`
- `rest-api`
- `postgresql`
- `docker`
- `maven`

## 5. Configurar Actions (CI/CD)

Crear archivo `.github/workflows/build.yml`:

```yaml
name: Build and Test

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 21
      uses: actions/setup-java@v3
      with:
        java-version: '21'
        distribution: 'temurin'
    
    - name: Build with Maven
      run: mvn clean package -DskipTests
    
    - name: Run tests
      run: mvn test
```

## 6. Verificar el Repositorio

```bash
# Ver remoto
git remote -v

# Ver ramas
git branch -a

# Ver historial
git log --oneline --graph
```

## 7. Agregar .github/workflows

```bash
# Crear carpeta si no existe
mkdir -p .github/workflows

# La haremos después
```

## 8. Próximos Pasos en Desarrollo

```bash
# Para nuevo feature
git checkout -b feature/tu-feature
git add .
git commit -m "feat: descripción"
git push origin feature/tu-feature
# Crear Pull Request en GitHub
```

## ✅ Checklist Final

- [ ] Repositorio creado en GitHub
- [ ] Git remoto configurado
- [ ] Código subido a master
- [ ] README visible en GitHub
- [ ] Topics agregados
- [ ] Rama master protegida (opcional)
- [ ] .gitignore funcionando (sin target/, logs, etc.)

---

**¡Tu proyecto está listo para GitHub!** 🎉
