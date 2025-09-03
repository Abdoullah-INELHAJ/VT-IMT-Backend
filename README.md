# VT-IMT

Application de gestion de courses (backend + frontend).

---

## 📌 Backend (Spring Boot)

### 1. Getting started

#### 1.1. Initier l'application
```sh
mvn clean install
```
#### 1.2. Lancer l'application
```
mvn spring-boot:run
```
L’application démarre par défaut sur : http://localhost:8080

### 2. 📌 API Endpoints

| Méthode | Endpoint                  | Description                                    |
|---------|---------------------------|------------------------------------------------|
| GET     | `/api/races`              | Liste toutes les courses à venir               |
| POST    | `/api/races`              | Crée une nouvelle course                       |
| GET     | `/api/races/{id}`         | Détails d’une course                           |
| POST    | `/api/races/{id}/register`| Inscrit un utilisateur à une course            |
| POST    | `/api/races/{id}/simulate`| Simule les résultats d’une course              |
| GET     | `/api/races/{id}/results` | Récupère les résultats d’une course            |
| POST    | `/api/users`              | Crée ou retourne un utilisateur                |
| GET     | `/api/me`                 | Récupère les infos du user connecté            |
