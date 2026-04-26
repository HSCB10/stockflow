# StockFlow API

REST API para gestión de inventario construida con Java Spring Boot y MySQL.

## 🛠 Tech Stack
- Java 21
- Spring Boot 3.4.5
- MySQL 8
- Maven

## 📦 Endpoints
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | /api/productos | Listar productos |
| GET | /api/productos/{id} | Obtener producto |
| POST | /api/productos | Crear producto |
| PUT | /api/productos/{id} | Actualizar producto |
| DELETE | /api/productos/{id} | Eliminar producto |
| GET | /api/productos/stock-critico | Productos con stock bajo |

## 🚀 Cómo ejecutar
```bash
git clone https://github.com/HSCB10/stockflow.git
cd stockflow
mvn spring-boot:run

## ✍️ Autor
Steven Cuesta — [@HSCB10](https://github.com/HSCB10)