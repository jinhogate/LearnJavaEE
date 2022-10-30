# LearnJavaEE
## SOMMAIRE
<a name="introduction"></a>
### I. Introduction
<a name="modele-mvc"></a>
### II. Modèle MVC
<a name="Installation"></a>
### III. Installation
***
#### I. Introduction
Nous allons décrire chaque étape de notre apprentissage de **la spécification JAVA EE**. 
Pour celà nous avons opté pour la formation basique du cours JAVA EE sur OpenClassrooms **https://openclassrooms.com/https://openclassrooms.com/**. 
Ce cours est transmi par ***M. Mathieu Nebra, Entrepreneur et auteur à plein temps et co-fondateur d'OpenClassrooms***. 

JAVA EE est un ensemble de spécifications ajouté à JAVA, permettant de mettre en place des applications WEB robustes, sécurisées et bien structurées. 
**Notons que JAVA est le 2eme langage le plus utilisé dans le monde des développeurs professionnels (36%), derrière javascript (42%)**. 

#### II. Modèle MVC
Le modèle MVC (Modèle Vue Contrôleur) est une manière de conception permettant de mieux organiser nos codes sources. C'est un modèle standard à la conception d'une application WEB JAVAEE. 

* **Model** : Il représente les objets JAVA (Entités principales de notre système).
C'est le composant intermédiaire entre **les bases de données** et le composant **Contrôleur**. 
* **Contrôleur** : Il permet d'aiguiller les requêtes http des utilisateurs. En effet il décompose les requêtes, et identifie les ressources/actions à appeler pour traiter ces requêtes.
Ces ressources/actions commminiquent avec le modèle si besoin et retournent un objet réponse que le contrôleur transmet à la vue. 
Le contrôleur représente l'objet **SERVLET** dans les spécifications JAVA EE. 
* **Vue** *: La vue représente l'interface Web à travers laquelle les utilisateurs comminiquent avec l'application WEB. Elle représente l'objet **JSP** dans les spécification JAVAEE.

Enfin tout au long de ce cours nous allons utiliser le framework pure JAVA EE. Et notons qu'il existe des frameworks (STRUTS, JSF, HIBBERNATE et SPRING) basés sur le modèle MVC permettant de développer des applications JAVA EE rapidement.

#### III. Installation
* Eclipse (https://www.eclipse.org/downloads/) : IDE (Environnement de Développement Intégré), va nous permettre d'écrire nos code sources et de complier notre application WEB. 
Après installation, mettre dans le bon format (UTF-8) les fichiers HTML, XML, JSP, CSS etc..
* Tomcat (https://tomcat.apache.org/download-80.cgi) : Conteneur Web en d'autres termes le serveur sur lequel notre application sera déployée.  


