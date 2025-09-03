# VT-IMT Backend

Spring Boot Web application pour fournir le back-end à l’application **VT-IMT** (gestion de courses et inscriptions).

## 1. Getting started

### 1.1. Initier l'application
```sh
**### mvn clean install
**
1.2. Lancer l'application
mvn spring-boot:run

L’application démarre par défaut sur :
http://localhost:8080

2. API (exemples)
Method	Path	Description
GET	/api/users/{id}	Récupérer le détail d’un utilisateur
GET	/api/races	Lister toutes les courses
POST	/api/races	Créer une nouvelle course
POST	/api/registrations	Inscrire un utilisateur à une course
GET	/api/results/{id}	Récupérer les résultats d’une course
3. Présentation générale

Spring Boot est un framework qui permet de développer rapidement des applications Java/JEE (web ou standalone).

Il accélère le développement en proposant :

des conventions intelligentes,

des abstractions utiles,

des mécanismes prêts à l'emploi (starters, auto-configuration, etc.).

Concrètement, Spring Boot se présente sous la forme d’un POM parent et de dépendances Maven/Gradle appelées starters.

4. H2 Database

Une base de données H2 en mémoire est utilisée pour la démo.

Console disponible à :
http://localhost:8080/h2-console

JDBC URL : jdbc:h2:mem:testdb

User : sa

Password : password

👉 Des données de démo (utilisateurs, courses, inscriptions) sont automatiquement chargées via import.sql.

5. Tech stack

Java 17+

Spring Boot 3

Spring Data JPA

H2 Database

Maven****
